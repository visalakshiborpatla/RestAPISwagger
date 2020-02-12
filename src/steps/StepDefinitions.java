package steps;

import baseclass.RestApiCalls;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefinitions{
       @Given("^user Executes the REST API$")
    public void userExecutesTheRESTAPI(){
    }

    @Then("^Response status code should be \"([^\"]*)\"$")
    public void responseStatusCodeShouldBe(int statusCode) {
    }

    @And("^response should includes the following$")
   public void responseShouldIncludesTheFollowing(DataTable dt) {
        RestApiCalls.getPetStatus();
        }

}



