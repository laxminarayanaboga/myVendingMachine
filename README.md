# Problem Statement - VendingMachine

Write a program to design Vending Machine using java with all possible tests

- Accepts coins of 1,5,10,25 Cents i.e. penny, nickel, dime, and quarter.
- Allow user to select products Coke(25), Pepsi(35), Soda(45)
- Allow user to take refund by cancelling the request.
- Return selected product and remaining change if any.
- Allow reset operation for vending machine supplier.

# Project Description
- maven - Java project 
- BDD Cucumber approach for testing
- src/main/java -> Vending Machine application
- src/test/java -> Cucumber Test code
- src/test/sources/feature -> feature files

## usage
- run project with command 'mvn clean verify'
- Reports -> refer to target/cucumber.html

## Assumptions & Limitations
- Handled one user transations only
- Vending machine going out of stock scenario is neither implemented nor tested
