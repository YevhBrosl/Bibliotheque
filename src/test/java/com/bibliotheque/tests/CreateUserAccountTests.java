package com.bibliotheque.tests;

import com.bibliotheque.models.User;
import com.bibliotheque.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateUserAccountTests extends TestBase {

//    @BeforeMethod
//    public void ensurePrecondition() {
//        if (!app.getUser().isLoginLinkPresent()) {
//            app.getUser().clickOnSignOutButton();
//        }
//    }
//
//    @Test(dataProvider = "addNewUserFromCsv", dataProviderClass = DataProviders.class)
//    public void createAccountPositiveTest(User user) {
//        app.getUser().clickOnRegisterLink();
//        app.getUser().fillInCreateAccountForm(user);
//        app.getUser().clickOnRegisterButton();
//        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
//    }
//
//    @Test
//    public void createExistingAccountNegativeTest() {
//        app.getUser().clickOnRegisterLink();
//        app.getUser().fillInCreateAccountForm(new User()
//                .setEmail(UserData.EMAIL)
//                .setPassword(UserData.PASSWORD)
//                .setConfirmPassword(UserData.CONFIRM_PASSWORD));
//        app.getUser().clickOnRegisterButton();
//        app.getUser().clickOnSignOutButton();
//        app.getUser().clickOnRegisterLink();
//        app.getUser().fillInCreateAccountForm(new User()
//                .setEmail(UserData.EMAIL)
//                .setPassword(UserData.PASSWORD)
//                .setConfirmPassword(UserData.CONFIRM_PASSWORD));
//        app.getUser().clickOnRegisterButton();
//        Assert.assertTrue(app.getUser().isExistingUserErrorPresent());
//    }
//

    @Test(dataProvider = "registrationLoginWithInvalidEmailFromCsv", dataProviderClass = DataProviders.class)
    public void createAccountWithInvalidEmailNegativeTest(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillInCreateAccountForm(user);
        Assert.assertTrue(app.getUser().isInvalidEmailWarningPresent("Input does not correspond with an email"));
    }

    @Test(dataProvider = "registrationLoginWithShortPasswordFromCsv", dataProviderClass = DataProviders.class)
    public void createAccountWithShortPasswordNegativeTest(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillInCreateAccountForm(user);
        Assert.assertTrue(app.getUser().isInvalidPasswordWarningPresent("8 symbols"));
    }

    @Test(dataProvider = "registrationLoginWithNoUppercasePasswordFromCsv", dataProviderClass = DataProviders.class)
    public void createAccountWithNoUppercasePasswordNegativeTest(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillInCreateAccountForm(user);
        Assert.assertTrue(app.getUser().isInvalidPasswordWarningPresent("capital letter"));
    }

    @Test(dataProvider = "registrationLoginWithNoLowercasePasswordFromCsv", dataProviderClass = DataProviders.class)
    public void createAccountWithNoLowercasePasswordNegativeTest(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillInCreateAccountForm(user);
        Assert.assertTrue(app.getUser().isInvalidPasswordWarningPresent("small letter"));
    }

    @Test(dataProvider = "registrationLoginWithNoDigitsPasswordFromCsv", dataProviderClass = DataProviders.class)
    public void createAccountWithNoDigitsPasswordNegativeTest(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillInCreateAccountForm(user);
        Assert.assertTrue(app.getUser().isInvalidPasswordWarningPresent("numerical digit"));
    }

    @Test(dataProvider = "registrationLoginWithNoSpecSymbolsPasswordFromCsv", dataProviderClass = DataProviders.class)
    public void createAccountWithNoSpecSymbolsPasswordNegativeTest(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillInCreateAccountForm(user);
        Assert.assertTrue(app.getUser().isInvalidPasswordWarningPresent("special symbol"));
    }

    @Test(dataProvider = "registrationWithNonMatchingPasswordsFromCsv", dataProviderClass = DataProviders.class)
    public void createAccountWithNonMatchingPasswordsNegativeTest(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillInCreateAccountForm(user);
        Assert.assertTrue(app.getUser().isFailedPasswordConfirmationWarningPresent("Passwords must coincide"));
    }

    @Test(dataProvider = "registrationWithEmptyEmailFromCsv", dataProviderClass = DataProviders.class)
    public void createAccountWithEmptyEmailNegativeTest(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillInCreateAccountForm(user);
        Assert.assertTrue(app.getUser().isInvalidEmailWarningPresent("Email required"));
    }

    @Test(dataProvider = "registrationWithEmptyPasswordFromCsv", dataProviderClass = DataProviders.class)
    public void createAccountWithEmptyPasswordNegativeTest(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillInCreateAccountForm(user);
        Assert.assertTrue(app.getUser().isInvalidPasswordWarningPresent("Password required"));
    }

    @Test
    public void createAccountWithEmptyPasswordConfirmationNegativeTest() {
        String email = "valid@gmail.com";
        String password = "Ve12345$";
        String confirmPassword = "";
        app.getUser().clickOnRegisterLink();
        app.getUser().fillInRegistrationForm(email, password, confirmPassword);
        Assert.assertTrue(app.getUser().isFailedPasswordConfirmationWarningPresent("Repeat password is required"));
    }

}
