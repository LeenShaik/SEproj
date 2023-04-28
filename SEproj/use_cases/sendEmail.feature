Feature: Send Email

Scenario: email sent successfully
Given that the admin is logged in
And the order status is complete 
When admin tries to send email to customer whose email is "s11923877@stu.najah.edu"
Then this massage : "Sent message successfully..." will appear
