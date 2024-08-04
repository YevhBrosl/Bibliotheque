package com.bibliotheque.fw;

import com.bibliotheque.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserHelper extends BaseHelper{
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegisterLink() {
        click(By.cssSelector(".css-1x7a1s3:nth-child(2)"));
    }

    public void fillInCreateAccountForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
        type(By.id("repeatPassword"), user.getConfirmPassword());
    }

    public void clickOnRegisterButton() {
        click(By.cssSelector(".css-x0nmhz"));
    }

    public boolean isInvalidEmailWarningPresent(String text) {
        return isTextPresent(By.xpath("//input[@id='email']/following-sibling::div"), text);
    }

    public boolean isInvalidPasswordWarningPresent(String text) {
        return isTextPresent(By.xpath("//input[@id='password']/following-sibling::div"), text);
    }

    public boolean isFailedPasswordConfirmationWarningPresent(String text) {
        return isTextPresent(By.xpath("//input[@id='repeatPassword']/following-sibling::div"), text);
    }

    public void fillInRegistrationForm(String email, String password, String confirmPassword) {
        type(By.id("email"), email);
        type(By.id("password"), password);
        type(By.id("repeatPassword"), confirmPassword);
    }

    public void clickOnLoginLink() {
        click(By.cssSelector(".css-1x7a1s3:nth-child(1)"));
    }

    public void fillInLoginForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void clickOnLoginButton() {
        click(By.cssSelector(".css-x0nmhz"));
    }


}
