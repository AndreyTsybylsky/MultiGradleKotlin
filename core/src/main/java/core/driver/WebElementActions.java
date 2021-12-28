package core.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class WebElementActions {
    private static WebDriver driver;
    protected WebDriverWait wait;

    public WebElementActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    protected WebElementActions waitModal(By locator) {
       // wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(org.openqa.selenium.TimeoutException.class);
        return this;
    }

    public WebElement getElement(By locator) {
       waitModal(locator);
       wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }
    public String getTitle(){
        return driver.getTitle();
    }

    public WebElementActions getUrl(String url){
        driver.get(url);
        return this;
    }
    public WebElementActions input(By key, String value){
        WebElement element = getElement(key);
        element.clear();
        element.sendKeys(value);
        return this;
    }


    public WebElementActions click(WebElement element){
        element.click();
        return this;
    }
    public WebElementActions jsClick(WebElement locator) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", locator);
        return this;
    }
    public WebElementActions scrollDown(WebElement locator) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", locator);
        return this;
    }

    public boolean isClickable(By locator) {
        if (isPresent(locator)) {
            WebElement webElement = getElement(locator);
            return isClickable(webElement);
        }
        return false;
    }

    public boolean isClickable(WebElement element) {
        return element.isEnabled() && element.isDisplayed();
    }

    public boolean isPresent(By element) {
        try {
            driver.findElement(element);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public String getElementsText(WebElement  element) {
        return element.getText();
    }

    public WebElement fluentWait(final By locator){
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(driver -> driver.findElement(locator));

        return foo;
    };


}
