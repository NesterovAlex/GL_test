package com.nesterov.project.selenium.pages;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OnlineStoreTest {

    @Test
    void verifyTotalPriceCalculatedCorrectlyInShoppingCartAfterAddingMultipleDifferentItemsIntoCart() {
        HomePage homePage = new HomePage("chrome");
        homePage.open();
        double sumPurchases = homePage.addDifferentItemToCart();
        double totalPriceFromCart = new Cart("chrome").getTotalPrice();
        assertEquals(sumPurchases, totalPriceFromCart);
    }

    @Test
    void VerifyPrintedChiffonDressPresentWithCorrectPrice() {
        String expectedPrice = "$16.40";
        String expectedTitle = "Printed Chiffon Dress";
        HomePage homePage = new HomePage("chrome");
        homePage.open();
        homePage.findPrintedChiffonDress().shouldHave(text(expectedTitle)).shouldHave(text(expectedPrice));
    }

    @Test
    void verifyPrintedChiffonDressIsAddedToCartFromSummerDressCatalogPage() {
        String expected = "Product successfully added to your shopping cart";
        SummerDressPage summerDressPage = new SummerDressPage("chrome");
        summerDressPage.open();
        summerDressPage.addToCart().shouldHave(text(expected));
    }

    @Test
    void verifyCorrectDetailsPresentOnItemDetailsPageForPrintedChiffonDress() {
        ChiffonDressPage chiffonDressPage = new ChiffonDressPage("chrome");
        chiffonDressPage.open();
        chiffonDressPage.findBasicInformation()
                .shouldHave(text("Printed Chiffon Dress"))
                .shouldHave(text("Model demo_7"))
                .shouldHave(text("Condition New"))
                .shouldHave(text("Printed chiffon knee length dress with tank straps. Deep v-neckline."));
        chiffonDressPage.findTechnicalSection()
                .shouldHave(text("$16.40"))
                .shouldHave(text("-20% $20.50"))
                .shouldHave(text("Quantity")).shouldHave(text("1"))
                .shouldHave(text("Size")).shouldHave(text("S"));
    }

    @Test
    void VerifyMultiplePrintedDiffOnDressesWithSizeMAddedToCartFromItemDetailsPage() {
        String quantity = "4";
        String size = "M";
        String expected = "Product successfully added to your shopping cart";
        ChiffonDressPage chiffonDressPage = new ChiffonDressPage("chrome");
        chiffonDressPage.open();
        chiffonDressPage.AddToCart(quantity, size).shouldHave(text(expected));
        closeWebDriver();
    }

    @Test
    void verifyTotalPriceRecalculatedCorrectlyInShoppingCartAfterChangingQuantityOfAlreadyAddedItemsInCart() {
        HomePage homePage = new HomePage("chrome");
        Cart cart = new Cart("chrome");
        homePage.open();
        double price = homePage.addProductToCart(HomePage.BLOUSE);
        cart.open();
        double beforeAdding = cart.getTotalPrice();
        assertEquals(price, beforeAdding);
        cart.addBlouse();
        double afterAdding = cart.getTotalPrice();
        assertEquals(afterAdding, price*2);
    }
}