package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ElementUtils.CommonElements;

public class SearchResultPage extends CommonElements{

	WebDriver driver;

	public SearchResultPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public String GetActualSearchResult()
	{
		WaitForVisibilitOf(driver, By.xpath("(//*[@class='listingRhs']//span)[1]"));
		return driver.findElement(By.xpath("(//*[@class='listingRhs']//span)[1]")).getText();
	}


	public void WaitforPopupAndClickinToit()
	{
		WaitForClickable(driver, By.xpath("//*[@class='fareLockInfoContainer']//button"));
		driver.findElement(By.xpath("//*[@class='fareLockInfoContainer']//button")).click();
	}

}
