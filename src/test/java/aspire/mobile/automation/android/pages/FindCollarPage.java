package aspire.mobile.automation.android.pages;

import jo.aspire.mobile.automationUtil.DriverProvider;
import jo.aspire.mobile.automationUtil.Helper;
import aspire.mobile.automation.IPages.IFindCollarPage;
import aspire.mobile.automation.steps.selectors;

public class FindCollarPage extends Helper implements IFindCollarPage {

	selectors selector;
	public FindCollarPage(DriverProvider driverPorvider,selectors selector) {
		super(driverPorvider);
		this.selector = selector;{
		}
	}
	public void settingupCollar() {
		wait(selector.fragment_set_user_photo_next()).click();
		wait(selector.fragment_setup_collar_intro_find_collar()).click();
		wait(for_find("Nearby Collars")).isDisplayed();
		wait(selector.widget_link_collar_signal_strength()).isDisplayed();
		wait(selector.widget_link_collar_signal_strength_collar()).isDisplayed();
		wait(selector.widget_link_collar_name()).isDisplayed();
		wait(selector.widget_link_collar_status()).isDisplayed();
	}
	public void connectCollar() {
		wait(selector.widget_link_collar_name_container()).click();
		wait(for_find("Connect to Collar")).isDisplayed();
		
	}
	public void closeApp() {
		currentDriver().closeApp();
		
	}
	public void openNearbycollars() {
		currentDriver().launchApp();
		wait(for_find("Nearby Collars")).isDisplayed();
		wait(selector.widget_link_collar_signal_strength()).isDisplayed();
		wait(selector.widget_link_collar_signal_strength_collar()).isDisplayed();
		wait(selector.widget_link_collar_name()).isDisplayed();
		wait(selector.widget_link_collar_status()).isDisplayed();
		
	}
	public void pairCollar() {
		wait(selector.widget_link_collar_name_container()).click();
		wait(selector.fragment_collar_connect_confirm_button()).click();
		
	}
	public void personalizeCollar() {
		wait(selector.fragment_dog_create_profile_add_photo()).isDisplayed();
		element(selector.fragment_dog_create_profile_name()).isDisplayed();
		element(selector.fragment_dog_create_profile_age()).isDisplayed();
		element(selector.fragment_dog_create_profile_weight()).isDisplayed();
		element(selector.fragment_dog_create_profile_gender()).isDisplayed();
		element(selector.fragment_dog_create_profile_next()).isDisplayed();
	}

	public void gobackNearby() {
		wait(for_find("Nearby Collars")).isDisplayed();
		element(selector.widget_link_collar_signal_strength()).isDisplayed();
		element(selector.widget_link_collar_signal_strength_collar()).isDisplayed();
		element(selector.widget_link_collar_name()).isDisplayed();
		element(selector.widget_link_collar_status()).isDisplayed();
		
	}
	public void tapNo() {
		wait(selector.fragment_collar_connect_reject_button()).click();
		
	}
	public void pairphone() {
		wait(selector.widget_link_collar_name_container()).click();
		
	}
}
