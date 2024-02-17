package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ElementUtils.CommonElements;

public class SearchPage extends CommonElements{

	WebDriver driver;

	@FindBy (xpath="//a[@class='close']")
	WebElement closeButton;
	@FindBy (xpath="//*[@for='fromCity']")
	WebElement FromLocation;
	@FindBy(xpath="//*[@for='toCity']")
	WebElement toLocation;
	@FindBy (xpath="//*[@data-cy='flightSW']//p[@data-cy='submit']//a")
	WebElement SearchButton;

	private String fromLoc ="//*[@for='fromCity']";

	// driver.findElement(By.xpath("//a[@class='close']"))

	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void WaitForAdsAndclickIntoIt()
	{
		try
		{
			WaitForFrameandSwitchintTO(driver, "webklipper-publisher-widget-container-notification-frame");
			/*WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("webklipper-publisher-widget-container-notification-frame"));*/

			//driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
			//ClickOnButton(driver.findElement(By.xpath("//a[@class='close']")));
			//.click();
			ClickOnButton(closeButton);

			driver.switchTo().defaultContent();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void ClickOnFromLocation(String FromExpectedCity)
	{

		WaitForClickable(driver, By.xpath(fromLoc));
		/*WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@for='fromCity']")));*/

		//ClickOnButton(driver.findElement(By.xpath("//*[@for='fromCity']")));
		ClickOnButton(FromLocation);

		selectList(FromExpectedCity);

	}

	public void ClickOnToLocation(String ToExpectedCity)
	{
		//ClickOnButton(driver.findElement(By.xpath("//*[@for='toCity']")));
		ClickOnButton(toLocation);

		selectList(ToExpectedCity);

	}


	public void selectList(String ExpectedCity)
	{
		List<WebElement> allCity = driver.findElements(By.xpath("//ul[@role='listbox']//li"));

		for(int i=1;i<allCity.size();i++)
		{
			String actualCity = RetriveTextFromElement(driver.findElement(By.xpath("(//ul[@role='listbox']//li)["+i+"]//*[contains(@class,'pushRight')]")));
			if(ExpectedCity.equalsIgnoreCase(actualCity))
			{
				ClickOnButton(driver.findElement(By.xpath("(//ul[@role='listbox']//li)["+i+"]")));
				break;
			}
		}
	}

	public boolean SelectDepatureDate(String expectedDay)
	{
		List<WebElement> totalWeekRows = driver.findElements(By.xpath("(//*[@class='DayPicker-Months']//div)[1]//div[@class='DayPicker-Week']"));
		for(WebElement eachWeekRow : totalWeekRows)
		{
			List<WebElement> totalDaysInWeek = eachWeekRow.findElements(By.cssSelector("div[class^='DayPicker-Day']"));
			for(WebElement eachDays : totalDaysInWeek)
			{
				String checkItsDisabled = eachDays.getAttribute("class");
				if (!checkItsDisabled.contains("disabled"))
				{
					String eachDayValue =eachDays.findElement(By.cssSelector("[class='dateInnerCell']>p:nth-of-type(1)")).getText();
					if(eachDayValue.equalsIgnoreCase(expectedDay))
					{
						eachDays.click();
						return true;
					}

				}
			}
		}
		return false;
	}

	public String GetFromandToLocationName()
	{
		String fromlocation = RetriveAttributeFromElement(driver.findElement(By.xpath("//*[@for='fromCity']//input")),"value");
		String tolocation = RetriveAttributeFromElement(driver.findElement(By.xpath("//*[@for='toCity']//input")),"value");
		String expectedText = "Flights from "+fromlocation+" to "+tolocation;
		return expectedText;
	}

	public void ClickOnSearch()
	{
		//ClickOnButton(driver.findElement(By.xpath("//*[@data-cy='flightSW']//p[@data-cy='submit']//a")));
		ClickOnButton(SearchButton);

	}

	public String ActualGetSameCityError()
	{
		return RetriveTextFromElement(driver.findElement(By.xpath("//*[@data-cy='sameCityError']")));
	}

}
