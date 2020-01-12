package setup;

import groovy.json.internal.Chr;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.EnvironmentConfiguration;
import java.net.MalformedURLException;
import java.net.URL;

public class ChromeCapabilities implements ICapabilities {
    private ChromeOptions options = new ChromeOptions();
    private WebDriver driver;

    public ChromeCapabilities() {
        setCapabilities();
    }

    @Override
    public void setCapabilities() {
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        this.caps.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        this.caps.setAcceptInsecureCerts(true);
        this.caps.setJavascriptEnabled(true);
        this.caps.setCapability(ChromeOptions.CAPABILITY, options);
        try {
            this.setDriver(new RemoteWebDriver(new URL(EnvironmentConfiguration.REMOTE_URL), this.caps));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void setDriver(RemoteWebDriver driver) {
        this.driver = driver;
    }
    @Override
    public WebDriver getDriver(){
        return this.driver;
    }
}
