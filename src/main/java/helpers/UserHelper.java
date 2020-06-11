package helpers;

import managers.AppManager;
import org.openqa.selenium.WebElement;
import pages.PageManager;

import java.util.List;
import java.util.stream.Collectors;

public class UserHelper extends PageManager {

    public UserHelper() {
        super(AppManager.getWebDriver());
    }

    public String getCurrencyFromHead(){
       return homePage.getTextFromCurrencyField();
    }

    public List getCurrencyProductsList(){
        List<WebElement> currencyProducts = homePage.getProductPriceCurrencyList();
        List<String> currencyProductsString = currencyProducts.stream().map(p -> p.getText()).collect(Collectors.toList());
        return currencyProductsString;
    }

    public void setUsdAsCurrency(){
        homePage.clickOnCurrencyChangeButton();
        homePage.clickOnUsdCurrency();
    }

    public void searchByWord(String searchWord){
        homePage.searchByWord(searchWord);
    }

}
