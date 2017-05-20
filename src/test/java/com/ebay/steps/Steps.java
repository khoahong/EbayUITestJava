package com.ebay.steps;

import com.ebay.helpers.AndroidDriverHelper;
import com.ebay.helpers.StringHelper;
import com.ebay.models.ProductInfo;
import com.ebay.pages.PageManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.util.List;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;

import static com.ebay.configs.SystemConfig.SCREENSHOT_TYPE;

public class Steps {
    PageManager pageManager;
    AndroidDriver driver;

    @Before
    public void before() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = AndroidDriverHelper.createAndroidDesiredCapabilities();
        driver = AndroidDriverHelper.createAndroidDriver(desiredCapabilities);
        pageManager = new PageManager(driver).initPages();
    }

    @After
    public void after(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            scenario.embed(Files.readAllBytes(screenshot.toPath()), SCREENSHOT_TYPE);
        }
        driver.quit();
    }


    @When("^I search for a product by keyword \"([^\"]*)\"$")
    public void searchByKeyword(String keyword) {
        pageManager.getHomePage().clickSearchBox();
        pageManager.getSearchPage().searchWithString(keyword);
    }

    @When("I sort the product by price from Low to high")
    public void sortByPriceFromLowToHigh() {
        pageManager.getSearchResultPage().sortByPriceFromLowToHigh();
    }

    @When("I get the first (\\d+) product?s in search result$")
    public void getListOfProductNamesAndPrices(int numberOfProduct) {
        List<ProductInfo> listOfProductNamesAndPrices = pageManager.getSearchResultPage().getListOfProductNamesAndPrices(numberOfProduct);
        for (ProductInfo productInfo : listOfProductNamesAndPrices) {
            System.out.println(productInfo.toString());
        }
    }

    @When("^I click on the first product in search result$")
    public void clickFirstProduct() {
        pageManager.getSearchResultPage().clickProductAtPosition(0);
    }

    @When("^I watch the product$")
    public void watchProduct() {
        pageManager.getProductDescriptionPage().watchProduct();
    }

    @When("^I fill in a random username in Username text field$")
    public void fillInRandomUsername() {
        String randomUsername = StringHelper.generateRandomUsername();
        pageManager.getSignInPage().fillInUsername(randomUsername);
    }

    @When("^I click on X button to close the SignInPage$")
    public void clickCloseButton() {
        pageManager.getSignInPage().clickCloseButton();
    }

    @Then("^\"([^\"]*)\" is showing up$")
    public void isLoaded(String page) {
        pageManager.getPageByClassName(page).isLoaded();
    }
}
