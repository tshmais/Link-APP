package aspire.mobile.automation.steps;

import org.jbehave.core.annotations.When;

import jo.aspire.mobile.automationUtil.DriverProvider;

public class BreedInformationSteps extends BaseSteps {

	public BreedInformationSteps(DriverProvider driverPorvider) throws Exception {
		super(driverPorvider);
	}
	
	@When("I tap on select a breed")
	public void tapSelectBreed() {
		BreedInformation.tapSelectBreed();

	}

}
