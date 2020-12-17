package appliFashion.business;

import org.openqa.selenium.WebDriver;

import appliFashion.Utility.CustomizedPDFReport;

public class AppliClient {
	
	public SetupEyes seteyes;
	public WebDriver driver;
	public UltraFastRunner ultrarunner;
	public CustomizedPDFReport pdfreport;
	public PageAppliFashion pgAppliFashion;
	
	
	public AppliClient(String[] args) throws Exception{
		
		seteyes = new SetupEyes(this);
		ultrarunner = new UltraFastRunner(this);
		pdfreport = new CustomizedPDFReport(this);
		pgAppliFashion = new PageAppliFashion(this);
	}
}
