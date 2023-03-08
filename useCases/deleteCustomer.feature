Feature: Delete Customer
Description: Only admin can delete a customer 

Background: The System has registered customers
	Given that these customers are registered in the system
	|123456|faihaa odeh|112233|faihaa.odeh20@gmail.com|10|0599773638|DerAlhatab|
  |113456|lana jaber|332211|s11923877@stu.najah.edu|3|0595721772|rafidia|
  |987654|jana taher|9876JJ|s11819423@stu.najah.edu|7|0593020265|makhfia|
  
Scenario: Admin is not logged in
Given that the admin is not logged in
And he want to delete customer that his id "987654"
When admin tries to delete a customer
Then an error massage "Admin login is required" should display

Scenario: customer deleted faild
Given that the admin is logged in
And he want to delete customer that his id  "987987"
And the customer is not registerd in the system
When admin tries to delete a customer 
Then an error massage "customer is not registered" should display

Scenario: customer deleted success
Given that the admin is logged in
And he want to delete customer that his id  "987654"
And the customer is registerd in the system
When admin tries to delete a customer
Then an information massage "customer deleted successfully" should display

