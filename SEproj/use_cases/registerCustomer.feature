Feature: Register user
Description:Only admin can register a customer 

Background: The System has registered customers
	Given that these customers are registered in the system
	|123456|faihaa odeh|faihaa.odeh20@gmail.com|5|0599773638|DerAlhatab|
  |113456|lana jaber|s11923877@stu.najah.edu|3|0595721772|rafidia|
  |987654|jana taher|s11819423@stu.najah.edu|7|0593020265|makhfia|

Scenario: customer is already registered
Given that the admin is logged in
And there is a customer with ID "123456" , name "faihaa odeh" , email "faihaa.odeh20@gmail.com",numOfReq 10 ,phone "0599773638",address "DerAlhatab" 
When admin tries to register a customer 
Then massage "customer is alreay registered" should display

Scenario: customer not registered before
Given that the admin is logged in
And there is a customer with ID "2984754" , name "Ahmad ammar" , email "ahm@gmail.com" ,numOfReq 1,phone "0599743789", address "Nablus street"  
When admin tries to register a customer
Then message "customer registered succefully" should displayed

