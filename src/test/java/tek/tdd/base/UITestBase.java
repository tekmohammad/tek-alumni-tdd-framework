package tek.tdd.base;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import tek.tdd.pages.HomePage;
import tek.tdd.pages.LoginPage;
import tek.tdd.pages.PlanCodePage;
import tek.tdd.utility.SeleniumUtilities;
@Listeners({ExtentITestListenerClassAdapter.class})
public class UITestBase extends SeleniumUtilities {
    private static final Logger LOG = LogManager.getLogger(UITestBase.class);
    public HomePage homePage;
    public LoginPage loginPage;
    public PlanCodePage planCodePage;

    @BeforeMethod
    public void initialTest() {
        LOG.info("Initializing Before Test Method ");
        initializeFramework();
        this.homePage = new HomePage();
        this.loginPage = new LoginPage();
        this.planCodePage = new PlanCodePage();
    }

    @AfterMethod
    public void cleanUpTest() {
        LOG.info("Initializing After Test Method ");
        closeBrowser();
    }
}
