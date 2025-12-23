package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;

public class AccountPage extends CommonPage {
    private By byLblFilmName = By.xpath("(//h1[contains(text(), 'Tên phim')])[1]");
    private By byLblTimeDuration = By.xpath("(//h3[contains(text(), 'Thời lượng')])[1]");
    private By byLblPrice = By.xpath("(//h3[contains(text(), 'Giá vé')])[1]");
    private By byLblPlace = By.xpath("(//h1[contains(@class, 'MuiTypography-colorSecondary')])[1]");
    private By byLblBox = By.xpath("(//h3[contains(text(), 'Rạp')])[1]");
    private By byLblSeatNo = By.xpath("(//h3[contains(text(), 'Ghế số')])[1]");

    public String getFilmNameValue() {
        LOG.info("getFilmNameValue");
        return getText(DriverFactory.getDriver(), byLblFilmName);
    }

    public String getTimeDurationValue() {
        LOG.info("getTimeDurationValue");
        return getText(DriverFactory.getDriver(), byLblTimeDuration);
    }

    public String getPriceValue() {
        LOG.info("getPriceValue");
        return getText(DriverFactory.getDriver(), byLblPrice);
    }

    public String getPlaceValue() {
        LOG.info("getPlaceValue");
        return getText(DriverFactory.getDriver(), byLblPlace);
    }

    public String getBoxValue() {
        LOG.info("getBoxValue");
        return getText(DriverFactory.getDriver(), byLblBox);
    }

    public String getSeatNoValue() {
        LOG.info("getSeatNoValue");
        return getText(DriverFactory.getDriver(), byLblSeatNo);
    }
}
