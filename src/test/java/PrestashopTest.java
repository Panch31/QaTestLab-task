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


}
