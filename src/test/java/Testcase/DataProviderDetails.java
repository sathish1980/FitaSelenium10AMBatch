package Testcase;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utils.ExcelFileHandling;

public class DataProviderDetails {
	@DataProvider
	public Object[][] GetSearchTestData() throws IOException
	{
		return ExcelFileHandling.ExcelReaddata("MakeMyTrip.xls","SearchWtihValid");
	}

	@DataProvider
	public Object[][] GetSearchInvalidTestData() throws IOException
	{
		return ExcelFileHandling.ExcelReaddata("MakeMyTrip.xls","SearchWtihinValid");
	}
}
