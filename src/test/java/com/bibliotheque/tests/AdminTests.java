package com.bibliotheque.tests;

import com.bibliotheque.data.AdminData;
import com.bibliotheque.models.Admin;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getAdmin().isLogOutLinkPresent()) {
            app.getAdmin().clickOnLogOutLink();
        }
        app.getAdmin().clickOnLoginLink();
        app.getAdmin().fillInLoginForm(new Admin()
                .setEmail(AdminData.EMAIL)
                .setPassword(AdminData.PASSWORD));
        app.getAdmin().clickOnLoginButton();
        app.getAdmin().clickOnProfileLink();
    }

    @Test
    public void getAllUsersListPositiveTest() {
        app.getAdmin().clickOnListUsersButton();
        Assert.assertTrue(app.getAdmin().isUserListPresent());
    }

    @Test
    public void blockUserPositiveTest() {
        app.getAdmin().clickOnListUsersButton();
        app.getAdmin().clickOnBlockButton();
        Assert.assertTrue(app.getAdmin().isActivateButtonPresent());
        app.getAdmin().clickOnActivateButton();
    }

    @Test
    public void unblockUserPositiveTest() {
        app.getAdmin().clickOnListUsersButton();
        app.getAdmin().clickOnBlockButton();
        app.getAdmin().clickOnActivateButton();
        Assert.assertTrue(app.getAdmin().isBlockButtonPresent());
    }

    @Test
    public void deleteUserPositiveTest() {
        app.getAdmin().clickOnListUsersButton();
        app.getAdmin().clickOnDeleteButton();
        Assert.assertTrue(app.getAdmin().isSuccessMessagePresent());
    }






}
