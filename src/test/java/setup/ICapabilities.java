package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public interface ICapabilities {
    DesiredCapabilities caps = new DesiredCapabilities();
    void setCapabilities();
    void setDriver(RemoteWebDriver driver);
    WebDriver getDriver();
}
