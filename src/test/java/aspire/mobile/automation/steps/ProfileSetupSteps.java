package aspire.mobile.automation.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import jo.aspire.mobile.automationUtil.DriverProvider;

public class ProfileSetupSteps extends BaseSteps {

	public ProfileSetupSteps(DriverProvider driverPorvider) throws Exception {
		super(driverPorvider);
	}
	
	@When("I enter in valid data for my dog's name: <name>, age: <age>, weight: <weight> and gender: <gender>")
	public void enterValidData(@Named("name") String name, @Named("age") String age,
			@Named("weight") String weight, @Named("gender") String gender) {
			ProfileSetup.enterValidData(name, age, weight, gender);

	}
	
	@When("I tap Next")
	public void tapNext() {
		ProfileSetup.tapNext();

	}
	
	@Then("I'm taken to the Choose Breed screen")
	public void chooseBreed() {
		ProfileSetup.chooseBreed();

	}
	
	@When("I have entered no information for my dog's name: <name>, age: <age>, weight: <weight> and gender: <gender>")
	public void enterNoinfo(@Named("name") String name, @Named("age") String age,
			@Named("weight") String weight, @Named("gender") String gender) {
			ProfileSetup.enterValidData(name, age, weight, gender);

	}
	
	@Then("An error message shows on the screen describing that all fields required")
	public void showerrormessage() {
		ProfileSetup.showerrormessage();

	}
	
	@Then("The Next button is disabled")
	public void disableNext() {
		ProfileSetup.disableNext();

	}
	
	@Then("I want to see a list of the dogs I've added so far so I know whether I have added all my dogs or not")
	public void seeDogslist() {
		ProfileSetup.seeDogslist();

	}
	
	@When("I select a breed")
	public void selectBreed() {
		ProfileSetup.selectBreed();

	}
	
	@When("I tap the button to add another collar")
	public void addCollar() {
		ProfileSetup.addCollar();

	}
	
	@Then("I start the new collar flow again")
	public void startCollarFlow() {
		ProfileSetup.startCollarFlow();

	}

}
