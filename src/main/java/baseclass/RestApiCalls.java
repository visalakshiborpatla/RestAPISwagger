package baseclass;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class RestApiCalls {

    public static void getPetStatus() {
        userStub();
        given().
                when().
                get("https://petstore.swagger.io/#/pet/").
                then().
                assertThat().
                statusCode(200).
                and().body("name", is("Doggie")).
                and().body("status", is("available"));
    }

    public static void userStub() {
        stubFor(get(urlPathMatching("/petStore/.*"))
                .withRequestBody(matching("<input>NAME</input>"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(body)));
        assertThat(testClient.get("").statusCode(), is(200));
        assertThat(testClient.get("").statusCode(), is(404));
    }
}