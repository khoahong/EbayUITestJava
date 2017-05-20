package com.ebay.pages;

import com.ebay.helpers.ActionHelper;
import com.ebay.models.ProductInfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.ebay.configs.ResourceId.SEARCHRESULTPAGE_NAMETEXTFIELD_ID;
import static com.ebay.configs.ResourceId.SEARCHRESULTPAGE_PRICEHIGHTOLOWBUTTON_XPATH;
import static com.ebay.configs.ResourceId.SEARCHRESULTPAGE_PRICETEXTFIELD_ID;
import static com.ebay.configs.ResourceId.SEARCHRESULTPAGE_PRODUCTITEMCELL_ID;
import static com.ebay.configs.ResourceId.SEARCHRESULTPAGE_SORTBUTTON_ID;
import static com.ebay.configs.SystemConfig.MAXIMUM_SCROLL;

public class SearchResultPage extends BasePage {
    @AndroidFindBy(id = SEARCHRESULTPAGE_SORTBUTTON_ID)
    private AndroidElement sortButton;
    @AndroidFindBy(xpath = SEARCHRESULTPAGE_PRICEHIGHTOLOWBUTTON_XPATH)
    private AndroidElement priceHighToLowButton;
    @AndroidFindBy(id = SEARCHRESULTPAGE_PRODUCTITEMCELL_ID)
    private List<AndroidElement> productCellItems;

    public SearchResultPage(AndroidDriver driver) {
        super(driver);
        uniqueElement = sortButton;
    }

    public void clickProductAtPosition(int index) {
        productCellItems.get(index).click();
    }

    public void sortByPriceFromLowToHigh() {
        sortButton.click();
        priceHighToLowButton.click();
    }

    public List<ProductInfo> getListOfProductNamesAndPrices(int numberOfProduct) {
        Set<ProductInfo> productNamesAndPrices = new HashSet<>();
        for (int i = 0; i < MAXIMUM_SCROLL; i++) {
            for (int j = 0; j < productCellItems.size(); j++) {
                List<MobileElement> nameInsideProductCellItem = productCellItems.get(j).findElementsById(SEARCHRESULTPAGE_NAMETEXTFIELD_ID);
                List<MobileElement> priceInsideProductCellItem = productCellItems.get(j).findElementsById(SEARCHRESULTPAGE_PRICETEXTFIELD_ID);
                if (nameInsideProductCellItem.size() > 0 && priceInsideProductCellItem.size() > 0) {
                    ProductInfo productInfo = new ProductInfo(nameInsideProductCellItem.get(0).getText(), priceInsideProductCellItem.get(0).getText());
                    productNamesAndPrices.add(productInfo);
                }
            }
            if (productNamesAndPrices.size() >= numberOfProduct)
                break;
            ActionHelper.swipeFromMiddleToTop(driver);
        }

        return new ArrayList<>(productNamesAndPrices).subList(0, numberOfProduct);
    }
}
