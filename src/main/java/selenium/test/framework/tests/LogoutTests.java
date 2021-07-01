package selenium.test.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.test.framework.pages.PortalPage;

public class LogoutTests extends AbstractTest {

    @Test
    public void successLogoutTest() {
        Assert.assertTrue(
                new PortalPage(driver)
                        .logout()
                        .isLoginButtonDisplayed());
    }
}