package selenium.test.framework.pages.environment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.test.framework.pages.PortalPage;

public class EnvironmentListPage extends PortalPage {

    @FindBy (css = "section#content > article > div:nth-of-type(1) > nav > ul > li > a")
    private WebElement addEnvironmentButton;

    @FindBy(id = "j_info_box")
    private WebElement infoBox;

    public EnvironmentListPage(WebDriver driver) {
        super(driver);
    }

    public AddEnvironmentPage openAddEnvironmentPage() {
        clickElement(addEnvironmentButton);
        return new AddEnvironmentPage(driver);
    }

    public boolean isInfoBoxDisplayed() {
        return isElementDisplayed(infoBox);
    }
}