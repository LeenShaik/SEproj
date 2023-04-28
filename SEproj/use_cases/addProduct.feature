Feature: Add product
Description:Only admin can add product

Background: The System has these products
	Given that these products are valid in the system
  |0|CARPET minimum than 9                    |15|
	|1|CARPET greater than 9 and smaller than 16|20|
	|2|CARPET greater than 16                   |30|
  |3|SINGLECOVER                              |13|
  |4|COUPLECOVER                              |20|
  |5|CURTAIN                                  |8|

Scenario: product is already valid
Given that the admin is logged in
And there is a product with id "4",name "COUPLECOVER",price 20 
When admin tries to add product
Then msg "product is already valid" should display

Scenario: product is not valid
Given that the admin is logged in
And there is a product with id "6",name "CLOTHES",price 7 
When admin tries to add product
Then msg "product added succefully" should displayed