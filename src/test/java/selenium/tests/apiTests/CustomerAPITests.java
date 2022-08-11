package selenium.tests.apiTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import selenium.tests.baseTests.BaseAPITest;
import selenium.models.Customer;

import static io.restassured.RestAssured.given;
public class CustomerAPITests extends BaseAPITest {
    @Test
    public void testCustomerApi() {
        Customer customer =
                given().spec(requestSpecification)
                        .when()
                        .get("/customers/12212")
                        .as(Customer.class);

        Assertions.assertEquals(12212, customer.getId());
        Assertions.assertEquals("John", customer.getFirstName());
        Assertions.assertEquals("Smith", customer.getLastName());
        Assertions.assertEquals("CA", customer.getAddress().getState());
        Assertions.assertEquals("310-447-4121", customer.getPhoneNumber());
        Assertions.assertEquals("622-11-9999", customer.getSsn());
    }
}
