package selenium.test.framework.utils.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import selenium.test.framework.utils.DefaultConfiguration;
import selenium.test.framework.utils.files.PathHelper;
import selenium.test.framework.utils.types.BrowserType;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public WebDriver getDriver(BrowserType browserType) {
        WebDriver driver = null;

        if (browserType == BrowserType.CHROME) {
            System.setProperty("webdriver.chrome.driver", new PathHelper().getResourceFilePath(DefaultConfiguration.CHROME_DRIVER_FILE_PATH));
            driver = new ChromeDriver();
        } else if (browserType == BrowserType.FIREFOX) {
            System.setProperty("webdriver.gecko.driver", new PathHelper().getResourceFilePath(DefaultConfiguration.FIREFOX_DRIVER_FILE_PATH));
            driver = new FirefoxDriver();
        } else if (browserType == BrowserType.OPERA) {
            //TODO
        } else if (browserType == BrowserType.SAFARI) {
            //TODO
        } else if (browserType == BrowserType.EDGE) {
            //TODO
        } else if (browserType == BrowserType.IE) {
            //TODO
        }

        // TODO read config from file
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

}
