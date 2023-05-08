Feature: logout
	Description: The user logs out from the system
	
	
Scenario: Admin logs out
	Given that admin is logged in
	When the admin logs out
	Then the admin is not logged in
	

	