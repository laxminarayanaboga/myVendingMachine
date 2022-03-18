package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vendingMachine.VendingMachine;

public class Steps {

	@Given("I approached the vending machine")
	public void i_approached_the_vending_machine() {
		VendingMachine.initiateInventory();
	}

	@When("I add {string} into vendingn machine")
	public void i_add_into_vendingn_machine(String coinsString) {
		String[] coins = coinsString.split(" and ");
		for (String coin : coins) {
			VendingMachine.addCoin(coin);
		}
	}

	@When("selected {string} product")
	public void selected_product(String product) {
		VendingMachine.selectProduct(product);
	}

	@Then("the product {string} should be delivered")
	public void the_product_should_be_delivered(String product) {
		Assert.assertEquals(product, VendingMachine.productReturned);
	}

	@Then("return remaining {int} if any")
	public void return_remaining_if_any(int amount) {
		Assert.assertEquals(amount, VendingMachine.outBoxBalance);
	}

	@Then("the product should not be delivered")
	public void the_product_should_not_be_delivered() {
		Assert.assertEquals(VendingMachine.ERROR, VendingMachine.productReturned);
	}

	@Then("machine should return the {int} amount")
	public void machine_should_return_the_amount(int returnAmount) {
		Assert.assertEquals(returnAmount, VendingMachine.outBoxBalance);
	}

	@Then("display the error message {string}")
	public void display_the_error_message(String errorMessage) {
		Assert.assertEquals(errorMessage, VendingMachine.errorMessage);
	}

	@When("press the cancel button")
	public void press_cancel_the_operation() {
		VendingMachine.cancel();
	}

	@Then("machine should return the {int}")
	public void machine_should_return_the(int money) {
		Assert.assertEquals(money, VendingMachine.outBoxBalance);
	}

	@When("Vending machine supplier reset the operation")
	public void vending_machine_supplier_reset_the_operation() {
		VendingMachine.adminReset();
	}

	@Then("machine should return back to the initial state")
	public void machine_should_return_back_to_the_initial_state() {
		Assert.assertEquals(0, VendingMachine.balance);
		Assert.assertEquals(0, VendingMachine.outBoxBalance);
		Assert.assertEquals("Welcome!", VendingMachine.messageBox);
	}
}
