import utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.InboxPage;
import pages.LoginPage;
import utils.DriverFactory;

public class InboxTest {
    LoginPage loginPage;
    InboxPage inboxPage;

    @BeforeClass
    public void setup() throws Exception {
        ConfigReader.loadConfig();
        DriverFactory.initDriver().get(ConfigReader.get("url"));
        loginPage = new LoginPage(DriverFactory.getDriver());
        inboxPage = new InboxPage(DriverFactory.getDriver());
        loginPage.login(ConfigReader.get("email"), ConfigReader.get("password"));
    }

    @Test
    public void verifyInboxLoaded() {
        Assert.assertTrue(inboxPage.isInboxDisplayed(), "Inbox not visible");
        System.out.println("Inbox is displayed.");
    }

    @Test
    public void verifyFirstEmailDetails() {
        String sender = inboxPage.getFirstEmailSender();
        String subject = inboxPage.getFirstEmailSubject();
        System.out.println("First Email Sender: " + sender);
        System.out.println("First Email Subject: " + subject);
        Assert.assertNotNull(sender);
        Assert.assertNotNull(subject);
    }

    @AfterClass
    public void teardown() {
        DriverFactory.quitDriver();
    }
}
