import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PrestashopTest extends TestBase {

    @Test
    public void productsCurrencyAndHeadCurrencyTest(){
        app.getNavigationHelper().goToLink("http://prestashop-automation.qatestlab.com.ua/ru/");
        app.getUserHelper().getCurrencyProductsList().forEach(elem -> Assert.assertTrue(elem.toString()
                .contains(app.getUserHelper().getCurrencyFromHead())));
        System.out.println("products currency and head currency test passed successfully");
    }

    @Test
    public void searchedForCountTest(){
        app.getNavigationHelper().goToLink("http://prestashop-automation.qatestlab.com.ua/ru/");
        app.getUserHelper().setUsdAsCurrency();
        app.getUserHelper().searchByWord("dress");
        String[] searchedForField = app.getSearchPageHelper().getTextAndIntFromSearchedForField();
        String number = searchedForField[1].replace(" ", "");
        number = number.replace(".", "");
        int searchedForCount = Integer.parseInt(number);
        Assert.assertEquals(searchedForField[0], "Товаров");
        Assert.assertEquals(searchedForCount, app.getSearchPageHelper().productResultCount());
    }

    @Test
    public void currencyOfProductsAtSearchPageTest(){
        app.getSearchPageHelper().productResultListCurrency().forEach(elem -> Assert.assertTrue(elem.contains("$")));
    }

    @Test
    public void productSortingTest(){
        app.getSearchPageHelper().setSorting();
        List<Double> pricesList = app.getSearchPageHelper().pricesList();
        for (int i = 0; i < app.getSearchPageHelper().productResultCount(); i++){
            Assert.assertTrue(pricesList.get(i) >= pricesList.get(i++));
        }
    }

    @Test
    public void discountTest(){
        List<Double> discountOfSaleProduct = app.getSearchPageHelper().getDiscountOfSaleProduct();
        List<Double> regularPriceOfDiscountProduct = app.getSearchPageHelper().getDiscountProductRegularPrice();
        List<Double> priceWithDiscount = app.getSearchPageHelper().getDiscountProductPriceWithDiscount();
        for (int i = 0; i < discountOfSaleProduct.size(); i++){
            double priceAfterDiscount = regularPriceOfDiscountProduct.get(i) - regularPriceOfDiscountProduct.get(i) *
                    discountOfSaleProduct.get(i) / 100;
            double roundPriceAfterDiscount = (double)Math.round(priceAfterDiscount * 100d) / 100d;
            double priceWithDiscountOnTheSite = priceWithDiscount.get(i);
            Assert.assertEquals(roundPriceAfterDiscount, priceWithDiscountOnTheSite);
        }
    }




}
