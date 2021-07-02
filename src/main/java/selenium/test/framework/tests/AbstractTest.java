package selenium.test.framework.tests;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import selenium.test.framework.utils.configuration.DefaultConfiguration;
import selenium.test.framework.utils.configuration.FrameworkConfiguration;
import selenium.test.framework.utils.date.DateTimeHelper;
import selenium.test.framework.utils.drivers.DriverFactory;
import selenium.test.framework.utils.files.FileHelper;
import selenium.test.framework.utils.files.PathHelper;
import selenium.test.framework.utils.generators.BaseGenerator;
import selenium.test.framework.utils.logger.CustomLogger;
import selenium.test.framework.utils.properties.PropertiesReader;
import selenium.test.framework.utils.screen.Screenshot;
import selenium.test.framework.utils.test.TestHelper;
import selenium.test.framework.utils.types.BrowserType;

import java.lang.reflect.Method;
import java.util.Properties;

public class AbstractTest {

    protected static WebDriver driver;
    protected static Screenshot screenshot;
    protected static Properties properties;
    protected static ExtentReports extentReports;
    protected static ExtentSparkReporter extentSparkReporter;
    protected ExtentTest extentTest;
    protected static String reportDirectory;

    @Parameters({"browserType"})
    @BeforeSuite
    public void setUpSuite(String browserType) {

        reportDirectory = DateTimeHelper.getDateInFormat(
                BaseGenerator.getTimestamp(),
                DateTimeHelper.removeSpecialSignsFromFormat(DefaultConfiguration.DATE_TIME_FORMAT));

        extentReports = new ExtentReports();
        extentSparkReporter = new ExtentSparkReporter(PathHelper.getProjectPath() + DefaultConfiguration.REPORTS_PATH + reportDirectory + "/" + "report.html");
        extentReports.attachReporter(extentSparkReporter);

        FrameworkConfiguration.configure();
        properties = new PropertiesReader().readProperties(DefaultConfiguration.PROPERTIES_FILE_PATH);
        screenshot = new Screenshot();
        driver = new DriverFactory().getDriver(
                BrowserType.valueOf(browserType.toUpperCase()),
                Integer.parseInt(properties.getProperty("driver.timeout.implicitlyWait")),
                Boolean.parseBoolean(properties.getProperty("driver.window.maximize")));

        driver.get(properties.getProperty("url"));
        CustomLogger.info("Page '" + properties.getProperty("url") + "' opened");
    }

    @AfterSuite
    public void tearDownSuite() {
        driver.quit();
        extentReports.flush();
    }

    @BeforeMethod
    public void setUpMethod(Method method) {
        CustomLogger.info("Test '" + method.getName() + "' started!");

        extentTest = extentReports.createTest(method.getName());
        extentTest.log(Status.INFO, "Test started!");
    }

    @Parameters({"makeScreenshot"})
    @AfterMethod
    public void tearDownMethod(ITestResult iTestResult, String configurationMakeScreenshot) {
        CustomLogger.info("Test '" + iTestResult.getMethod().getMethodName() + "' finished with status: " + TestHelper.getResultName(iTestResult.getStatus()) + "!");

        boolean makeScreenshot = false;

        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, "Test finished with status: " + TestHelper.getResultName(iTestResult.getStatus()) + "!");
            if (configurationMakeScreenshot.equalsIgnoreCase("ON_FAIL"))
                makeScreenshot = true;
        } else if (iTestResult.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, "Test finished with status: " + TestHelper.getResultName(iTestResult.getStatus()) + "!");
            if (configurationMakeScreenshot.equalsIgnoreCase("ALWAYS"))
                makeScreenshot = true;
        }

        if (makeScreenshot) {
            String screenshotFileName = BaseGenerator.getTimestamp() + "_" +
                    iTestResult.getMethod().getMethodName() + "_" +
                    TestHelper.getResultName(iTestResult.getStatus()) + ".png";

            screenshot.makeScreenshot(
                    driver,
                    screenshotFileName);

            FileHelper.copyFile(PathHelper.getProjectPath() + DefaultConfiguration.SCREENSHOTS_PATH + screenshotFileName,
                    PathHelper.getProjectPath() + DefaultConfiguration.REPORTS_PATH + reportDirectory + DefaultConfiguration.REPORTS_SCREENSHOT_PATH + screenshotFileName);

            extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath("." + DefaultConfiguration.REPORTS_SCREENSHOT_PATH + screenshotFileName).build());
        }
    }
}
