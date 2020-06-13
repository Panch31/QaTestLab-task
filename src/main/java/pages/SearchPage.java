package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.logging.Logger;

public class SearchPage extends Page {

    private static final Logger log = Logger.getLogger(String.valueOf(SearchPage.class));

    public SearchPage(PageManager pages) {
        super(pages);
    }

    @FindBy(xpath = "//div[contains(@class, 'col-md-6')]/p")
    WebElement searchedForProductCount;

    @FindBy(xpath = "//span[@class = 'discount-percentage']")
    List<WebElement> discountOfProductWithDiscount;

    @FindBy(xpath = "//span[@class = 'discount-percentage']/preceding-sibling::span")
    List<WebElement> productWithDiscountRegularPrice;

    @FindBy(xpath = "//span[@class = 'discount-percentage']/following-sibling::span")
    List<WebElement> productWithDiscountPriceWithDiscount;

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
        log.info("click on the sorting field");
    }

    public void clickOnFromHighToLowSortingField(){
        wait.until(ExpectedConditions.visibilityOf(fromHighToLowPriceField));
        fromHighToLowPriceField.click();
        log.info("click on the sorting from High to Low price field");
    }

    public List getProductRegularPriceList(){
        return productRegularPriceList;
    }

    public List getDiscountOfSaleProduct(){
        return discountOfProductWithDiscount;
    }

    public List getDiscountProductRegularPrice(){
        return productWithDiscountRegularPrice;
    }

    public List getDiscountProductPriceWithDiscount(){
        return productWithDiscountPriceWithDiscount;
    }

}
