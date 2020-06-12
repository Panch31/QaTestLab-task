import org.testng.Assert;
import org.testng.annotations.Test;

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
        driver.navigate().refresh();
        app.getSearchPageHelper().priceCompare().forEach(elem -> System.out.println(elem));
    }

    @Test
    public void getAncestor(){
        app.getSearchPageHelper().getAncestor();
    }




}
