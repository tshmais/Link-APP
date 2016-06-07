package aspire.mobile.automation.steps;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.io.IOException;

import jo.aspire.generic.EnvirommentManager;
import jo.aspire.mobile.automationUtil.DriverProvider;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.BeforeStory;

import com.aspire.automationReport.AspireReport;



public class StoriesLifeCycle {
	DriverProvider driverProvider; 

	StoriesLifeCycle(DriverProvider driverProvider){
		this.driverProvider = driverProvider;
	}
	
	
	private  String getProperty (String name){
		return EnvirommentManager.getInstance().getProperty(name);
	}
	
	public static AppiumDriverLocalService Service;
	//long startTime 	= 0;
	//long endTime 	= 0;
	//String maxRunTime = EnvirommentManager.getInstance().getProperty("maxTimeToRestartEmulator"); //minutes  2.3 hrs
	
	
	
	public void startServer(){
		
	
		  
		  DriverProvider.initializePortsAndUUIDs();
		for (int i = 0; i < DriverProvider.appiumPortsList.size(); i++) {
			Service = AppiumDriverLocalService
					.buildService(new AppiumServiceBuilder()
							.usingDriverExecutable(
									new File(getProperty("Node")))
							.withAppiumJS(new File(getProperty("AppiumJS")))
							.withIPAddress("127.0.0.1").usingPort(Integer.parseInt(DriverProvider.appiumPortsList.get(i).trim()))
							.withArgument(GeneralServerFlag.LOG_LEVEL, "error")
							.withArgument(GeneralServerFlag.SESSION_OVERRIDE));
			Service.start();
		}
//try {
//	Thread.sleep(10000);
//} catch (InterruptedException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
	}

	
	@AfterStory
	public void runAfterStory() {
	try {
			driverProvider.closeCurrentDriver();
			AspireReport.getInstance().setCurrentStoryEndDate();
			AspireReport.getInstance().printEveryThing();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeStories
	
    public void runBeforeStories() throws IOException, InterruptedException{
		if (getProperty("autoStartAppium").equals("true") && !(getProperty("UseSauceLabs").equals("true") || getProperty("RunAmazon").equals("true"))) {
		    if (System.getProperty("os.name").toLowerCase().contains("mac")){
	        	Runtime.getRuntime().exec("killall node");
	        //	Runtime.getRuntime().exec("killall adb");
	        }
	        if (System.getProperty("os.name").toLowerCase().contains("windows")){
	        	  Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	        	  Thread.sleep(10000);
	        }
			startServer();
    
		//Service.start();
		}
          
    }
	
	@AfterStories
	public void runAfterStories() throws IOException {

			AspireReport.getInstance().printEveryThing();
			AspireReport.getInstance().getReportDataManager().openReport();
			if (getProperty("autoStartAppium").equals("true") && !(getProperty("UseSauceLabs").equals("true") || getProperty("RunAmazon").equals("true"))) {
			Service.stop();
			}

	}
    
    
    @BeforeScenario
    public void runBeforeScenario()
    {
    	AspireReport.getInstance().setCurrentScenarioStartDate();
          
    }

    @BeforeStory
    public void runBeforeStory()
    {
    	AspireReport.getInstance().setCurrentStoryStartDate();
    }
    @AfterScenario
    public void runAfterScenario()
    {
    	AspireReport.getInstance().setCurrentScenarioEndDate();
     String sessionId = driverProvider.sessions.get(Thread.currentThread().getName());
        if(sessionId != null)
        {
          // ASReport.getInstance().setSessionId(sessionId);
        	AspireReport.getInstance().getReportDataManager().setSessionId(sessionId);
        }
    }

}
