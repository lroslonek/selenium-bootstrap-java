package com.testdetective.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverWaits {

    public static WebElement waitForElementVisibility(WebDriver driver, WebElement elem, int timeout) {
        return new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.visibilityOf(elem));
    }

    public static void waitForAttributeChange
            (WebDriver driver, WebElement elem, String attribute, String value, int timeout) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.attributeToBe(elem, attribute, value));

    }

    public static void waitForElementToHaveText(WebDriver driver, WebElement elem, String text, int timeout) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.textToBePresentInElement(elem, text));

    }

}
