package selenium.tests.uiTests;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import selenium.tests.baseTests.BaseTestLoggedIn;
import selenium.tests.baseTests.BaseTestLoggedInMocked;
import selenium.utils.CustomLoanProvider;

import static selenium.utils.CustomLoanProvider.readJson;

@WireMockTest(httpPort = 9876)
public class RequestLoanTestMock extends BaseTestLoggedInMocked {

//    @ParameterizedTest
//    @ArgumentsSource(CustomLoanProvider.class)
//    public void applyForLoan(JSONObject loanType) {
//        navigate.To((url.requestLoan()));
//        requestLoan.applyForLoan(loanType);
//        Assertions.assertEquals(String.valueOf(loanType.get("loanStatus")), requestLoan.getLoanStatus());
//    }


//    @Test
//    public void applyForLoan_InBoundaries_shouldBeAccepted() {
//        navigate.To((url.requestLoan()));
//        requestLoan.applyForLoan(approvedLoan);
//        Assertions.assertEquals("Approved", requestLoan.getLoanStatus());
//    }
//

    JSONObject loans = (JSONObject) readJson("src/test/java/selenium/testData/loans.json");
    JSONObject deniedLoan = (JSONObject) loans.get("deniedLoan");
    @Test
    public void applyForLoan_OutsideBoundaries_shouldNotBeAccepted() {
        navigate.ToMock((url.requestLoan()));
        requestLoan.applyForLoan(deniedLoan);
        Assertions.assertEquals("Approved", requestLoan.getLoanStatus());
    }
}