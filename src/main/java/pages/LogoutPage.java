package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;

public class LogoutPage extends CommonPage {
    private By byBtnAgree = By.xpath("//button[contains(@class, 'swal2-confirm')]");
    private By byLblLogoutMsg = By.id("swal2-title");

    public void clickAgreeButton() {
        LOG.info("clickAgreeButton");
        click(DriverFactory.getDriver(), byBtnAgree);
    }

    public String getLogoutMessage() {
        LOG.info("getLogoutMessage");
        return getText(DriverFactory.getDriver(), byLblLogoutMsg);
    }
}
