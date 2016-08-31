package aspire.mobile.automation.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import jo.aspire.mobile.automationUtil.DriverProvider;

public class ViewingOwnerProfileSteps extends BaseSteps {

	public ViewingOwnerProfileSteps(DriverProvider driverPorvider) throws Exception {
		super(driverPorvider);
	}
	
	//@Given("the user opens the app")
	//public void opensApp(){

	//}
	
	
	@When("I want to see my owner profile")
	public void seeProfile() {
		ViewingOwnerProfile.seeProfile();
	 
	}
	
	@Then("I can know if anything needs to be updated")
	public void knowAnything() {  
		ViewingOwnerProfile.knowAnything();

	}
	
	@Then("I am presented with my profile information Name, Photo, Member since, Email, My owned dogs, Connected Social Accounts")
	public void presentProfile() {  
		ViewingOwnerProfile.presentProfile();

	}
	
	@Then("I am shown the options Edit my info, Change my password, Log out, Close my account")
	public void showOption() {  
		ViewingOwnerProfile.showOption();

	}
	
	@Then("I am taken through the profile photo flow")
	public void photoFlow() {  
		ViewingOwnerProfile.photoFlow();

	}
	
	

}
