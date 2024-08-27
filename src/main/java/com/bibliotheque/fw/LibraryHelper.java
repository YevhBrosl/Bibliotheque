package com.bibliotheque.fw;

import com.bibliotheque.models.Book;
import com.bibliotheque.models.Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LibraryHelper extends BaseHelper{
    public LibraryHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isLogOutLinkPresent() {
        return isElementPresent(By.xpath("//a[.='Log out']"));
    }

    public void clickOnLogOutLink() {
        click(By.xpath("//a[.='Log out']"));
    }

    public void clickOnRegisterLink() {
        click(By.xpath("//a[.='Register']"));
    }

    public void fillInCreateAccountForm(Library library) {
        type(By.id("email"), library.getEmail());
        type(By.id("password"), library.getPassword());
        type(By.id("repeatPassword"), library.getConfirmPassword());
    }

    public void clickOnLibraryRadioButton() {
        click(By.xpath("//label[.='Library']/input"));
    }

    public void clickOnRegisterButton() {
        click(By.xpath("//button[.='Register']"));
    }

    public boolean isExistingUserErrorPresent() {
        return isElementPresent(By.xpath("//span[.='email is already in use']"));
    }

    public void clickOnLoginLink() {
        click(By.xpath("//a[.='Log In']"));
    }

    public void fillInLoginForm(Library library) {
        type(By.name("email"), library.getEmail());
        type(By.name("password"), library.getPassword());
    }

    public void clickOnLoginButton() {
        click(By.xpath("//button[.='Log In']"));
    }

    public void clickOnProfileLink() {
        click(By.xpath("//a[.='library@gm.com']"));
    }

    public boolean isSuccessMessagePresent() {
        return isElementPresent(By.cssSelector("[class*='success']"));
    }

    public void clickOnGoToLibraryManagerButton() {
        click(By.xpath("//button[.='Go to Library Manager']"));
    }

    public void clickOnRegisterNewLibraryButton() {
        click(By.xpath("//button[.='Register a new library']"));
    }

    public void fillOutLibraryRegistrationForm(Library library) {
        type(By.id("name"), library.getName());
        type(By.id("country"), library.getCountry());
        type(By.id("zip"), library.getZip());
        type(By.id("city"), library.getCity());
        type(By.id("street"), library.getStreet());
        type(By.id("number"), library.getHouse());
        type(By.cssSelector("input[name='phone']"), library.getPhone());
    }

    public void clickOnLibraryCard() {
        click(By.className("css-1nohlrz"));
    }

    public void clickOnAddNewBooksButton() {
        click(By.xpath("//button[.='Add new book(s)']"));
    }

    public void fillOutBookDataForm(Book book) {
        type(By.id("title"), book.getTitle());
        type(By.id("author_name"), book.getAuthorName());
        type(By.id("author_surname"), book.getAuthorSurname());
        type(By.id("year"), book.getYear());
        type(By.id("isbn"), book.getIsbn());
        type(By.id("publisher"), book.getPublisher());
        type(By.id("quantity"), String.valueOf(book.getQuantity()));
    }

    public void clickOnAddBookButton() {
        click(By.xpath("//button[.='Add new book']"));
    }

}
