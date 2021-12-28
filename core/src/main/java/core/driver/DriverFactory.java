package core.driver;

import core.browser.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;


public class DriverFactory {

    private String getOS = System.getProperty("os.name").toLowerCase();

    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance(){
        return instance;
    }

    InheritableThreadLocal<WebDriver> driver = new InheritableThreadLocal<>();

    public void setDriver(BrowserType browserType){
        if (getOS.contains("mac") && browserType.equals(BrowserType.SAFARI)){
            driver.set(new SafariDriver());
        }else {
            WebDriverManager.getInstance(DriverManagerType.valueOf(browserType.toString())).setup();
            switch (browserType){
                case CHROME:
                    driver.set(new ChromeDriver());
                    break;

                case EDGE:
                    driver.set(new EdgeDriver());
                    break;

                case FIREFOX:
                    driver.set(new FirefoxDriver());
                    break;

                case IEXPLORER:
                    if (getOS.contains("win")){
                        driver.set(new InternetExplorerDriver());
                    }
                    break;
            }
        }

        driver.get().manage().window().maximize();
    }

    public WebDriver getDriver(){
        return driver.get();
    }

    public void removeDriver(){
        if (driver.get() != null){
            try {
                driver.get().quit();
                driver.remove();
            }catch (Exception e){
                System.err.println("Unable to quit WebDriver");
            }
        }
    }
}
