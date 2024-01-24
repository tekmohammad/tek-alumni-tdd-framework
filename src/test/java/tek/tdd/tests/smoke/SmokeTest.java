package tek.tdd.tests.smoke;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import tek.tdd.base.BaseSetup;
import tek.tdd.base.UITestBase;
import tek.tdd.pages.HomePage;
import tek.tdd.pages.LoginPage;
import tek.tdd.utility.SeleniumUtilities;

public class SmokeTest extends UITestBase {

    @Test(testName = "Login Test Happy Path")
    public void testLoginHappyPath() throws InterruptedException {
        /*
        Login with credentials and validate CSR Portal
         */
        loginPage.login("supervisor", "tek_supervisor");
        Thread.sleep(1000);
        String title = getElementText(homePage.homePageTitle);
        Assert.assertEquals(title, "Customer Service Portal");

    }

    @Test(priority = 1)
    public void testApplicationTitle() throws InterruptedException {
        //Login And validate Accounts Section
        System.out.println("Test 1");
        loginPage.login("supervisor", "tek_supervisor");
        Thread.sleep(1000);
        String title = getElementText(homePage.homePageTitle);
        Assert.assertEquals(title, "Customer Service Portal");
    }

    @Test(dataProvider = "negativeData")
    public void negativeSecurityTesting(String username, String password, String expectedError) {
        loginPage.login(username, password);
        String actual = loginPage.getErrorMessage().replace("ERROR\n" , "");
        Assert.assertEquals(actual,
                expectedError,
                "Validate negative login");
    }

    @DataProvider(name = "negativeData")
    public String[][] negativeData() {
        return new String[][]{
                {"Wrong Username" , "tek_supervisor" , "User Wrong Username not found"} ,
                {"supervisor" , "wrongpassowrd" , "Password not matched"} ,
                {"John Smith" , "tek_supervisor" , "User John Smith not found"} ,
        };
    }
}
