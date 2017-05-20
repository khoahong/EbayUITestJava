package com.ebay.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.ebay.configs.ResourceId.SIGNINPAGE_CLOSEBUTTON_ID;
import static com.ebay.configs.ResourceId.SIGNINPAGE_USERNAMEEDITFIELD_ID;

public class SignInPage extends BasePage {
    @AndroidFindBy(id = SIGNINPAGE_USERNAMEEDITFIELD_ID)
    private AndroidElement usernameEditField;
    @AndroidFindBy(id = SIGNINPAGE_CLOSEBUTTON_ID)
    private AndroidElement closeButton;

    public SignInPage(AndroidDriver driver) {
        super(driver);
        uniqueElement = usernameEditField;
    }

    public void fillInUsername(String username) {
        usernameEditField.replaceValue(username);
    }

    public void clickCloseButton() {
        closeButton.click();
    }
}
