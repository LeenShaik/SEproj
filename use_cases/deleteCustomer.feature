Feature: Delete Customer
Description: Only admin can delete a customer 

Background: The System has registered customers
	Given this customers are registered in the system
	|123456|faihaa odeh|faihaa.odeh20@gmail.com|5|0599773638|DerAlhatab|
  |113456|lana jaber|s11923877@stu.najah.edu|2|0595721772|rafidia|
  |987654|jana taher|s11819423@stu.najah.edu|1|0593020265|makhfia|
  

Scenario: customer deleted faild
Given admin want to delete customer that his id "987987"
When admin tries to delete a customer 
Then customer deleted faild

Scenario: customer deleted success
Given admin want to delete customer that his id "123456"
When admin tries to delete a customer
Then customer deleted successfully

