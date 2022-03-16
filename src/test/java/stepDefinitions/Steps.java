package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	@Given("something")
	public void something() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("something");
	}

	@When("action some")
	public void action_some() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("action_some");
	}

	@Then("something else should not happen")
	public void something_else_should_not_happen() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("something_else_should_not_happen");
	}
}
