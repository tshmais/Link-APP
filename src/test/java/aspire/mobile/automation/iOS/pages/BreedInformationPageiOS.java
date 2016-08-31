package aspire.mobile.automation.iOS.pages;

import jo.aspire.mobile.automationUtil.DriverProvider;
import jo.aspire.mobile.automationUtil.Helper;

import org.junit.AfterClass;

import aspire.mobile.automation.IPages.IBreedInformationPage;
import aspire.mobile.automation.steps.selectors;

public class BreedInformationPageiOS extends Helper implements IBreedInformationPage {

	selectors selector;
	public BreedInformationPageiOS(DriverProvider driverPorvider,selectors selector) {
		super(driverPorvider);
		this.selector = selector;
	}
	
	@AfterClass
	public void runAfterTest() {
	}

	public void tapSelectBreed() {
		// TODO Auto-generated method stub
		
	}

}
