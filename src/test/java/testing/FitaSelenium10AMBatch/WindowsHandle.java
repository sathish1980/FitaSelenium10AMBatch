package testing.FitaSelenium10AMBatch;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowsHandle {

	WebDriver driver;
	public void windowsimplementation()
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/window.xhtml");
		String parentWindow= driver.getWindowHandle();
		driver.findElement(By.id("j_idt88:new")).click();
		Set<String> allWindows = driver.getWindowHandles();
		for(String eachWidow : allWindows )
		{
			if(!eachWidow.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(eachWidow);
				List<WebElement> elementExist = driver.findElements(By.id("menuform:j_idt40"));
				if(elementExist.size()>0)
				{
					WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
					wait.until(ExpectedConditions.elementToBeClickable(By.id("menuform:j_idt40")));

					driver.findElement(By.id("menuform:j_idt40")).click();
					wait.until(ExpectedConditions.elementToBeClickable(By.id("menuform:m_input")));

					driver.findElement(By.id("menuform:m_input")).click();
					driver.findElement(By.id("j_idt88:name")).sendKeys("sathish");
					driver.quit();
				}
				driver.switchTo().window(parentWindow);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WindowsHandle W = new WindowsHandle();
		W.windowsimplementation();
	}

}
