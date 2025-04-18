import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.DriverFactory;
import utils.ExtentManager;

public class BaseTest {
    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;
    protected Logger logger;

    @BeforeClass
    public void globalSetup() throws Exception {
        ConfigReader.loadConfig();
        extent = ExtentManager.getInstance();
        logger = LogManager.getLogger(this.getClass());
        driver = DriverFactory.initDriver();
        logger.info("Driver initialized and config loaded");
    }

    @AfterClass
    public void globalTeardown() {
        DriverFactory.quitDriver();
        extent.flush();
        logger.info("Driver quit and report flushed");
    }
}