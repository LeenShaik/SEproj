Feature: invoices 

Scenario: invoice printed
Given that the customer are registered in the system
And the customer logged in successfully
And he want to clean "CARPET" , productSpace 4 
Then the price is 15 
And the msg "your invoice is " 15 printed

Scenario: invoice calculated
Given that the customer are registered in the system
And the customer logged in successfully
And he want to clean  3 "CURTAIN" 
Then the price is 24


Scenario: invoice calculated
Given that the customer are registered in the system
And has discount
And the customer logged in successfully
And he want to clean "SINGLECOVER" 
Then the price is 12
