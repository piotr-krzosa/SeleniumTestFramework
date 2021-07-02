package selenium.test.framework.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.test.framework.pages.PortalPage;
import selenium.test.framework.utils.data.ReleaseDataProvider;
import selenium.test.framework.utils.models.ReleaseDataModel;

public class AddReleaseTests extends AbstractTest {

    private ReleaseDataModel releaseDataModel;

    @BeforeMethod
    public void setUp() {
        releaseDataModel = ReleaseDataProvider.generateDataModel();
    }

    @Test
    public void successAddReleaseTest() {
        Assert.assertTrue(
                new PortalPage(driver)
                        .openReleaseListPage()
                        .openAddReleasePage()
                        .fillForm(releaseDataModel)
                        .submitForm()
                        .isInfoBoxDisplayed());
    }

    // TODO provider with ArrayList
    @DataProvider(name = "releaseGeneratedDataProvider")
    public Object[][] releaseGeneratedDataProvider() {
        return ReleaseDataProvider.generateDataList(5);
    }

    // TODO provider with ArrayList
    @DataProvider(name = "releaseReadDataProvider")
    public Object[][] releaseReadDataProvider(){
        return ReleaseDataProvider.readDataList("releaseData.csv");
    }

    // TODO provider with ArrayList
    @Test (dataProvider = "releaseReadDataProvider")
    public void successAddReleaseTest(String name, String startDate, String endDate, String description, String idActive) {

        ReleaseDataModel releaseDataModel = new ReleaseDataModel();
        releaseDataModel.setName(name);
        releaseDataModel.setStarDate(startDate);
        releaseDataModel.setEndDate(endDate);
        releaseDataModel.setDescription(description);
        releaseDataModel.setActive(Boolean.parseBoolean(idActive));

        Assert.assertTrue(
                new PortalPage(driver)
                        .openReleaseListPage()
                        .openAddReleasePage()
                        .fillForm(releaseDataModel)
                        .submitForm()
                        .isInfoBoxDisplayed());
    }

}
