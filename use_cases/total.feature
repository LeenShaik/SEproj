Feature: total


Background: The System has complete ordered
Given that these orders are in the system 
|0|123456|0|123|1|20|15|COMPLETE|
|1|123456|0|223|1|20|15|COMPLETE|
|2|123456|0|123|1|20|15|COMPLETE|
|3|123456|2|445|1|20|30|COMPLETE|
|4|123456|0|445|1|20|13|COMPLETE|
|5|113456|5|123|1|12|8|COMPLETE|
|6|113456|4|113|1|12|20|COMPLETE|
|7|987654|4|113|1|0|20|COMPLETE|


Scenario: print total cash
When admin tries to show the total cash
Then total cash = 136 printed 
  

Scenario: print total paid
When admin tries to show the total paid
Then total paid = 45 printed 


Scenario: print total delivered items
When admin tries to show the delivered items
Then total delivered items = 7 printed 