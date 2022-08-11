package selenium.tests.baseTests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseAPITest {
    protected RequestSpecification requestSpecification;

    @BeforeEach
    public void beforeApi() {
        requestSpecification = new RequestSpecBuilder()
//                .setBaseUri("https://parabank.parasoft.com/parabank/services/bank")
                .setBaseUri("http://localhost:8080/parabank/services/bank")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .build();
    }
}
