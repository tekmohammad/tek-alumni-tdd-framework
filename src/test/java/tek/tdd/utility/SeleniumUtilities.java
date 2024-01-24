package tek.tdd.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.tdd.base.BaseSetup;

import java.time.Duration;

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
}
