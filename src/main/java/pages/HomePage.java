package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;

public class HomePage extends CommonPage {
    private By byLnkTheGentlemen = By.xpath("//a[contains(@href, '/detail/8898')][div]");
    private By byLnkPartner = By.xpath("//img[@alt='cgvlogo']/parent::a");

    public void clickTheGentlemenLink() {
        LOG.info("clickTheGentlemenLink");
        click(DriverFactory.getDriver(), byLnkTheGentlemen);
    }

    public void navigatePartnerPage() {
        LOG.info("navigatePartnerPage");
        click(DriverFactory.getDriver(), byLnkPartner);
    }
}
