package testcases;

import base.BaseTest;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import reports.ExtentReportManager;

@Listeners(TestListener.class)
public class TC02_LoginTest extends BaseTest {

    @Test(description = "Login Test")
    public void testLogin() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        driver.get("https://demo1.cybersoft.edu.vn/"); // Navigate (mo) 1 site

        // Step1: Click "Dang Nhap" link on the top right
        ExtentReportManager.info("Step1: Click \"Dang Nhap\" link on the top right");
        LOG.info("Step1: Click \"Dang Nhap\" link on the top right");
        homePage.getTopBarNavigation().navigateLoginPage();

        // Step2: Enter account to login
        ExtentReportManager.info("Step2: Enter account to login");
        LOG.info("Step2: Enter account to login");
        String account = "taikhoan_2025_12_20_13_41_20";
        loginPage.enterAccount(account);

        // Step3: Enter password to login
        ExtentReportManager.info("Step3: Enter password to login");
        LOG.info("Step3: Enter password to login");
        String password = "123456789";
        loginPage.enterPassword(password);

        // Step4: Click login
        ExtentReportManager.info("Step4: Click login");
        LOG.info("Step4: Click login");
        loginPage.clickLoginButton();

        // VP1: Check "Đăng nhập thành công" message display
        ExtentReportManager.info("VP1: Check \"Đăng nhập thành công\" message display");
        LOG.info("VP1: Check \"Đăng nhập thành công\" message display");
        String loginMessage = loginPage.getLoginMessage();
        Assert.assertEquals(loginMessage, "Đăng nhập thành công", "Login message fail");

        // VP2: Check "Dang Xuat" link display
        ExtentReportManager.info("VP2: Check \"Dang Xuat\" link display");
        LOG.info("VP2: Check \"Dang Xuat\" link display");
        String logoutLinkText = homePage.getTopBarNavigation().getLogoutLinkText();
        Assert.assertEquals(logoutLinkText, "Đăng xuất", "Logout text fail");

        // VP3: Check user profile name displays
        ExtentReportManager.info("VP3: Check user profile name displays");
        LOG.info("VP3: Check user profile name displays");
        String nameText = homePage.getTopBarNavigation().getNameText();
        Assert.assertEquals(nameText, "taikhoan", "Name text fail");

        ExtentReportManager.pass("PASSED");
    }
}
