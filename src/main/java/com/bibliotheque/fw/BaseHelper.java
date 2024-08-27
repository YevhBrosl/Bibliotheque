package com.bibliotheque.fw;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BaseHelper {
    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }

    public boolean isTextPresent(By locator, String text) {
        List<WebElement> elements = driver.findElements(locator);
        for (WebElement el : elements) {
            if (el.getText().contains(text)) return true;
        }
        return false;
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(driver -> element.getText().toLowerCase().contains(text.toLowerCase()));
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String takeScreenshot() {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshots/screen-" + System.currentTimeMillis() + ".png");

        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshot.getAbsolutePath();
    }

}
