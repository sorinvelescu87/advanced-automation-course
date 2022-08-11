package selenium.tests.uiTests;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import selenium.tests.baseTests.BaseTestLoggedIn;
import selenium.utils.CustomLoanProvider;

public class RequestLoanTest extends BaseTestLoggedIn {

    @ParameterizedTest
    @ArgumentsSource(CustomLoanProvider.class)
    public void applyForLoan(JSONObject loanType) {
        navigate.To((url.requestLoan()));
        requestLoan.applyForLoan(loanType);
        Assertions.assertEquals(String.valueOf(loanType.get("loanStatus")), requestLoan.getLoanStatus());
    }


//    @Test
//    public void applyForLoan_InBoundaries_shouldBeAccepted() {
//        navigate.To((url.requestLoan()));
//        requestLoan.applyForLoan(approvedLoan);
//        Assertions.assertEquals("Approved", requestLoan.getLoanStatus());
//    }
//
//    @Test
//    public void applyForLoan_OutsideBoundaries_shouldNotBeAccepted() {
//        navigate.To((url.requestLoan()));
//        requestLoan.applyForLoan(deniedLoan);
//        Assertions.assertEquals("Denied", requestLoan.getLoanStatus());
//    }
}