package helpers;

import managers.AppManager;
import pages.PageManager;

public class UserHelper extends PageManager {

    public UserHelper() {
        super(AppManager.getWebDriver());
    }

    public void getCurrencyFromHead(){
        homePage.getTextFromCurrencyField();
    }

}
