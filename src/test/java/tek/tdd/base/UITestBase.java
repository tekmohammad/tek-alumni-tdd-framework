package tek.tdd.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import tek.tdd.pages.HomePage;
import tek.tdd.pages.LoginPage;
import tek.tdd.pages.PlanCodePage;
import tek.tdd.utility.SeleniumUtilities;

public class UITestBase extends SeleniumUtilities {
    public HomePage homePage;
    public LoginPage loginPage;
    public PlanCodePage planCodePage;

    @BeforeMethod
    public void initialTest() {
        initializeFramework();
        this.homePage = new HomePage();
        this.loginPage = new LoginPage();
        this.planCodePage = new PlanCodePage();
    }

    @AfterMethod
    public void cleanUpTest() {
        closeBrowser();
    }
}