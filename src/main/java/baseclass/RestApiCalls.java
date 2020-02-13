package baseclass;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class RestApiCalls {

    public static void getPetStatus() {
                given().
                when().
                get("https://petstore.swagger.io/v2/pet/").
                then().
                assertThat().
                statusCode(200).
                and().body("name", is("Doggie")).
                and().body("status", is("available"));
    }
}
