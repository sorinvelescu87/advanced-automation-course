package selenium.pageObjects;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.utils.Times;

public abstract class BasePage {
    Times times = new Times();
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, times.defaultTimeout());
    }

    public void waitForElementToBeDisplayed(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForDropDownToHaveOption(By locator, String option) {
        wait.until(ExpectedConditions.
                        presenceOfNestedElementLocatedBy(
                                locator,
                                By.xpath(String.format("//option[@value='%s']", option))));
    }

    @SneakyThrows
    public void waitForPageToBeLoaded() {
        wait.until((ExpectedCondition<Boolean>) webDriver ->
                ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void click(By locator) {
        try {
            waitForElementToBeClickable(locator);
            findElement(locator).click();
        } catch (TimeoutException exception) {
            Assertions.fail(String.format("Exception in click(): %s", exception.getMessage()));
        }
    }

    public void type(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    public WebElement findElement (By locator) {
        return driver.findElement(locator);
    }
}
