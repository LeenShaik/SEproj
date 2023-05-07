Feature: Search Product
Description:Only admin can search a product 

Background: The System has these products
	Given that these products are valid in the system
	|0|CARPET minimum than 9|15|
	|1|CARPET greater than 9 and smaller than 16|20|
	|2|CARPET greater than 16|30|
  |3|SINGLECOVER|13|
  |4|COUPLECOVER|20|
  |5|CURTAIN|8|

Scenario: product search faild
Given that the admin is logged in
When admin tries to search for id "12"
Then this msg "product is not valid" should display

Scenario: product search success
Given that the admin is logged in
When admin tries to search for id "1"
Then this msg "product information => id:1 , name:CARPET greater than 9 and smaller than 16 , price:20" should display



