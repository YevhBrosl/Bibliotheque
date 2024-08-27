package com.bibliotheque.tests;

import com.bibliotheque.data.BookData;
import com.bibliotheque.data.LibraryData;
import com.bibliotheque.models.Book;
import com.bibliotheque.models.Library;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LibraryTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getLibrary().isLogOutLinkPresent()) {
            app.getLibrary().clickOnLogOutLink();
        }
        app.getLibrary().clickOnLoginLink();
        app.getLibrary().fillInLoginForm(new Library()
                .setEmail(LibraryData.EMAIL)
                .setPassword(LibraryData.PASSWORD));
        app.getLibrary().clickOnLoginButton();
        app.getLibrary().clickOnProfileLink();
    }

    @Test
    public void addNewLibraryPositiveTest() {
        app.getLibrary().clickOnGoToLibraryManagerButton();
        app.getLibrary().clickOnRegisterNewLibraryButton();
        app.getLibrary().fillOutLibraryRegistrationForm(new Library()
                .setName(LibraryData.NAME)
                .setCountry(LibraryData.COUNTRY)
                .setZip(LibraryData.ZIP)
                .setCity(LibraryData.CITY)
                .setStreet(LibraryData.STREET)
                .setHouse(LibraryData.HOUSE)
                .setPhone(LibraryData.PHONE));
        app.getLibrary().pause(7000);
        app.getLibrary().clickOnRegisterButton();
        Assert.assertTrue(app.getLibrary().isSuccessMessagePresent());
    }

    @Test
    public void addBookPositiveTest() {
        app.getLibrary().clickOnGoToLibraryManagerButton();
        app.getLibrary().pause(2000);
        app.getLibrary().clickOnLibraryCard();
        app.getLibrary().clickOnAddNewBooksButton();
        app.getLibrary().fillOutBookDataForm(new Book()
                .setTitle(BookData.TITLE)
                .setAuthorName(BookData.AUTHOR_NAME)
                .setAuthorSurname(BookData.AUTHOR_SURNAME)
                .setYear(BookData.YEAR)
                .setIsbn(BookData.ISBN)
                .setPublisher(BookData.PUBLISHER)
                .setQuantity(BookData.QUANTITY));
        app.getLibrary().pause(7000);
        app.getLibrary().clickOnAddBookButton();
        Assert.assertTrue(app.getLibrary().isSuccessMessagePresent());
    }
}
