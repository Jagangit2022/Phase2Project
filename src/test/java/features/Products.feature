Feature: Check Individual products price from the Inverntory page

  Background: Swaglabs Application launch
    Given user has launched the swaglabs application
    
	@Sanity
  Scenario Outline: To validate the price of the product
    When I enter username "<username>"
    And I enter password "<password>"
    And I click on login button
    Then I should be landed on Products page
    And product price should be as per the below table
      | Sauce Labs Backpack               | $29.99 |
      | Sauce Labs Bike Light             | $9.99  |
      | Sauce Labs Bolt T-Shirt           | $15.99 |
      | Sauce Labs Fleece Jacket          | $49.99 |
      | Sauce Labs Onesie                 | $7.99  |
      | Test.allTheThings() T-Shirt (Red) | $15.99 |

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |
