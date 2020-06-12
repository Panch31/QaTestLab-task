package helpers;

import managers.AppManager;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import pages.PageManager;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SearchPageHelper extends PageManager {

    public SearchPageHelper() {
        super(AppManager.getWebDriver());
    }

    public String[] getTextAndIntFromSearchedForField(){
        String searchedFor = searchPage.getTextFromSearchedForField();
        String[] searchedForString = searchedFor.split(":");
        return searchedForString;
    }

    public int productResultCount(){
        int productResultCount = searchPage.getSearchedProductList().size();
        return productResultCount;
    }

    public List<String> productResultListCurrency(){
        List<WebElement> resultListCurrency = searchPage.getSearchedProductListPrice();
        return resultListCurrency.stream().map(p -> p.getText()).collect(Collectors.toList());
    }

    public void setSorting(){
        searchPage.clickOnSortingButton();
        searchPage.clickOnFromHighToLowSortingField();
    }

    public List<Double> priceCompare(){
        List<WebElement> productRegularPriceList = searchPage.getProductRegularPriceList();
        List<String> regularPriceStringList = productRegularPriceList.stream().map(p -> p.getText().
                replace("," , ".").replaceAll("[^\\d.]", "")).collect(Collectors.toList());
        List<Double> regularPriceDoubleList = regularPriceStringList.stream().map(p -> Double.parseDouble(p))
        .collect(Collectors.toList());
        return regularPriceDoubleList;
    }

    public void getAncestor(){
        searchPage.getAncestor();
    }
}
