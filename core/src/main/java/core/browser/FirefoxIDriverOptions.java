package core.browser;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.stream.Stream;

public class FirefoxIDriverOptions implements IDriverOptions {

    BrowserType browserType;
    FirefoxOptions options = new FirefoxOptions();
    DesiredCapabilities capabilities = new DesiredCapabilities();

    @Override
    public BrowserType getBrowserType() {
       browserType = BrowserType.FIREFOX;
        return browserType;

    }

    @Override
    public DesiredCapabilities getCapabilities() {
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--ignore-certificate-errors");
        return capabilities;
    }
    Stream <Double> randoms = Stream.generate(Math::random);
}
