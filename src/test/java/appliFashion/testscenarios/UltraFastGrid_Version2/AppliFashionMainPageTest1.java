package appliFashion.testscenarios.UltraFastGrid_Version2;

import appliFashion.business.AppliClient;

public class AppliFashionMainPageTest1 {

	public static void main(String[] args) throws Exception {
		
		AppliClient client = new AppliClient(args);
		// TODO Auto-generated method stub
		client.ultrarunner.setBeforeTestSuite("CHROME", 1200, 800);
		client.pgAppliFashion.setFullPageScreenshot(true);
		client.ultrarunner.SetApiKey();
		client.ultrarunner.SetAppName("AppliFashion");
		client.ultrarunner.SetBatchName("Holiday Shopping");
		client.ultrarunner.setConfigValues();
		client.ultrarunner.getConfigValues();
		client.ultrarunner.setTestName("Test 1");
		client.ultrarunner.OpenEyes();
		
		//Test1 Starts from here
		client.pgAppliFashion.LaunchApplication("Dev_App_Version");
		client.pgAppliFashion.checkWindows("Validation of Entire Main Page");
		client.ultrarunner.afterTestSuite();
		client.ultrarunner.afterEachRun();

	}
}
