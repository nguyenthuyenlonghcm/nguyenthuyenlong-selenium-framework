package testcases;

import base.BaseTest;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import reports.ExtentReportManager;

@Listeners(TestListener.class)
public class TC03_LogoutTest extends BaseTest {

    @Test(description = "Logout Test")
    public void testLogout() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        LogoutPage logoutPage = new LogoutPage();

        driver.get("https://demo1.cybersoft.edu.vn/");

        /* --- 1. LOGIN --- */

        // Step1: Click "Dang Nhap" link on the top right
        ExtentReportManager.info("Step1: Click \"Dang Nhap\" link on the top right");
        LOG.info("Step1: Click \"Dang Nhap\" link on the top right");
        homePage.getTopBarNavigation().navigateLoginPage();

        // Step2: Enter account to login
        ExtentReportManager.info("Step2: Enter account to login");
        LOG.info("Step2: Enter account to login");
        String username = "taikhoan_2025_12_20_13_41_20";
        loginPage.enterAccount(username);

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

        // Step5: Wait login message disappear
        ExtentReportManager.info("Step5: Wait login message disappear");
        LOG.info("Step5: Wait login message disappear");
        loginPage.waitLoginMessageDisappear();

        /* --- 2. LOGOUT --- */

        // Step6: Click logout link on the top right
        ExtentReportManager.info("Step6: Click logout link on the top right");
        LOG.info("Step6: Click logout link on the top right");
        homePage.getTopBarNavigation().navigateLogoutPage();

        // Step7: Click agree button in logout page
        ExtentReportManager.info("Step7: Click agree button in logout page");
        LOG.info("Step7: Click agree button in logout page");
        logoutPage.clickAgreeButton();

        // VP2: Check "Đã đăng xuất" message display on top right
        ExtentReportManager.info("VP2: Check \"Đã đăng xuất\" message display on top right");
        LOG.info("VP2: Check \"Đã đăng xuất\" message display on top right");
        String logoutMessage = logoutPage.getLogoutMessage();
        Assert.assertEquals(logoutMessage, "Đã đăng xuất", "Logout message fail");

        // VP3: Check "Dang Nhap" link display on top right
        ExtentReportManager.info("VP3: Check \"Dang Nhap\" link display on top right");
        LOG.info("VP3: Check \"Dang Nhap\" link display on top right");
        String loginLinkText = homePage.getTopBarNavigation().getLoginLinkText();
        Assert.assertEquals(loginLinkText, "Đăng Nhập", "Login text fail");

        // VP4: Check "Dang Ky" link display on top right
        ExtentReportManager.info("VP4: Check \"Dang Ky\" link display on top right");
        LOG.info("VP4: Check \"Dang Ky\" link display on top right");
        String registerLinkText = homePage.getTopBarNavigation().getRegisterText();
        Assert.assertEquals(registerLinkText, "Đăng Ký", "Register text fail");

        ExtentReportManager.pass("PASSED");

    }
}
