package aspire.mobile.automation.iOS.pages;

import jo.aspire.mobile.automationUtil.DriverProvider;
import jo.aspire.mobile.automationUtil.Helper;
import aspire.mobile.automation.IPages.IRegistrationPage;
import aspire.mobile.automation.steps.selectors;

public class RegistrationPageiOS extends Helper implements IRegistrationPage {

	selectors selector;
	public RegistrationPageiOS(DriverProvider driverPorvider,selectors selector) {
		super(driverPorvider);
		this.selector = selector;
	}
	public void signupEmail() {
		// TODO Auto-generated method stub
		
	}
	public void signupUsingEmail(String username, String email, String password) {
		// TODO Auto-generated method stub
		
	}
	public void createAccount() {
		// TODO Auto-generated method stub
		
	}
	public void useCollar() {
		// TODO Auto-generated method stub
		
	}
	public void createdAccount() {
		// TODO Auto-generated method stub
		
	}
	public void showErrormsg() {
		// TODO Auto-generated method stub
		
	}
	public void nonselectableButton() {
		// TODO Auto-generated method stub
		
	}
	public void showserrormessage() {
		// TODO Auto-generated method stub
		
	}

}
