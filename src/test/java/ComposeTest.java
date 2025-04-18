import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import pages.ComposePage;

public class ComposeTest extends BaseTest {
    @Test
    public void testComposeAndSend() {
        test = extent.createTest("Compose and Send Email Test");
        driver.get("https://mail.google.com");
        ComposePage composePage = new ComposePage(driver);
        composePage.composeAndSend("receiver@example.com", "Test Subject", "Test Body");
        test.log(Status.PASS, "Email composed and sent successfully");
        logger.info("Compose email test completed successfully");
    }
}
