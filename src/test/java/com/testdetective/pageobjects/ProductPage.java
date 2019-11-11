package com.testdetective.pageobjects;

import com.testdetective.commons.WebdriverWaits;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(id = "dnn_ctr103511_ViewTemplate_ctl00_ctl01_Popup360Label")
    private WebElement view360;

    @FindBy(className = "addToBag")
    private WebElement addToBag;

    @FindBy(id = "pTypeLISTTHC")
    private WebElement colorSelect;

    @FindBy(id = "aPersAddToBag")
    private WebElement addToBagPopup;

    @FindBy(id = "PersonalisationModal")
    private WebElement modal;

    @FindBy(id = "bagQuantity")
    private WebElement bagQuantity;

    @FindBy(id = "aCheckout")
    private WebElement goToCheckoutPopup;

    @FindBy(css = "#PersonalisationModal > div > div > div.modal-header > button")
    private WebElement modalCloseBtn;

    @FindBy(className = "HeaderCheckoutLink")
    private WebElement goToCheckoutHeaderBtn;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage addProductToBag() {
        addToBag.click();
        WebdriverWaits.waitForElementVisibility(driver, modalCloseBtn, 3).click();
        return this;
    }

    public ProductPage bagHasOneItem() {
        WebdriverWaits.waitForElementVisibility(driver, goToCheckoutPopup, 3);
        Assert.assertEquals("Bag quantity is incorect", "1", bagQuantity.getText());
        return this;
    }

    public CheckoutPage goToCheckout() {
        goToCheckoutHeaderBtn.click();
        return new CheckoutPage(driver);
    }

}
