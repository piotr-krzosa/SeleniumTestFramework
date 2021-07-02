package selenium.test.framework.utils.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import selenium.test.framework.utils.configuration.DefaultConfiguration;
import selenium.test.framework.utils.files.PathHelper;
import selenium.test.framework.utils.logger.CustomLogger;
import selenium.test.framework.utils.types.BrowserType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public WebDriver getDriver(BrowserType browserType, int implicitlyWait, boolean windowMaximize) {
        WebDriver driver = null;

        if (browserType == BrowserType.CHROME) {
            System.setProperty("webdriver.chrome.driver", new PathHelper().getResourceFilePath(DefaultConfiguration.CHROME_DRIVER_FILE_PATH));
            driver = new ChromeDriver();
            CustomLogger.info("CHROME driver prepared");
        } else if (browserType == BrowserType.FIREFOX) {
            System.setProperty("webdriver.gecko.driver", new PathHelper().getResourceFilePath(DefaultConfiguration.FIREFOX_DRIVER_FILE_PATH));
            driver = new FirefoxDriver();
            CustomLogger.info("FIREFOX driver prepared");
        } else if (browserType == BrowserType.OPERA) {
            //TODO
        } else if (browserType == BrowserType.SAFARI) {
            //TODO
        } else if (browserType == BrowserType.EDGE) {
            //TODO
        } else if (browserType == BrowserType.IE) {
            //TODO
        } else if (browserType == BrowserType.REMOTE_CHROME) {
            try {
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new RemoteWebDriver(new URL("http://192.168.1.3:4444/wd/hub"), chromeOptions);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
        if (windowMaximize)
            driver.manage().window().maximize();
        CustomLogger.info("Driver configured with parameters: implicitlyWait = " + implicitlyWait + ", window.maximize = " + windowMaximize);
        return driver;
    }

}
