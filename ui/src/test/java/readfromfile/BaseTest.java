package readfromfile;

import core.browser.BrowserType;
import core.driver.DriverFactory;
import core.driver.WebElementActions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import pageobject.BasePage;
import utils.LoginPageHelperUi;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public abstract class BaseTest {

    protected WebDriver driver;
    protected LoginPageHelperUi loginPageHelperUi;


    @BeforeAll
    void beforeAll(){
        DriverFactory.getInstance().setDriver(BrowserType.CHROME);
        driver = DriverFactory.getInstance().getDriver();
        loginPageHelperUi = new LoginPageHelperUi(driver);
    }

    @AfterAll
    void afterAll() {
        driver.quit();
        DriverFactory.getInstance().removeDriver();
    }
}
