package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtilities;

public class HomePage extends SeleniumUtilities {

    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='root']/div/div/div[1]/h2")
    public WebElement homePageTitle;

    @FindBy(xpath = "//div[@id='root']/div/div/div[1]/button[1]")
    public WebElement profileButton;

    @FindBy(xpath = "//button[text() = 'Logout']")
    public WebElement logoutButton;

    public void logout() {
        clickElement(profileButton);
        clickElement(logoutButton);
    }
}
