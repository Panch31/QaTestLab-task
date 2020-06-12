package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SearchPage extends Page {

    public SearchPage(PageManager pages) {
        super(pages);
    }

    @FindBy(xpath = "//div[contains(@class, 'col-md-6')]/p")
    WebElement searchedForProductCount;

    @FindBy(xpath = "//span[@class = 'discount-percentage']")
    List<WebElement> productWithDiscount;

    @FindBy(xpath = "//div[@class = 'product-price-and-shipping']")
    List<WebElement> searchedProductsList;

    @FindBy(xpath = "//div[@class = 'product-price-and-shipping']/span[1]")
    List<WebElement> productRegularPriceList;

    @FindBy(xpath = "//div[@class = 'product-price-and-shipping']/span[contains(@itemprop, 'price')]")
    List<WebElement> searchedProductsListPrice;

    @FindBy(xpath = "(//i[@class = 'material-icons pull-xs-right'])")
    WebElement sortingButton;

    @FindBy(xpath = "(//div[@class = 'dropdown-menu']/a)[last()]")
    WebElement fromHighToLowPriceField;

    public String getTextFromSearchedForField(){
        return searchedForProductCount.getText();
    }

    public List getSearchedProductList(){
        return searchedProductsList;
    }

    public List getSearchedProductListPrice(){
        return searchedProductsListPrice;
    }

    public void clickOnSortingButton(){
        sortingButton.click();
    }

    public void clickOnFromHighToLowSortingField(){
        wait.until(ExpectedConditions.visibilityOf(fromHighToLowPriceField));
        fromHighToLowPriceField.click();
    }

    public List getProductRegularPriceList(){
        return productRegularPriceList;
    }

    public void getAncestor(){
        List<WebElement> AncestorsOfProductWithDiscount = productWithDiscount.stream().map(p -> p.findElement
                (By.xpath("//span[@class = 'discount-percentage']/parent::div"))).collect(Collectors.toList());
        AncestorsOfProductWithDiscount.forEach(elem -> System.out.println(elem.getText()));

    }

}
