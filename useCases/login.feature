Feature: login
Background:
Given that this is admin table

|leen|12345l|leen.aljaber123@gmail.com|0597059511|
|sama|56789s|samataher123@gmail.com|0592760313|

	
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