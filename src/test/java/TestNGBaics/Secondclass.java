package TestNGBaics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Secondclass {



	@Test(priority=0,groups="Sanity")
	public void Testcase2()
	{
		System.out.println(" second class Testcase2");
	}

	@Test(priority=1,groups="SIT")
	public void Testcase3()
	{
		System.out.println(" second class Testcase3");
	}

	@Test(priority=2,groups={"Sanity","SIT"})
	public void Testcase1()
	{
		System.out.println(" Second class Testcase1");
	}


	@BeforeClass(alwaysRun=true)
	public void Beforeclass()
	{
		System.out.println("second class in Before Class");
	}

	@AfterClass(alwaysRun=true)
	public void Afterclass()
	{
		System.out.println("Second class in After Class");
	}

}
