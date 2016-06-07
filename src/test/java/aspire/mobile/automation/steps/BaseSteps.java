package aspire.mobile.automation.steps;

import jo.aspire.mobile.automationUtil.DriverProvider;
import jo.aspire.mobile.automationUtil.DriverProvider.platform;
import aspire.mobile.automation.IPages.ILoginPage;
import aspire.mobile.automation.IPages.IRegistrationPage;
import aspire.mobile.automation.android.pages.LoginPage;
import aspire.mobile.automation.android.pages.RegistrationPage;
import aspire.mobile.automation.iOS.pages.LoginPageiOS;
import aspire.mobile.automation.iOS.pages.RegistrationPageiOS;



public class BaseSteps {
	
	ILoginPage login;
	IRegistrationPage registration;
	selectors selector;
	
	
	

	public BaseSteps(DriverProvider driverPorvider){
		
		selector = new selectors(driverPorvider);
		
		
		if (DriverProvider.getPlatform() == platform.ANDROID) {
			// Android
			login = new LoginPage(driverPorvider,selector);
			registration = new RegistrationPage(driverPorvider,selector);

		} else {
			// iOS
			login = new LoginPageiOS(driverPorvider,selector);
			registration = new RegistrationPageiOS(driverPorvider,selector);
		}
		
		
		
		

	}
	

}
