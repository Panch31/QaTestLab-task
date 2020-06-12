import managers.AppManager;
import managers.SingletonAppManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import util.TestListener;

@Listeners(util.TestListener.class)
public class TestBase {

    AppManager app = SingletonAppManager.getInstance().manager;
    WebDriver driver = AppManager.getWebDriver();

    @BeforeMethod
    public void beforeMethod() {
    }

    @BeforeClass
    public void beforeClass() {
    }

    @BeforeSuite
    public void beforeSuite() {
    }


    @AfterMethod
    public void afterMethod() {
    }

    @AfterClass
    public void afterClass() {
    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }

}
