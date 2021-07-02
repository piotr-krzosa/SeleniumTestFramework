package selenium.test.framework.pages.release;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.test.framework.pages.PortalPage;
import selenium.test.framework.utils.models.ReleaseDataModel;

public class AddReleasePage extends PortalPage {

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "startDate")
    private WebElement startDateField;

    @FindBy(id = "endDate")
    private WebElement endDateField;

    @FindBy(id = "description")
    private WebElement descriptionField;

    @FindBy(id = "active")
    private WebElement activeCheckbox;

    @FindBy(id = "save")
    private WebElement saveButton;

    public AddReleasePage(WebDriver driver) {
        super(driver);
    }

    public AddReleasePage fillForm(ReleaseDataModel releaseDataModel) {
        if (releaseDataModel != null) {
            if (releaseDataModel.getName() != null)
                fillElement(nameField, releaseDataModel.getName());
            if (releaseDataModel.getStarDate() != null)
                fillElement(startDateField, releaseDataModel.getStarDate());
            if (releaseDataModel.getEndDate() != null)
                fillElement(endDateField, releaseDataModel.getEndDate());
            if (releaseDataModel.getDescription() != null)
                fillElement(descriptionField, releaseDataModel.getDescription());
            if (releaseDataModel.isActive() != null)
                selectCheckbox(activeCheckbox, releaseDataModel.isActive());
        }
        return this;
    }

    public ReleaseListPage submitForm() {
        clickElement(saveButton);
        return new ReleaseListPage(driver);
    }
}
