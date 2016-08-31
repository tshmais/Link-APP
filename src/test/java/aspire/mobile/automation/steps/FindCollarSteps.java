package aspire.mobile.automation.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import jo.aspire.mobile.automationUtil.DriverProvider;

public class FindCollarSteps extends BaseSteps {

	public FindCollarSteps(DriverProvider driverPorvider) throws Exception {
		super(driverPorvider);
	}
	
	@When("I am setting up my collar I want to be presented with all the collars my phone can detect")
	public void settingupCollar() {
		FindCollar.settingupCollar();
	}
	
	@Then("I can choose and connect to my new collar")
	public void connectCollar() {  
		FindCollar.connectCollar();

	}
	
	@When("I close the App")
	public void closeApp() {
		FindCollar.closeApp();
	}
	
	@Then("If I relaunch the Link app when it was in the background and not terminated I expect to be brought back to the Nearby Collars view")
	public void openNearbycollars() {  
		FindCollar.openNearbycollars();

	}
	
	@When("I want the collar and my phone to be paired together")
	public void pairCollar() {
		FindCollar.pairCollar();
	}
	
	@When("I want the collar and phone to be paired together")
	public void pairphone() {
		FindCollar.pairphone();
	}
	
	@Then("I can personalize the collar for my dog")
	public void personalizeCollar() {  
		FindCollar.personalizeCollar();

	}
	
	@When("I observe that the collar I wanted to connect to does not have its light blinking")
	public void noblinkingLight() {

	}
	
	@Then("I should be able to tap on No")
	public void tapNo() {  
		FindCollar.tapNo();
	}
	
	@Then("select a different collar to go back to the Nearby Collars results to select a different collar")
	public void gobackNearby() {  
		FindCollar.gobackNearby();

	}

}
