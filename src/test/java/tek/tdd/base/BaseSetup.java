package tek.tdd.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import tek.tdd.browsers.ChromeBrowser;
import tek.tdd.browsers.EdgeBrowser;
import tek.tdd.browsers.FirefoxBrowser;
import tek.tdd.browsers.IBrowser;
import tek.tdd.exception.FrameworkSetupException;
import tek.tdd.utility.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BaseSetup {
    private static final Logger LOG = LogManager.getLogger(BaseSetup.class);
    private static WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    private final Properties properties;

    //Setup Framework
    //Setup browser
    //navigate to application.
    public BaseSetup() {
        //Custom property that can set by Maven or By OS Environment variable.
        //Values we pass to tek_env will be dev or qa
        // Maven goal will be something like mvn clean test -Dtek_env=qa
        String targetEnvironment = System.getProperty("tek_env");
        String configFilePath;
        if (targetEnvironment == null) {
            configFilePath = Constants.CONFIG_FILE_BASE_PATH + "dev_env.properties";
        } else {
            configFilePath = Constants.CONFIG_FILE_BASE_PATH + targetEnvironment + "_env.properties";
        }
        LOG.info("Config file path ::::: " + configFilePath);
        this.properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(configFilePath);
            this.properties.load(inputStream);
        } catch (IOException ex) {
            LOG.error("Can not load property file with message");
            throw new FrameworkSetupException("Can not load property file with message " + ex.getMessage());
        }
    }



    private String getProperty(String key) {
        return this.properties.get(key).toString();
    }

    public void initializeFramework() {
        //browser type
        //url for environment.
        String browser = getProperty("browser.type");
        boolean isHeadless = Boolean.parseBoolean(getProperty("browser.isHeadless"));
        LOG.debug("Running on browser {} with headless {}" , browser , isHeadless);
        IBrowser browserInterface;
        switch (browser.toLowerCase()) {
            case "chrome":
                browserInterface = new ChromeBrowser();
                break;
            case "firefox":
                browserInterface = new FirefoxBrowser();
                break;
            case "edge":
                browserInterface = new EdgeBrowser();
                break;
            default:
                throw new FrameworkSetupException("Wrong Browser type");
        }
        driver = browserInterface.setupBrowser(isHeadless);
        //Selenium configuration.
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.WAIT_IN_SECONDS));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.WAIT_IN_SECONDS));
        driver.get(getProperty("base_url"));
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }


}
