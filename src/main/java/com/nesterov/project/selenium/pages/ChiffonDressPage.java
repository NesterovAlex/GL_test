package com.nesterov.project.selenium.pages;

import com.codeborne.selenide.SelenideElement;
import com.nesterov.project.config.PageConfig;
import org.openqa.selenium.By;

public class ChiffonDressPage extends BasePage {

    private static final By BASIC_INFORMATION_SECTION = By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]");
    private static final By TECHNICAL_INFORMATION_SECTION = By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[4]");
    private static final By QUANTITY_TYPE_FIELD = By.id("quantity_wanted");
    private static final By ADD_TO_CART_BUTTON = By.name("Submit");
    private static final By CART_DETAILS = By.xpath("//header/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]");
    private static final By SELECT_SIZE_ELEMENT = By.xpath("//select[@id='group_1']");
    private static final By BLOUSE_PRICE = By.xpath("//select[@id='group_1']");

    public ChiffonDressPage(String browser) {
        super(browser);
    }

    public void open() {
        open(PageConfig.CHIFFON_DRESS_PAGE_URL);
    }

    public SelenideElement findBasicInformation() {
        return findElement(BASIC_INFORMATION_SECTION);
    }

    public SelenideElement findTechnicalSection() {
        return findElement(TECHNICAL_INFORMATION_SECTION);
    }

    public SelenideElement AddToCart(String quantity, String size) {
        typeQuantity(quantity);
        typeSize(size);
        clickAddToCart();
        return findElement(SummerDressPage.SUCCESSFULLY_ADDED_TEXT);
    }

    private void typeQuantity(String quantity) {
        findElement(QUANTITY_TYPE_FIELD).sendKeys(quantity);
    }

    private void typeSize(String size) {
        findElement(SELECT_SIZE_ELEMENT).selectOption(size);
    }

    private void clickAddToCart() {
        findElement(ADD_TO_CART_BUTTON).click();
    }
}
