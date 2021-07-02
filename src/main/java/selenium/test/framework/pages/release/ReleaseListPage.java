package selenium.test.framework.pages.release;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.test.framework.pages.PortalPage;

public class ReleaseListPage extends PortalPage {

    @FindBy(css = "section#content > article > div:nth-of-type(1) > nav > ul > li > a")
    private WebElement addReleaseButton;

    @FindBy(id = "j_info_box")
    private WebElement infoBox;

    public ReleaseListPage(WebDriver driver) {
        super(driver);
    }

    public AddReleasePage openAddReleasePage() {
        clickElement(addReleaseButton);
        return new AddReleasePage(driver);
    }

    public boolean isInfoBoxDisplayed() {
        return isElementDisplayed(infoBox);
    }
}
