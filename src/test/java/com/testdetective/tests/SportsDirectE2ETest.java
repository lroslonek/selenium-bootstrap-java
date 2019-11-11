package com.testdetective.tests;

import com.testdetective.pageobjects.CheckoutPage;
import com.testdetective.pageobjects.MainPage;
import com.testdetective.pageobjects.ProductPage;
import com.testdetective.pageobjects.SearchResultPage;
import org.junit.Test;

public class SportsDirectE2ETest extends TestSetup {

    @Test
    public void shouldGoToCheckout() {
        new MainPage(driver)
                .openPage()
                .closePopup()
                .searchProduct("Messi");

        new SearchResultPage(driver)
                .checkIfResultsArePresent()
                .filterResults("Mens", "Black")
                .getFirstPromoCodeProduct();

        new ProductPage(driver)
                .addProductToBag()
                .bagHasOneItem()
                .goToCheckout();

        new CheckoutPage(driver)
                .totalProductQuantityCorrect();

    }
}
