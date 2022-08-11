package selenium.pageObjects;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RequestLoan extends BasePage {
    private final By loanAmount = By.id("amount");
    private final By downPayment = By.id("downPayment");
    private final By fromAccountId = By.id("fromAccountId");
    private final By buttonApply = By.xpath("//input[@value='Apply Now']");
    private final By loanStatus = By.id("loanStatus");

    public RequestLoan(WebDriver driver) {
        super(driver);
    }

//    public void applyForLoan(String amount, String downPaymentAmount, String fromAccountNumber) {
//        type(loanAmount, amount);
//        type(downPayment, downPaymentAmount);
//        selectFromAccount(fromAccountNumber);
//        click(buttonApply);
//        waitForElementToBeDisplayed(loanStatus);
//    }

    public void applyForLoan(JSONObject loanDetails) {
        type(loanAmount, String.valueOf(loanDetails.get("amount")));
        type(downPayment, String.valueOf(loanDetails.get("downPaymentAmount")));
        selectFromAccount(String.valueOf(loanDetails.get("fromAccountNumber")));
        click(buttonApply);
        waitForElementToBeDisplayed(loanStatus);
    }

    public String getLoanStatus() {
        return findElement(loanStatus).getText();
    }

    private void selectFromAccount(String accountNumber) {
        waitForDropDownToHaveOption(fromAccountId, accountNumber);
        Select fromAccount = new Select(findElement(fromAccountId));
        fromAccount.selectByVisibleText(accountNumber);
    }
}
