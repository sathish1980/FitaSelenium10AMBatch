package testing.FitaSelenium10AMBatch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {
	WebDriver driver;
	public void framesimplementation()
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/frame.xhtml");
		//driver.findElement(By.xpath("//*[contains(@style,'#ff7295') and @id='Click' ]")).click();
		List<WebElement> allFrames =driver.findElements(By.tagName("iframe"));

		for(int i=0;i<allFrames.size();i++)
		{
			driver.switchTo().frame(i);
			List<WebElement> exlementexist = driver.findElements(By.xpath("//*[contains(@style,'#ff7295') and @id='Click' ]"));
			if(exlementexist.size()>0)
			{
				driver.findElement(By.xpath("//*[contains(@style,'#ff7295') and @id='Click' ]")).click();
			}
			driver.switchTo().defaultContent();
		}
	}

	public void multframesimplementation()
	{

		//driver.get("https://leafground.com/frame.xhtml");
		//driver.findElement(By.xpath("//*[contains(@style,'#ff7295') and @id='Click' ]")).click();
		List<WebElement> allFrames =driver.findElements(By.tagName("iframe"));

		for(int i=0;i<allFrames.size();i++)
		{
			driver.switchTo().frame(i);
			List<WebElement> innerFrames =driver.findElements(By.tagName("iframe"));
			if(innerFrames.size()>0)
			{
				driver.switchTo().frame("frame2");
				List<WebElement> exlementexist = driver.findElements(By.xpath("//*[contains(@style,'#4b7ecf') and @id='Click' ]"));
				if(exlementexist.size()>0)
				{
					driver.findElement(By.xpath("//*[contains(@style,'#4b7ecf') and @id='Click' ]")).click();
				}
			}
			driver.switchTo().defaultContent();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frames F = new Frames();
		F.framesimplementation();
		F.multframesimplementation();
	}

}
