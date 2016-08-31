package aspire.mobile.automation.android.pages;

import jo.aspire.mobile.automationUtil.DriverProvider;
import jo.aspire.mobile.automationUtil.Helper;
import aspire.mobile.automation.IPages.IViewingOwnerProfile;
import aspire.mobile.automation.steps.selectors;

public class ViewingOwnerProfilePage extends Helper implements IViewingOwnerProfile {

	selectors selector;
	public ViewingOwnerProfilePage(DriverProvider driverPorvider,selectors selector) {
		super(driverPorvider);
		this.selector = selector;
	}
	

	public void seeProfile() {
		wait(for_find("Main View"));
		wait(for_find("Navigate up")).click();
		wait(for_find("com.smartpettech.link.debug:id/widget_main_navigation_header_dog_profile_photo"));
		wait(for_find("Settings")).click();
		sleepTime(1000);
		wait(selector.fragment_settings_account()).click();
		
	}


	public void knowAnything() {
		wait(selector.widget_user_profile_header_name()).isDisplayed();
		wait(selector.widget_user_profile_header_email_address()).isDisplayed();
		wait(selector.widget_user_profile_header_member_since()).isDisplayed();
		wait(selector.widget_user_profile_header_profile_img()).isDisplayed();
		
	}


	public void presentProfile() {
		wait(selector.widget_user_profile_header_name()).isDisplayed();
		wait(selector.widget_user_profile_header_email_address()).isDisplayed();
		wait(selector.widget_user_profile_header_member_since()).isDisplayed();
		wait(selector.widget_user_profile_header_profile_img()).isDisplayed();
		wait(selector.widget_dog_profile_card_photo()).isDisplayed();
		wait(selector.widget_dog_profile_card_dog_name()).isDisplayed();
		wait(selector.widget_dog_profile_card_collar_ownership()).isDisplayed();
		
	}


	public void showOption() {
		wait(for_find("More options")).click();
		wait(for_find("Edit Profile")).isDisplayed();
		wait(for_find("Change Password")).click();
		wait(for_find("Close Account")).click();
	}


	public void photoFlow() {
		wait(for_find("Owner Photo")).isDisplayed();
		wait(selector.fragment_set_user_photo_add_photo()).click();
		
	}


	
}
