Feature: login

	
Scenario: admin can login
	Given admin is not logged in
	And the username is "leen.aljaber123@gmail.com"
	And the password is "12345"
	Then the admin login succeeds
	And the admin is logged in
	
Scenario: admin has the wrongPassword
	Given admin is not logged in
	And the username is "leen.aljaber123@gmail.com"
	And the password is "67890"
	Then the admin login fails
	And the admin is not logged in