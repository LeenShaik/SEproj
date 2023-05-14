Feature: login

	
Scenario: admin can login
	Given the username is "leen.aljaber123@gmail.com"
	And the password is "12345"
	Then the admin login succeeds
	
Scenario: admin has the wrongPassword
	Given the username is "leen.aljaber123@gmail.com"
	And the password is "67890"
	Then the admin login fails
