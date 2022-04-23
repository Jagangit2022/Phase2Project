Feature: Login feature scenarios

  Background: Swaglabs Application launch
    Given user has launched the swaglabs application

	@Sanity
  Scenario Outline: Verify successful login with correct username and password
    When I enter username "<username>"
    And I enter password "<password>"
    And I click on login button
    Then I should be landed on Products page

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |
      
	@Regression
  Scenario Outline: Verify login fail with incorrect username or password
    When I enter username "<username>"
    And I enter password "<password>"
    And I click on login button
    Then I should see error message "<error>"

    Examples: 
      | username      | password      | error                                                                     |
      | standard_user | secret_sauce1 | Epic sadface: Username and password do not match any user in this service |
