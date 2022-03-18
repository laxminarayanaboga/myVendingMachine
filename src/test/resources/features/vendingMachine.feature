Feature:  
	Vending Machine should accept valid coins and deliver the user selected product 
	Description: Vending Machine should accept valid coins and deliver the user selected product

Scenario Outline: 
	Vending Machine should accept valid coins and deliver the user selected product and return remaining change if any
	Given I approached the vending machine 
	When I add "<coins>" into vendingn machine 
	And selected "<product>" product 
	Then the product "<product>" should be delivered 
	And return remaining <change> if any 
	Examples: 
		|coins|product|change|
		|QUARTER|COKE|0|
		|DIME and QUARTER|PEPSI|0|
		|DIME and DIME and QUARTER|SODA|0|
		|NICKEL and NICKEL and DIME and QUARTER|SODA|0|
		|PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY and PENNY|COKE|0|
		|QUARTER and QUARTER|PEPSI|15|
		|QUARTER and QUARTER|SODA|5|
		|DIME and DIME and DIME|COKE|5|
		
Scenario Outline: 
	Vending Machine should not deliver the product if the input money is less than 
	the product price 
	Given I approached the vending machine 
	When I add "<coins>" into vendingn machine 
	And selected "<product>" product 
	Then the product should not be delivered 
	And machine should return the <returnAmount> amount 
	And display the error message "<errorMessage>" 
	
	Examples: 
		|coins|product|returnAmount|errorMessage|
		|DIME|COKE|10|Insufficient amount, retry again with correct amount. Collect your change.|
		|PENNY|SODA|1|Insufficient amount, retry again with correct amount. Collect your change.|
		|DIME and PENNY|PEPSI|11|Insufficient amount, retry again with correct amount. Collect your change.|
		
		
Scenario Outline: Vending Machine should not accept invalid coins 
	Given I approached the vending machine 
	When I add "<coins>" into vendingn machine 
	And machine should return the <returnAmount> amount 
	And display the error message "<error>" 
	Examples: 
		|coins|returnAmount|error|
		|TWO_PENNY|0|Invalid denomination or invalid coin. Terminating the transaction. Please collect the amount.|
		|DIME and TWO_DIME|10|Invalid denomination or invalid coin. Terminating the transaction. Please collect the amount.|
		|SOMETHING|0|Invalid denomination or invalid coin. Terminating the transaction. Please collect the amount.|
		|ABCD12^£|0|Invalid denomination or invalid coin. Terminating the transaction. Please collect the amount.|
		
Scenario Outline: 
	Vending Machine should allow user to take refund by cancelling the request. 
	Given I approached the vending machine 
	When I add "<coins>" into vendingn machine 
	And press the cancel button 
	Then machine should return the <money> 
	Examples: 
		|coins|money|
		|NICKEL|5|
		|QUARTER|25|
		|NICKEL and QUARTER|30|
		|QUARTER and QUARTER and DIME|60|
		
		
Scenario Outline: 
	Vending machine supplier should be able to reset the operation for vending 
	machine 
	Given I approached the vending machine 
	When I add "<coins>" into vendingn machine 
	When Vending machine supplier reset the operation 
	Then machine should return back to the initial state 
	Examples: 
		|coins|
		|NICKEL|
		|QUARTER|
		|NICKLE and QUARTER|
		|QUARTER and QUARTER and DIME|