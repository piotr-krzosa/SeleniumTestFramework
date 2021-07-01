package selenium.test.framework.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import selenium.test.framework.utils.drivers.DriverFactory;
import selenium.test.framework.utils.screen.Screenshot;
import selenium.test.framework.utils.test.TestHelper;
import selenium.test.framework.utils.types.BrowserType;

import java.util.Date;

public class AbstractTest {

    protected static WebDriver driver;
    protected static Screenshot screenshot;

    @Parameters({"browserType"})
    @BeforeSuite
    public void setUpSuite(String browserType) {
        screenshot = new Screenshot();
        driver = new DriverFactory().getDriver(BrowserType.valueOf(browserType.toUpperCase()));

        // TODO read config from file
        driver.get("http://beta.demo.testarena.pl/login");
    }

    @AfterSuite
    public void tearDownSuite() {
        driver.quit();
    }

    @Parameters({"makeScreenshot"})
    @AfterMethod
    public void tearDownMethod(ITestResult iTestResult, String configurationMakeScreenshot) {

        boolean makeScreenshot = false;

        if (configurationMakeScreenshot.equalsIgnoreCase("ALWAYS")) {
            if (iTestResult.getStatus() == ITestResult.FAILURE || iTestResult.getStatus() == ITestResult.SUCCESS)
                makeScreenshot = true;
        } else if (configurationMakeScreenshot.equalsIgnoreCase("ON_FAIL")) {
            if (iTestResult.getStatus() == ITestResult.FAILURE)
                makeScreenshot = true;
        }

        if (makeScreenshot)
            screenshot.makeScreenshot(
                    driver,
                    new Date().getTime() + "_" +
                            iTestResult.getMethod().getMethodName() + "_" +
                            TestHelper.getResultName(iTestResult.getStatus()));

    }
}
