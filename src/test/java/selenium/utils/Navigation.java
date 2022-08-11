package selenium.utils;

import org.openqa.selenium.WebDriver;
import selenium.pageObjects.BasePage;

public class Navigation extends BasePage {
    Urls urls = new Urls();

    public Navigation(WebDriver driver) {
        super(driver);
    }

    public void To(String page) {
        String url = urls.baseUrl() + page;
        driver.get(url);
        waitForPageToBeLoaded();
    }

    public void ToMock(String page) {
        String url = urls.baseMockUrl() + page;
        driver.get(url);
        waitForPageToBeLoaded();
    }
}
