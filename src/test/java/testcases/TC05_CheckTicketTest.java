package testcases;

import base.BaseTest;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import reports.ExtentReportManager;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Listeners(TestListener.class)
public class TC05_CheckTicketTest extends BaseTest {

    @Test(description = "Check Ticket Test")
    public void testCheckTicket() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();
        DetailFilmPage detailFilmPage = new DetailFilmPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        AccountPage accountPage = new AccountPage();

        driver.get("https://demo1.cybersoft.edu.vn/");

        /* --- 1. REGISTER --- */
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

        //VP1: Check register successful message display
        ExtentReportManager.info("VP1: Check register successful message display");
        LOG.info("VP1: Check register successful message display");
        String actualRegisterMsg = registerPage.getRegisterMessage();
        Assert.assertEquals(actualRegisterMsg, "Đăng ký thành công", "Register message fail");

        // Step8: Wait register message disappear
        ExtentReportManager.info("Step8: Wait register message disappear");
        LOG.info("Step8: Wait register message disappear");
        registerPage.waitRegisterMessageDisappear();

        /* --- 2. LOGIN --- */
        // Step9: Click login link on top right
        ExtentReportManager.info("Step9: Click login link on top right");
        LOG.info("Step9: Click login link on top right");
        homePage.getTopBarNavigation().navigateLoginPage();

        // Step10: Enter account to log in
        ExtentReportManager.info("Step10: Enter account to login");
        LOG.info("Step10: Enter account to login");
        loginPage.enterAccount(username);

        // Step11: Enter password to login
        ExtentReportManager.info("Step11: Enter password to login");
        LOG.info("Step11: Enter password to login");
        loginPage.enterPassword(password);

        // Step12: Click login button
        ExtentReportManager.info("Step12: Click login button");
        LOG.info("Step12: Click login button");
        loginPage.clickLoginButton();

        // VP2: Check login successful message display
        ExtentReportManager.info("VP2: Check login successful message display");
        LOG.info("VP2: Check login successful message display");
        String loginMessage = loginPage.getLoginMessage();
        Assert.assertEquals(loginMessage, "Đăng nhập thành công", "Login message fail");

        /* --- 3. BOOK TICKET --- */
        String expectedBookingMessage = "Đặt vé thành công";

        // Step13: Click banner of film 'The Gentlemen'
        ExtentReportManager.info("Step13: Click banner of film 'The Gentlemen'");
        LOG.info("Step13: Click banner of film 'The Gentlemen'");
        homePage.clickTheGentlemenLink();

        // Step14: Click first time range booking this film
        ExtentReportManager.info("Step14: Click first time range booking this film");
        LOG.info("Step14: Click first time range booking this film");
        detailFilmPage.clickTimeRangeLink();

        // Step15: Click the first available seat
        ExtentReportManager.info("Step15: Click the first available seat");
        LOG.info("Step15: Click the first available seat");
        bookTicketPage.clickFirstSeat();

        String firstSeatNo = String.format("Ghế số:%s", bookTicketPage.getFirstSeatNo());
        LOG.info(String.format("firstSeatNo: %s", firstSeatNo));

        // Step16: Click Booking button
        ExtentReportManager.info("Step16: Click Booking button");
        LOG.info("Step16: Click Booking button");
        bookTicketPage.clickBookingButton();

        // VP3: Check booking successful message display
        ExtentReportManager.info("VP17: Check booking successful message display");
        LOG.info("VP17: Check booking successful message display");
        String actualBookingMessage = bookTicketPage.getBookingMessage();
        Assert.assertEquals(actualBookingMessage, expectedBookingMessage, "Booking message not correct");

        // Step17: Click [Đồng ý] button
        ExtentReportManager.info("Step17: Click [Đồng ý] button");
        LOG.info("Step17: Click [Đồng ý] button");
        bookTicketPage.clickAgreeButton();

        /* --- 4. CHECK TICKET --- */
        String expectedFilmName = "Tên phim: The Gentlemen";
        String expectedTimeDuration = "Thời lượng: 120 phút";
        // Giá vé: 114000 VND
        String expectedVipPrice = "Giá vé: 114000 VND";
        String expectedRegularPrice = "Giá vé: 95000 VND";
        List<String> expectedPrices = Arrays.asList(expectedVipPrice, expectedRegularPrice);
        String expectedPlace = "CGV - Golden Plaza";
        String expectedBox = "Rạp 3";

        // Step18: Click name of account on top right bar
        ExtentReportManager.info("Step18: Click name of account on top right bar");
        LOG.info("Step18: Click name of account on top right bar");
        homePage.getTopBarNavigation().navigateAccountPage();

        // VP4: Check film name
        ExtentReportManager.info("VP5: Check film name");
        LOG.info("VP5: Check film name");
        String actualFilmName = accountPage.getFilmNameValue();
        Assert.assertEquals(actualFilmName, expectedFilmName, "Film name not correct");

        // VP5: Check time duration
        ExtentReportManager.info("VP6: Check film time duration");
        LOG.info("VP6: Check film time duration");
        String actualTimeDuration = accountPage.getTimeDurationValue();
        Assert.assertEquals(actualTimeDuration, expectedTimeDuration, "Time duration not correct");

        // VP6: Check price
        ExtentReportManager.info("VP7: Check price");
        LOG.info("VP7: Check price");
        String actualPrice = accountPage.getPriceValue();
        Assert.assertTrue(expectedPrices.contains(actualPrice), "Price is incorrect. Expected one of " + expectedPrices + " but found: " + actualPrice);

        // VP7: Check place
        ExtentReportManager.info("VP8: Check place");
        LOG.info("VP8: Check place");
        String actualPlace = accountPage.getPlaceValue();
        Assert.assertEquals(actualPlace, expectedPlace, "Place not correct");

        // VP8: Check box
        ExtentReportManager.info("VP9: Check box");
        LOG.info("VP9: Check box");
        String actualBox = accountPage.getBoxValue();
        Assert.assertEquals(actualBox, expectedBox, "Box not correct");

        // VP9: Check seat No.
        ExtentReportManager.info("VP10: Check seat No.");
        LOG.info("VP10: Check seat No.");
        String actualSeatNo = accountPage.getSeatNoValue();
        Assert.assertEquals(actualSeatNo, firstSeatNo);

        ExtentReportManager.pass("PASSED");
    }
}
