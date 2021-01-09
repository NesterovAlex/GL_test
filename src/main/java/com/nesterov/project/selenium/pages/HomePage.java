package com.nesterov.project.selenium.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.nesterov.project.config.PageConfig;
import org.openqa.selenium.By;

import static java.lang.Double.parseDouble;

public class HomePage extends BasePage {

    private static final By PRINTED_CHIFFON_DRESS_ELEMENT = By.xpath("//body/div[@id='page']/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[7]/div[1]");
    public static final By BLOUSE = By.xpath("//body/div[@id='page']/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[2]/div[1]/span[1]");
    private static final By PRINTED_DRESS = By.xpath("//body/div[@id='page']/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[3]/div[1]/div[2]/div[1]/span[1]");
    private static final By PRINTED_SUMMER_DRESS = By.xpath("//body/div[@id='page']/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[6]/div[1]/div[2]/div[1]/span[1]");
    private static final By ADD_TO_CART_BUTTON = By.linkText("Add to cart");
    private static final By CLOSE = By.className("cross");

    public HomePage(String browser) {
        super(browser);
    }

    public void open() {
        open(PageConfig.HOME_PAGE_URL);
    }

    public SelenideElement findPrintedChiffonDress() {
        return findElement(PRINTED_CHIFFON_DRESS_ELEMENT);
    }

    public double addDifferentItemToCart() {
        double blousePrice = addProductToCart(BLOUSE);
        double printedDressPrice = addProductToCart(PRINTED_DRESS);
        double summerPrintedDressPrice = addProductToCart(PRINTED_SUMMER_DRESS);
        return blousePrice + printedDressPrice +summerPrintedDressPrice;
    }

    public double addProductToCart(By product){
        double price = parseDouble(findElement(product).getText().substring(1));
        findElement(product).hover();
        findElement(ADD_TO_CART_BUTTON).click();
        Selenide.element(CLOSE).click();
        return price;
    }
}
