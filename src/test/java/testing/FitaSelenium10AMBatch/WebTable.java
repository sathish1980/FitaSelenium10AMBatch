package testing.FitaSelenium10AMBatch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	WebDriver driver;
	public void webtableimplementation(String expectedCountry) throws InterruptedException
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/table.xhtml");
		List<WebElement> allPages = driver.findElements(By.xpath("//*[@class='ui-paginator-pages']//a"));
		for(int j=1;j<=allPages.size();j++)
		{
			driver.findElement(By.xpath("//*[@class='ui-paginator-pages']//a["+j+"]")).click();
			Thread.sleep(2000);

			List<WebElement> allRows = driver.findElements(By.xpath("//tbody[@id='form:j_idt89_data']//tr"));
			for(int i=1;i<=allRows.size();i++)
			{
				String eachCountry = driver.findElement(By.xpath("//tbody[@id='form:j_idt89_data']//tr["+i+"]//td[2]//span[3]")).getText();
				if(expectedCountry.equalsIgnoreCase(eachCountry))
				{
					String NAme = driver.findElement(By.xpath("//tbody[@id='form:j_idt89_data']//tr["+i+"]//td[1]")).getText();
					System.out.println(NAme);
				}
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebTable W = new WebTable();
		W.webtableimplementation("Italy");
	}

}
