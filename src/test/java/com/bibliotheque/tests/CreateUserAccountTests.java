package com.bibliotheque.tests;

import com.bibliotheque.data.UserData;
import com.bibliotheque.models.User;
import com.bibliotheque.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateUserAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getUser().isLogOutLinkPresent()) {
            app.getUser().clickOnLogOutLink();
        }
    }

    @Test(priority = 1)
    public void createUniversalAccountPositiveTest() {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillInCreateAccountForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD)
                .setConfirmPassword(UserData.CONFIRM_PASSWORD));
        app.getUser().clickOnRegisterButton();
        app.getUser().clickOnLogOutLink();
    }

    @Test(dataProvider = "addNewUserFromCsv", dataProviderClass = DataProviders.class)
    public void createAccountPositiveTest(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillInCreateAccountForm(user);
        app.getUser().pause(10000);
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isLogOutLinkPresent());
    }

    @Test(priority = 2)
    public void createExistingAccountNegativeTest() {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillInCreateAccountForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD)
                .setConfirmPassword(UserData.CONFIRM_PASSWORD));
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isExistingUserErrorPresent());
    }


    @Test(dataProvider = "registrationLoginWithInvalidEmailFromCsv", dataProviderClass = DataProviders.class)
    public void createAccountWithInvalidEmailNegativeTest(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillInCreateAccountForm(user);
        Assert.assertTrue(app.getUser().isInvalidEmailWarningPresent());
    }

    @Test(dataProvider = "registrationLoginWithShortPasswordFromCsv", dataProviderClass = DataProviders.class)
    public void createAccountWithShortPasswordNegativeTest(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillInCreateAccountForm(user);
        Assert.assertTrue(app.getUser().isShortPasswordWarningPresent());
    }

    @Test(dataProvider = "registrationLoginWithNoUppercasePasswordFromCsv", dataProviderClass = DataProviders.class)
    public void createAccountWithNoUppercasePasswordNegativeTest(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillInCreateAccountForm(user);
        Assert.assertTrue(app.getUser().isNoUppercasePasswordWarningPresent());
    }

    @Test(dataProvider = "registrationLoginWithNoLowercasePasswordFromCsv", dataProviderClass = DataProviders.class)
    public void createAccountWithNoLowercasePasswordNegativeTest(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillInCreateAccountForm(user);
        Assert.assertTrue(app.getUser().isNoLowercasePasswordWarningPresent());
    }

    @Test(dataProvider = "registrationLoginWithNoDigitsPasswordFromCsv", dataProviderClass = DataProviders.class)
    public void createAccountWithNoDigitsPasswordNegativeTest(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillInCreateAccountForm(user);
        Assert.assertTrue(app.getUser().isNoDigitsPasswordWarningPresent());
    }

    @Test(dataProvider = "registrationLoginWithNoSpecSymbolsPasswordFromCsv", dataProviderClass = DataProviders.class)
    public void createAccountWithNoSpecSymbolsPasswordNegativeTest(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillInCreateAccountForm(user);
        Assert.assertTrue(app.getUser().isNoSpecialSymbolPasswordWarningPresent());
    }

    @Test(dataProvider = "registrationWithNonMatchingPasswordsFromCsv", dataProviderClass = DataProviders.class)
    public void createAccountWithNonMatchingPasswordsNegativeTest(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillInCreateAccountForm(user);
        Assert.assertTrue(app.getUser().isFailedPasswordConfirmationWarningPresent());
    }

    @Test(dataProvider = "registrationWithEmptyEmailFromCsv", dataProviderClass = DataProviders.class)
    public void createAccountWithEmptyEmailNegativeTest(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillInCreateAccountForm(user);
        Assert.assertTrue(app.getUser().isEmptyEmailWarningPresent());
    }

    @Test(dataProvider = "registrationWithEmptyPasswordFromCsv", dataProviderClass = DataProviders.class)
    public void createAccountWithEmptyPasswordNegativeTest(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillInCreateAccountForm(user);
        Assert.assertTrue(app.getUser().isEmptyPasswordWarningPresent());
    }

    @Test(dataProvider = "registrationWithEmptyPasswordConfirmationFromCsv", dataProviderClass = DataProviders.class)
    public void createAccountWithEmptyPasswordConfirmationNegativeTest(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillInCreateAccountForm(user);
        Assert.assertTrue(app.getUser().isEmptyPasswordConfirmationWarningPresent());
    }

    @AfterMethod
    public void returnToHomePage() {
        app.getUser().clickOnSiteLogo();
    }

}
