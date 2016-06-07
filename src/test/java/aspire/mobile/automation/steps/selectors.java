package aspire.mobile.automation.steps;

import jo.aspire.generic.EnvirommentManager;
import jo.aspire.mobile.automationUtil.DriverProvider;
import jo.aspire.mobile.automationUtil.Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class selectors extends Helper
{
	public selectors(DriverProvider driverPorvider) {
		super(driverPorvider);
	}


	private  String getProperty (String name)
	{
		return EnvirommentManager.getInstance().getProperty(name);
	}
	
	public  By activity_welcome_logo(){ return for_find(getProperty("activity_welcome_logo"));}
	public  By activity_welcome_tagline(){ return for_find(getProperty("activity_welcome_tagline"));}
	public  By activity_welcome_facebook_signup(){ return for_find(getProperty("activity_welcome_facebook_signup"));}
	public  By activity_welcome_email_signup(){ return for_find(getProperty("activity_welcome_email_signup"));}
	public  By activity_welcome_have_account(){ return for_find(getProperty("activity_welcome_have_account"));}
	public  WebElement activity_email_sign_in_email_address(){return findElement(getProperty("activity_email_sign_in_email_address"));}
	public  WebElement activity_email_sign_in_password(){ return findElement(getProperty("activity_email_sign_in_password"));}
	public  WebElement activity_email_sign_in_sign_in(){ return findElement(getProperty("activity_email_sign_in_sign_in"));}
	public  By activity_email_sign_in_facebook(){ return for_find(getProperty("activity_email_sign_in_facebook"));}
	public  WebElement activity_email_registration_name(){return findElement(getProperty("activity_email_registration_name"));}
	public  WebElement activity_email_registration_email_address(){ return findElement(getProperty("activity_email_registration_email_address"));}
	public  WebElement activity_email_registration_password(){ return findElement(getProperty("activity_email_registration_password"));}
	public  WebElement activity_email_registration_create_account(){ return findElement(getProperty("activity_email_registration_create_account"));}
	
}