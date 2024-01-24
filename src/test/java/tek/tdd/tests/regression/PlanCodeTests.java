package tek.tdd.tests.regression;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tek.tdd.base.UITestBase;
import tek.tdd.pages.HomePage;
import tek.tdd.pages.LoginPage;
import tek.tdd.utility.SeleniumUtilities;

public class PlanCodeTests extends UITestBase {

    @Test
    public void testPlanCodeTable() {
        loginPage.login("supervisor", "tek_supervisor");
        planCodePage.clickOnPlanLink();

        Assert.assertEquals(planCodePage.getPlanCodeTableRows(), 4, "Validate Plan Code counts");
    }
}
