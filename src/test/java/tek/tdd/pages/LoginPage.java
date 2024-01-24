package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtilities;

public class LoginPage extends SeleniumUtilities {

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(linkText = "Login")
    public WebElement loginLink;

    @FindBy(name = "username")
    public WebElement usernameInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Sign In']")
    public WebElement singInButton;

    @FindBy(xpath = "//div[contains(@class, 'banner-error')]")
    private WebElement errorBanner;

    public String getErrorMessage() {
        return getElementText(errorBanner);
    }

    public void login(String username, String password) {

        clickElement(loginLink);
        sendText(usernameInput, username);
        sendText(passwordInput, password);
        clickElement(singInButton);
    }
}
