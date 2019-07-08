package run;

import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import readers.Config;
import utils.WebDriverFactory;

public class Hooks {
	
	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extentReports;
	private static ExtentTest extentTest;
	
	WebDriverFactory wdf = new WebDriverFactory();
	
	@Before("@GoogleChrome")
	public void setGoogleChromeDriver() throws Exception {
		
		if(extentReports == null) {
			
			extentReports = new ExtentReports();
			htmlReporter = new ExtentHtmlReporter("./src/test/resources/reports/htmlReporter.html");
			extentReports.attachReporter(htmlReporter);
		}
		
		//TODO
		//extentTest = extentReports.createTest();
		
		System.setProperty("webdriver.chrome.driver", Config.getProperty("driver"));
		wdf.setNavegador(new ChromeDriver());
	}
	
	@After
	public void finalizaDrivers() {
		
		wdf.quitDriver();
	}

}
