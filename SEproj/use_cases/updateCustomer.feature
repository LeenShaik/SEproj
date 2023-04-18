Feature: Update Customer
Description:Only admin can update a customer 

Background: The System has registered customers
	Given that these customers are registered in the system
  |123456|faihaa odeh|faihaa.odeh20@gmail.com|5|0599773638|DerAlhatab|
  |113456|lana jaber|s11923877@stu.najah.edu|3|0595721772|rafidia|
  |987654|jana taher|s11819423@stu.najah.edu|7|0593020265|makhfia|


Scenario: customer update faild
Given that the admin is logged in
And he want to update customer that his id  "987987"
When admin tries to update a customer "address" to "rafidia" 
Then this msg "customer is not registered" should display

Scenario: customer update success
Given that the admin is logged in
And he want to update customer that his id  "987654"
When admin tries to update a customer "address" to "rafidia"
Then this msg "customer updated successfully" should display

