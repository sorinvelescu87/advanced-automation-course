package selenium.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By inputUsername = By.name("username");
    private final By inputPassword = By.name("password");
    private final By buttonLogin = By.xpath("//input[@value='Log In']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        type(inputUsername, username);
        type(inputPassword, password);
        click(buttonLogin);
    }
}
