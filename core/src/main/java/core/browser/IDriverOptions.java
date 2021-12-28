package core.browser;

import org.openqa.selenium.remote.DesiredCapabilities;

public interface IDriverOptions {
   BrowserType getBrowserType();
   DesiredCapabilities getCapabilities();
}
