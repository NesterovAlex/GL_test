package com.nesterov.project.selenium.pages;

import com.nesterov.project.config.PageConfig;
import org.openqa.selenium.By;

import static java.lang.Double.parseDouble;

public class Cart extends BasePage{

    private static final By TOTAL_PRICE = By.id("total_price");
    private static final By TOTAL_SHIPPING = By.id("total_shipping");
    private static final By ADD_BLOUSE_BUTTON = By.id("cart_quantity_up_2_7_0_0");

    public Cart(String browser) {
        super(browser);
    }
    public void open() {
        open(PageConfig.CART_URL);
    }

    public double getTotalPrice(){
        open(PageConfig.CART_URL);
        double totalShipping = parseDouble(findElement(TOTAL_SHIPPING).getText().substring(1));
        return parseDouble(findElement(TOTAL_PRICE).getText().substring(1)) - totalShipping;
    }

    public void addBlouse(){
        findElement(ADD_BLOUSE_BUTTON).click();
    }
}
