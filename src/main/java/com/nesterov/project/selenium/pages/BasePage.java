package com.nesterov.project.selenium.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class BasePage {

    public BasePage(String browser) {
        Configuration.browser = browser;
        Configuration.startMaximized = true;
    }

    public void open(String url){
        Selenide.open(url);
    }

    public SelenideElement findElement(By element) {
       return Selenide.element(element);
    }
}
