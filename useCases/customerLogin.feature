Feature: customer login
Background:

Given that these customer are regesterd in the system 
|123456|faihaa odeh|112233|faihaa.odeh20@gmail.com|10|0599773638|DerAlhatab|
|113456|lana jaber|332211|s11923877@stu.najah.edu|3|0595721772|rafidia|
|987654|jana taher|9876JJ|s11819423@stu.najah.edu|7|0593020265|makhfia|


Scenario: login succesfully
	Given that the customer is not logged in
	And the customer is already registerd
	And the customer inter email "faihaa.odeh20@gmail.com" and password "112233"
	Then the customer login succeeds
	And the customer is logged in
	
Scenario: customer has wrong password or username
  Given that the customer is not logged in
	And the customer is already registerd
	And the customer inter email "faihaaodeh2@gmail.com" and password "1122222"
  Then the customer login fails
  And the customer is not logged in
  
