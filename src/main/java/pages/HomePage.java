package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends Page {

    public HomePage(PageManager pages) {
            super(pages);
    }

    @FindBy(xpath = "(//span[contains(@class, 'expand-more')])[2]")
    WebElement currencyField;

    @FindBy(xpath = "//span[@itemprop = 'price']")
    List<WebElement> ProductsPriceCurrencyList;

    @FindBy(xpath = "(//i[@class = 'material-icons expand-more'])[2]")
    WebElement CurrencyChangeButton;

    @FindBy(xpath = "//ul[@aria-labelledby = 'dLabel']/li[3]")
    WebElement UsdCurrency;

    @FindBy(xpath = "//input[@name = 's']")
    WebElement SearchField;

    public void goToLink(String http){
        driver.get(http);
    }

    public List getProductPriceCurrencyList(){
        wait.until(ExpectedConditions.visibilityOf(ProductsPriceCurrencyList.get(1)));
        return ProductsPriceCurrencyList;
    }

    public String getTextFromCurrencyField(){
        return currencyField.getText();
    }

    public void clickOnCurrencyChangeButton(){
        CurrencyChangeButton.click();
    }

    public void clickOnUsdCurrency(){
        wait.until(ExpectedConditions.elementToBeClickable(UsdCurrency));
        UsdCurrency.click();
    }

    public void searchByWord(String searchedText){
        SearchField.sendKeys(searchedText);
        SearchField.sendKeys(Keys.ENTER);
    }

}
