package testcases;

import base.BaseTest;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import reports.ExtentReportManager;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Listeners(TestListener.class)
public class TC01_RegisterTest extends BaseTest {

    @Test(description = "Register Test")
    public void testRegister() throws InterruptedException {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();

        driver.get("https://demo1.cybersoft.edu.vn/"); // Navigate (mo) 1 site

        ZoneId vietnameZone = ZoneId.of("Asia/Ho_Chi_Minh");
        LocalDateTime now = LocalDateTime.now(vietnameZone);
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        String username = "taikhoan_" + now.format(formatter);
        String password = "123456789";
        String name = "taikhoan";
        String email = username + "@example.com";

        //Step1: Click link "Dang ky"
        ExtentReportManager.info("Step1: Click link \"Dang ky\"");
        LOG.info("Step1: Click link \"Dang ky\"");
        homePage.getTopBarNavigation().navigateRegisterPage();

        //Step2: Enter account
        ExtentReportManager.info("Step2: Enter account");
        LOG.info("Step2: Enter account");
        registerPage.enterAccount(username);

        //Step3: Enter password
        ExtentReportManager.info("Step3: Enter password");
        LOG.info("Step3: Enter password");
        registerPage.enterPassword(password);

        //Step4: Enter confirm password
        ExtentReportManager.info("Step4: Enter confirm password");
        LOG.info("Step4: Enter confirm password");
        registerPage.enterConfirmPassword(password);

        //Step5: Enter name
        ExtentReportManager.info("Step5: Enter name");
        LOG.info("Step5: Enter name");
        registerPage.enterName(name);

        //Step6: Enter email
        ExtentReportManager.info("Step6: Enter email");
        LOG.info("Step6: Enter email");
        registerPage.enterEmail(email);

        //Step7: Click register button
        ExtentReportManager.info("Step7: Click register button");
        LOG.info("Step7: Click register button");
        registerPage.clickRegister();

        //Step8: Verify user register successfully
        ExtentReportManager.info("Step8: Verify user register successfully");
        LOG.info("Step8: Verify user register successfully");
        //VP1: "Đăng ký thành công" message display
        ExtentReportManager.info("VP1: \"Đăng ký thành công\" message display");
        LOG.info("VP1: \"Đăng ký thành công\" message display");
        String actualRegisterMsg = registerPage.getRegisterMessage();
        Assert.assertEquals(actualRegisterMsg, "Đăng ký thành công", "Register message fail");

        //VP2: Check register page still displays
        ExtentReportManager.info("VP2: Check register page still displays");
        LOG.info("VP2: Check register page still displays");
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://demo1.cybersoft.edu.vn/sign-up", "Register page does not display");

        //Wait register message disappear
        ExtentReportManager.info("Wait register message disappear");
        LOG.info("Wait register message disappear");
        registerPage.waitRegisterMessageDisappear();

        //VP3: Check new account login successfully
        ExtentReportManager.info("VP3: Check new account login successfully");
        LOG.info("VP3: Check new account login successfully");
        //Click on Login link
        ExtentReportManager.info("Click on Login link");
        LOG.info("Click on Login link");
        homePage.getTopBarNavigation().navigateLoginPage();

        //Enter account to log in
        ExtentReportManager.info("Enter account to login");
        LOG.info("Enter account to login");
        loginPage.enterAccount(username);

        //Enter password to log in
        ExtentReportManager.info("Enter password to login");
        LOG.info("Enter password to login");
        loginPage.enterPassword(password);

        //Click login
        ExtentReportManager.info("Click login");
        LOG.info("Click login");
        loginPage.clickLoginButton();

        //VP3.1: "Đăng nhập thành công" message display
        ExtentReportManager.info("VP3.1: \"Đăng nhập thành công\" message display");
        LOG.info("VP3.1: \"Đăng nhập thành công\" message display");
        String loginMessage = loginPage.getLoginMessage();
        Assert.assertEquals(loginMessage, "Đăng nhập thành công", "Login message fail");

        ExtentReportManager.pass("PASSED");
    }
}
