package com.bibliotheque.fw;

import com.bibliotheque.models.User;
import com.bibliotheque.utils.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserHelper extends BaseHelper{
    public static final String invalidEmailWarning = PropertiesLoader.loadProperty("invalidEmailWarning");
    public static final String shortPasswordWarning = PropertiesLoader.loadProperty("shortPasswordWarning");
    public static final String noUppercasePasswordWarning = PropertiesLoader.loadProperty("noUppercasePasswordWarning");
    public static final String noLowercasePasswordWarning = PropertiesLoader.loadProperty("noLowercasePasswordWarning");
    public static final String noDigitsPasswordWarning = PropertiesLoader.loadProperty("noDigitsPasswordWarning");
    public static final String noSpecialSymbolPasswordWarning = PropertiesLoader.loadProperty("noSpecialSymbolPasswordWarning");
    public static final String nonMatchingPasswordsWarning = PropertiesLoader.loadProperty("nonMatchingPasswordsWarning");
    public static final String emptyEmailWarning = PropertiesLoader.loadProperty("emptyEmailWarning");
    public static final String emptyPasswordWarning = PropertiesLoader.loadProperty("emptyPasswordWarning");
    public static final String emptyPasswordConfirmationWarning = PropertiesLoader.loadProperty("emptyPasswordConfirmationWarning");


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

    public boolean isInvalidEmailWarningPresent() {
        return isTextPresent(By.xpath("//input[@id='email']/following-sibling::div"), invalidEmailWarning);
    }

    public boolean isShortPasswordWarningPresent() {
        return isTextPresent(By.xpath("//input[@id='password']/following-sibling::div"), shortPasswordWarning);
    }

    public boolean isNoUppercasePasswordWarningPresent() {
        return isTextPresent(By.xpath("//input[@id='password']/following-sibling::div"), noUppercasePasswordWarning);
    }

    public boolean isNoLowercasePasswordWarningPresent() {
        return isTextPresent(By.xpath("//input[@id='password']/following-sibling::div"), noLowercasePasswordWarning);
    }

    public boolean isNoDigitsPasswordWarningPresent() {
        return isTextPresent(By.xpath("//input[@id='password']/following-sibling::div"), noDigitsPasswordWarning);
    }

    public boolean isNoSpecialSymbolPasswordWarningPresent() {
        return isTextPresent(By.xpath("//input[@id='password']/following-sibling::div"), noSpecialSymbolPasswordWarning);
    }

    public boolean isFailedPasswordConfirmationWarningPresent() {
        return isTextPresent(By.xpath("//input[@id='repeatPassword']/following-sibling::div"), nonMatchingPasswordsWarning);
    }

    public boolean isEmptyEmailWarningPresent() {
        return isTextPresent(By.xpath("//input[@id='email']/following-sibling::div"), emptyEmailWarning);
    }

    public boolean isEmptyPasswordWarningPresent() {
        return isTextPresent(By.xpath("//input[@id='password']/following-sibling::div"), emptyPasswordWarning);
    }

    public boolean isEmptyPasswordConfirmationWarningPresent() {
        return isTextPresent(By.xpath("//input[@id='repeatPassword']/following-sibling::div"), emptyPasswordConfirmationWarning);
    }

}
