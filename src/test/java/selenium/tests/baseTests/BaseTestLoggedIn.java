package selenium.tests.baseTests;

import org.junit.jupiter.api.BeforeEach;

public class BaseTestLoggedIn extends BaseTest {
    @BeforeEach
        public void login() {
        navigate.To(url.homepage());
        loginPage.login(credentials.getUsername(), credentials.getPassword());
    }
}
