package com.bibliotheque.tests;

import com.bibliotheque.data.BookData;
import com.bibliotheque.models.Book;
import com.bibliotheque.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class BookSearchTests extends TestBase {

    @Test(dataProvider = "searchByAuthorFromCsv", dataProviderClass = DataProviders.class)
    public void searchByAuthorPositiveTest(Book book) {
        app.getUser().selectSearchOption("Author");
        app.getUser().enterAuthorIntoSearchField(book);
        app.getUser().clickOnSearchButton();
        Assert.assertTrue(app.getUser().isBookAuthorFound(book));
    }

    @Test(dataProvider = "searchByTitleFromCsv", dataProviderClass = DataProviders.class)
    public void searchByTitlePositiveTest(Book book) {
        app.getUser().selectSearchOption("Title");
        app.getUser().enterTitleIntoSearchField(book);
        app.getUser().clickOnSearchButton();
        Assert.assertTrue(app.getUser().isBookTitleFound(book));
    }

    @Test
    public void searchByIsbnPositiveTest() {
        Book book = new Book().setIsbn(BookData.ISBN);
        app.getUser().selectSearchOption("ISBN");
        app.getUser().enterIsbnIntoSearchField(book);
        app.getUser().clickOnSearchButton();
        Assert.assertTrue(app.getUser().isBookIsbnFound(book));
    }

    @Test(dataProvider = "searchByInvalidAuthorFromCsv", dataProviderClass = DataProviders.class)
    public void searchByAuthorNegativeTest(Book book) {
        app.getUser().selectSearchOption("Author");
        app.getUser().enterAuthorIntoSearchField(book);
        app.getUser().clickOnSearchButton();
        Assert.assertTrue(app.getUser().isNoBookFoundMessagePresent());
    }

    @Test(dataProvider = "searchByInvalidTitleFromCsv", dataProviderClass = DataProviders.class)
    public void searchByTitleNegativeTest(Book book) {
        app.getUser().selectSearchOption("Title");
        app.getUser().enterTitleIntoSearchField(book);
        app.getUser().clickOnSearchButton();
        Assert.assertTrue(app.getUser().isNoBookFoundMessagePresent());
    }

    @Test(dataProvider = "searchByInvalidIsbnFromCsv", dataProviderClass = DataProviders.class)
    public void searchByIsbnNegativeTest(Book book) {
        app.getUser().selectSearchOption("ISBN");
        app.getUser().enterIsbnIntoSearchField(book);
        app.getUser().clickOnSearchButton();
        Assert.assertTrue(app.getUser().isNoBookFoundMessagePresent());
    }

    @AfterMethod
    public void returnToSearchPage() {
        app.getUser().clickOnSiteLogo();
    }
}
