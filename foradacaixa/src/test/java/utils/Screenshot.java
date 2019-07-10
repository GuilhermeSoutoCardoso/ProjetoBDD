package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import run.Hooks;

public class Screenshot {
	
	public static void logPrint(String log) {
		
		ExtentTest extentTest = Hooks.getExtentTest();
		try {
			
			efetuarPrintTela(log);
			extentTest.log(Status.INFO, log, MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	private static void efetuarPrintTela(String log) {
		
		WebDriverFactory wdf = new WebDriverFactory();
		
		File file = ((TakesScreenshot) wdf.getWebDriver()).getScreenshotAs(OutputType.FILE);
		try {
			
			FileUtils.copyFile(file, new File("./src/test/resources/reports/print.jpeg"));
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
