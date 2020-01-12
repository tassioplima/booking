package setup;

public class CapabilitiesFactory {
    public ICapabilities getCapabilities(String browser) {
        switch (browser) {
            case "chrome":
                return new ChromeCapabilities();
            default:
                throw new RuntimeException("Choose between Chrome or another browser, please!");
        }
    }
}
