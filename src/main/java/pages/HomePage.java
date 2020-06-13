package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.logging.Logger;

public class HomePage extends Page {

    private static final Logger log = Logger.getLogger(String.valueOf(HomePage.class));

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
        log.info("get product price currency list");
        return productsPriceCurrencyList;
    }

    public String getTextFromCurrencyField(){
        log.info("get currency");
        return currencyField.getText();
    }

    public void clickOnCurrencyChangeButton(){
        log.info("click on currency button");
        currencyChangeButton.click();
    }

    public void clickOnUsdCurrency(){
        wait.until(ExpectedConditions.elementToBeClickable(usdCurrency));
        log.info("click on usd currency");
        usdCurrency.click();
    }

    public void searchByWord(String searchedText){
        searchField.sendKeys(searchedText);
        searchField.sendKeys(Keys.ENTER);
        log.info("search by word");
    }

}
