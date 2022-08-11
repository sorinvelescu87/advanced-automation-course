package selenium.tests.apiTests;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.json.simple.JSONObject;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import selenium.tests.baseTests.BaseAPITest;
import selenium.utils.CustomLoanProvider;
import selenium.utils.Loans;

@WireMockTest(httpPort = 9876)
public class RequestLoanAPIMockTests extends BaseAPITest {
    @ParameterizedTest
    @ArgumentsSource(CustomLoanProvider.class)
    public void requestLoanViaAPI(JSONObject loanType) {
        Loans.requestLoanViaAPI(loanType);
    }
}
