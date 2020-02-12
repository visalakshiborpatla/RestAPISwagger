package testrunner;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features", glue = "test", tags= {""@API_Test"} )

public class Runner(){

        }