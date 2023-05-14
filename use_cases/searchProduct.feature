Feature: Search Product
Description:Only admin can search a product 

Background: The System has these products
	Given that this products are valid in the system
	|0|CARPET minimum than 9|15|
	|1|CARPET greater than 9 and smaller than 16|20|
	|2|CARPET greater than 16|30|
  |3|SINGLECOVER|13|
  |4|COUPLECOVER|20|
  |5|CURTAIN|8|

Scenario: product search faild
When admin tries to search for id "12"
Then search faild

Scenario: product search success
When admin tries to search for id "1"
Then search success



