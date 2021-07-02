package selenium.test.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.test.framework.pages.PortalPage;
import selenium.test.framework.utils.generators.BaseGenerator;

public class AddVersionTests extends AbstractTest {

    /**
     * Example with action chain
     */
    @Test
    public void successAddVersionTest() {
        Assert.assertTrue(
                new PortalPage(driver).openVersionListPage()
                        .openAddVersionPage()
                        .fillForm(
                                "ver_" + BaseGenerator.getTimestamp(),
                                BaseGenerator.getRandomString(BaseGenerator.getRandomNumber(0,255))
                        )
                        .submitForm()
                        .isInfoBoxDisplayed()
        );
    }
}