package appliFashion.testscenarios.UltraFastGrid_Version3;

import appliFashion.business.AppliClient;

public class AppliFashionMainPageTest3_CHROME {

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
		client.ultrarunner.setTestName("Test 3");
		client.ultrarunner.OpenEyes();
		
		client.pgAppliFashion.LaunchApplication("Final_Production_App_Version");
		client.pgAppliFashion.getProductDetails();
		client.pgAppliFashion.checkWindows("product details");
		client.ultrarunner.afterTestSuite();
		client.ultrarunner.afterEachRun();

	}
}
