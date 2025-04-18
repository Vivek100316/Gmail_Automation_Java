package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import pages.BasePage;

import java.util.List;

public class InboxPage extends BasePage {
    public InboxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@title, 'Inbox')] | //div[text()='Inbox']")
    private WebElement inboxLabel;

    @FindBy(xpath = "//table[@role='grid']//tr[contains(@class,'zA')]")
    private List<WebElement> emailRows;

    @FindBy(xpath = "//tr[@jscontroller and contains(@class, 'zA')]//span[@email]")
    private WebElement firstEmailSender;

    @FindBy(xpath = "//tr[@jscontroller and contains(@class, 'zA')]//span[@class='bog']")
    private WebElement firstEmailSubject;

    public boolean isInboxDisplayed() {
        return isElementVisible(inboxLabel);
    }

    public int getEmailCount() {
        return emailRows.size();
    }

    public String getFirstEmailSender() {
        return firstEmailSender.getText();
    }

    public String getFirstEmailSubject() {
        return firstEmailSubject.getText();
    }

    public void openFirstEmail() {
        if (!emailRows.isEmpty()) {
            emailRows.get(0).click();
        }
    }
}