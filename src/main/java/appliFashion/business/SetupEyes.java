package appliFashion.business;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.applitools.eyes.selenium.Eyes;

public class SetupEyes {
	
	public static Eyes eyes;
	private AppliClient client;
	
	
	public SetupEyes(AppliClient appliClient) {
		// TODO Auto-generated constructor stub
		this.client = appliClient;	
	}

	public void setUpWebDriver() {
		
		String path =  System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"/resources/chromedriver.exe");
		client.driver = new ChromeDriver();
		System.out.println("<<<<<<<<<<<Successfully Initialized the ChromeDriver>>>>>>>>>>>");
	}
	
	public void setUpEdgeDriver() {
		String path =  System.getProperty("user.dir");
		System.setProperty("webdriver.edge.driver", path+"/resources/msedgedriver.exe");
		client.driver = new EdgeDriver();
		System.out.println("<<<<<<<<<<<Successfully Initialized the EdgeDriver>>>>>>>>>>>");

	}
	
	public void SetupGeckoDriver() {
		String path =  System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", path+"/resources/geckodriver.exe");
		client.driver = new FirefoxDriver();
		System.out.println("<<<<<<<<<<<Successfully Initialized the geckoDriver>>>>>>>>>>>");
	}
	
}
