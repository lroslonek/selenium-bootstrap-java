package com.testdetective.pageobjects;

import com.testdetective.commons.WebdriverWaits;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(className = "modal-header")
    private WebElement adPopup;

    @FindBy(css = "#advertPopup > div > div > div.modal-header > button")
    private WebElement adPopupClose;

    @FindBy(id = "txtSearch")
    private WebElement productSearch;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage openPage() {
        driver.get("https://pl.sportsdirect.com");
        return this;
    }

    public MainPage closePopup() {
        WebdriverWaits.waitForElementVisibility(driver, adPopup, 2);
        adPopupClose.click();
        return this;
    }

    public SearchResultPage searchProduct(String phrase) {
        productSearch.sendKeys(phrase);
        productSearch.sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);
    }
}
