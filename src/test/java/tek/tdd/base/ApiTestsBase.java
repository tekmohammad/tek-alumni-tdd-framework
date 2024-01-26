package tek.tdd.base;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

@Listeners({ExtentITestListenerClassAdapter.class})
public class ApiTestsBase extends BaseSetup {
    private static final Logger LOG = LogManager.getLogger(ApiTestsBase.class);

    @BeforeSuite
    public void initializeApiTests() {
        LOG.info("Initializing API Tests");
        LOG.debug("Base URL {} ", getApiBaseUrl());
        RestAssured.baseURI = getApiBaseUrl();
    }
}
