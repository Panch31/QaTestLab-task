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
    List<WebElement> productsPriceCurrencyList;

    @FindBy(xpath = "(//i[@class = 'material-icons expand-more'])[2]")
    WebElement currencyChangeButton;

    @FindBy(xpath = "//ul[@aria-labelledby = 'dLabel']/li[3]")
    WebElement usdCurrency;

    @FindBy(xpath = "//input[@name = 's']")
    WebElement searchField;

    public void goToLink(String http){
        driver.get(http);
    }

    public List getProductPriceCurrencyList(){
        wait.until(ExpectedConditions.visibilityOf(productsPriceCurrencyList.get(1)));
        return productsPriceCurrencyList;
    }

    public String getTextFromCurrencyField(){
        return currencyField.getText();
    }

    public void clickOnCurrencyChangeButton(){
        currencyChangeButton.click();
    }

    public void clickOnUsdCurrency(){
        wait.until(ExpectedConditions.elementToBeClickable(usdCurrency));
        usdCurrency.click();
    }

    public void searchByWord(String searchedText){
        searchField.sendKeys(searchedText);
        searchField.sendKeys(Keys.ENTER);
    }

}
