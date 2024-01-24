package tek.tdd.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.tdd.base.BaseSetup;

import java.time.Duration;

public class SeleniumUtilities extends BaseSetup {

    private WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(Constants.WAIT_IN_SECONDS));
    }

    public void clickElement(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendText(WebElement element, String text) {
        getWait().until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public String getElementText(WebElement element) {
        return getWait().until(ExpectedConditions.visibilityOf(element)).getText();
    }
}
