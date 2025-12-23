package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;

public class BookTicketPage extends CommonPage {
    private By byLblPrice = By.xpath("//p[@class=\"MuiTypography-root MuiTypography-body1\"][contains(@style, \"color: rgb(139, 195, 74); font-size: 35px; text-align: center;\")]");
    private By byLblPlace = By.xpath("//h3[contains(text(), \"Cụm Rạp\")]/following-sibling::h3");
    private By byLblAddress = By.xpath("//h3[text()=\"Địa chỉ:\"]/following-sibling::h3");
    private By byLblBox = By.xpath("//h3[text()=\"Rạp:\"]/following-sibling::h3");
    private By byLblDateTimeStart = By.xpath("//h3[text()=\"Ngày giờ chiếu:\"]/following-sibling::h3");
    private By byLblFilmName = By.xpath("//h3[text()=\"Tên Phim:\"]/following-sibling::h3");
    private By byLblSeatNo = By.xpath("//h3[contains(text(), \"Chọn:\")]/following-sibling::h3");
    private By byBtnFirstSeat = By.xpath("//button[contains(@class, \"MuiButtonBase-root MuiButton-root\")][not(@disabled)][1]");
    private By byLblFirstSeatNo = By.xpath("//button[contains(@class, \"MuiButtonBase-root MuiButton-root\")][not(@disabled)][1]/span[1]");
    private By byBtnBooking = By.xpath("//button[contains(@class, \"MuiButtonBase-root MuiButton-root\")][span[text()=\"ĐẶT VÉ\"]]");
    private By byLblBookingMsg = By.id("swal2-title");
    private By byBtnAgree = By.xpath("//button[text()=\"Đồng ý\"]");

    public String getPriceValue() {
        LOG.info("getPriceValue");
        return getText(DriverFactory.getDriver(), byLblPrice);
    }

    public String getPlaceValue() {
        LOG.info("getPlaceValue");
        return getText(DriverFactory.getDriver(), byLblPlace);
    }

    public String getAddressValue() {
        LOG.info("getAddressValue");
        return getText(DriverFactory.getDriver(), byLblAddress);
    }

    public String getBoxValue() {
        LOG.info("getBoxValue");
        return getText(DriverFactory.getDriver(), byLblBox);
    }

    public String getDateTimeStartValue() {
        LOG.info("getDateTimeStartValue");
        return getText(DriverFactory.getDriver(), byLblDateTimeStart);
    }

    public String getFilmNameValue() {
        LOG.info("getFilmNameValue");
        return getText(DriverFactory.getDriver(), byLblFilmName);
    }

    public String getSeatNoValue(boolean isGetEmptyText) {
        LOG.info("getSeatNoValue");
        if (isGetEmptyText) {
            return getEmptyText(DriverFactory.getDriver(), byLblSeatNo);
        } else {
            return getText(DriverFactory.getDriver(), byLblSeatNo);
        }
    }

    public void clickFirstSeat() {
        LOG.info("clickFirstVipSeat");
        click(DriverFactory.getDriver(), byBtnFirstSeat);
    }

    public String getFirstSeatNo() {
        LOG.info("getFirstVipSeatNo");
        return getText(DriverFactory.getDriver(), byLblFirstSeatNo);
    }

    public void clickBookingButton() {
        LOG.info("clickBookingButton");
        click(DriverFactory.getDriver(), byBtnBooking);
    }

    public String getBookingMessage() {
        LOG.info("getBookingMessage");
        return getText(DriverFactory.getDriver(), byLblBookingMsg);
    }

    public void clickAgreeButton() {
        LOG.info("clickAgreeButton");
        click(DriverFactory.getDriver(), byBtnAgree);
    }
}
