package Testcase;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import DriverUtils.Browser;
import ElementUtils.CommonElements;
import Pages.SearchPage;
import Pages.SearchResultPage;


public class MakeMyTripSearch extends Browser{

	String MethodName = null;
	CommonElements cm = new CommonElements();
	public String expectedSameCityError = "From & To airports cannot be the same";
	int count=0;
	@BeforeSuite
	public void BrowserLauch()
	{
		LaunchTheBrowser();
		//driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");

	}

	@BeforeClass
	public void ClickOnADs()
	{
		SearchPage sp = new SearchPage(driver);
		sp.WaitForAdsAndclickIntoIt();
	}

	@BeforeMethod
	public void StartReport(Method method)
	{
		test = report.startTest(method.getName());
		MethodName= method.getName();
	}


	@Test(priority=0,dataProvider="GetSearchTestData",dataProviderClass=DataProviderDetails.class)
	public void SearchFlightWithValidData(String from,String to,String date) throws IOException{
		/*
		 * Select from location
		 * Select to location
		 * Select Date
		 * Get the From and to Location name
		 * Click on search
		 * Get the search result and verify against it
		 */
		//BrowserLauch();
		//ClickOnADs();
		count=count+1;
		SearchPage sp = new SearchPage(driver);
		test.log(LogStatus.INFO, "MakeMyTrip is Launched sucessfully");
		sp.ClickOnFromLocation(from);
		test.log(LogStatus.INFO, "From location is selected as "+from);
		sp.ClickOnToLocation(to);
		test.log(LogStatus.INFO, "To location is selected as "+to);
		sp.SelectDepatureDate(date);
		test.log(LogStatus.INFO, "date is selected as "+date);
		String expectedResult = sp.GetFromandToLocationName();
		sp.ClickOnSearch();
		test.log(LogStatus.INFO, "Search button is clicked");
		SearchResultPage SRP = new SearchResultPage(driver);
		SRP.WaitforPopupAndClickinToit();
		test.log(LogStatus.INFO, "popup is clicked");
		String actualResult =SRP.GetActualSearchResult();
		Assert.assertEquals(expectedResult, actualResult);
		String screenShotPath = sp.screenshot(driver,MethodName+count);
		test.log(LogStatus.INFO, test.addScreenCapture(screenShotPath));
		driver.navigate().back();
		test.log(LogStatus.INFO, "Back button is clicked");

	}

	@Test(priority=1,dataProvider="GetSearchInvalidTestData",dataProviderClass=DataProviderDetails.class)
	public void SearchWithSameCityError(String from,String to,String date) throws IOException{
		//BrowserLauch();
		//ClickOnADs();
		count=count+1;
		SearchPage sp = new SearchPage(driver);

		sp.ClickOnFromLocation(from);
		test.log(LogStatus.INFO, "From location is selected as "+from);
		sp.ClickOnToLocation(to);
		test.log(LogStatus.INFO, "To location is selected as "+to);
		Assert.assertEquals(expectedSameCityError, sp.ActualGetSameCityError());

		String screenShotPath = sp.screenshot(driver,MethodName+count);
		test.log(LogStatus.INFO, test.addScreenCapture(screenShotPath));

	}

	@AfterMethod
	public void WriteIntoReport(ITestResult result)
	{
		if(result.getStatus()==0)
		{
			test.log(LogStatus.FAIL, "Test case is Failed");
		}
		else if(result.getStatus()==1)
		{
			test.log(LogStatus.PASS, "Test case is Passed");
		}
		else
		{
			test.log(LogStatus.SKIP, "Test case is SKIPPED");
		}
	}

	@AfterSuite
	public void TearDown()
	{
		driver.quit();
		saveReport();
	}




}
