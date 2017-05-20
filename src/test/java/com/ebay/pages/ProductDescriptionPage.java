package com.ebay.pages;

import com.ebay.helpers.ActionHelper;

import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.ebay.configs.ResourceId.PRODUCTDESCRIPTIONPAGE_PRICETEXTFIELD_ID;
import static com.ebay.configs.ResourceId.PRODUCTDESCRIPTIONPAGE_WATCHBUTTON_ID;

public class ProductDescriptionPage extends BasePage {
    @AndroidFindBy(id = PRODUCTDESCRIPTIONPAGE_WATCHBUTTON_ID)
    private AndroidElement watchButton;
    @AndroidFindBy(id = PRODUCTDESCRIPTIONPAGE_PRICETEXTFIELD_ID)
    private AndroidElement priceTextField;

    public ProductDescriptionPage(AndroidDriver driver) {
        super(driver);
        uniqueElement = priceTextField;
    }

    public void watchProduct() {
        //Price text field is visible means page was loaded
        driverWait.until(ExpectedConditions.visibilityOf(priceTextField));
        ActionHelper.swipeFromMiddleToTop(driver);
        driverWait.until(ExpectedConditions.elementToBeClickable(watchButton));
        watchButton.click();
    }
}
