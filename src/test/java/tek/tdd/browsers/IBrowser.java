package tek.tdd.browsers;

import org.openqa.selenium.WebDriver;

public interface IBrowser {

    WebDriver setupBrowser(boolean isHeadless);
}
