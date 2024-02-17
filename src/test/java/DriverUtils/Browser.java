package DriverUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Browser {

	public WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	public void LaunchTheBrowser()
	{
		ChromeOptions c =new ChromeOptions();
		c.addArguments("--disable-notifications");
		c.addArguments("start-maximized");
		driver= new ChromeDriver(c);
		report = new ExtentReports(System.getProperty("user.dir")+"//Reports//automation.html",true);
	}

	public void saveReport()
	{
		report.flush();
	}

}
