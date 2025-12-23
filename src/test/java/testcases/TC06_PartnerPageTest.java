package testcases;

import base.BaseTest;
import listeners.TestListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import reports.ExtentReportManager;

import java.time.Duration;
import java.util.Objects;

@Listeners(TestListener.class)
public class TC06_PartnerPageTest extends BaseTest {
    @Test(description = "Partner Page Test")
    public void testPartnerPage() {
        HomePage homePage = new HomePage();

        driver.get("https://demo1.cybersoft.edu.vn/");

        String parentWindowId = driver.getWindowHandle();
        LOG.info("parentWindow: " + parentWindowId);

        // Step1: Click partner cgv logo
        ExtentReportManager.info("Step1: Click partner cgv logo");
        LOG.info("Step1: Click partner cgv logo");
        homePage.navigatePartnerPage();

        // VP1: Check displaying partner page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> d.getWindowHandles().size() > 1);

        for (String windowId : driver.getWindowHandles()) {
            if (!windowId.equals(parentWindowId)) {
                driver.switchTo().window(windowId);
                break;
            }
        }

        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("cgv.vn"), "URL is incorrect: " + driver.getCurrentUrl());
    }
}
