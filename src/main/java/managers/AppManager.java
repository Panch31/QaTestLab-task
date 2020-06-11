package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import util.PropertyLoader;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class AppManager {

    private static WebDriver driver;

    AppManager(){
        File chromeDriver = new File(PropertyLoader.loadProperty("chrome.driver.path"));
        ChromeDriverService driverService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();
        ChromeOptions chromeOptions = new ChromeOptions()
                .addArguments("--start-maximized");
        driver = new ChromeDriver(driverService, chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
    }

    public static WebDriver getWebDriver(){return driver;}

}
