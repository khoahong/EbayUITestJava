package com.ebay.pages;

import java.util.HashMap;

import io.appium.java_client.android.AndroidDriver;

public class PageManager {
    private AndroidDriver driver;
    private HomePage homePage;
    private SearchPage searchPage;
    private SearchResultPage searchResultPage;
    private ProductDescriptionPage productDescriptionPage;
    private SignInPage signInPage;
    private HashMap<String, BasePage> pageHashMap = new HashMap<>();


    public PageManager(AndroidDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public SearchPage getSearchPage() {
        return searchPage;
    }

    public SearchResultPage getSearchResultPage() {
        return searchResultPage;
    }

    public ProductDescriptionPage getProductDescriptionPage() {
        return productDescriptionPage;
    }

    public SignInPage getSignInPage() {
        return signInPage;
    }

    public BasePage getPageByClassName(String className) {
        return pageHashMap.get(className);
    }

    public PageManager initPages() {
        this.homePage = new HomePage(driver);
        this.searchPage = new SearchPage(driver);
        this.searchResultPage = new SearchResultPage(driver);
        this.productDescriptionPage = new ProductDescriptionPage(driver);
        this.signInPage = new SignInPage(driver);
        pageHashMap.put(HomePage.class.getSimpleName(), homePage);
        pageHashMap.put(SearchPage.class.getSimpleName(), searchPage);
        pageHashMap.put(SearchResultPage.class.getSimpleName(), searchResultPage);
        pageHashMap.put(ProductDescriptionPage.class.getSimpleName(), productDescriptionPage);
        pageHashMap.put(SignInPage.class.getSimpleName(), signInPage);
        return this;
    }
}
