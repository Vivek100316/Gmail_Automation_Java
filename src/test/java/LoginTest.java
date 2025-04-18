import utils.ConfigReader;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import pages.InboxPage;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginTest extends BaseTest {
    private static final Logger log = LogManager.getLogger(LoginTest.class);
    private LoginPage loginPage;
    private InboxPage inboxPage;
    private ExtentTest test;

    @BeforeClass
    public void setupTest() throws Exception {
        ConfigReader.loadConfig();
        DriverFactory.initDriver().get(ConfigReader.get("url"));
        loginPage = new LoginPage(DriverFactory.getDriver());
        inboxPage = new InboxPage(DriverFactory.getDriver());
        test = extent.createTest("Login Test - Gmail Automation");
    }

    @Test
    public void verifyLoginToGmail() {
        try {
            test.log(Status.INFO, "Starting Gmail login test");
            loginPage.login(ConfigReader.get("email"), ConfigReader.get("password"));
            boolean inboxVisible = inboxPage.isInboxDisplayed();
            test.log(Status.INFO, "Inbox Displayed: " + inboxVisible);
            assert inboxVisible;
            test.pass("Login successful and Inbox is displayed");
            log.info("Login successful");
        } catch (Exception e) {
            test.fail("Login test failed: " + e.getMessage());
            log.error("Login test failed", e);
            throw e;
        }
    }

    @AfterClass
    public void tearDownTest() {
        DriverFactory.quitDriver();
        extent.flush();
        log.info("Driver closed and report flushed");
    }
}