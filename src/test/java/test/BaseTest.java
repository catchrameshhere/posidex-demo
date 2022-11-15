package test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utils.Common;
import utils.ReadFile;

public class BaseTest {
	Common common;
	static WebDriver driver;

	String fileName = "config.properties";
	String url;
	
	@Parameters({"browser"})
	@BeforeTest
	public void setup(String browser) {
		Properties prop = new Properties();
		ReadFile rf = new ReadFile();
		prop = rf.readPropertyFile(fileName);
		url = prop.getProperty("url");
		
		common = new Common();
		common.setupBrowser(browser, url);
		driver = common.getDriver();
	}
	
	
	@AfterTest
	public void tearDown() {
		common.quitBrowser();
	}
}
