package com.testdetective.pageobjects;

import com.testdetective.commons.WebdriverWaits;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {

    @FindBy(css = "#dnn_ctr178840_ViewTemplate_ctl00_productsCount_prdsFound > span:nth-child(1)")
    private WebElement resultsCounter;

    @FindBy(id = "ProductContainer")
    private WebElement productContainer;

    @FindBy(xpath = "(//img[@class='rtSashImg img-responsive'])[1]")
    private WebElement firstPromoCodeProduct;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage checkIfResultsArePresent() {
        int results = Integer.valueOf(resultsCounter.getText());
        Assert.assertTrue("Empty results list!", results > 0);
        return this;
    }

    public SearchResultPage filterResults(String... filterNames) {
        for (String name: filterNames) {
            driver.findElement(By.xpath("//*[contains(@data-filtername,'" + name + "')]"))
                    .click();
        }
        handleSearchBlur();
        return this;
    }

    public ProductPage getFirstPromoCodeProduct() {
        driver.findElement(By.xpath("(//img[@class='rtSashImg img-responsive'])[1]")).click();
        return new ProductPage(driver);
    }

    private void handleSearchBlur() {
        WebdriverWaits.waitForAttributeChange(driver, productContainer, "style", "opacity: 0.5;", 2);
        WebdriverWaits.waitForAttributeChange(driver, productContainer, "style", "opacity: 1;", 2);
    }
}
