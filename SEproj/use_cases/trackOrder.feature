Feature: track order

Scenario: order in treatment
Given that order status is waiting
And admin want to set status to in treatment
Then order status is in treatment


Scenario: order complete
Given that order status is in treatment
And admin want to set statue to complete
Then order status is complete



