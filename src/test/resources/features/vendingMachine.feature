Feature:  
	Vending Machine should accept valid coins and deliver the user selected product 
	Description: Vending Machine should accept valid coins and deliver the user selected product

Scenario Outline: 
	Vending Machine should accept valid coins and deliver the user selected product and return remaining change if any
	Given I approached the vending machine 
	When I add <coins> into vendingn machine 
	And selected <product> 
	Then the product should be delivered 
	And return remaining <change> if any 
	Examples: 
		|coins|product|change|
		|25|Coke|0|
		|10 and 25|Pepsi|0|
		|10 and 10 and 25|Soda|0|
		|5 and 10 and 25|Soda|0|
		|1 and 1 and 1 and 1 and 1 and 1 and 1 and 1 and 1 and 1 and 1 and 1 and 1 and 1 and 1 and 1 and 1 and 1 and 1 and 1 and 1 and 1 and 1 and 1|Coke|0|
		|25 and 25|Pepsi|15|
		|25 and 25|Soda|5|
		|10 and 10 and 10|Coke|5|
		
		#Accepts coins of 1,5,10,25 Cents i.e. penny, nickel, dime, and quarter. 
		#Allow user to select products Coke(25), Pepsi(35), Soda(45) 
		
Scenario Outline: Vending Machine should not accept invalid coins 
	Given  I approached the vending machine 
	When  I add invalid <coin> into vendingn machine 
	Then  machine should throw the coin out 
	And  display the error message <error> 
	Examples: 
		|coin|error|
		|2|incorrect denomination|
		|20|incorrect denomination|
		|50|incorrect denomination|
		|100|incorrect denomination|
		
Scenario Outline: 
	Vending Machine should allow user to take refund by cancelling the request. 
	Given I approached the vending machine 
	When I add <coins> into vendingn machine 
	And press cancel the operation 
	Then machine should return the <money> 
	Examples: 
		|coins|money|
		|5|5|
		|25|25|
		|5 and 25|30|
		|25 and 25 and 10|60|
		
		
Scenario Outline: 
	Vending machine supplier should be able to reset the operation for vending machine
	Given I approached the vending machine 
	When I add <coins> into vendingn machine 
	When Vending machine supplier reset the operation 
	Then machine should return back to the initial state 
	Examples: 
		|coins|
		|5|
		|25|
		|5 and 25|
		|25 and 25 and 10|