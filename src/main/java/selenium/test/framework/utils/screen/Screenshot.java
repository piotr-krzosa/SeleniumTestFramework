package selenium.test.framework.utils.screen;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import selenium.test.framework.utils.configuration.DefaultConfiguration;
import selenium.test.framework.utils.files.FileHelper;
import selenium.test.framework.utils.files.PathHelper;

import java.io.File;

public class Screenshot {

    public void makeScreenshot(WebDriver driver, String destinationFileName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHelper.copyFile(screenshot, PathHelper.getProjectPath() + DefaultConfiguration.SCREENSHOTS_PATH + destinationFileName);
    }

    public void makeCustomScreenshot(WebDriver driver, String destinationFilePath) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHelper.copyFile(screenshot, destinationFilePath);
    }
}