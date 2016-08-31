package aspire.mobile.automation.iOS.pages;

import jo.aspire.mobile.automationUtil.DriverProvider;
import jo.aspire.mobile.automationUtil.Helper;
import aspire.mobile.automation.IPages.IProfileSetupPage;
import aspire.mobile.automation.steps.selectors;

public class ProfileSetupPageiOS extends Helper implements IProfileSetupPage {

	selectors selector;
	public ProfileSetupPageiOS(DriverProvider driverPorvider,selectors selector) {
		super(driverPorvider);
		this.selector = selector;
	}
	
	public void tapNext() {
		// TODO Auto-generated method stub
		
	}
	public void chooseBreed() {
		// TODO Auto-generated method stub
		
	}

	public void enterValidData(String name, String age, String weight,
			String gender) {
		// TODO Auto-generated method stub
		
	}

	public void showerrormessage() {
		// TODO Auto-generated method stub
		
	}

	public void disableNext() {
		// TODO Auto-generated method stub
		
	}

	public void enterNoinfo(String name, String age, String weight,
			String gender) {
		// TODO Auto-generated method stub
		
	}

	public void seeDogslist() {
		// TODO Auto-generated method stub
		
	}

	public void selectBreed() {
		// TODO Auto-generated method stub
		
	}

	public void addCollar() {
		// TODO Auto-generated method stub
		
	}

	public void startCollarFlow() {
		// TODO Auto-generated method stub
		
	}

}
