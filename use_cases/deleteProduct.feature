Feature: Delete Product
Description: Only admin can delete a product 

Background: The System has these products
	Given these products valid in the system
	|0|CARPET minimum than 9|15|
	|1|CARPET greater than 9 and smaller than 16|20|
	|2|CARPET greater than 16|30|
  |3|SINGLECOVER|13|
  |4|COUPLECOVER|20|
  |5|CURTAIN|8|
  
Scenario: product deleted faild
Given that admin want to delete product that its id "7"
When admin tries to delete a product
Then product deleted faild

Scenario: product deleted success
Given that admin want to delete product that its id "5"
When admin tries to delete a product
Then product deleted successfully

