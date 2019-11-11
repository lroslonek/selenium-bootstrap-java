package com.testdetective.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(id = "SubtotalLabel")
    private WebElement totalProductQuantity;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage totalProductQuantityCorrect() {
        int quantity = Character.getNumericValue(totalProductQuantity.getText().charAt(0));
        Assert.assertEquals("Item quantity is incorrect", 1, quantity);
        return this;
    }
}
