package appliFashion.business;

import org.openqa.selenium.By;

import com.applitools.eyes.TestResultContainer;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.fluent.Target;

public class PageAppliFashion {
	private AppliClient client;
	public static TestResults result;
	By sAppName = By.xpath("xpath=//*[@id='A____8']");
	String sBlackCheckbox = "xpath=//*[@id='colors__Black']";
	String sFilterButton = "xpath=//*[@id='filterBtn']";
	String sFilterRegion = "xpath=//*[@id='product_grid']";
	
	public PageAppliFashion(AppliClient appliClient) {
		// TODO Auto-generated constructor stub
		this.client =appliClient;
	}
	
	public void LaunchApplication(String sAppUrl) throws InterruptedException {
	
	try {
		switch (sAppUrl) {
		case "Initial_Production_App_Version":
			UltraFastRunner.webdriver.get("https://demo.applitools.com/tlcHackathonMasterV1.html");
			Thread.sleep(5000);
			break;
			
		case "Dev_App_Version":
			UltraFastRunner.webdriver.get("https://demo.applitools.com/tlcHackathonDev.html");
			Thread.sleep(5000);
			break;
			
		case "Final_Production_App_Version":
			UltraFastRunner.webdriver.get("https://demo.applitools.com/tlcHackathonMasterV2.html");
			Thread.sleep(5000);
			break;
		}
		
	}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Cannot open the URL");
		}
	}
	
	public void filterElements() throws Exception {
			Thread.sleep(3000);
			UltraFastRunner.webdriver.findElement(By.id("colors__Black")).click();
			UltraFastRunner.webdriver.findElement(By.id("filterBtn")).click();
			SetupEyes.eyes.checkRegion(By.id("product_grid"), "filter by color");
	}
	
	public void getProductDetails() throws Exception{
		
		if((UltraFastRunner.webdriver.findElement(By.id("IMG__imgfluid__215")).isDisplayed())) {
			UltraFastRunner.webdriver.findElement(By.id("IMG__imgfluid__215")).click();			
		}else {
			System.out.println("connot find the product");
		}
	}
	
	
	public static void handleTestResults(TestResultContainer summary) {
		
		UltraFastRunner.result = summary.getTestResults();
		if (UltraFastRunner.result == null) {
			System.out.println("no information available");
		} else {
			System.out.println("<<<<<<<<<<<META INFO OF THE TEST>>>>>>>>>>>>");
			System.out.printf("URL = %s,\n AppName=%s, testname = %s, Browser = %s, OS = %s, viewport = %dx%d, matched = %d, missing = %d, aborted = %s\n",
					UltraFastRunner.result.getUrl(),
					UltraFastRunner.result.getAppName(),
					UltraFastRunner.result.getName(),
					UltraFastRunner.result.getHostApp(),
					UltraFastRunner.result.getHostOS(),
					UltraFastRunner.result.getHostDisplaySize().getWidth(),
					UltraFastRunner.result.getHostDisplaySize().getHeight(),
					UltraFastRunner.result.getMatches(),
					UltraFastRunner.result.getMissing(),
					(UltraFastRunner.result.isAborted()? "aborted": "completed OK"));
		}
	}
	
	
	public void setFullPageScreenshot(boolean value) {
		client.ultrarunner.suiteConfig.setForceFullPageScreenshot(value);
	}
	
	public void checkWindows(String tag) {	
		SetupEyes.eyes.checkWindow(tag);
	}
	
	public void checkAppName() {
		SetupEyes.eyes.checkElement(sAppName);
	}	
}
