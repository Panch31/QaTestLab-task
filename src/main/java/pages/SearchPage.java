package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPage extends Page {

    public SearchPage(PageManager pages) {
        super(pages);
    }

    @FindBy(xpath = "//div[contains(@class, 'col-md-6')]/p")
    WebElement SearchedForProductCount;

    @FindBy(xpath = "//div[@class = 'product-price-and-shipping']")
    List<WebElement> SearchedProductsList;

    @FindBy(xpath = "//div[@class = 'product-price-and-shipping']/span[contains(@itemprop, 'price')]")
    List<WebElement> SearchedProductsListPrice;

    @FindBy(xpath = "(//i[@class = 'material-icons pull-xs-right'])")
    WebElement SortingButton;

    @FindBy(xpath = "(//div[@class = 'dropdown-menu']/a)[last()]")
    WebElement FromHighToLowPriceField;

    public String getTextFromSearchedForField(){
        return SearchedForProductCount.getText();
    }

    public List getSearchedProductList(){
        return SearchedProductsList;
    }

    public List getSearchedProductListPrice(){
        return SearchedProductsListPrice;
    }

    public void clickOnSortingButton(){
        SortingButton.click();
    }

    public void clickOnFromHughToLowSortingField(){
        wait.until(ExpectedConditions.elementToBeClickable(FromHighToLowPriceField)).click();
    }

}
