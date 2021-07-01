package selenium.test.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage fillForm(String email, String password) {
        if (email != null && email.length() > 0)
            fillElement(emailField, email);
        if (password != null && password.length() > 0)
            fillElement(passwordField, password);
        return this;
    }

    public DashboardPage submitForm() {
        clickElement(loginButton);
        return new DashboardPage(driver);
    }

    public boolean isLoginButtonDisplayed() {
        return isElementDisplayed(loginButton);
    }
}
