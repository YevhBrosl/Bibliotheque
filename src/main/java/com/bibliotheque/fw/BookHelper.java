package com.bibliotheque.fw;

import com.bibliotheque.models.Book;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookHelper extends BaseHelper{
    public BookHelper(WebDriver driver) {
        super(driver);
    }

    public void selectSearchOption(String option) {
        WebElement dropdown = driver.findElement(By.cssSelector(".css-722xk8"));
        Select select = new Select(dropdown);
        select.selectByValue(option);
    }

    public void enterAuthorIntoSearchField(Book book) {
        type(By.className("css-1v74olb"), book.getAuthor());
    }

    public void clickOnSearchButton() {
        click(By.className("css-fg22mo"));
    }

    public void enterTitleIntoSearchField(Book book) {
        type(By.className("css-1v74olb"), book.getTitle());
    }
}
