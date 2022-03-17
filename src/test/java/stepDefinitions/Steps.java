package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vendingMachine.VendingMachine;

public class Steps {

	@Given("^I approached the vending machine$")
	public void i_approached_the_vending_machine() {
		VendingMachine.initiateInventory();
	}

	@When("^I add ([^\"]*) into vendingn machine$")
	public void i_add_into_vendingn_machine(String coinsString) {
		String[] coins = coinsString.split(" and ");
		for (String coin : coins) {
			VendingMachine.addCoin(coin);
		}
	}

	@When("^selected ([^\"]*) product$")
	public void selected_product(String product) {
		VendingMachine.selectProduct(product);
	}

	@Then("^the product ([^\"]*) should be delivered$")
	public void the_product_should_be_delivered(String product) {
		Assert.assertEquals(product, VendingMachine.productReturned);
	}

	@Then("^return remaining ([^\"]*) if any$")
	public void return_remaining_if_any(Integer amount) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("TODO: implement.. received amount: " + amount);
	}

	@Then("^the product should not be delivered$")
	public void the_product_should_not_be_delivered() {
		System.out.println("the_product_should_not_be_delivered");
	}

	@Then("^machine should throw the coins out$")
	public void machine_should_throw_the_coins_out() {
		System.out.println("machine_should_throw_the_coins_out");
	}

	@Then("^display the error message ([^\"]*)$")
	public void display_the_error_message(String errorMessage) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("error message: " + errorMessage);
	}

	@When("^press the cancel button$")
	public void press_cancel_the_operation() {
		System.out.println("press_cancel_the_operation");
	}

	@Then("^machine should return the ([^\"]*)$")
	public void machine_should_return_the(Integer money) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("machine_should_return_the: " + money);
	}

	@When("Vending machine supplier reset the operation")
	public void vending_machine_supplier_reset_the_operation() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("vending_machine_supplier_reset_the_operation");
	}

	@Then("machine should return back to the initial state")
	public void machine_should_return_back_to_the_initial_state() {
		System.out.println("machine_should_return_back_to_the_initial_state");
	}
}
