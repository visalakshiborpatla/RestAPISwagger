Feature: Swagger API Test GET operation

  @API_Test
  Scenario:  Verify  REST services for PET APIs - GET operation
    Given user Executes the REST API
    Then Response status code should be "200"
    And response should includes the following
      |  status     | name |
      |  available  | catty |
      |  available  | myPet |

