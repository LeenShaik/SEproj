Feature: Delete Customer
Description: Only admin can delete a customer 

Background: The System has registered customers
	Given that these customers are registered in the system
	|123456|faihaa odeh|faihaa.odeh20@gmail.com|5|0599773638|DerAlhatab|
  |113456|lana jaber|s11923877@stu.najah.edu|3|0595721772|rafidia|
  |987654|jana taher|s11819423@stu.najah.edu|7|0593020265|makhfia|
  

Scenario: customer deleted faild
Given that the admin is logged in
And he want to delete customer that his id "987987"
When admin tries to delete a customer 
Then a msg "customer is not registered" should display

Scenario: customer deleted success
Given that the admin is logged in
And he want to delete customer that his id "123456"
When admin tries to delete a customer
Then a msg "customer deleted successfully" should display

