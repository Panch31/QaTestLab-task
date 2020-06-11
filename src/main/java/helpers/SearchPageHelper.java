package helpers;

import managers.AppManager;
import org.openqa.selenium.WebElement;
import pages.PageManager;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPageHelper extends PageManager {

    public SearchPageHelper() {
        super(AppManager.getWebDriver());
    }

    public String[] getTextAndIntFromSearchedForField(){
        String searchedFor = searchPage.getTextFromSearchedForField();
        String[] searchedForString = searchedFor.split(":");
        System.out.println(searchedForString[0]);
        System.out.println(searchedForString[1]);
        return searchedForString;
    }

    public void clickOnSortingButton(){
        searchPage.clickOnSortingButton();
    }

    public int productResultCount(){
        int productResultCount = searchPage.getSearchedProductList().size();
        return productResultCount;
    }

    public List<String> productResultListCurrency(){
        List<WebElement> resultListCurrency = searchPage.getSearchedProductListPrice();
        return resultListCurrency.stream().map(p -> p.getText()).collect(Collectors.toList());
    }
}
