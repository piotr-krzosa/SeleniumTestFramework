package selenium.test.framework.pages.version;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.test.framework.pages.PortalPage;

public class VersionListPage extends PortalPage {

    @FindBy(css = "section#content > article > div:nth-of-type(1) > nav > ul > li > a")
    private WebElement addVersionButton;

    @FindBy(id = "j_info_box")
    private WebElement infoBox;

    public VersionListPage(WebDriver driver) {
        super(driver);
    }

    public AddVersionPage openAddVersionPage() {
        clickElement(addVersionButton);
        return new AddVersionPage(driver);
    }

    public boolean isInfoBoxDisplayed() {
        return isElementDisplayed(infoBox);
    }
}
