package com.bibliotheque.tests;

import com.bibliotheque.models.Book;
import com.bibliotheque.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookSearchTests extends TestBase{

    @Test(dataProvider = "searchByAuthorFromCsv", dataProviderClass = DataProviders.class)
    public void searchByAuthorPositiveTest(Book book) {
        app.getBook().selectSearchOption("author");
        app.getBook().enterAuthorIntoSearchField(book);
        app.getBook().clickOnSearchButton();
//        Assert.assertTrue(app.getUser().areSearchResultsPresent());
    }

    @Test(dataProvider = "searchByTitleFromCsv", dataProviderClass = DataProviders.class)
    public void searchByTitlePositiveTest(Book book) {
        app.getBook().selectSearchOption("book");
        app.getBook().enterTitleIntoSearchField(book);
        app.getBook().clickOnSearchButton();
//        Assert.assertTrue(app.getUser().areSearchResultsPresent());
    }

    @Test(dataProvider = "searchByInvalidAuthorFromCsv", dataProviderClass = DataProviders.class)
    public void searchByAuthorNegativeTest(Book book) {
        app.getBook().selectSearchOption("author");
        app.getBook().enterAuthorIntoSearchField(book);
        app.getBook().clickOnSearchButton();
//        Assert.assertTrue(app.getUser().areSearchResultsPresent());
    }

    @Test(dataProvider = "searchByInvalidTitleFromCsv", dataProviderClass = DataProviders.class)
    public void searchByTitleNegativeTest(Book book) {
        app.getBook().selectSearchOption("book");
        app.getBook().enterTitleIntoSearchField(book);
        app.getBook().clickOnSearchButton();
//        Assert.assertTrue(app.getUser().areSearchResultsPresent());
    }
}
