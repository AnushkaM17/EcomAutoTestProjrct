Feature: Registration functionality scenarios
  
  
 
  Scenario: Verify whether the user is able to register into the application by providing all the fields
    Given I launch the application
    And I navigate to Account Registration page
    When I provide all the below valid details
    	| FirstName | Anushka 									|
    	| LastName  | More 								|
    	| Email			| anushkamore121@gmail.com |
    	| Telephone	| 123456789						|
    	| Password	| 1234								|
    And I select the Privacy Policy
    And I click on Continue button
    Then I should see that the User Account has successfully created