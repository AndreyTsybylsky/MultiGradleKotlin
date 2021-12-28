package core.browser;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class ChromeIDriverOptions implements IDriverOptions {
    BrowserType browserType;
    ChromeOptions options = new ChromeOptions();
    DesiredCapabilities capabilities = new DesiredCapabilities();

    @Override
    public BrowserType getBrowserType() {
        browserType = BrowserType.CHROME;
        return browserType;
    }

    @Override
    public DesiredCapabilities getCapabilities() {
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        Map<String, Object> prefs = new HashMap<>();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--ignore-certificate-errors");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return capabilities;}
    }