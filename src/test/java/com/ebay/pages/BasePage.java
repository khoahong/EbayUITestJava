package com.ebay.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import static com.ebay.configs.SystemConfig.ELEMENT_FIND_TIMEOUT;
import static com.ebay.configs.SystemConfig.WEBDRIVERWAIT_TIMEOUT;

public class BasePage {
    protected AndroidDriver driver;
    protected WebDriverWait driverWait;
    protected AndroidElement uniqueElement;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, WEBDRIVERWAIT_TIMEOUT);
        PageFactory.initElements(new AppiumFieldDecorator(driver, ELEMENT_FIND_TIMEOUT, TimeUnit.SECONDS), this);
    }

    public Boolean isLoaded() {
        if (uniqueElement == null)
            System.out.println("uniqueElement must be initialized!");
        return uniqueElement.isDisplayed();
    }
}
