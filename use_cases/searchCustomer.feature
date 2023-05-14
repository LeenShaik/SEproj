Feature: Search Customer
Description:Only admin can search a customer 

Background: The System has registered customers
	Given customers registered in the system
	|123456|faihaa odeh|faihaa.odeh20@gmail.com|5|0599773638|DerAlhatab|
  |113456|lana jaber|s11923877@stu.najah.edu|2|0595721772|rafidia|
  |987654|jana taher|s11819423@stu.najah.edu|1|0593020265|makhfia|

Scenario: customer search faild
When admin tries to search for customer id "123433"
Then customer search faild
Scenario: customer search success
When admin tries to search for customer id "123456"
Then customer search success


