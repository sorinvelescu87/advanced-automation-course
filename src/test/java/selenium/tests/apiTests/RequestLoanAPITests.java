package selenium.tests.apiTests;

import org.json.simple.JSONObject;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import selenium.tests.baseTests.BaseAPITest;
import selenium.utils.CustomLoanProvider;
import selenium.utils.Loans;

public class RequestLoanAPITests extends BaseAPITest {
    @ParameterizedTest
    @ArgumentsSource(CustomLoanProvider.class)
    public void requestLoanViaAPI(JSONObject loanType) {
        Loans.requestLoanViaAPI(loanType);
    }
}
