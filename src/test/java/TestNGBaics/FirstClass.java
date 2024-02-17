package TestNGBaics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstClass {



	@Test(priority=0,invocationCount=4,invocationTimeOut=60,dependsOnMethods="Testcase1")
	public void Testcase2()
	{
		System.out.println("Testcase2");
	}

	@Test(priority=1,timeOut=60)
	public void Testcase3()
	{
		System.out.println("Testcase3");
	}

	@Test(priority=2,timeOut=60)
	public void Testcase4() throws InterruptedException
	{
		System.out.println("Testcase4");
		Thread.sleep(5000);
	}

	@Test(priority=3,enabled=true,description="ValidLogin")
	public void Testcase1()
	{
		System.out.println("Testcase1");
		throw new ArithmeticException("Error");
	}

	@Test(priority=4,enabled=true,description="ValidLogin")
	public void Testcase5()
	{
		System.out.println("Testcase5");
	}

	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method");
	}

	@AfterMethod
	public void afterMethod()
	{
		System.out.println("after Method");
	}

	@BeforeClass
	public void Beforeclass()
	{
		System.out.println("Before Class");
	}

	@AfterClass
	public void Afterclass()
	{
		System.out.println("After Class");
	}


	@BeforeTest(alwaysRun=true)
	public void BeforeTest()
	{
		System.out.println("Before Test");
	}

	@AfterTest(alwaysRun=true)
	public void AfterTest()
	{
		System.out.println("After Test");
	}

	@BeforeSuite(alwaysRun=true)
	public void BeforeSuite()
	{
		System.out.println("Before Suite");
	}

	@AfterSuite(alwaysRun=true)
	public void Aftersuite()
	{
		System.out.println("After Suite");
	}
}
