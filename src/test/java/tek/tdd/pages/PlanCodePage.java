package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.tests.regression.PlanCodeTests;
import tek.tdd.utility.SeleniumUtilities;

import java.util.List;

public class PlanCodePage extends SeleniumUtilities {

    public PlanCodePage() {
        PageFactory.initElements(getDriver(), this);
    }
    @FindBy(linkText = "Plans")
    private WebElement plansLink;

    @FindBy(xpath = "//table/tbody/tr")
    private List<WebElement> planCodeRows;

    public void clickOnPlanLink() {
        clickElement(plansLink);
    }

    public int getPlanCodeTableRows() {
        return planCodeRows.size();
    }
}
