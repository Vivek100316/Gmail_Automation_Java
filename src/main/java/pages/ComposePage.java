package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComposePage extends BasePage {
    public ComposePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[text()='Compose']")
    private WebElement composeButton;

    @FindBy(name = "to")
    private WebElement toField;

    @FindBy(name = "subjectbox")
    private WebElement subjectField;

    @FindBy(xpath = "//div[@aria-label='Message Body']")
    private WebElement bodyField;

    @FindBy(xpath = "//div[text()='Send']")
    private WebElement sendButton;

    public void composeAndSend(String to, String subject, String body) {
        click(composeButton);
        type(toField, to);
        type(subjectField, subject);
        type(bodyField, body);
        click(sendButton);
    }
}
