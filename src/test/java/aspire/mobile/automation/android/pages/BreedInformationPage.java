package aspire.mobile.automation.android.pages;

import jo.aspire.mobile.automationUtil.DriverProvider;
import jo.aspire.mobile.automationUtil.Helper;
import aspire.mobile.automation.IPages.IBreedInformationPage;
import aspire.mobile.automation.steps.selectors;

public class BreedInformationPage extends Helper implements IBreedInformationPage {

	selectors selector;
	public BreedInformationPage(DriverProvider driverPorvider,selectors selector) {
		super(driverPorvider);
		this.selector = selector;
		}
	
	public void tapSelectBreed() {
		wait(selector.fragment_dog_breed_select_breed()).click();
		
	}

}
