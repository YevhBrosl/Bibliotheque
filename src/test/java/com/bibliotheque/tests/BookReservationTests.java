package com.bibliotheque.tests;

import com.bibliotheque.data.BookData;
import com.bibliotheque.data.UserData;
import com.bibliotheque.models.Book;
import com.bibliotheque.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookReservationTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLogOutLinkPresent()) {
            app.getUser().clickOnLoginLink();
            app.getUser().fillInLoginForm(new User()
                    .setEmail(UserData.EMAIL)
                    .setPassword(UserData.PASSWORD));
            app.getUser().clickOnLoginButton();
        }
        app.getUser().selectSearchOption("ISBN");
        app.getUser().enterIsbnIntoSearchField(new Book()
                .setIsbn(BookData.ISBN));
        app.getUser().clickOnSearchButton();
    }

    @Test
    public void addBookToCartPositiveTest() {
        app.getUser().clickOnOrderButton();
        Assert.assertTrue(app.getUser().isBookAddedToCart());
        app.getUser().returnToSearchPage();
    }

    @Test
    public void addCompleteBookReservationPositiveTest() {
        app.getUser().clickOnOrderButton();
        app.getUser().fillOutBookReservationForm(new User()
                .setFirstName(UserData.FIRST_NAME)
                .setLastName(UserData.LAST_NAME)
                .setPhone(UserData.PHONE)
                .setZip(UserData.ZIP)
                .setCountry(UserData.COUNTRY)
                .setCity(UserData.CITY)
                .setStreet(UserData.STREET)
                .setHouse(UserData.HOUSE));
        app.getUser().tickTermsCheckbox();
        app.getUser().pause(4500);
        app.getUser().clickOnConfirmOrderButton();
        Assert.assertTrue(app.getUser().isSuccessMessagePresent());
    }

}
