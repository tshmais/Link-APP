package aspire.mobile.automation.android.pages;

import org.openqa.selenium.WebElement;

import jo.aspire.mobile.automationUtil.DriverProvider;
import jo.aspire.mobile.automationUtil.Helper;
import aspire.mobile.automation.IPages.IProfileSetupPage;
import aspire.mobile.automation.steps.selectors;

public class ProfileSetupPage extends Helper implements IProfileSetupPage {

	selectors selector;
	public ProfileSetupPage(DriverProvider driverPorvider,selectors selector) {
		super(driverPorvider);
		this.selector = selector;
	}
	
	public void tapNext() {
		wait(selector.fragment_dog_create_profile_next()).click();
		
	}
	public void chooseBreed() {
		wait(selector.fragment_dog_breed_tell_us()).isDisplayed();
		wait(selector.fragment_dog_breed_is_mix_label()).isDisplayed();
		wait(selector.fragment_dog_breed_select_breed()).isDisplayed();
		
	}

	public void enterValidData(String name, String age, String weight,
			String gender) {
		wait(selector.fragment_dog_create_profile_name()).sendKeys(name);
		try {
			hideKeyboard();
		} catch (Exception e) {}
		element(selector.fragment_dog_create_profile_age()).sendKeys(age);
		try {
			hideKeyboard();
		} catch (Exception e) {}
		element(selector.fragment_dog_create_profile_weight()).sendKeys(weight);
		try {
			hideKeyboard();
		} catch (Exception e) {}
		element(selector.fragment_dog_create_profile_gender()).click();
		wait(for_find(gender)).click();
	
		
	}

	public void enterNoinfo(String name, String age, String weight,
			String gender) {
		wait(selector.fragment_dog_create_profile_name()).sendKeys(name);
		try {
			hideKeyboard();
		} catch (Exception e) {}
		element(selector.fragment_dog_create_profile_age()).sendKeys(age);
		try {
			hideKeyboard();
		} catch (Exception e) {}
		element(selector.fragment_dog_create_profile_weight()).sendKeys(weight);
		try {
			hideKeyboard();
		} catch (Exception e) {}
		element(selector.fragment_dog_create_profile_gender()).click();
		wait(for_find(gender)).click();
		
		
	}

	public void showerrormessage() {
		wait(for_find("all fields required")).isDisplayed();
		
	}

	public void disableNext() {
		wait(selector.fragment_dog_create_profile_next()).isSelected();
		
	}

	public void seeDogslist() {
		wait(selector.widget_dog_profile_list_item_profile_photo()).isDisplayed();
		element(selector.widget_dog_profile_list_item_name()).isDisplayed();
		element(selector.widget_dog_profile_list_item_breed()).isDisplayed();
		element(selector.widget_dog_profile_list_item_age()).isDisplayed();
		element(selector.widget_dog_profile_list_item_weight()).isDisplayed();
		element(selector.widget_dog_profile_list_item_gender()).isDisplayed();
		
	}

	public void selectBreed() {
		wait(selector.fragment_dog_breed_select_breed()).click();
		wait(for_find("Akita")).click();
		element(selector.fragment_dog_breed_done()).click();
	}

	public void addCollar() {
		wait(for_find("Add Collar")).click();
		
	}

	public void startCollarFlow() {
		// TODO Auto-generated method stub
		
	}

}
