package utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class EnvironmentConfiguration {
    /**
     * Command line.
     */
    private static final String environment = System.getProperty("environment.name", "local");
    private static final Config resources = ConfigFactory.parseResources(String.format("%s-environment.conf", environment));
    /**
     * SERVICE.
     */
    public static final String SERVICE_BASE_URL = resources.getString("service.url");
    public static final String SERVICE_END_POINT = resources.getString("service.end-point");
    /**
     * BROWSER.
     */
    public static final String BROWSER_NAME = System.getProperty("browser.name", "chrome");
    /**
     * SELENIUM
     */
    public static final String REMOTE_URL = resources.getString("selenium.remote_url");
    public static final String BASE_URL = resources.getString("selenium.base_url");
    /**
     * Private constructor.
     */
    private EnvironmentConfiguration() { }
}