package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.tests.regression.PlanCodeTests;
import tek.tdd.utility.SeleniumUtilities;

import java.util.LinkedList;
import java.util.List;

public class PlanCodePage extends SeleniumUtilities {

    public PlanCodePage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(linkText = "Plans")
    private WebElement plansLink;

    @FindBy(xpath = "//table/tbody/tr")
    private List<WebElement> planCodeRows;

    @FindBy(xpath = "//table/tbody/tr/td[4]")
    private List<WebElement> planCodeCreatedDate;

    public void clickOnPlanLink() {
        clickElement(plansLink);
    }

    public int getPlanCodeTableRows() {
        return getElementList(planCodeRows).size();
    }

    public List<String> getCreatedDateText() {
        List<WebElement> elements = getElementList(planCodeCreatedDate);
        List<String> elementText = new LinkedList<>();
        for(WebElement element : elements) {
           elementText.add( element.getText());
        }
        return elementText;
    }
}
