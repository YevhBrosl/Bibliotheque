package com.bibliotheque.tests;

import com.bibliotheque.data.LibraryData;
import com.bibliotheque.models.Library;
import com.bibliotheque.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateLibraryAccountTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getLibrary().isLogOutLinkPresent()) {
            app.getLibrary().clickOnLogOutLink();
        }
    }

    @Test(dataProvider = "addNewLibraryFromCsv", dataProviderClass = DataProviders.class)
    public void createLibraryAccountPositiveTest(Library library) {
        app.getLibrary().clickOnRegisterLink();
        app.getLibrary().fillInCreateAccountForm(library);
        app.getLibrary().clickOnLibraryRadioButton();
        app.getLibrary().pause(7000);
        app.getLibrary().clickOnRegisterButton();
        Assert.assertTrue(app.getLibrary().isLogOutLinkPresent());
    }

    @Test
    public void createExistingLibraryAccountNegativeTest() {
        app.getLibrary().clickOnRegisterLink();
        app.getLibrary().fillInCreateAccountForm(new Library()
                .setEmail(LibraryData.EMAIL)
                .setPassword(LibraryData.PASSWORD)
                .setConfirmPassword(LibraryData.CONFIRM_PASSWORD));
        app.getLibrary().clickOnLibraryRadioButton();
        app.getLibrary().pause(7000);
        app.getLibrary().clickOnRegisterButton();
        app.getLibrary().clickOnLogOutLink();
        app.getLibrary().clickOnRegisterLink();
        app.getLibrary().fillInCreateAccountForm(new Library()
                .setEmail(LibraryData.EMAIL)
                .setPassword(LibraryData.PASSWORD)
                .setConfirmPassword(LibraryData.CONFIRM_PASSWORD));
        app.getLibrary().clickOnLibraryRadioButton();
        app.getLibrary().pause(7000);
        app.getLibrary().clickOnRegisterButton();
        Assert.assertTrue(app.getLibrary().isExistingUserErrorPresent());
    }


}
