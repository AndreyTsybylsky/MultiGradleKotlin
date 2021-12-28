package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public By userNameBy = By.xpath(".//*[@id='username']");
    public By passwordBy = By.xpath(".//*[@id='password']");
    public By loginByButton = By.xpath(".//*[@id='login']/button/i");

    @FindBy(xpath = ".//*[@id='username']")
    private WebElement userName;
    @FindBy(xpath = ".//*[@id='password']")
    private WebElement password;
    @FindBy(xpath = ".//*[@id='login']/button/i")
    private WebElement loginButton;

    public void openPage(String url){
        webElementActions.getUrl(url);
    }

    public LoginPage inputName(String value){
        webElementActions.input(userNameBy, value);
        return this;
    }

    public LoginPage inputPassword(String value){
        webElementActions.input(passwordBy, value);
        return this;
    }

    public LoginPage clickLoginButton(){
        webElementActions.click(loginButton);
        return this;
    }
}
