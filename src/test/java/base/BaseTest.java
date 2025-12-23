package base;

import drivers.DriverFactory;
import drivers.DriverManager;
import drivers.DriverManagerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import reports.ExtentReportManager;

public class BaseTest {
    protected final Logger LOG = LogManager.getLogger(getClass());
    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        LOG.info("beforeSuite - Init Extent Report");
        ExtentReportManager.initializeExtentReports();
    }

    @BeforeClass
    public void beforeClass() {
        DriverManager driverManager = DriverManagerFactory.getDriverManager("chrome");
//        DriverManager driverManager = DriverManagerFactory.getDriverManager("firefox");
//        DriverManager driverManager = DriverManagerFactory.getDriverManager("edge");
        this.driver = driverManager.getDriver();
        this.driver.manage().window().maximize();
        DriverFactory.setDriver(this.driver);
    }

    @BeforeMethod
    public void beforeMethod(ITestResult result) {
        ExtentReportManager.createTest(result.getMethod().getMethodName());
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        LOG.info("Test completed");
        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentReportManager.captureScreenshot(this.driver, result.getMethod().getMethodName());
            ExtentReportManager.fail("FAIL");
        }
    }

    @AfterClass
    public void afterClass() {
        if(this.driver != null) {
            this.driver.quit();
        }
    }

    @AfterSuite
    public void afterSuite() {
        ExtentReportManager.flushReports();
    }
}
