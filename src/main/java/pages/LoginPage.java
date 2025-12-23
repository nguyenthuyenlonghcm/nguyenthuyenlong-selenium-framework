package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;

public class LoginPage extends CommonPage {

    private By byTxtLoginAccount = By.id("taiKhoan");
    private By byTxtLoginPassword = By.id("matKhau");
    private By byBtnLogin = By.xpath("//button[span[text()='Đăng nhập']]");
    private By byLblLoginMsg = By.id("swal2-title");

    public void enterAccount(String account) {
        LOG.info(String.format("enterAccount: %s", account));
        sendKeys(DriverFactory.getDriver(), byTxtLoginAccount, account);
    }

    public void enterPassword(String password) {
        LOG.info(String.format("enterPassword: %s", password));
        sendKeys(DriverFactory.getDriver(), byTxtLoginPassword, password);
    }

    public void clickLoginButton() {
        LOG.info("clickLoginButton");
        click(DriverFactory.getDriver(), byBtnLogin);
    }

    public String getLoginMessage() {
        LOG.info("getLoginMessage");
        return getText(DriverFactory.getDriver(), byLblLoginMsg);
    }

    public void waitLoginMessageDisappear() {
        LOG.info("waitLoginMessageDisappear");
        waitForInvisibilityOfElementLocated(DriverFactory.getDriver(), byLblLoginMsg);
    }
}
