package selenium.test.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import selenium.test.framework.utils.logger.CustomLogger;
import selenium.test.framework.utils.page.ElementHelper;

public abstract class AbstractPage {

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillElement(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
        CustomLogger.info(ElementHelper.getElementLogInfo(element) + " was cleared and filled with value '" + value + "'");
    }

    public void clickElement(WebElement element) {
        String elementInfo = ElementHelper.getElementLogInfo(element);
        element.click();
        CustomLogger.info(elementInfo + " was clicked");
    }

    public boolean isElementDisplayed(WebElement element) {
        CustomLogger.info(ElementHelper.getElementLogInfo(element) + " was checked if is displayed. Result: " + element.isDisplayed());
        return element.isDisplayed();
    }
}
