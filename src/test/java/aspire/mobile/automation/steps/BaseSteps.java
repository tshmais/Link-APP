package aspire.mobile.automation.steps;

import jo.aspire.mobile.automationUtil.DriverProvider;
import jo.aspire.mobile.automationUtil.DriverProvider.platform;
import aspire.mobile.automation.IPages.IBreedInformationPage;
import aspire.mobile.automation.IPages.IFindCollarPage;
import aspire.mobile.automation.IPages.ILoginPage;
import aspire.mobile.automation.IPages.IProfileSetupPage;
import aspire.mobile.automation.IPages.IRegistrationPage;
import aspire.mobile.automation.IPages.IViewingOwnerProfile;
import aspire.mobile.automation.android.pages.BreedInformationPage;
import aspire.mobile.automation.android.pages.FindCollarPage;
import aspire.mobile.automation.android.pages.LoginPage;
import aspire.mobile.automation.android.pages.ProfileSetupPage;
import aspire.mobile.automation.android.pages.RegistrationPage;
import aspire.mobile.automation.android.pages.ViewingOwnerProfilePage;
import aspire.mobile.automation.iOS.pages.BreedInformationPageiOS;
import aspire.mobile.automation.iOS.pages.FindCollarPageiOS;
import aspire.mobile.automation.iOS.pages.LoginPageiOS;
import aspire.mobile.automation.iOS.pages.ProfileSetupPageiOS;
import aspire.mobile.automation.iOS.pages.RegistrationPageiOS;
import aspire.mobile.automation.iOS.pages.ViewingOwnerProfilePageiOS;



public class BaseSteps {
	
	ILoginPage login;
	IRegistrationPage registration;
	IViewingOwnerProfile ViewingOwnerProfile;
	IFindCollarPage FindCollar;
	IProfileSetupPage ProfileSetup;
	IBreedInformationPage BreedInformation;
	selectors selector;
	
	
	

	public BaseSteps(DriverProvider driverPorvider){
		
		selector = new selectors(driverPorvider);
		
		
		if (DriverProvider.getPlatform() == platform.ANDROID) {
			// Android
			login = new LoginPage(driverPorvider,selector);
			registration = new RegistrationPage(driverPorvider,selector);
			ViewingOwnerProfile = new ViewingOwnerProfilePage(driverPorvider,selector);
			FindCollar = new FindCollarPage(driverPorvider,selector);
			ProfileSetup = new ProfileSetupPage(driverPorvider,selector);
			BreedInformation = new BreedInformationPage(driverPorvider,selector);

		} else {
			// iOS
			login = new LoginPageiOS(driverPorvider,selector);
			registration = new RegistrationPageiOS(driverPorvider,selector);
			ViewingOwnerProfile = new ViewingOwnerProfilePageiOS(driverPorvider,selector);
			FindCollar = new FindCollarPageiOS(driverPorvider,selector);
			ProfileSetup = new ProfileSetupPageiOS(driverPorvider,selector);
			BreedInformation = new BreedInformationPageiOS(driverPorvider,selector);
		}
		
		
		
		

	}
	

}
