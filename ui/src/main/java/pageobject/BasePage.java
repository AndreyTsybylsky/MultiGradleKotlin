package pageobject;

import core.driver.WebElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebElementActions webElementActions;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.webElementActions = new WebElementActions(driver);
    }
}
