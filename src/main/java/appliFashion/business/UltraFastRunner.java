package appliFashion.business;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResultContainer;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.TestResultsStatus;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.config.Configuration;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.model.ChromeEmulationInfo;
import com.applitools.eyes.visualgrid.model.DesktopBrowserInfo;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.IosDeviceInfo;
import com.applitools.eyes.visualgrid.model.IosDeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;

public class UltraFastRunner {
	
	private AppliClient client;
	public String desktopBaseline = "desktop baseline";
	private EyesRunner runner;
	public static TestResults result;
	public static WebDriver webdriver;
	public Configuration testConfig;
	String myEyesServer = "http://eyesapi.applitools.com/";
	SetupEyes setEyes = new SetupEyes(client);
	Configuration suiteConfig = (Configuration) new Configuration();
	
	
	public UltraFastRunner(AppliClient appliClient) {
		// TODO Auto-generated constructor stub
		this.client = appliClient;
	}


	public void setBeforeTestSuite(String sBrowserType, int viewPortWidth, int viewPortHeight) {
		
		System.out.println("<----------Starting up with Applitools UltraFast Grid Runner---------->");
		
		runner = new VisualGridRunner();
		
		switch (sBrowserType) {
		
		case "CHROME":
				suiteConfig.addBrowser(new DesktopBrowserInfo(viewPortWidth, viewPortHeight, BrowserType.CHROME, desktopBaseline));
				suiteConfig.setViewportSize(new RectangleSize(viewPortWidth, viewPortHeight));
			break;
			
		case "CHROME_ONE_VERSION_BACK":
			suiteConfig.addBrowser(new DesktopBrowserInfo(viewPortWidth, viewPortHeight, BrowserType.CHROME_ONE_VERSION_BACK, desktopBaseline));
			suiteConfig.setViewportSize(new RectangleSize(viewPortWidth, viewPortHeight));
			
		case "CHROME_TWO_VERSIONS_BACK":
			suiteConfig.addBrowser(new DesktopBrowserInfo(viewPortWidth, viewPortHeight, BrowserType.CHROME_TWO_VERSIONS_BACK, desktopBaseline));
			suiteConfig.setViewportSize(new RectangleSize(viewPortWidth, viewPortHeight));
			
		case "FIREFOX":
			suiteConfig.addBrowser(new DesktopBrowserInfo(viewPortWidth, viewPortHeight, BrowserType.FIREFOX, desktopBaseline));
			suiteConfig.setViewportSize(new RectangleSize(viewPortWidth, viewPortHeight));
			break;
		
		case "SAFARI":
			suiteConfig.addBrowser(new DesktopBrowserInfo(viewPortWidth, viewPortHeight, BrowserType.SAFARI, desktopBaseline));
			suiteConfig.setViewportSize(new RectangleSize(viewPortWidth, viewPortHeight));
			
		case "IE_10":
			suiteConfig.addBrowser(new DesktopBrowserInfo(viewPortWidth, viewPortHeight, BrowserType.IE_10, desktopBaseline));
			suiteConfig.setViewportSize(new RectangleSize(viewPortWidth, viewPortHeight));
		
		case "IE_11":
			suiteConfig.addBrowser(new DesktopBrowserInfo(viewPortWidth, viewPortHeight, BrowserType.IE_11, desktopBaseline));
			suiteConfig.setViewportSize(new RectangleSize(viewPortWidth, viewPortHeight));
		
		case "EDGE_CHROMIUM":
			suiteConfig.addBrowser(new DesktopBrowserInfo(viewPortWidth, viewPortHeight, BrowserType.EDGE_CHROMIUM, desktopBaseline));
			suiteConfig.setViewportSize(new RectangleSize(viewPortWidth, viewPortHeight));
			
		case "EDGE_LEGACY":
			suiteConfig.addBrowser(new DesktopBrowserInfo(viewPortWidth, viewPortHeight, BrowserType.EDGE_CHROMIUM, desktopBaseline));
			suiteConfig.setViewportSize(new RectangleSize(viewPortWidth, viewPortHeight));
			
		case "IPHONE X":
			suiteConfig.addBrowser(new ChromeEmulationInfo(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT));
			suiteConfig.setViewportSize(new RectangleSize(viewPortWidth, viewPortHeight));
			break;
		}
		
	}
	
	public void SetApiKey() {
		
		Properties props = System.getProperties();
		try {
			props.load(new FileInputStream(new File(System.getProperty("user.dir")+"/properties/test.properties")));
			System.out.println("Key :"+ System.getProperty("applitools.api.key"));
			suiteConfig.setApiKey(System.getProperty("applitools.api.key"));
			System.out.println("Successfully fetched the ApiKey");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Cannot find the properties file");
		}	
	}
	
	public void getServerURL() {
		suiteConfig.setServerUrl(myEyesServer);
	}
	
	public void SetAppName(String sAppName) {
		suiteConfig.setAppName(sAppName);
	}
	
	public void SetBatchName(String batchName) {
		suiteConfig.setBatch(new BatchInfo(batchName));
	}
	

	public void setConfigValues() {
		SetupEyes.eyes = new Eyes(runner);
		SetupEyes.eyes.setConfiguration(suiteConfig);	
		client.seteyes.setUpWebDriver();
	}
	
	public void getConfigValues() {
		testConfig = SetupEyes.eyes.getConfiguration();
		
	}
	
	public void setTestName(String testName) {
		testConfig.setTestName(testName);
		SetupEyes.eyes.setConfiguration(testConfig);
	}
	
	public void OpenEyes() {
		try {
			webdriver = SetupEyes.eyes.open(client.driver);
			System.out.println("<<<<<<<Successfully opened up the eyes>>>>>>>");
		}catch(Exception e) {
			System.out.println("Connot open the eyes");
			e.printStackTrace();
		}
	}
	
	
	public void afterEachRun() {

	try {
		SetupEyes.eyes.closeAsync();
		System.out.println("<<<<<<<Closing up the Webdriver>>>>>>>");
		webdriver.quit();
		}catch(Exception e) {
		SetupEyes.eyes.abortAsync();
		System.out.println("Not able to close the eyes. Hence aborting the process");
	  }
   }
	
	public void afterTestSuite() {
		
		TestResultsSummary allTestResults = runner.getAllTestResults(false);
		for (TestResultContainer results : allTestResults) {
			PageAppliFashion.handleTestResults(results);
		}
	}
}