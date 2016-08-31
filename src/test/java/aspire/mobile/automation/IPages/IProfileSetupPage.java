package aspire.mobile.automation.IPages;

public interface IProfileSetupPage {

	void enterValidData(String name, String age, String weight, String gender );

	void tapNext();

	void chooseBreed();

	void enterNoinfo(String name, String age, String weight, String gender );

	void showerrormessage();

	void disableNext();

	void seeDogslist();

	void selectBreed();

	void addCollar();

	void startCollarFlow();

}
