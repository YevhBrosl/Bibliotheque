package com.bibliotheque.fw;

import com.bibliotheque.models.Book;
import com.bibliotheque.models.User;
import com.bibliotheque.utils.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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
    public static final String failedBookSearch = PropertiesLoader.loadProperty("failedBookSearch");



    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegisterLink() {
        click(By.xpath("//a[.='Register']"));
    }

    public void fillInCreateAccountForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
        type(By.id("repeatPassword"), user.getConfirmPassword());
    }

    public void clickOnRegisterButton() {
        click(By.xpath("//button[.='Register']"));
    }

    public void clickOnLoginLink() {
        click(By.xpath("//a[.='Log In']"));
    }

    public void fillInLoginForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void clickOnLoginButton() {
        click(By.xpath("//button[.='Log In']"));
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

    public boolean isLogOutLinkPresent() {
        return isElementPresent(By.xpath("//a[.='Log out']"));
    }

    public void clickOnLogOutLink() {
        click(By.xpath("//a[.='Log out']"));
    }

    public boolean isExistingUserErrorPresent() {
        return isElementPresent(By.xpath("//span[.='email is already in use']"));
    }

    public boolean isFailureMessagePresent() {
        return isElementPresent(By.cssSelector("[class*='error']"));
    }

    public boolean isBookAuthorFound(Book book) {
        String author = book.getAuthorSurname().toLowerCase();
        WebElement data = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/main[1]/div[2]/div[1]/div[1]/div[2]/div[1]/p[2]/span[2]"));
        return shouldHaveText(data, author, 10);
    }

    public void selectSearchOption(String option) {
        WebElement selectMenu = driver.findElement(By.tagName("select"));
        Select select = new Select(selectMenu);
        select.selectByVisibleText(option);
    }

    public void enterAuthorIntoSearchField(Book book) {
        type(By.cssSelector("input[type='text']"), book.getAuthorSurname());
    }

    public void clickOnSearchButton() {
        click(By.xpath("//button[.='Search']"));
    }

    public void clickOnSiteLogo() {
        click(By.cssSelector("h1"));
    }

    public void enterTitleIntoSearchField(Book book) {
        type(By.cssSelector("input[type='text']"), book.getTitle());
    }

    public boolean isBookTitleFound(Book book) {
        String title = book.getTitle().toLowerCase();
        WebElement data = driver.findElement(By.xpath("//span[@class='css-d0k013']"));
        return shouldHaveText(data, title, 10);
    }

    public void enterIsbnIntoSearchField(Book book) {
        type(By.cssSelector("input[type='text']"), book.getIsbn());
    }

    public boolean isBookIsbnFound(Book book) {
        String isbn = book.getIsbn();
        WebElement data = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[2]/div[1]/p[3]/span[2]"));
        return shouldHaveText(data, isbn, 10);
    }

    public boolean isNoBookFoundMessagePresent() {
        return isTextPresent(By.xpath("//div[.='Failed to fetch books']"), failedBookSearch);
    }

    public void clickOnOrderButton() {
        click(By.xpath("//button[.='Order']"));
    }

    public boolean isBookAddedToCart() {
        return isElementPresent(By.xpath("//span[.='1']"));
    }

    public void tickTermsCheckbox() {
        click(By.id("terms"));
    }

    public void clickOnConfirmOrderButton() {
        click(By.xpath("//button[.='Confirm order']"));
    }

    public boolean isSuccessMessagePresent() {
        return isElementPresent(By.cssSelector("[class*='success']"));
    }

    public void fillOutBookReservationForm(User user) {
        type(By.id("firstName"), user.getFirstName());
        type(By.id("lastName"), user.getLastName());
        type(By.name("phone"), user.getPhone());
        type(By.id("zip"), user.getZip());
        type(By.id("country"), user.getCountry());
        type(By.id("city"), user.getCity());
        type(By.id("street"), user.getStreet());
        type(By.id("houseNumber"), user.getHouse());
    }

    public void returnToSearchPage() {
        click(By.xpath("//a[.='Return to book search']"));
    }


}
