package aspire.mobile.automation.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import jo.aspire.mobile.automationUtil.DriverProvider;

public class RegistrationSteps extends BaseSteps {

	public RegistrationSteps(DriverProvider driverPorvider) throws Exception {
		super(driverPorvider);
	}
	
	@When("the user tap on signup with email")
	public void signupEmail() {
		registration.signupEmail();
	}
	
	@When("enter valid Name: <username> and valid email: <email> and valid password: <password>")
	public void registerHisAccount(@Named("username") String username,@Named("email") String email,
			@Named("password") String password) {
		registration.signupUsingEmail(username, email, password);
	}
	
	@When("tap creat account")
	public void createAccount() {
		registration.createAccount();
	}
	
	@Then("he can use the collar without involving any social networks")
	public void useCollar() {
		registration.useCollar();
	}
	
	@Then("the server creates the account, logs the user in, and moves to the setup flow")
	public void createdAccount() {
		registration.createdAccount();
	}
	
	@When("enter valid Name: <username> and valid email: <email> and invalid password: <password>")
	public void invalidpassword(@Named("username") String username,@Named("email") String email,
			@Named("password") String password) {
		registration.signupUsingEmail(username, email, password);
	}
	
	@Then("an error message shows on the input with a problem")
	public void showErrormsg() {
		registration.showErrormsg();
	}
	
	@Then("the Register button never becomes selectable and so registration cannot occur")
	public void nonselectableButton() {
		registration.nonselectableButton();
	}
	
	@When("enter valid Name: <username> and invalid email: <email> and valid password: <password>")
	public void invalidemail(@Named("username") String username,@Named("email") String email,
			@Named("password") String password) {
		registration.signupUsingEmail(username, email, password);
	}
	
	@Then("an error message shows on the input with problem")
	public void showserrormessage() {
		registration.showserrormessage();
	}

}
