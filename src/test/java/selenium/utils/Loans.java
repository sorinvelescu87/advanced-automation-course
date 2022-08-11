package selenium.utils;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Loans {
    public static void requestLoanViaAPI(JSONObject loanDetails) {
        given().accept(ContentType.JSON)
                    .queryParam("customerId", 12212)
                    .queryParam("amount", String.valueOf(loanDetails.get("amount")))
                    .queryParam("downPayment", String.valueOf(loanDetails.get("downPaymentAmount")))
                    .queryParam("fromAccountId", String.valueOf(loanDetails.get("fromAccountNumber")))
                .when()
                    .post("https://parabank.parasoft.com/parabank/services/bank/requestLoan")
                .then()
                    .log().all().statusCode(200)
                .and()
                    .body("approved", equalTo(loanDetails.get("approved")));
    }
}
