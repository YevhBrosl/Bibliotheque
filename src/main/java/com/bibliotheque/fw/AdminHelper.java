package com.bibliotheque.fw;

import com.bibliotheque.data.AdminData;
import com.bibliotheque.models.Admin;
import com.bibliotheque.models.User;
import com.bibliotheque.utils.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminHelper extends BaseHelper{

    public static final String listOfAllUsers = PropertiesLoader.loadProperty("listOfAllUsers");
    public AdminHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isLogOutLinkPresent() {
        return isElementPresent(By.xpath("//a[.='Log out']"));
    }

    public void clickOnLogOutLink() {
        click(By.xpath("//a[.='Log out']"));
    }

    public void clickOnLoginLink() {
        click(By.xpath("//a[.='Log In']"));
    }

    public void fillInLoginForm(Admin admin) {
        type(By.name("email"), admin.getEmail());
        type(By.name("password"), admin.getPassword());
    }

    public void clickOnLoginButton() {
        click(By.xpath("//button[.='Log In']"));
    }

    public void clickOnProfileLink() {
        click(By.xpath("//a[.='admin@admin.com']"));
    }

    public void clickOnListUsersButton() {
        click(By.xpath("//button[.='List of all users']"));
    }

    public boolean isUserListPresent() {
        return isTextPresent(By.xpath("//h2[.='List of all users.']"), listOfAllUsers);
    }

    public void clickOnBlockButton() {
        click(By.xpath("(//button[.='Block'])[3]"));
    }


    public boolean isActivateButtonPresent() {
        return isElementPresent(By.xpath("//button[.='Activate']"));
    }


    public void clickOnActivateButton() {
        click(By.xpath("//button[.='Activate']"));
    }


    public boolean isBlockButtonPresent() {
        return isElementPresent(By.xpath("(//button[.='Block'])[3]"));
    }

    public void clickOnDeleteButton() {
        click(By.xpath("(//button[.='Delete'])[3]"));
    }

    public boolean isSuccessMessagePresent() {
        return isElementPresent(By.cssSelector("[class*='success']"));
    }


}
