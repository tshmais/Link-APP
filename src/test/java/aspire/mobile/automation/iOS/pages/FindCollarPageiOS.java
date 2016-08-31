package aspire.mobile.automation.iOS.pages;

import org.junit.AfterClass;

import jo.aspire.mobile.automationUtil.DriverProvider;
import jo.aspire.mobile.automationUtil.Helper;
import aspire.mobile.automation.IPages.IFindCollarPage;
import aspire.mobile.automation.steps.selectors;

public class FindCollarPageiOS extends Helper implements IFindCollarPage {

	selectors selector;
	public FindCollarPageiOS(DriverProvider driverPorvider,selectors selector) {
		super(driverPorvider);
		this.selector = selector;
	}
	
	@AfterClass
	public void runAfterTest() {
	}

	public void settingupCollar() {
		// TODO Auto-generated method stub
		
	}

	public void connectCollar() {
		// TODO Auto-generated method stub
		
	}

	public void closeApp() {
		// TODO Auto-generated method stub
		
	}

	public void openNearbycollars() {
		// TODO Auto-generated method stub
		
	}

	public void pairCollar() {
		// TODO Auto-generated method stub
		
	}

	public void personalizeCollar() {
		// TODO Auto-generated method stub
		
	}

	public void gobackNearby() {
		// TODO Auto-generated method stub
		
	}

	public void tapNo() {
		// TODO Auto-generated method stub
		
	}

	public void pairphone() {
		// TODO Auto-generated method stub
		
	}

}
