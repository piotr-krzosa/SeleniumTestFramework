package selenium.test.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.test.framework.pages.PortalPage;
import selenium.test.framework.pages.environment.AddEnvironmentPage;
import selenium.test.framework.pages.environment.EnvironmentListPage;
import selenium.test.framework.utils.generators.BaseGenerator;

public class AddEnvironmentTests extends AbstractTest {

    /**
     * Example without action chain
     */
    @Test
    public void successAddEnvironmentTest() {
        PortalPage portalPage = new PortalPage(driver);

        EnvironmentListPage environmentListPage = portalPage.openEnvironmentListPage();

        AddEnvironmentPage addEnvironmentPage = environmentListPage.openAddEnvironmentPage();
        addEnvironmentPage.fillForm(
                "env_" + BaseGenerator.getTimestamp(),
                BaseGenerator.getRandomString(BaseGenerator.getRandomNumber(0, 255)));

        environmentListPage = addEnvironmentPage.submitForm();

        Assert.assertTrue(environmentListPage.isInfoBoxDisplayed());
    }
}