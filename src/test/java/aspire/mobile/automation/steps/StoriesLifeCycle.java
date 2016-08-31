package aspire.mobile.automation.steps;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import jo.aspire.generic.EnvirommentManager;
import jo.aspire.mobile.automationUtil.DriverProvider;
import jo.aspire.mobile.automationUtil.TargetPlatform;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.BeforeStory;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aspire.automationReport.AspireReport;
import com.aspire.automationReport.MetaStoryInfo;
import com.aspire.automationReport.StoriesStatusCounter;



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

	}

	
	@AfterStory
	public void runAfterStory() {
		
			try {
				driverProvider.closeCurrentDriver();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			AspireReport.getInstance().setCurrentStoryEndDate();
			AspireReport.getInstance().printEveryThing();
	        try {
	        	
	        	
	        	String environment = "";
				if (TargetPlatform.platformName.equals("Android")) {
					environment = "Link APP - Android";
				} else {
					environment = "Link APP - iOS";
				}
	        	  StoriesStatusCounter counter =  AspireReport.getInstance().getReportDataManager().getTestCounters();
	              int passedTestCount = counter.getPassed();
	              int failedTestCount = counter.getFailed();
	              int skippedTestCount = counter.getSkipped();
	              int totalTestCount = passedTestCount + failedTestCount + skippedTestCount;
	     	     PrintWriter writer = new PrintWriter(AspireReport.getInstance().getReportDataManager().getReportPath() + File.separator + "High_Level_Results.txt", "UTF-8");
	     	   
	     	     String HighLevelResults = "  - Number of test cases ran: "+totalTestCount+ "<br/>" + "<font color='green'>  - Number of test cases passed: </font>" +passedTestCount+ "<br/>" + "<font color='red'>  - Number of test cases failed: </font>" +failedTestCount + "<br/>" + "<font color='blue'>  - Number of test cases skipped: </font>" + skippedTestCount + "<br/>";
	     	     for(String key : AspireReport.getInstance().getReportDataManager().getTestCounters().getMetaInfo().keySet()){
	     	    	MetaStoryInfo metaInfo = AspireReport.getInstance().getReportDataManager().getTestCounters().getMetaInfo().get(key);
	     	    	HighLevelResults = HighLevelResults + "<font color='green'>  - Number of " + key + " test cases passed: </font>" + metaInfo.getPassedCount() + "<br/>" + "<font color='red'>  - Number of " + key + " test cases failed: </font>" + metaInfo.getFailedCount()+ "<br/>";
	     	     }
	     	     
	     	     String email_body = "Hi Team,"+ "<br/>" + "<br/>" +"Please see attached test results"+ "<br/>" + "<br/>" +environment+ "<br/>" + "<br/>"+"<b> High Level Results</b>" + "<br/>" + HighLevelResults + "<br/>" + "<br/>" +"Thanks,"+ "<br/>" +"QA Team";
	     	     writer.println("email_body = " + email_body);
	     	     writer.close();
	           
	        } catch (Exception e) {
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
		}else{
			  DriverProvider.initializePortsAndUUIDs();
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
