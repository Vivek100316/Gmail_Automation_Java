// File: pages/LoginPage.java
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "identifierId")
    private WebElement emailField;

    @FindBy(id = "identifierNext")
    private WebElement nextEmailBtn;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(id = "passwordNext")
    private WebElement nextPasswordBtn;

    public void login(String email, String password) {
        type(emailField, email);
        click(nextEmailBtn);
        waitForVisibility(passwordField);
        type(passwordField, password);
        click(nextPasswordBtn);
    }
}
