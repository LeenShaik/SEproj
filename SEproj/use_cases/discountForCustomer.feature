Feature: discount for customer


Scenario: there is a discount 
Given that the count of request for customer is 5
Then discount will apply


Scenario: there is no discount 
Given that the count of request for customer is 2
Then The discount does not apply
