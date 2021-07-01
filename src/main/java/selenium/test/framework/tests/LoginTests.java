package selenium.test.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.test.framework.pages.LoginPage;

public class LoginTests extends AbstractTest {

    @Test
    public void successLoginTest() {
        Assert.assertTrue(
                new LoginPage(driver)
                        .fillForm("administrator@testarena.pl","sumXQQ72$L")
                        .submitForm()
                        .isLogoutButtonDisplayed());
    }
}
