package aspire.mobile.automation.IPages;

public interface IRegistrationPage {

	void signupEmail();

	void signupUsingEmail(String username, String email, String password);

	void createAccount();

	void useCollar();

	void createdAccount();

	void showErrormsg();

	void nonselectableButton();

	void showserrormessage();

}
