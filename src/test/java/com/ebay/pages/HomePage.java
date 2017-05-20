package com.ebay.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.ebay.configs.ResourceId.HOMEPAGE_SEARCHBOX_ID;

public class HomePage extends BasePage {
    @AndroidFindBy(id = HOMEPAGE_SEARCHBOX_ID)
    private AndroidElement searchBox;

    public HomePage(AndroidDriver driver) {
        super(driver);
        uniqueElement = searchBox;
    }

    public void clickSearchBox() {
        searchBox.click();
    }
}
