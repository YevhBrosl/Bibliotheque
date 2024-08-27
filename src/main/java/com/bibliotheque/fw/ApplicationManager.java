package com.bibliotheque.fw;

import com.bibliotheque.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {

    String browser;
    WebDriver driver;

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    UserHelper user;

    LibraryHelper library;

    BookHelper book;

    AdminHelper admin;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {

        System.err.close();

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        WebDriverListener listener = new MyListener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);

        driver.get("http://localhost:5173");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        library = new LibraryHelper(driver);
        book = new BookHelper(driver);
        admin = new AdminHelper(driver);
    }

    public UserHelper getUser() {
        return user;
    }

    public LibraryHelper getLibrary() {
        return library;
    }

    public BookHelper getBook() {
        return book;
    }

    public AdminHelper getAdmin() {
        return admin;
    }

    public void stop() {
        driver.quit();
    }


}
