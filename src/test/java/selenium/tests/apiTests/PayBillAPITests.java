package selenium.tests.apiTests;

import org.junit.jupiter.api.Test;
import selenium.tests.baseTests.BaseAPITest;
import selenium.models.Address;
import selenium.models.BillCustomer;

import static io.restassured.RestAssured.given;

public class PayBillAPITests extends BaseAPITest {
    Address address = new Address("1431 Main St", "Beverly Hills", "CA", "90210");
    BillCustomer customer = new BillCustomer("John Smith", address, "310-447-4121", "13344" );
    @Test
    public void payBillAPI() {
        given().spec(requestSpecification)
                    .queryParam("accountId", "12345")
                    .queryParam("amount", "100")
                    .body(customer)
                .when()
                    .post("/billpay")
                .then().log().ifError()
                    .statusCode(200);
    }
}
