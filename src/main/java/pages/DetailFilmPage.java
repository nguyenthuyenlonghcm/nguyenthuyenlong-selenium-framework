package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;

public class DetailFilmPage extends CommonPage {
    private By byLnkTimeRange = By.xpath("//a[@href=\"/purchase/46716\"]");

    public void clickTimeRangeLink() {
        LOG.info("clickTimeRangeLink");
        click(DriverFactory.getDriver(), byLnkTimeRange);
    }
}
