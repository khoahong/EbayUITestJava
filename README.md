# EbayUITestJava
Demo test with Android Ebay app version 5.9.0 using Java.

### Environments
- OSX 10.11.6
- Ruby 2.3.0p0
- Appium server: 1.6.3
- Genymotion 2.8.1
- Emulator: Nexus 5, API 21, 5.0.0, 1080x1920

### How to run
- Run appium server: `appium`.
- Run emulator.
- Run `adb devices` to get list of devices.
- Navigate to project dir, Run test with gradle:
```sh
 gradle -Dcucumber.options="--tags @search.search_with_guest_user --plugin pretty --plugin html:report" -DdeviceName="your_device_name" -Dapp="full_path_to_apk"
 Ex:
 gradle -Dcucumber.options="--tags @search.search_with_guest_user --plugin pretty --plugin html:report" -DdeviceName="192.168.56.101:5555" -Dapp="/Users/test/EbayUITestJava/apk/com.ebay.mobile_5.9.0.apk"
```

### Report
- HTML report (with screenshot if scenario is failed) will be located at: `report/index.html`

### Explanations
- Project is implemented based on `Cucumber`, `PageObject` and `PageFactory`: https://github.com/SeleniumHQ/selenium/wiki/PageFactory
- `getPageByClassName(String page)` method in `PageManager` will be helpful when retrieving dynamic page:
 ```
     @Then("^\"([^\"]*)\" is showing up$")
     public void isLoaded(String page) {
         pageManager.getPageByClassName(page).isLoaded();
     }
 ```
- Method `List<ProductInfo> getListOfProductNamesAndPrices(int numberOfProduct)` will return list of N products from search result by swiping.
- `ProductInfo` will override `equals` and `hashCode` methods to support getting unique element in `HashSet<ProductInfo>`
