package testrunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features",
                glue = "test",
                tags= {"@API_Test"},
                format= {"pretty",
                "html:target/cucumber-reports-pretty",
                "json: target/cucumber-reports/GetTestReport.json"})

public class Runner(){
@BeforeEach
    public void setup () {
        wireMockServer = new WireMockServer(8090);
        wireMockServer.start();
        userStub();
    }

    @AfterEach
    public void teardown () {
        wireMockServer.stop();
    }

    @Test
    public static void userStub() {
      stubFor(get(urlPathMatching("/petStore/.*"))
           .withRequestBody(matching("<input>NAME</input>"))
           .willReturn(aResponse()
           .withStatus(200)
           .withHeader("Content-Type", "application/json")
           .withBody(body)));
           assertThat(testClient.get("https://petstore.swagger.io/v2/pet/101").statusCode(), is(200));
           assertThat(testClient.get("https://petstore.swagger.io/v2/pet/101").statusCode(), is(404));
    }

    @Test
    public void validateResponse() {
        Response response =  given().when().get("https://petstore.swagger.io/v2/pet/101");
        String title = response.jsonPath().get("status.available");
        System.out.println(title);
        Assert.assertEquals("available", title);
    }
}
