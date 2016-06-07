package aspire.mobile.automation.iOS.pages;



import jo.aspire.mobile.automationUtil.DriverProvider;
import jo.aspire.mobile.automationUtil.Helper;

import org.junit.AfterClass;







import aspire.mobile.automation.IPages.ILoginPage;
import aspire.mobile.automation.steps.selectors;



public class LoginPageiOS extends Helper implements ILoginPage {

	selectors selector;
	public LoginPageiOS(DriverProvider driverPorvider,selectors selector) {
		super(driverPorvider);
		this.selector = selector;
	}

	@AfterClass
	public void runAfterTest() {
	}



	public void displayApps() {
		//currentDriver().resetApp();
		
	}

	public void Location(String value) {

		try {
			clickOnImage("OK.png");
			sleepTime(3000);
			clickOnImage("Don't Allow.png");
		} catch (Exception e1) {}
			
		wait(for_attribute("Continuar")).click();
		wait(for_attribute("Elegir Ciudad")).click();
       


		try {
			wait(for_attribute(value)).click();
		} catch (Exception e) {
			
			int screenHeight = currentDriver().manage().window().getSize().getHeight();
			int screenWidth = currentDriver().manage().window().getSize().getWidth();
			 for (int i = 0; i < 3; i++) {
				currentDriver().swipe((int) (screenWidth * 0.5),
						(int) (screenHeight * 0.8), (int) (screenWidth * 0.5),
						0, 1000);
				sleepTime(1000);
			}
			wait(for_attribute(value)).click();
		}
    }
	

             
 
    public void selectMarket(){
	
}

	public void notLoggedin() {
		// TODO Auto-generated method stub
		
	}

	public void loginEmail() {
		// TODO Auto-generated method stub
		
	}

	public void loginUsingEmail(String username, String password) {
		// TODO Auto-generated method stub
		
	}

	public void haveAccount() {
		// TODO Auto-generated method stub
		
	}

	public void becomeTappable() {
		// TODO Auto-generated method stub
		
	}

	public void takenToDefaultview() {
		// TODO Auto-generated method stub
		
	}

	public void appearMessages() {
		// TODO Auto-generated method stub
		
	}

	public void disableLogin() {
		// TODO Auto-generated method stub
		
	}

	public void appearMessage() {
		// TODO Auto-generated method stub
		
	}

	public void tapLogin() {
		// TODO Auto-generated method stub
		
	}

	public void displayMessage() {
		// TODO Auto-generated method stub
		
	}

	public void loginFB() {
		// TODO Auto-generated method stub
		
	}

	public void controlCollarFB() {
		// TODO Auto-generated method stub
		
	}

	public void notAuthorized() {
		// TODO Auto-generated method stub
		
	}

	public void askforPermission() {
		// TODO Auto-generated method stub
		
	}

	public void loggedin() {
		// TODO Auto-generated method stub
		
	}

	public void displayMainMenu() {
		// TODO Auto-generated method stub
		
	}

	public void loginsuccessfullyFB() {
		// TODO Auto-generated method stub
		
	}

	public void viewWelcome() {
		// TODO Auto-generated method stub
		
	}

	public void restartApp() {
		// TODO Auto-generated method stub
		
	}

	public void killProcess() {
		// TODO Auto-generated method stub
		
	}

	public void appeardescriptivemsg() {
		// TODO Auto-generated method stub
		
	}

	public void remainsRegistrationView() {
		// TODO Auto-generated method stub
		
	}

	public void failsRegistration() {
		// TODO Auto-generated method stub
		
	}


	public void doesntLogin() {
		// TODO Auto-generated method stub
		
	}

	public void welcomeView() {
		// TODO Auto-generated method stub
		
	}


}
