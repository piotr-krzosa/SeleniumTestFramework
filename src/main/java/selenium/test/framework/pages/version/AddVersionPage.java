package selenium.test.framework.pages.version;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.test.framework.pages.PortalPage;

public class AddVersionPage extends PortalPage {

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "description")
    private WebElement descriptionField;

    @FindBy(id = "save")
    private WebElement saveButton;

    public AddVersionPage(WebDriver driver) {
        super(driver);
    }

    public AddVersionPage fillForm (String name, String description) {
        fillElement(nameField, name);
        fillElement(descriptionField, description);
        return this;
    }

    public VersionListPage submitForm() {
        clickElement(saveButton);
        return new VersionListPage(driver);
    }
}
