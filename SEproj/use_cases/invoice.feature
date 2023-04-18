Feature: invoices 
Background: The System has registered customers
	Given that these customers are registered in the system
	|123456|faihaa odeh|faihaa.odeh20@gmail.com|5|0599773638|DerAlhatab|
  |113456|lana jaber|s11923877@stu.najah.edu|3|0595721772|rafidia|
  |987654|jana taher|s11819423@stu.najah.edu|7|0593020265|makhfia|
  
Scenario: invoice printed
Given that the customer with id "113456"  
And he want to clean "CARPET minimum than 9" 
Then the price is 27
And the msg "his invoice is " 27 printed

Scenario: invoice printed
Given that the customer with id "123456"  
And he want to clean "CARPET minimum than 9" 
Then the price is 32
And the msg "his invoice is " 32 printed



