package run;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import readers.Config;
import utils.Screenshot;
import utils.WebDriverFactory;

public class Hooks {
	
	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extentReports;
	private static ExtentTest extentTest;
	
	WebDriverFactory wdf = new WebDriverFactory();
	
	@Before("@GoogleChrome")
	public void setGoogleChromeDriver(Scenario cenario) throws Exception {
		
		if(extentReports == null) {
			
			extentReports = new ExtentReports();
			htmlReporter = new ExtentHtmlReporter(Config.getProperty("reports.dir"));
			htmlReporter.loadXMLConfig(new File(Config.getProperty("reports.config")));
			extentReports.setSystemInfo("User Name: ", System.getProperty("user.name"));
			extentReports.setSystemInfo("Time Zone: ", System.getProperty("user.timezone"));
			extentReports.attachReporter(htmlReporter);
		}
		
		extentTest = extentReports.createTest(cenario.getId());
		
		System.setProperty("webdriver.chrome.driver", Config.getProperty("drivers"));
		wdf.setNavegador(new ChromeDriver());
	}
	
	@After
	public void finalizaDrivers(Scenario cenario) {
		
		if(cenario.isFailed()) {
			
			Screenshot.logPrint("Teste Falhou: ");
			Screenshot.efetuarPrintTela("Erro: ");
			extentTest.log(Status.FAIL, "Cenário: " + "\"" + cenario.getName() + "\"" + " executado com falha!");
		} else {
			
			Screenshot.logPrint("Teste Passou: ");
			Screenshot.efetuarPrintTela("Print: ");
			extentTest.log(Status.PASS, "Cenário: " + "\"" + cenario.getName() + "\"" + " executado com sucesso!");
		}
		
		extentReports.flush();
		
		wdf.quitDriver();
	}
	
	public static ExtentTest getExtentTest() {
		
		return extentTest;
	}

}
