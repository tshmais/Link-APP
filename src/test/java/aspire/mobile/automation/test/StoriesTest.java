package aspire.mobile.automation.test;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.web.selenium.WebDriverHtmlOutput.WEB_DRIVER_HTML;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jo.aspire.generic.EnvirommentManager;
import jo.aspire.mobile.automationUtil.DriverProvider;
import jo.aspire.mobile.automationUtil.SauceLabeSessionHandler;
import jo.aspire.mobile.automationUtil.TargetPlatform;

import org.apache.commons.io.FileUtils;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.MetaFilter;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.embedder.StoryManager;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.failures.PendingStepStrategy;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.model.Meta;
import org.jbehave.core.model.Scenario;
import org.jbehave.core.model.Story;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.spring.SpringApplicationContextFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.jbehave.web.selenium.ContextView;
import org.jbehave.web.selenium.LocalFrameContextView;
import org.jbehave.web.selenium.SeleniumConfiguration;
import org.jbehave.web.selenium.SeleniumContext;
import org.jbehave.web.selenium.SeleniumContextOutput;
import org.jbehave.web.selenium.SeleniumStepMonitor;
import org.springframework.context.ApplicationContext;

import com.aspire.automationReport.AspireReport;
import com.saucelabs.saucerest.SauceREST;

/**
 * Class which provides the link between the JBehave's executor framework
 * (called Embedder) and the textual stories.
 */

//@RunWith(JUnitReportingRunner.class)
public class StoriesTest extends JUnitStories {
	private static Embedder embedder = null;
	private int numberOfThreads = 1;

	PendingStepStrategy pendingStepStrategy = new FailingUponPendingStep();
	CrossReference crossReference = new CrossReference().withJsonOnly()
			.withPendingStepStrategy(pendingStepStrategy)
			.withOutputAfterEachStory(true)
			.excludingStoriesWithNoExecutedScenarios(true);
	ContextView contextView = new LocalFrameContextView().sized(640, 80)
			.located(10, 10);
	SeleniumContext seleniumContext = new SeleniumContext();
	SeleniumStepMonitor stepMonitor = new SeleniumStepMonitor(contextView,
			seleniumContext, crossReference.getStepMonitor());
	Format[] formats = new Format[] {
			new SeleniumContextOutput(seleniumContext), CONSOLE,
			WEB_DRIVER_HTML, AspireReport.Aspire_Report };
	StoryReporterBuilder reporterBuilder = new StoryReporterBuilder()
			.withCodeLocation(codeLocationFromClass(StoriesTest.class))
			.withFailureTrace(true).withFailureTraceCompression(true)
			.withDefaultFormats().withFormats(formats)
			.withCrossReference(crossReference);

	public StoriesTest() {
		EnvirommentManager.setInitialClass(this.getClass());
		numberOfThreads = Integer.parseInt(EnvirommentManager.getInstance()
				.getProperty("threads"));
	}

	@Override
	public Configuration configuration() {

		boolean headless = true;// GraphicsEnvironment.isHeadless();
		if (TargetPlatform.runOnAmazon) {
			reporterBuilder = new StoryReporterBuilder()
					.withCodeLocation(codeLocationFromClass(StoriesTest.class))
					.withFailureTrace(true).withFailureTraceCompression(true)
					.withDefaultFormats().withCrossReference(crossReference);
		}
		Configuration configuration = new SeleniumConfiguration()
				.useSeleniumContext(seleniumContext)
				.usePendingStepStrategy(pendingStepStrategy)
				.useStoryControls(
						new StoryControls().doResetStateBeforeScenario(false))
				.useStoryLoader(new LoadFromClasspath(StoriesTest.class))
				.useStoryReporterBuilder(reporterBuilder);

		return headless ? configuration : configuration
				.useStepMonitor(stepMonitor);
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		ApplicationContext context = new SpringApplicationContextFactory(
				"steps.xml").createApplicationContext();
		return new SpringStepsFactory(configuration(), context);
	}

	@Override
	protected List<String> storyPaths() {

		return new StoryFinder().findPaths(
				codeLocationFromClass(this.getClass()).getFile(), asList("**/"
						+ System.getProperty("storyFilter", "*") + ".story"),
				null);
	}

	protected List<String> failedStoryPaths(List<String> stories) {
		ArrayList<String> storiesToRun = new ArrayList<String>();

		for (String story : stories) {
			storiesToRun.add("**/" + story+".story");
		}
		return new StoryFinder().findPaths(
				codeLocationFromClass(this.getClass()).getFile(), storiesToRun,
				null);
	}

	private void setReportName() {
		String buildName = System.getProperty("buildName");
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("MMddhhmmss");
		if (buildName == null) {
			buildName = "";
		}
		

    	String environment = "";
		if (TargetPlatform.platformName.equals("Android")) {
			environment = "Link APP - Android";
		} else {
			environment = "Link APP - iOS";
		}
		
		String dateAndTime = ft.format(date);
		String dateAndTime1 = ft.format(date);
		dateAndTime = dateAndTime.replace(",,", " ");
		dateAndTime1 = dateAndTime1.replace(",,", ":");
		
		String ReportName = System.getProperty("Report_Name");
		  if (ReportName == null) {
		   ReportName = "Link API Automation Report " + dateAndTime + " " +"(BuildNumber " + buildName + ")" + ".html";
		  }
		
		AspireReport.getInstance().getReportDataManager().setReportFileName(ReportName);
		if(Integer.parseInt(EnvirommentManager.getInstance().getProperty("threads")) > 1){
			AspireReport.getInstance().getReportDataManager().setThreading(true);
		}
		AspireReport.getInstance().getReportDataManager().setReportTitle("Link APP");
		AspireReport.getInstance().getReportDataManager().setReportSubTitle("testing report");
		AspireReport.getInstance().getReportDataManager().setTitle(environment+" Automation");
		AspireReport.getInstance().getReportDataManager().setRunningMobile(true);
		AspireReport.getInstance().getReportDataManager().setPlatformName(TargetPlatform.platformName);
		AspireReport.getInstance().getReportDataManager().setDeviceName(TargetPlatform.deviceName);
		AspireReport.getInstance().getReportDataManager().setPlatformVersion(TargetPlatform.platformVersion);
		AspireReport.getInstance().getReportDataManager().setBuildNumber(TargetPlatform.appFileName);

	}

	public void getPlatformInformation() {
		String platformVersion = System.getProperty("platformVersion");
		if (platformVersion == null) { // get the Android version attribute from
										// Environment.properties
			platformVersion = EnvirommentManager.getInstance().getProperty(
					"platformVersion");
		}
		TargetPlatform.platformVersion = platformVersion;

		String platformName = System.getProperty("platformName");
		if (platformName == null) { // get the Android version attribute from
									// Environment.properties
			platformName = EnvirommentManager.getInstance().getProperty(
					"platformName");
		}
		TargetPlatform.platformName = platformName;

		String deviceName = System.getProperty("deviceName");
		if (deviceName == null) { // get the Android version attribute from
									// Environment.properties
			deviceName = EnvirommentManager.getInstance().getProperty(
					TargetPlatform.platformName + "DeviceName");
		}
		TargetPlatform.deviceName = deviceName;

		// get the Android version attribute from Environment.properties
		TargetPlatform.appFileName = EnvirommentManager.getInstance()
				.getProperty(TargetPlatform.platformName + "AppFileName");



	}

	@Override
	public void run() throws Throwable {
		DriverProvider.jobName="AKC Link";
		if (System.getProperty("skipTests") != null
				&& System.getProperty("skipTests").equals("true")) {
			return;
		}

		if ((System.getProperty("RunAmazon") != null && System.getProperty(
				"RunAmazon").equals("true"))
				|| EnvirommentManager.getInstance().getProperty("RunAmazon")
						.trim().equals("true")) {
			TargetPlatform.runOnAmazon = true;
		}
		getPlatformInformation();
		if (!TargetPlatform.runOnAmazon) {
			// split the versions in list

			checkFileInfo();
		}
		String[] platformVersionList = TargetPlatform.platformVersion
				.split(",");
		for (int i = 0; i < platformVersionList.length; i++) {
			TargetPlatform.platformVersion = platformVersionList[i];
			embedder = configuredEmbedder();
			embedder.embedderControls().doGenerateViewAfterStories(false);
			embedder.embedderControls().useStoryTimeoutInSecs(5000);
			embedder.useMetaFilters(getMetaData());
			//embedder.useMetaFilters(asList("+AwsDeviceFarm"));

			boolean rerunFailed = Boolean.parseBoolean(EnvirommentManager
					.getInstance().getProperty("rerunFailedStories"));


			if (!TargetPlatform.runOnAmazon) {
				embedder.embedderControls().useThreads(numberOfThreads);
				setReportName();
			}
			try {

				if (SauceLabeSessionHandler.getRunOnSauce()) {
				//	ASReport.getInstance().isRunOnSauce(true);
					AspireReport.getInstance().getReportDataManager().setRunOnSauce(true);
				} else {
					//ASReport.getInstance().isRunOnSauce(false);
					AspireReport.getInstance().getReportDataManager().setRunOnSauce(false);
				}

				if (!rerunFailed) {
					//ASReport.writeFailedReport = true;
				}
				
				embedder.runStoriesAsPaths(storyPaths());

//				if (!rerunFailed) {
//					skipScenariosList();
//				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				embedder.generateCrossReference();
			}

			if (rerunFailed && !TargetPlatform.runOnAmazon) {
				int rerunCount = Integer.parseInt(EnvirommentManager
						.getInstance().getProperty("rerunCount"));

				for (int j = 1; j <= rerunCount; j++) {
				if (AspireReport.getInstance().getReportDataManager().getFailedStories() != null
							&& AspireReport.getInstance().getReportDataManager().getFailedStories().size() > 0) {
						Embedder embedder2 = configuredEmbedder();
						embedder2.embedderControls().doGenerateViewAfterStories(false);
						embedder2.embedderControls().useStoryTimeoutInSecs(5000);
						embedder2.useMetaFilters(getMetaData());
						embedder2.embedderControls()
								.useThreads(numberOfThreads);
						try {
							if (j == rerunCount) {
								//ASReport.writeFailedReport = true;
							}
							
//							if (j == rerunCount || AspireReport.getInstance().getReportDataManager().getFailedStories().size() == 0) {
//								skipScenariosList();
//							}
	
							embedder2.runStoriesAsPaths(failedStoryPaths(AspireReport.getInstance().getReportDataManager().getFailedStories()));
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							embedder2.generateCrossReference();
						}
					}
								
				}
				//ASReport.storyFailedList = null;
			
			}
			}
		}

	 public void checkFileInfo() {
	        boolean uploadFile = Boolean.parseBoolean(EnvirommentManager
	                .getInstance().getProperty("upload-apk-file"));
	        String lastFolderName = "apk";
	        String fileExtension =".apk";
	        if (TargetPlatform.platformName.toLowerCase().equals("ios")) {
	            fileExtension =".app.zip";
	            lastFolderName = "builds-archive";
	        }
	        String userDir = System.getProperty("user.dir") + File.separator
	                + "app" + File.separator + "build" + File.separator + "outputs"
	                + File.separator + lastFolderName;
	        
	        File folder = new File(userDir);
	        File lastFile = null;
	        long maxTime = 0;
	        for (File file : folder.listFiles()) {
	            if (file.lastModified() > maxTime
	                    && !file.getName().toLowerCase().contains(".ds_store")) {
	               // System.out.println("File:" + file.getName() + ", Last modified:" + file.lastModified());
	                lastFile = file;
	                maxTime = file.lastModified();
	            }
	        }
	        
	        String newFileName = lastFile.getName();
	        newFileName =  newFileName.replace(".apk", "");
	        newFileName =  newFileName.replace(".app.zip", "");
	        newFileName =  newFileName.replace(".", "");
	        newFileName =  newFileName.replace("(", "");
	        newFileName =  newFileName.replace(")", "");
	        newFileName =  newFileName.replace("_", "");
	        newFileName =  newFileName.replace("--", "");
	        newFileName =  newFileName.replace("-", "");
	        newFileName = newFileName + fileExtension;
	       
	       
	        
	         String newFilePath = lastFile.getAbsolutePath().replace(lastFile.getName(), "") + newFileName;
	          File newFile = new File(newFilePath);


	            try {
					FileUtils.moveFile(lastFile, newFile);
				} catch (IOException e1) {}
	   
	        String localApp = newFile.getName();
	        TargetPlatform.appFileName = localApp;
	        TargetPlatform.fileDirectory = newFile.getParent();
	        if (SauceLabeSessionHandler.getRunOnSauce() && uploadFile) {
	            String user = SauceLabeSessionHandler.getAuth().getUsername();
	            String key = SauceLabeSessionHandler.getAuth().getAccessKey();
	            URL serverAddress;
	            SauceREST rest = new SauceREST(user, key);
	            System.out.println("********** Uploading apk file *********");
	            
	            try {
	                rest.uploadFile(newFile, localApp);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            System.out.println("********** Uploading apk file has completed *********");
	        }
	        
	      
			System.out.println(TargetPlatform.platformName);
			System.out.println(TargetPlatform.platformVersion);
			System.out.println(TargetPlatform.deviceName);
//			  if (SessionHandler.getRunOnSauce() && uploadFile){
				  System.out.println(newFileName);
//	        }else{
//	        	System.out.println(TargetPlatform.appFileName);
//	        }
				
//	        try {
//	            FileUtils.cleanDirectory(new File(userDir));
//	        } catch (IOException e) {
//	            // TODO Auto-generated catch block
//	            e.printStackTrace();
//	        }

	    }

	public List<String> getMetaData() {
		ArrayList<String> metaData = new ArrayList<String>();
		metaData.add("-skip");
		if (!TargetPlatform.runOnAmazon) {
			metaData.add("-AwsDeviceFarm");
		}
		metaData.add("+both");
		metaData.add("+" + TargetPlatform.platformName);
		if (TargetPlatform.platformName.toLowerCase().equals("ios")) {
			metaData.add("-Android");
		} else {
			metaData.add("-iOS");
		}
		return metaData;
	}
	
	
	
    public static void skipScenariosList() {
        
        ArrayList<Scenario> skipScenarios = new ArrayList<Scenario>();
              StoryManager storyManager;
				storyManager = embedder.storyManager();
              List<String> stories =  new StoryFinder().findPaths(
          codeLocationFromClass(StoriesTest.class).getFile(), asList("**/"
            + System.getProperty("storyFilter", "*") + ".story"),
          null);
              for (String storyPath : stories) {
                 Story story = storyManager.storyOfPath(storyPath);
                 if (new MetaFilter("skip").allow(story.getMeta())) {
                        for (Scenario scenario : story.getScenarios()) {
                            // scenario also inherits meta from story
                            Meta inherited = scenario.getMeta().inheritFrom(story.getMeta());
                            if (new MetaFilter("+skip").allow(inherited)) {
                             System.out.println("this is skipped:" + scenario.getTitle()); 
                             skipScenarios.add(scenario);
                                break;
                            }
                        }
                    }
              }
              
              //ASReport.getInstance().skipScenariosList(skipScenarios);
              AspireReport.getInstance().getReportDataManager().addSkippedScenarios(skipScenarios);
} 


}








