package appliFashion.testscenarios.UltraFastGrid_Version3;

import appliFashion.business.AppliClient;

public class AppliFashionMainPageTest1_SAFARI {

	public static void main(String[] args) throws Exception {
		
		AppliClient client = new AppliClient(args);
		// TODO Auto-generated method stub
		client.ultrarunner.setBeforeTestSuite("SAFARI", 1200, 800);
		client.pgAppliFashion.setFullPageScreenshot(true);
		client.ultrarunner.SetApiKey();
		client.ultrarunner.SetAppName("AppliFashion");
		client.ultrarunner.SetBatchName("Holiday Shopping");
		client.ultrarunner.setConfigValues();
		client.ultrarunner.getConfigValues();
		client.ultrarunner.setTestName("Test 1");
		client.ultrarunner.OpenEyes();
		
		//Test1 Starts from here
		client.pgAppliFashion.LaunchApplication("Final_Production_App_Version");
		client.pgAppliFashion.checkWindows("Validation of Entire Main Page");
		client.ultrarunner.afterTestSuite();
		client.ultrarunner.afterEachRun();

	}
}
