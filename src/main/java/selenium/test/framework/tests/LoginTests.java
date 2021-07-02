package selenium.test.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.test.framework.pages.LoginPage;

public class LoginTests extends AbstractTest {

    @Test
    public void successLoginTest() {
        Assert.assertTrue(
                new LoginPage(driver)
                        .fillForm(properties.getProperty("email"), properties.getProperty("password"))
                        .submitForm()
                        .isLogoutButtonDisplayed());
    }
}
