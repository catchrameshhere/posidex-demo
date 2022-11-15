package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Common {
	
	private WebDriver driver;
	
	public void setupBrowser(String browser, String url) {
		//getting the system property
		String currDir = System.getProperty("user.dir");//current project directory
		String fs = System.getProperty("file.separator");//OS file separator 

		//open chrome browser
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", currDir + fs + "drivers" + fs + "chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		//open firefox browser
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", currDir + fs + "drivers" + fs + "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		//open edge browser
		else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", currDir + fs + "drivers" + fs + "msedgedriver.exe");
			driver = new EdgeDriver();
		}
		//handling the browser error for invalid input
		else {
			System.out.println("Valid browser was not provided, hence quitting the automation run");
			System.exit(0);
		}


		//open url
		if(url !="")
			driver.get(url);
		else
			driver.get("about:blank");
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public void closeTab() {
		driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
}





