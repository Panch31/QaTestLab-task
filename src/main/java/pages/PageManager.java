package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.PageFactory.initElements;

public class PageManager {

    private WebDriver driver;

    public PageManager(WebDriver driver){
        this.driver = driver;
    }

    private <T extends Page> T initElements(T page){
        PageFactory.initElements(driver,page);
        return page;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
