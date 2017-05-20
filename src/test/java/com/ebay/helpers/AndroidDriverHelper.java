package com.ebay.helpers;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

import static com.ebay.configs.SystemConfig.ANDROID_PLATFORM_NAME;
import static com.ebay.configs.SystemConfig.CAPS_APP_KEY;
import static com.ebay.configs.SystemConfig.CAPS_DEVICENAME_KEY;
import static com.ebay.configs.SystemConfig.CAPS_PLATFORMNAME_KEY;
import static com.ebay.configs.SystemConfig.DRIVER_REMOTE_ADDRESS;

public class AndroidDriverHelper {
    public static DesiredCapabilities createAndroidDesiredCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(CAPS_DEVICENAME_KEY, System.getProperty("deviceName"));
        desiredCapabilities.setCapability(CAPS_PLATFORMNAME_KEY, ANDROID_PLATFORM_NAME);
        desiredCapabilities.setCapability(CAPS_APP_KEY, System.getProperty("app"));
        return desiredCapabilities;
    }

    public static AndroidDriver createAndroidDriver(DesiredCapabilities desiredCapabilities) throws MalformedURLException {
        return new AndroidDriver(new URL(DRIVER_REMOTE_ADDRESS), desiredCapabilities);
    }
}
