package com.bibliotheque.fw;

import com.bibliotheque.models.Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LibraryHelper extends BaseHelper{
    public LibraryHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegisterLink() {
        click(By.cssSelector(".css-1x7a1s3:nth-child(2)"));
    }

    public void fillInCreateAccountForm(Library library) {
        type(By.id("email"), library.getEmail());
        type(By.id("password"), library.getPassword());
        type(By.id("repeatPassword"), library.getConfirmPassword());
    }

    public void clickOnLibraryRadioButton() {
        click(By.cssSelector(".css-jdnsh7>label:nth-child(2)>input"));
    }

    public void clickOnRegisterButton() {
        click(By.cssSelector(".css-x0nmhz"));
    }

}
