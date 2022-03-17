Feature:  
	Vending Machine should accept valid coins and deliver the user selected product 
	Description: Vending Machine should accept valid coins and deliver the user selected product

Scenario Outline: 
	Vending Machine should accept valid coins and deliver the user selected product and return remaining change if any
	Given I approached the vending machine 
	When I add <coins> into vendingn machine 
	And selected <product> product 
	Then the product should be delivered 
	And return remaining <change> if any 
	Examples: 
		|coins|product|change|
		|QUARTER|Coke|0|
		|DIME and QUARTER|Pepsi|0|
		|DIME and DIME and QUARTER|Soda|0|
		|NICKLE and DIME and QUARTER|Soda|0|
		|PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY|Coke|0|
		|QUARTER and QUARTER|Pepsi|PENNYNICKLE|
		|QUARTER and QUARTER|Soda|NICKLE|
		|DIME and DIME and DIME|Coke|NICKLE|
		
Scenario Outline: 
	Vending Machine should not deliver the product if the input money is less than the product price 
	Given  I approached the vending machine 
	When  I add invalid <coins> into vendingn machine 
	And selected <product> product 
	Then the product should not be delivered 
	And  machine should throw the coins out 
	And  display the error message <error> 
	Examples: 
		|coins|product|error|
		|20|Coke|Insufficient Amount. Please insert amount equal or more than the product price|
		|PENNY|Soda|Insufficient Amount. Please insert amount equal or more than the product price|
		|20 and PENNY|Pepsi|Insufficient Amount. Please insert amount equal or more than the product price|
		
Scenario Outline: Vending Machine should not accept invalid coins 
	Given  I approached the vending machine 
	When  I add invalid <coin> into vendingn machine 
	Then  machine should throw the coins out 
	And  display the error message <error> 
	Examples: 
		|coin|error|
		|2TWO_PENNY|incorrect denomination|
		|TWO_DIME|incorrect denomination|
		|SOMETHING|incorrect denomination|
		|ABCD|incorrect denomination|
		
Scenario Outline: 
	Vending Machine should allow user to take refund by cancelling the request. 
	Given I approached the vending machine 
	When I add <coins> into vendingn machine 
	And press the cancel button 
	Then machine should return the <money> 
	Examples: 
		|coins|money|
		|NICKLE|NICKLE|
		|QUARTER|QUARTER|
		|NICKLE and QUARTER|30|
		|QUARTER and QUARTER and DIME|60|
		
		
Scenario Outline: 
	Vending machine supplier should be able to reset the operation for vending machine
	Given I approached the vending machine 
	When I add <coins> into vendingn machine 
	When Vending machine supplier reset the operation 
	Then machine should return back to the initial state 
	Examples: 
		|coins|
		|NICKLE|
		|QUARTER|
		|NICKLE and QUARTER|
		|QUARTER and QUARTER and DIME|