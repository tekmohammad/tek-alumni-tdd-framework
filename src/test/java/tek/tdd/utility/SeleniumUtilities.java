package tek.tdd.utility;

import com.aventstack.extentreports.service.ExtentTestManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tek.tdd.base.BaseSetup;

import java.time.Duration;
import java.util.List;

public class SeleniumUtilities extends BaseSetup {
    private final static Logger LOG = LogManager.getLogger(SeleniumUtilities.class);
    private WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(Constants.WAIT_IN_SECONDS));
    }

    public void clickElement(WebElement element) {
        LOG.debug("Target element to click {}", element);
        getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendText(WebElement element, String text) {
        LOG.debug("Target element to sendKey {}", element);
        getWait().until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public String getElementText(WebElement element) {
        LOG.debug("Target element to get text {}", element);
        return getWait().until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public List<WebElement> getElementList(List<WebElement> element) {
        return getWait().until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public void assertEqual(String actual , String expected, String message) {
        ExtentTestManager.getTest()
                        .info("Asserting actual " + actual  + " expected " + expected);
        Assert.assertEquals(actual, expected, message);
    }

    public void assertEqual(int actual, int expected, String message) {
        ExtentTestManager.getTest()
                .info("Asserting actual " + actual  + " expected " + expected);
        Assert.assertEquals(actual, expected, message);
    }
}
