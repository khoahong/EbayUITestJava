package com.ebay.helpers;

import org.apache.commons.lang3.RandomStringUtils;

public class StringHelper {
    private static int USERNAME_LENGTH = 6;

    public static String generateRandomUsername() {
        return RandomStringUtils.randomAlphanumeric(USERNAME_LENGTH);
    }
}
