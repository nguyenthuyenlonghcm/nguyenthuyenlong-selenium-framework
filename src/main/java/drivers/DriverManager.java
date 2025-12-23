package drivers;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;

    public abstract void createDriver();

    public WebDriver getDriver() {
        if(this.driver == null) {
            createDriver();
        }
        return this.driver;
    }

}
