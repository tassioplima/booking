package setup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import utils.EnvironmentConfiguration;

public class SetupTest {

    private CapabilitiesFactory capabilitiesFactory = new CapabilitiesFactory();
    public ICapabilities caps;
    @BeforeEach
    public void setUpCapabilities() {
        caps = capabilitiesFactory.getCapabilities(EnvironmentConfiguration.BROWSER_NAME.toLowerCase());
        caps.getDriver().get(EnvironmentConfiguration.BASE_URL);
    }
    @AfterEach
    public void setDown() {
        caps.getDriver().quit();
    }
}
