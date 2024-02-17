package testing.FitaSelenium10AMBatch;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropdown {

	WebDriver driver;

	public void dropdownimp() throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.linkText("Create new account")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));

		Select dayDropdown  = new Select(driver.findElement(By.id("day")));
		dayDropdown.selectByIndex(4);

		Select monthDropdown  = new Select(driver.findElement(By.id("month")));
		monthDropdown.selectByValue("7");

		Select yearDropdown  = new Select(driver.findElement(By.id("year")));
		System.out.println(yearDropdown.isMultiple());
		yearDropdown.selectByVisibleText("2010");

		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		Select multidrop = new Select(driver.findElement(By.xpath("//*[@id='second' and @class='col-lg-3']")));
		if(multidrop.isMultiple())
		{
			multidrop.selectByIndex(2);
			Thread.sleep(1000);
			multidrop.selectByVisibleText("Bonda");
			Thread.sleep(1000);
			multidrop.selectByValue("pizza");
			Thread.sleep(1000);
			multidrop.deselectByValue("bonda");
			Thread.sleep(1000);
			multidrop.deselectAll();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Dropdown d = new Dropdown();
		d.dropdownimp();
	}

}
