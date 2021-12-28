package utils;

import core.excptions.NoPropertiesException;
import org.openqa.selenium.WebDriver;
import pageobject.LoginPage;

import static core.utils.PropertyLoader.returnConfigValue;

public class LoginPageHelperUi extends HelperUi {

    public LoginPage loginPage;
    public LoginPageHelperUi(WebDriver driver){
        super(driver);
        this.loginPage = new LoginPage(driver);
    }
    public LoginPage getLoginPage() {
        return loginPage;
    }

    public LoginPageHelperUi openLoginPage() throws NoPropertiesException {
        getLoginPage().openPage(returnConfigValue("url.base"));
            return this;
    }

public LoginPageHelperUi login(User user){
        getLoginPage()
                .inputName(user.getName())
                .inputPassword(user.getPass())
                .clickLoginButton();
        return this;
}
}
