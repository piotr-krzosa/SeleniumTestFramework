package selenium.test.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.test.framework.pages.environment.EnvironmentListPage;
import selenium.test.framework.pages.release.ReleaseListPage;
import selenium.test.framework.pages.version.VersionListPage;

public class PortalPage extends AbstractPage {

    @FindBy(xpath = "//html/body/header/div[2]/div[2]/a/span")
    private WebElement logoutButton;

    @FindBy(css = "div#wrapper > ul > li:nth-of-type(3) > a")
    private WebElement releaseListButton;

    @FindBy(css = "div#wrapper > ul > li:nth-of-type(4) > a")
    private WebElement environmentListButton;

    @FindBy(css = "div#wrapper > ul > li:nth-of-type(5) > a")
    private WebElement versionListButton;

    public PortalPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoutButtonDisplayed() {
        return isElementDisplayed(logoutButton);
    }

    public LoginPage logout() {
        clickElement(logoutButton);
        return new LoginPage(driver);
    }

    public EnvironmentListPage openEnvironmentListPage() {
        clickElement(environmentListButton);
        return new EnvironmentListPage(driver);
    }

    public VersionListPage openVersionListPage(){
        clickElement(versionListButton);
        return new VersionListPage(driver);
    }

    public ReleaseListPage openReleaseListPage(){
        clickElement(releaseListButton);
        return new ReleaseListPage(driver);
    }
}
