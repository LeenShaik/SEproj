Feature:  Distribution of work to the available worker
Description:Only admin can search a customer 

Background: The System has registered workers
	Given that these worker are registered in the system
	|123|hamza ahmad|0598937949|Rafedia|true|
  |113|taher yaseen|0599894568|Rafedia|true|
  |223|ayman mohammed|059378568|makhfia|true|
  |445|mohammed waleed|059998768|makhfia|false|

Scenario: distribute work successfully
Given that there is order with id "0"
When admin tries to distribute the order to the worker
And the worker is free
Then available worker received the order 
And the status change to intreatment

