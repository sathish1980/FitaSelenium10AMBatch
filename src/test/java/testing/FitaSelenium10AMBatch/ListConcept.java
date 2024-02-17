package testing.FitaSelenium10AMBatch;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListConcept {

	WebDriver driver;

	public void listimp(String[] expectedCountrys) throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/select.xhtml;");
		for (String expectedCountry :expectedCountrys)
		{
			driver.findElement(By.xpath("//*[@id='j_idt87:country']//div[starts-with(@class,'ui-selectonemenu-trigger')]")).click();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j_idt87:country_items']//following-sibling::li[last()]")));

			List<WebElement> allCountry =driver.findElements(By.xpath("//*[@id='j_idt87:country_items']//following-sibling::li"));
			System.out.println(allCountry.size());
			for (WebElement eachcounty : allCountry)
			{
				//String actualCountry = eachcounty.getText();
				String actualCountry = eachcounty.getAttribute("data-label");

				System.out.println(actualCountry);
				if(expectedCountry.equalsIgnoreCase(actualCountry))
				{
					eachcounty.click();
					Thread.sleep(1000);
					break;
				}
			}
		}
	}

	public void VV()
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/select.xhtml;");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		System.out.println(driver.findElement(By.id("j_idt87:country")).getCssValue("background"));
		//#f8f9fa
	}

	// validation
	//isSelected()
	//isDisplayed()
	//isEnabled()

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ListConcept L = new ListConcept();
		//String[] coun = {"USA","India"};
		//L.listimp(coun);
		L.VV();
	}

}
