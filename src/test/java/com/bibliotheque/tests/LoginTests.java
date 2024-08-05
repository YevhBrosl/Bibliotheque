package com.bibliotheque.tests;

import com.bibliotheque.data.UserData;
import com.bibliotheque.models.User;
import com.bibliotheque.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    String email = "bertie_wooster@gm.com";
    String password = "Bertie123$";
    String confirmPassword = "Bertie123$";
    String wrongEmail = "bertiewooster@gm.com";
    String wrongPassword = "Bertie123#";

//    @BeforeClass()
//    public void createAccountPrecondition() {
//        if (app.getUser().isSignOutButtonPresent()) {
//            app.getUser().clickOnSignOutButton();
//        }
//        app.getUser().clickOnRegisterLink();
//        app.getUser().fillInRegistrationForm(email, password, confirmPassword);
//        app.getUser().clickOnRegisterButton();
//        app.getUser().clickOnSignOutButton();
//    }

//    @BeforeMethod
//    public void ensurePrecondition() {
//        if (app.getUser().isSignOutButtonPresent()) {
//            app.getUser().clickOnSignOutButton();
//        }
//    }

//    @Test()
//    public void loginPositiveTest() {
//        app.getUser().clickOnLoginLink();
//        app.getUser().fillLoginForm(new User()
//                .setEmail(UserData.EMAIL)
//                .setPassword(UserData.PASSWORD));
//        app.getUser().clickOnLoginButton();
//        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
//    }

    @Test()
    public void loginNegativeWithoutEmailTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillInLoginFormWithoutEmail(password);
        Assert.assertTrue(app.getUser().isInvalidEmailWarningPresent("Email required"));
    }

    @Test()
    public void loginNegativeWithoutPasswordTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillInLoginFormWithoutPassword(email);
        Assert.assertTrue(app.getUser().isInvalidPasswordWarningPresent("Password required"));
    }

    @Test(dataProvider = "registrationLoginWithInvalidEmailFromCsv", dataProviderClass = DataProviders.class)
    public void loginWithInvalidEmailNegativeTest(User user) {
        app.getUser().clickOnLoginLink();
        app.getUser().fillInLoginForm(user);
        Assert.assertTrue(app.getUser().isInvalidEmailWarningPresent("This is not an acceptable email"));
    }

    @Test(dataProvider = "registrationLoginWithShortPasswordFromCsv", dataProviderClass = DataProviders.class)
    public void loginWithShortPasswordNegativeTest(User user) {
        app.getUser().clickOnLoginLink();
        app.getUser().fillInLoginForm(user);
        Assert.assertTrue(app.getUser().isInvalidPasswordWarningPresent("8 symbols"));
    }

    @Test(dataProvider = "registrationLoginWithNoUppercasePasswordFromCsv", dataProviderClass = DataProviders.class)
    public void loginWithNoUppercasePasswordNegativeTest(User user) {
        app.getUser().clickOnLoginLink();
        app.getUser().fillInLoginForm(user);
        Assert.assertTrue(app.getUser().isInvalidPasswordWarningPresent("capital letter"));
    }

    @Test(dataProvider = "registrationLoginWithNoLowercasePasswordFromCsv", dataProviderClass = DataProviders.class)
    public void loginWithNoLowercasePasswordNegativeTest(User user) {
        app.getUser().clickOnLoginLink();
        app.getUser().fillInLoginForm(user);
        Assert.assertTrue(app.getUser().isInvalidPasswordWarningPresent("small letter"));
    }

    @Test(dataProvider = "registrationLoginWithNoDigitsPasswordFromCsv", dataProviderClass = DataProviders.class)
    public void loginWithNoDigitsPasswordNegativeTest(User user) {
        app.getUser().clickOnLoginLink();
        app.getUser().fillInLoginForm(user);
        Assert.assertTrue(app.getUser().isInvalidPasswordWarningPresent("numerical digit"));
    }

    @Test(dataProvider = "registrationLoginWithNoSpecSymbolsPasswordFromCsv", dataProviderClass = DataProviders.class)
    public void loginWithNoSpecSymbolsPasswordNegativeTest(User user) {
        app.getUser().clickOnLoginLink();
        app.getUser().fillInLoginForm(user);
        Assert.assertTrue(app.getUser().isInvalidPasswordWarningPresent("special symbol"));
    }

//    @Test(dataProvider = "loginWithoutRegistrationFromCsv", dataProviderClass = DataProviders.class)
//    public void loginWithoutRegistrationNegativeTest(User user) {
//        app.getUser().clickOnLoginLink();
//        app.getUser().fillInLoginForm(user);
//        app.getUser().clickOnLoginButton();
//        Assert.assertTrue(app.getUser().isUserNotFoundErrorPresent());
//    }
//
//    @Test
//    public void loginWithWrongEmailNegativeTest() {
//        app.getUser().clickOnLoginLink();
//        app.getUser().fillInLoginFormWithWrongData(wrongEmail, password);
//        app.getUser().clickOnLoginButton();
//        Assert.assertTrue(app.getUser().isUserNotFoundErrorPresent());
//    }
//
//    @Test
//    public void loginWithWrongPasswordNegativeTest() {
//        app.getUser().clickOnLoginLink();
//        app.getUser().fillInLoginFormWithWrongData(email, wrongPassword);
//        app.getUser().clickOnLoginButton();
//        Assert.assertTrue(app.getUser().isWrongPasswordErrorPresent());
//    }
}
