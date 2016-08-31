package aspire.mobile.automation.android.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import org.openqa.selenium.WebElement;

import jo.aspire.mobile.automationUtil.DriverProvider;
import jo.aspire.mobile.automationUtil.Helper;
import aspire.mobile.automation.IPages.IRegistrationPage;
import aspire.mobile.automation.steps.selectors;

public class RegistrationPage extends Helper implements IRegistrationPage {

	selectors selector;
	public RegistrationPage(DriverProvider driverPorvider,selectors selector) {
		super(driverPorvider);
		this.selector = selector;
	}
	
	public void signupEmail() {
		wait(selector.activity_welcome_email_signup()).click();
		
	}
	
	public void signupUsingEmail(String username, String email, String password) {
		WebElement mail = wait(selector.activity_email_registration_name());
		mail.clear();
		mail.sendKeys(username);
		selector.activity_email_registration_email_address().sendKeys(email);
		((AndroidDriver) currentDriver()).pressKeyCode(AndroidKeyCode.ENTER);
		selector.activity_email_registration_password().sendKeys(password);
		
	}

	public void createAccount() {
		((AndroidDriver) currentDriver()).pressKeyCode(AndroidKeyCode.ENTER);
		selector.activity_email_registration_create_account().click();
		
	}

	public void useCollar() {
		wait(for_find("Set up your collar"));
		
	}

	public void createdAccount() {
		wait(for_find("Set up your collar"));
		
	}

	public void showErrormsg() {
		wait(selector.activity_email_registration_name()).click();
		wait(for_find("Please enter a password that meets the minimum password requirements"));
		
	}

	public void nonselectableButton() {
		selector.activity_email_registration_create_account().isSelected();
		
	}

	public void showserrormessage() {
		wait(for_find("Please enter a valid email address"));
		
	}

}
