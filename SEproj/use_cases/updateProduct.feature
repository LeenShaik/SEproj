Feature: Update Product
Description:Only admin can update a product 

Background: The System has these products
	Given that these products are valid in the system
  |0|CARPET minimum than 9|15|
	|1|CARPET greater than 9 and smaller than 16|20|
	|2|CARPET greater than 16|30|
  |3|SINGLECOVER|13|
  |4|COUPLECOVER|20|
  |5|CURTAIN|8|
  

Scenario: product update faild
Given that the admin is logged in
And he want to update product that its id  "7"
When admin tries to update a product "price" to "14"
Then  massage "product is not valid" should display

Scenario: product update success
Given that the admin is logged in
And he want to update product that its id "3" 
When admin tries to update a product "price" to "14"
Then massage "product updated successfully" should display

