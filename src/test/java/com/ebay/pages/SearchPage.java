package com.ebay.pages;

import com.ebay.helpers.ActionHelper;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.ebay.configs.ResourceId.SEARCHPAGE_SEARCHPLATEEDITFIELD_ID;

public class SearchPage extends BasePage {
    @AndroidFindBy(id = SEARCHPAGE_SEARCHPLATEEDITFIELD_ID)
    private AndroidElement searchPlateEditField;

    public SearchPage(AndroidDriver driver) {
        super(driver);
        uniqueElement = searchPlateEditField;
    }

    public void fillInSeachPlateWithString(String string) {
        searchPlateEditField.replaceValue(string);
    }

    public void searchWithString(String string) {
        fillInSeachPlateWithString(string);
        ActionHelper.pressEnter(driver);
    }
}
