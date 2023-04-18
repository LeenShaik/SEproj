Feature: Search Customer
Description:Only admin can search a customer 

Background: The System has registered customers
	Given that these customers are registered in the system
	|123456|faihaa odeh|faihaa.odeh20@gmail.com|5|0599773638|DerAlhatab|
  |113456|lana jaber|s11923877@stu.najah.edu|3|0595721772|rafidia|
  |987654|jana taher|s11819423@stu.najah.edu|7|0593020265|makhfia|

Scenario: customer search faild
Given that the admin is logged in
When admin tries to search for id "123433"
Then a "customer is not registered" should display

Scenario: customer search success
Given that the admin is logged in
When admin tries to search for id "123456"
Then a "coustomer information => id:123456 , name:faihaa odeh , email:faihaa.odeh20@gmail.com , number of requests:10 , phone number:0599773638 , address:DerAlhatab" 



