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
public class TC04_BookTicketTest extends BaseTest {

    @Test(description = "Book Ticket Test")
    public void testBookTicket() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();
        DetailFilmPage detailFilmPage = new DetailFilmPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

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

        /* --- 3. BOOKING TICKET --- */
        String expectedInitialPrice = "0VND";
        String expectedVipPrice = "114000VND";
        String expectedRegularPrice = "95000VND";
        List<String> expectedPrices = Arrays.asList(expectedVipPrice, expectedRegularPrice);
        String expectedPlace = "CGV - Golden Plaza";
        String expectedAddress = "Tầng 4, Trung tâm thương mại Golden Plaza, 922 Nguyễn Trãi, P. 14, Q. 5";
        String expectedBox = "Rạp 3";
        String expectedDateTimeStart = "07/12/2025 -06:12";
        String expectedFilmName = "The Gentlemen";
        String expectedInitialSeatNo = "";
        String expectedBookingMessage = "Đặt vé thành công";

        // Step13: Click banner of film 'The Gentlemen'
        ExtentReportManager.info("Step13: Click banner of film 'The Gentlemen'");
        LOG.info("Step13: Click banner of film 'The Gentlemen'");
        homePage.clickTheGentlemenLink();

        // Step14: Click first time range booking this film
        ExtentReportManager.info("Step14: Click first time range booking this film");
        LOG.info("Step14: Click first time range booking this film");
        detailFilmPage.clickTimeRangeLink();

        // VP3: Check price
        ExtentReportManager.info("VP3: Check price");
        LOG.info("VP3: Check price");
        String actualPrice = bookTicketPage.getPriceValue();
        LOG.info(actualPrice);
        Assert.assertEquals(actualPrice, expectedInitialPrice, "Price not correct");

        // VP4: Check place
        ExtentReportManager.info("VP4: Check place");
        LOG.info("VP4: Check place");
        String actualPlace = bookTicketPage.getPlaceValue();
        LOG.info(actualPlace);
        Assert.assertEquals(actualPlace, expectedPlace, "Place not correct");

        // VP5: Check address
        ExtentReportManager.info("VP5: Check address");
        LOG.info("VP5: Check address");
        String actualAddress = bookTicketPage.getAddressValue();
        LOG.info(actualAddress);
        Assert.assertEquals(actualAddress, expectedAddress, "Address not correct");

        // VP6: Check box
        ExtentReportManager.info("VP6: Check box");
        LOG.info("VP6: Check box");
        String actualBox = bookTicketPage.getBoxValue();
        LOG.info(actualBox);
        Assert.assertEquals(actualBox, expectedBox, "Box not correct");

        // VP7: Check date time the film start
        ExtentReportManager.info("VP7: Check date time the film start");
        LOG.info("VP7: Check date time the film start");
        String actualDateTimeStart = bookTicketPage.getDateTimeStartValue();
        LOG.info(actualDateTimeStart);
        Assert.assertEquals(actualDateTimeStart, expectedDateTimeStart, "DateTimeStart not correct");

        // VP8: Check film name
        ExtentReportManager.info("VP8: Check film name");
        LOG.info("VP8: Check film name");
        String actualFilmName = bookTicketPage.getFilmNameValue();
        LOG.info(actualFilmName);
        Assert.assertEquals(actualFilmName, expectedFilmName, "FilmName not correct");

        // VP9: Check seat No.
        ExtentReportManager.info("VP9: Check seat No.");
        LOG.info("VP9: Check seat No.");
        String actualSeatNo = bookTicketPage.getSeatNoValue(true);
        LOG.info(actualSeatNo);
        Assert.assertEquals(actualSeatNo, expectedInitialSeatNo, "Seat No. not correct");

        // Step15: Click the first available seat
        ExtentReportManager.info("Step15: Click the first available seat");
        LOG.info("Step15: Click the first available seat");
        bookTicketPage.clickFirstSeat();

        String firstSeatNo = String.format("Ghế %s,", bookTicketPage.getFirstSeatNo());
        LOG.info(String.format("firstSeatNo: %s", firstSeatNo));

        // VP10: Check price after selecting seat
        ExtentReportManager.info("VP10: Check price after selecting seat");
        LOG.info("VP10: Check price after selecting seat");
        String actualPriceAfterSelectingSeat = bookTicketPage.getPriceValue();
        LOG.info(actualPriceAfterSelectingSeat);
        Assert.assertTrue(expectedPrices.contains(actualPriceAfterSelectingSeat), "Price is incorrect. Expected one of " + expectedPrices + " but found: " + actualPriceAfterSelectingSeat);

        // VP11: Check place after selecting seat
        ExtentReportManager.info("VP11: Check place after selecting seat");
        LOG.info("VP11: Check place after selecting seat");
        String actualPlaceAfterSelectingSeat = bookTicketPage.getPlaceValue();
        LOG.info(actualPlaceAfterSelectingSeat);
        Assert.assertEquals(actualPlaceAfterSelectingSeat, expectedPlace, "Place not correct");

        // VP12: Check address after selecting seat
        ExtentReportManager.info("VP12: Check address after selecting seat");
        LOG.info("VP12: Check address after selecting seat");
        String actualAddressAfterSelectingSeat = bookTicketPage.getAddressValue();
        LOG.info(actualAddressAfterSelectingSeat);
        Assert.assertEquals(actualAddressAfterSelectingSeat, expectedAddress, "Address not correct");

        // VP13: Check box after selecting seat
        ExtentReportManager.info("VP13: Check box after selecting seat");
        LOG.info("VP13: Check box after selecting seat");
        String actualBoxAfterSelectingSeat = bookTicketPage.getBoxValue();
        LOG.info(actualBoxAfterSelectingSeat);
        Assert.assertEquals(actualBoxAfterSelectingSeat, expectedBox, "Box not correct");

        // VP14: Check date time the film start after selecting seat
        ExtentReportManager.info("VP14: Check date time the film start after selecting seat");
        LOG.info("VP14: Check date time the film start after selecting seat");
        String actualDateTimeStartAfterSelectingSeat = bookTicketPage.getDateTimeStartValue();
        LOG.info(actualDateTimeStartAfterSelectingSeat);
        Assert.assertEquals(actualDateTimeStartAfterSelectingSeat, expectedDateTimeStart, "DateTimeStart not correct");

        // VP15: Check film name after selecting seat
        ExtentReportManager.info("VP15: Check film name after selecting seat");
        LOG.info("VP15: Check film name after selecting seat");
        String actualFilmNameAfterSelectingSeat = bookTicketPage.getFilmNameValue();
        LOG.info(actualFilmNameAfterSelectingSeat);
        Assert.assertEquals(actualFilmNameAfterSelectingSeat, expectedFilmName, "FilmName not correct");

        // VP16: Check seat No. after selecting seat
        ExtentReportManager.info("VP16: Check seat No. after selecting seat");
        LOG.info("VP16: Check seat No. after selecting seat");
        String actualSeatNoAfterSelectingSeat = bookTicketPage.getSeatNoValue(true);
        LOG.info(actualSeatNoAfterSelectingSeat);
        Assert.assertEquals(actualSeatNoAfterSelectingSeat, firstSeatNo, "Seat No. not correct");

        // Step16: Click Booking button
        ExtentReportManager.info("Step16: Click Booking button");
        LOG.info("Step16: Click Booking button");
        bookTicketPage.clickBookingButton();

        // VP17: Check booking successful message display
        ExtentReportManager.info("VP17: Check booking successful message display");
        LOG.info("VP17: Check booking successful message display");
        String actualBookingMessage = bookTicketPage.getBookingMessage();
        Assert.assertEquals(actualBookingMessage, expectedBookingMessage, "Booking message not correct");

        ExtentReportManager.pass("PASSED");
    }
}
