package aspire.mobile.automation.steps;

import io.appium.java_client.MobileElement;
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
	public  By activity_email_registration_name(){return for_find(getProperty("activity_email_registration_name"));}
	public  WebElement activity_email_registration_email_address(){ return findElement(getProperty("activity_email_registration_email_address"));}
	public  WebElement activity_email_registration_password(){ return findElement(getProperty("activity_email_registration_password"));}
	public  WebElement activity_email_registration_create_account(){ return findElement(getProperty("activity_email_registration_create_account"));}
	public  WebElement fragment_collar_setup_intro_title(){ return findElement(getProperty("fragment_collar_setup_intro_title"));}
	public  WebElement fragment_collar_setup_pictorial(){ return findElement(getProperty("fragment_collar_setup_pictorial"));}
	public  By fragment_settings_account(){ return for_find(getProperty("fragment_settings_account"));}
	public  By widget_user_profile_header_name(){ return for_find(getProperty("widget_user_profile_header_name"));}
	public  By widget_user_profile_header_email_address(){ return for_find(getProperty("widget_user_profile_header_email_address"));}
	public  By widget_user_profile_header_member_since(){ return for_find(getProperty("widget_user_profile_header_member_since"));}
	public  By widget_user_profile_header_profile_img(){ return for_find(getProperty("widget_user_profile_header_profile_img"));}
	public  By widget_dog_profile_card_photo(){ return for_find(getProperty("widget_dog_profile_card_photo"));}
	public  By widget_dog_profile_card_dog_name(){ return for_find(getProperty("widget_dog_profile_card_dog_name"));}
	public  By widget_dog_profile_card_collar_ownership(){ return for_find(getProperty("widget_dog_profile_card_collar_ownership"));}
	public  By fragment_set_user_photo_add_photo(){ return for_find(getProperty("fragment_set_user_photo_add_photo"));}
	public  By fragment_set_user_photo_next(){ return for_find(getProperty("fragment_set_user_photo_next"));}
	public  By fragment_setup_collar_intro_find_collar(){ return for_find(getProperty("fragment_setup_collar_intro_find_collar"));}
	public  By widget_link_collar_signal_strength(){ return for_find(getProperty("widget_link_collar_signal_strength"));}
	public  By widget_link_collar_signal_strength_collar(){ return for_find(getProperty("widget_link_collar_signal_strength_collar"));}
	public  By widget_link_collar_name(){ return for_find(getProperty("widget_link_collar_name"));}
	public  By widget_link_collar_status(){ return for_find(getProperty("widget_link_collar_status"));}
	public  By widget_link_collar_name_container(){ return for_find(getProperty("widget_link_collar_name_container"));}
	public  By fragment_collar_connect_confirm_button(){ return for_find(getProperty("fragment_collar_connect_confirm_button"));}
	public  By fragment_dog_create_profile_add_photo(){ return for_find(getProperty("fragment_dog_create_profile_add_photo"));}
	public  By fragment_dog_create_profile_name(){ return for_find(getProperty("fragment_dog_create_profile_name"));}
	public  By fragment_dog_create_profile_age(){ return for_find(getProperty("fragment_dog_create_profile_age"));}
	public  By fragment_dog_create_profile_weight(){ return for_find(getProperty("fragment_dog_create_profile_weight"));}
	public  By fragment_dog_create_profile_gender(){ return for_find(getProperty("fragment_dog_create_profile_gender"));}
	public  By fragment_dog_create_profile_next(){ return for_find(getProperty("fragment_dog_create_profile_next"));}
	public  By fragment_collar_connect_reject_button(){ return for_find(getProperty("fragment_collar_connect_reject_button"));}
	public  By fragment_dog_breed_tell_us(){ return for_find(getProperty("fragment_dog_breed_tell_us"));}
	public  By fragment_dog_breed_is_mix_label(){ return for_find(getProperty("fragment_dog_breed_is_mix_label"));}
	public  By fragment_dog_breed_select_breed(){ return for_find(getProperty("fragment_dog_breed_select_breed"));}
	public  By widget_dog_profile_list_item_profile_photo(){ return for_find(getProperty("widget_dog_profile_list_item_profile_photo"));}
	public  By widget_dog_profile_list_item_name(){ return for_find(getProperty("widget_dog_profile_list_item_name"));}
	public  By widget_dog_profile_list_item_breed(){ return for_find(getProperty("widget_dog_profile_list_item_breed"));}
	public  By widget_dog_profile_list_item_age(){ return for_find(getProperty("widget_dog_profile_list_item_age"));}
	public  By widget_dog_profile_list_item_weight(){ return for_find(getProperty("widget_dog_profile_list_item_weight"));}
	public  By widget_dog_profile_list_item_gender(){ return for_find(getProperty("widget_dog_profile_list_item_gender"));}
	public  By fragment_dog_breed_done(){ return for_find(getProperty("fragment_dog_breed_done"));}
	
	
	
	
	
	
	
	
	
	
	
	
}