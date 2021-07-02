package selenium.test.framework.pages.environment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.test.framework.pages.PortalPage;

public class AddEnvironmentPage extends PortalPage {

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "description")
    private WebElement descriptionField;

    @FindBy(id = "save")
    private WebElement saveButton;

    public AddEnvironmentPage(WebDriver driver) {
        super(driver);
    }

    public AddEnvironmentPage fillForm(String name, String description) {
        fillElement(nameField, name);
        fillElement(descriptionField, description);
        return this;
    }

    public EnvironmentListPage submitForm() {
        clickElement(saveButton);
        return new EnvironmentListPage(driver);
    }
}