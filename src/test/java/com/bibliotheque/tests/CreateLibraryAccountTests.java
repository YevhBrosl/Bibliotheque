package com.bibliotheque.tests;

import com.bibliotheque.data.LibraryData;
import com.bibliotheque.models.Library;
import com.bibliotheque.models.User;
import com.bibliotheque.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateLibraryAccountTests extends TestBase{

//    @BeforeMethod
//    public void ensurePrecondition() {
//        if (!app.getLibrary().isLoginLinkPresent()) {
//            app.getLibrary().clickOnSignOutButton();
//        }
//    }
//
//    @Test(dataProvider = "addNewLibraryFromCsv", dataProviderClass = DataProviders.class)
//    public void createLibraryAccountPositiveTest(Library library) {
//        app.getLibrary().clickOnRegisterLink();
//        app.getLibrary().fillInCreateAccountForm(library);
//        app.getLibrary().clickOnLibraryRadioButton();
//        app.getLibrary().clickOnRegisterButton();
//        Assert.assertTrue(app.getLibrary().isSignOutButtonPresent());
//    }
//
//    @Test
//    public void createExistingLibraryAccountNegativeTest() {
//        app.getLibrary().clickOnRegisterLink();
//        app.getLibrary().fillInCreateAccountForm(new Library()
//                .setEmail(LibraryData.EMAIL)
//                .setPassword(LibraryData.PASSWORD)
//                .setConfirmPassword(LibraryData.CONFIRM_PASSWORD));
//        app.getLibrary().clickOnLibraryRadioButton();
//        app.getLibrary().clickOnRegisterButton();
//        app.getLibrary().clickOnSignOutButton();
//        app.getLibrary().clickOnRegisterLink();
//        app.getLibrary().fillInCreateAccountForm(new Library()
//                .setEmail(LibraryData.EMAIL)
//                .setPassword(LibraryData.PASSWORD)
//                .setConfirmPassword(LibraryData.CONFIRM_PASSWORD));
//        app.getLibrary().clickOnLibraryRadioButton();
//        app.getLibrary().clickOnRegisterButton();
//        Assert.assertTrue(app.getLibrary().isErrorPresent());
//    }


}
