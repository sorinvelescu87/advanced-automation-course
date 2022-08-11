package selenium.tests.baseTests;

import org.junit.jupiter.api.BeforeEach;

public class BaseTestLoggedInMocked extends BaseTest {
    @BeforeEach
        public void login() {
        navigate.ToMock(url.homepage());
        loginPage.login(credentials.getUsername(), credentials.getPassword());
    }
}
