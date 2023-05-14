Feature: Report


Background: The System has registered customers
	Given that this customers are registered in the system
	|123456|faihaa odeh|faihaa.odeh20@gmail.com|5|0599773638|DerAlhatab|
  |113456|lana jaber|s11923877@stu.najah.edu|2|0595721772|rafidia|
  |987654|jana taher|s11819423@stu.najah.edu|1|0593020265|makhfia|
  
  And  these products are valid in the system 
  |0|CARPET minimum than 9|15|
	|1|CARPET greater than 9 and smaller than 16|20|
	|2|CARPET greater than 16|30|
  |3|SINGLECOVER|13|
  |4|COUPLECOVER|20|
  |5|CURTAIN|8|
  
  And that this worker are registered in the system
	|123|hamza ahmad|0598937949|Rafedia|true|
  |113|taher yaseen|0599894568|Rafedia|true|
  |223|ayman mohammed|059378568|makhfia|true|
  |445|mohammed waleed|059998768|makhfia|false|
  
Scenario: Print report 
When admin tries to show the report 
Then report will display 
  
