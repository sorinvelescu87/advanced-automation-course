package selenium.tests.baseTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.pageObjects.LoginPage;
import selenium.pageObjects.RequestLoan;
import selenium.testData.LoginCredentials;
import selenium.utils.Navigation;
import selenium.utils.Urls;

import static io.restassured.RestAssured.given;

public class BaseTest {
    LoginPage loginPage;
    LoginCredentials credentials;
    protected Navigation navigate;
    protected Urls url = new Urls();
    protected RequestLoan requestLoan;
    private WebDriver driver;

    @BeforeEach
    public void startBrowser() {
        given()
                .when().post("https://parabank.parasoft.com/parabank/services/bank/initializeDB")
                .then().log().all().statusCode(204);
        System.setProperty("webdriver.chrome.driver", "/Users/sorinvelescu/Downloads/chromedriver7");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.navigate = new Navigation(this.driver);
        this.loginPage = new LoginPage(this.driver);
        this.requestLoan = new RequestLoan(this.driver);
        this.credentials = new LoginCredentials();
    }

    @AfterEach
    public void stopBrowser() {
        driver.quit();
    }
}