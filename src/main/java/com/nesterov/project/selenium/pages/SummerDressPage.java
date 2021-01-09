package com.nesterov.project.selenium.pages;

import com.codeborne.selenide.SelenideElement;
import com.nesterov.project.config.PageConfig;
import org.openqa.selenium.By;

public class SummerDressPage extends BasePage {

    private static final By PRINTED_CHIFFON_DRESS_ELEMENT = By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[3]");
    private static final By ADD_TO_CART_BUTTON = By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[3]/div[1]/div[2]/div[2]/a[1]");
    public static final By SUCCESSFULLY_ADDED_TEXT = By.xpath("//header/div[3]/div[1]/div[1]/div[4]/div[1]/div[1]/h2[1]");

    public SummerDressPage(String browser) {
        super(browser);
    }

    public void open() {
        open(PageConfig.SUMMER_DRESS_PAGE_URL);
    }

    public SelenideElement addToCart() {
        findPrintedChiffonDress().hover();
        findElement(ADD_TO_CART_BUTTON).click();
        return findElement(SUCCESSFULLY_ADDED_TEXT);
    }

    private SelenideElement findPrintedChiffonDress() {
        return findElement(PRINTED_CHIFFON_DRESS_ELEMENT);
    }
}
