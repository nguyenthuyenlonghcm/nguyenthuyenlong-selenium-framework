package components;

import base.BasePage;
import drivers.DriverFactory;
import org.openqa.selenium.By;

public class TopBarNavigation extends BasePage {
    private By byLnkRegister = By.xpath("//h3[text()='Đăng Ký']");
    private By byLnkLogin = By.xpath("//h3[text()='Đăng Nhập']/parent::a");
    private By byLnkLogout = By.xpath("//a[h3[text()='Đăng xuất']]");
    private By byLblName = By.xpath("//h3[text()='taikhoan']");
    private By byLnkName = By.xpath("//h3[text()='taikhoan']/parent::a");

    public void navigateRegisterPage() {
        LOG.info("navigateRegisterPage");
        click(DriverFactory.getDriver(), byLnkRegister);
    }

    public void navigateLoginPage() {
        LOG.info("navigateLoginPage");
        click(DriverFactory.getDriver(), byLnkLogin);
    }

    public void navigateLogoutPage() {
        LOG.info("navigateLogoutPage");
        click(DriverFactory.getDriver(), byLnkLogout);
    }

    public String getLoginLinkText() {
        LOG.info("getLoginLinkText");
        return getText(DriverFactory.getDriver(), byLnkLogin);
    }

    public String getRegisterText() {
        LOG.info("getRegisterText");
        return getText(DriverFactory.getDriver(), byLnkRegister);
    }

    public String getLogoutLinkText() {
        LOG.info("getLogoutLinkText");
        return getText(DriverFactory.getDriver(), byLnkLogout);
    }

    public String getNameText() {
        LOG.info("getNameText");
        return getText(DriverFactory.getDriver(), byLblName);
    }

    public void navigateAccountPage() {
        LOG.info("navigateAccountPage");
        click(DriverFactory.getDriver(), byLnkName);
    }
}
