package tek.tdd.tests.regression;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tek.tdd.base.UITestBase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


public class PlanCodeTests extends UITestBase {
    private static final Logger LOG = LogManager.getLogger(PlanCodeTests.class);

    @BeforeMethod
    public void setupPlanCodeTest() {
        loginPage.login("supervisor", "tek_supervisor");
        planCodePage.clickOnPlanLink();
    }


    @Test
    public void testPlanCodeTable() {
        LOG.info("Starting test Plan Code Table");
        int actual = planCodePage.getPlanCodeTableRows();
        ExtentTestManager.getTest()
                        .info("Actual number of plan code table rows " + actual);
        LOG.debug("Actual number of plan code table rows {}" , actual);
        assertEqual(actual, 4, "Validate Plan Code counts");
    }

    @Test
    public void testPlanCodeCreatedDate() {
        LOG.info("Starting plan code created date");

        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        String expectedDate = formatter.format(now);
        LOG.debug("Current Date {}" , expectedDate);

        var list = planCodePage.getCreatedDateText();

//        list.forEach(actual -> {
//            Assert.assertEquals(actual, expectedDate, "Validate Created Date");
//        });
        LOG.info("Actual Created dates {}" ,list);
        for (String actual : list) {
           assertEqual(actual, expectedDate, "Validate Created Date");
        }
    }
}
