package com.bibliotheque.tests;

import com.bibliotheque.data.UserData;
import com.bibliotheque.models.User;
import com.bibliotheque.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

//    @BeforeMethod
//    public void ensurePrecondition() {
//        if (app.getUser().isSignOutButtonPresent()) {
//            app.getUser().clickOnSignOutButton();
//        }
//    }
//
//    @Test()
//    public void loginPositiveTest() {
//        app.getUser().clickOnLoginLink();
//        app.getUser().fillInLoginForm(new User()
//                .setEmail(UserData.EMAIL)
//                .setPassword(UserData.PASSWORD));
//        app.getUser().clickOnLoginButton();
//        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
//    }

    @Test()
    public void loginNegativeWithoutEmailTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillInLoginForm(new User()
                .setPassword(UserData.PASSWORD));
        Assert.assertTrue(app.getUser().isEmptyEmailWarningPresent());
    }

    @Test()
    public void loginNegativeWithoutPasswordTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillInLoginForm(new User()
                .setEmail(UserData.EMAIL));
        Assert.assertTrue(app.getUser().isEmptyPasswordWarningPresent());
    }

//    @Test(dataProvider = "registrationLoginWithInvalidEmailFromCsv", dataProviderClass = DataProviders.class)
//    public void loginWithInvalidEmailNegativeTest(User user) {
//        app.getUser().clickOnLoginLink();
//        app.getUser().fillInLoginForm(user);
//        Assert.assertTrue(app.getUser().isInvalidEmailWarningPresent());
//    }

    @Test(dataProvider = "registrationLoginWithShortPasswordFromCsv", dataProviderClass = DataProviders.class)
    public void loginWithShortPasswordNegativeTest(User user) {
        app.getUser().clickOnLoginLink();
        app.getUser().fillInLoginForm(user);
        Assert.assertTrue(app.getUser().isShortPasswordWarningPresent());
    }

    @Test(dataProvider = "registrationLoginWithNoUppercasePasswordFromCsv", dataProviderClass = DataProviders.class)
    public void loginWithNoUppercasePasswordNegativeTest(User user) {
        app.getUser().clickOnLoginLink();
        app.getUser().fillInLoginForm(user);
        Assert.assertTrue(app.getUser().isNoUppercasePasswordWarningPresent());
    }

    @Test(dataProvider = "registrationLoginWithNoLowercasePasswordFromCsv", dataProviderClass = DataProviders.class)
    public void loginWithNoLowercasePasswordNegativeTest(User user) {
        app.getUser().clickOnLoginLink();
        app.getUser().fillInLoginForm(user);
        Assert.assertTrue(app.getUser().isNoLowercasePasswordWarningPresent());
    }

    @Test(dataProvider = "registrationLoginWithNoDigitsPasswordFromCsv", dataProviderClass = DataProviders.class)
    public void loginWithNoDigitsPasswordNegativeTest(User user) {
        app.getUser().clickOnLoginLink();
        app.getUser().fillInLoginForm(user);
        Assert.assertTrue(app.getUser().isNoDigitsPasswordWarningPresent());
    }

    @Test(dataProvider = "registrationLoginWithNoSpecSymbolsPasswordFromCsv", dataProviderClass = DataProviders.class)
    public void loginWithNoSpecSymbolsPasswordNegativeTest(User user) {
        app.getUser().clickOnLoginLink();
        app.getUser().fillInLoginForm(user);
        Assert.assertTrue(app.getUser().isNoSpecialSymbolPasswordWarningPresent());
    }

//    @Test(dataProvider = "loginWithoutRegistrationFromCsv", dataProviderClass = DataProviders.class)
//    public void loginWithoutRegistrationNegativeTest(User user) {
//        app.getUser().clickOnLoginLink();
//        app.getUser().fillInLoginForm(user);
//        app.getUser().clickOnLoginButton();
//        Assert.assertTrue(app.getUser().isUserNotFoundErrorPresent());
//    }

//    @Test
//    public void loginWithWrongEmailNegativeTest() {
//        app.getUser().clickOnLoginLink();
//        app.getUser().fillInLoginForm(new User()
//                .setEmail(UserData.WRONG_EMAIL)
//                .setPassword(UserData.PASSWORD));
//        app.getUser().clickOnLoginButton();
//        Assert.assertTrue(app.getUser().isUserNotFoundErrorPresent());
//    }

//    @Test
//    public void loginWithWrongPasswordNegativeTest() {
//        app.getUser().clickOnLoginLink();
//        app.getUser().fillInLoginForm(new User()
//                .setEmail(UserData.EMAIL)
//                .setPassword(UserData.WRONG_PASSWORD));
//        app.getUser().clickOnLoginButton();
//        Assert.assertTrue(app.getUser().isWrongPasswordErrorPresent());
//    }
}
