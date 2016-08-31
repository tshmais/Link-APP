package aspire.mobile.automation.android.pages;


import jo.aspire.mobile.automationUtil.DriverProvider;
import jo.aspire.mobile.automationUtil.Helper;

import org.junit.AfterClass;
import org.openqa.selenium.WebElement;

import aspire.mobile.automation.IPages.ILoginPage;
import aspire.mobile.automation.steps.selectors;



public class LoginPage extends Helper implements ILoginPage {

	selectors selector;
	public LoginPage(DriverProvider driverPorvider,selectors selector) {
		super(driverPorvider);
		this.selector = selector;
	}

	@AfterClass
	public void runAfterTest() {
	}

	public void assertTitleWithText(String title) {
		wait(for_text_exact(title));
	}


	public void displayApps() {
		currentDriver().resetApp();
	}

	public void notLoggedin() {
		wait(selector.activity_welcome_logo()).isDisplayed();
		wait(selector.activity_welcome_tagline()).isDisplayed();
		wait(selector.activity_welcome_facebook_signup()).isDisplayed();
		wait(selector.activity_welcome_email_signup()).isDisplayed();
		wait(selector.activity_welcome_have_account()).isDisplayed();
	}

	public void loginEmail() {
		wait(selector.activity_welcome_have_account()).click();
		
	}

	public void loginUsingEmail(String username, String password) {
		WebElement mail = selector.activity_email_sign_in_email_address();
		mail.clear();
		mail.sendKeys(username);
		selector.activity_email_sign_in_password().sendKeys(password);
		selector.activity_email_sign_in_sign_in().click();
	
		
	}

	public void haveAccount() {
		wait(selector.activity_welcome_have_account()).click();
		
	}

	public void becomeTappable() {
		selector.activity_email_sign_in_sign_in().isEnabled();
		
	}

	public void takenToDefaultview() {
		// TODO Auto-generated method stub
		
	}

	public void appearMessages() {
		wait(for_find("Please enter a valid email address"));
		
	}

	public void disableLogin() {
		selector.activity_email_sign_in_sign_in().isSelected();
		
	}

	public void appearMessage() {
		selector.activity_email_sign_in_email_address().click();
		wait(for_find("Please enter a password that meets the minimum password requirements"));
		
	}

	public void tapLogin() {
		selector.activity_email_sign_in_sign_in().click();
		
	}

	public void displayMessage() {
		wait(for_find("Please enter a valid email address"));
		
	}

	public void loginFB() {
		wait(selector.activity_welcome_have_account()).click();
		wait(selector.activity_email_sign_in_facebook()).click();
		
	}

	public void controlCollarFB() {
		wait(for_find("no Facebook"));	 
		
	}

	public void notAuthorized() {
		wait(for_find("no Facebook"));
		
	}

	public void askforPermission() {
		// TODO Auto-generated method stub
		
	}

	public void loggedin() {
		// TODO Auto-generated method stub
		
	}

	public void displayMainMenu() {
		// TODO Auto-generated method stub
		
	}

	public void loginsuccessfullyFB() {
		// TODO Auto-generated method stub
		
	}

	public void viewWelcome() {
		// TODO Auto-generated method stub
		
	}

	public void restartApp() {
		// TODO Auto-generated method stub
		
	}

	public void killProcess() {
		// TODO Auto-generated method stub
		
	}

	public void appeardescriptivemsg() {
		// TODO Auto-generated method stub
		
	}

	public void remainsRegistrationView() {
		// TODO Auto-generated method stub
		
	}

	public void failsRegistration() {
		wait(for_find("no Facebook"));
		
	}

	public void doesntLogin() {
		wait(for_find("no Facebook"));
		
	}


	public void welcomeView() {
		wait(selector.activity_welcome_logo()).isDisplayed();
		wait(selector.activity_welcome_tagline()).isDisplayed();
		wait(selector.activity_welcome_facebook_signup()).isDisplayed();
		wait(selector.activity_welcome_email_signup()).isDisplayed();
		wait(selector.activity_welcome_have_account()).isDisplayed();
		
	}

	public void forgetPassword() {
		// TODO Auto-generated method stub
		
	}

	public void signOut() {
		wait(for_find("Main View"));
		wait(for_find("Navigate up")).click();
		wait(for_find("com.smartpettech.link.debug:id/widget_main_navigation_header_dog_profile_photo"));
		wait(for_find("Settings")).click();
		sleepTime(1000);
		wait(for_find("Sign out")).click();
		
	}

	public void successfulSignout() {
		wait(selector.activity_welcome_logo()).isDisplayed();
		wait(selector.activity_welcome_tagline()).isDisplayed();
		wait(selector.activity_welcome_facebook_signup()).isDisplayed();
		wait(selector.activity_welcome_email_signup()).isDisplayed();
		wait(selector.activity_welcome_have_account()).isDisplayed();
		
	}

	
	

}