package aspire.mobile.automation.steps;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jo.aspire.generic.EnvirommentManager;
import jo.aspire.mobile.automationUtil.DriverProvider;

import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertThat;
import aspire.mobile.util.MysqlConnector;





public class LoginSteps extends BaseSteps {
	MysqlConnector dbConn = new MysqlConnector();
	 public List<String> dataList = new ArrayList<String>();
	 String response2;
	public LoginSteps(DriverProvider driverPorvider) throws Exception {
		
		super(driverPorvider);
	}

	@Given("the user opens the app")
	public void opensApp(){

	}
	
	@When("he is not logged in")
	public void notLoggedin() {
		login.notLoggedin();
	}
	
	@When("wants to log in with email")
	public void loginEmail() {
		login.loginEmail();

	}
	
	@Given("I want to open a connection to MySQL DB")
	 @When("I want to open a connection to MySQL DB")
	 @Then("I want to open a connection to MySQL DB")
	 public void connect2MySQL() throws ClassNotFoundException, SQLException {

	  assertThat(dbConn.dbOpenConn(), Matchers.equalTo(true));
	 }
	
	
	@Then("I want to pull the data from the DB using $query query with $id")
	 @When("I want to pull the data from the DB using $query query with $id")
	 public void getDBDataRID(String query, String id) throws ClassNotFoundException,
	   SQLException {
	  String getQuery = String.format(EnvirommentManager.getInstance()
	    .getProperty(query));
	  getQuery = getQuery.replaceFirst("\\[parameter\\]", id);
	  dataList = dbConn.ExecuteAPIQuery(getQuery);

	 }
	
	@When("logins using valid username: <username> and valid password: <password>")
	public void signInWithEmail(@Named("username") String username,
			@Named("password") String password) {
		login.loginUsingEmail(username, password);

	}
	
	@Then("he can use the app to control the collar")
	public void controlCollar() {  

	}
	
	@When("he taps on I already have an account on the Welcome view")
	public void haveAccount() {
		login.haveAccount();
	}
	
	@Then("Log in button should become tappable")
	public void becomeTappable() {  
		login.becomeTappable();
	}

	@Then("he is taken to the default initial view of the Link app")
	public void takenToDefaultview() {  
		login.takenToDefaultview();
	}
	
	@When("logins using empty username: <username> and password: <password>")
	public void signInWithEmptyEmail(@Named("username") String username,
			@Named("password") String password) {
		login.loginUsingEmail(username, password);
	}
	
	@Then("Descriptive messages appear on the proper inputs after he has given focus to each field and move onto the next field")
	public void appearMessages() {  
		login.appearMessages();
	}
	
	@Then("the login button is not enabled")
	public void disableLogin() {  
		login.disableLogin();
	}
	
	@When("logins using username: <username> and empty password: <password>")
	public void signInWithEmptypassword(@Named("username") String username,
			@Named("password") String password) {
		login.loginUsingEmail(username, password);
	}
	
	@Then("Descriptive message appear on the proper inputs after he has given focus to each field and move onto the next field")
	public void appearMessage() {  
		login.appearMessage();
	}
	
	@When("logins using email without @: <username> and  password: <password>")
	public void signInWithinvalidEmail(@Named("username") String username,
			@Named("password") String password) {
		login.loginUsingEmail(username, password);
	}
	
	@When("logins using username: <username> and password shorter than 8 characters: <password>")
	public void signInWithlesspassword(@Named("username") String username,
			@Named("password") String password) {
		login.loginUsingEmail(username, password);
	}
	
	@When("logins using incorrect email: <username> and password: <password>")
	public void signInWithIncorrectEmail(@Named("username") String username,
			@Named("password") String password) {
		login.loginUsingEmail(username, password);
	}
	
	@Then("the user is able to tap Log in")
	public void tapLogin() {  
		login.tapLogin();
	}
	
	@Then("an error message occurs Incorrect email and/or password")
	public void displayMessage() {  
		login.displayMessage();
	}
	
	@When("logins using correct email: <username> and incorrect password: <password>")
	public void signInWithIncorrectpassword(@Named("username") String username,
			@Named("password") String password) {
		login.loginUsingEmail(username, password);
	}
	
	@When("wants to log in with Facebook account")
	public void loginFB() {  
		login.loginFB();
	}
	
	@Then("he can use the app to control the collar without needing a password")
	public void controlCollarFB() {  
		login.controlCollarFB();
	}
	
	@When("not authorized already")
	public void notAuthorized() {
		login.notAuthorized();
	}
	
	@When("the user will be asked for permission to share public profile and email")
	public void askforPermission() {  
		login.askforPermission();
	}
	
	@Then("user is logged in")
	public void loggedin() {  
		login.loggedin();
	}
	
	@Then("App displays the Main View")
	public void displayMainMenu() {  
		login.displayMainMenu();
	}
	
	@When("registration with Facebook fails")
	public void failsRegistration() {  
		login.failsRegistration();
	}
	
	@Then("App remains on the Registration View")
	public void remainsRegistrationView() {  
		login.remainsRegistrationView();
	}
	
	@Then("a descriptive error message should appear on the Welcome View")
	public void appeardescriptivemsg() {  
		login.appeardescriptivemsg();
	}
	
	@Then("App process can be killed")
	public void killProcess() {  
		login.killProcess();
	}
	
	@Then("App restarted")
	public void restartApp() {  
		login.restartApp();
	}
	
	@Then("the Welcome View will be presented to the user")
	public void viewWelcome() {  
		login.viewWelcome();
	}
	
	@Then("the user will still be able to successfully log in using Facebook account")
	public void loginsuccessfullyFB() {  
		login.loginsuccessfullyFB();
	}
	
	@When("the user logs in to his account on the app username: <username> password: <password>")
	public void signIntoHisAccount(@Named("username") String username,
			@Named("password") String password) {
		login.loginUsingEmail(username, password);
	}
	
	@When("the login is saved on the app")
	public void saveLogin() {  
	}
	
	@Then("the user doesn't have to log in every time when opening the app")
	public void doesntLogin() {  
		login.doesntLogin();
	}
	
	@When("user is presented with the AKC Link launch screen which includes branding")
	public void launchAKC() {
		
	}
	
	@Then("the Welcome view should display following options Sign up with Facebook, Sign up with Email, I already have an account")
	public void welcomeView() {  
		login.welcomeView();
	}
	
	@Then("he wants to see I forget my password in login screen")
	public void forgetPassword() {  
		login.forgetPassword();
	}
	
	@When("I am presented a menu option to Sign Out")
	public void signOut() {
		login.signOut();
	 
	}
	
	@Then("on Success, I am brought to the Welcome View upon successful sign out")
	public void successfulSignout() {  
		login.successfulSignout();

	}
	

}
