package com.ebay.helpers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class ActionHelper {
    private static int SCREEN_TOP_EDGE = 10;
    private static int SWIPE_DURATION = 1000;

    public static void pressEnter(AndroidDriver driver) {
        driver.pressKeyCode(AndroidKeyCode.ENTER);
    }

    public static void swipeFromMiddleToTop(AndroidDriver driver) {
        int halfScreenHeight = driver.manage().window().getSize().getHeight() / 2;
        int halfScreenWidth = driver.manage().window().getSize().getWidth() / 2;
        driver.swipe(halfScreenWidth, halfScreenHeight, halfScreenWidth, SCREEN_TOP_EDGE, SWIPE_DURATION);
    }
}
