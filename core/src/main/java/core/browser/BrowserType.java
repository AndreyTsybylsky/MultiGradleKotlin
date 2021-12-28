package core.browser;

public enum BrowserType {
    EDGE("edge"),
    FIREFOX("firefox"),
    CHROME("chrome"),
    IEXPLORER("iexplorer"),
    SAFARI("safari");
    private String browserType;

    BrowserType(String browserType) {
        this.browserType = browserType;
    }

    public String getValue() {
        return browserType;
    }
}