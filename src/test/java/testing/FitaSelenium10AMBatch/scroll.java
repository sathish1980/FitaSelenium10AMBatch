package testing.FitaSelenium10AMBatch;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class scroll {


	WebDriver driver;
	public void scrollimplementation() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://leafground.com/drag.xhtml");
		JavascriptExecutor js= (JavascriptExecutor)driver;
		//vertical scroll down
		js.executeScript("window.scrollBy(0,750)", "");
		Thread.sleep(2000);
		//vertical scroll down
		js.executeScript("window.scrollBy(0,-750)", "");
		Thread.sleep(2000);
		//horizontal scroll right
		js.executeScript("window.scrollBy(750,0)", "");
		Thread.sleep(2000);
		//horizontal scroll left
		js.executeScript("window.scrollBy(-750,0)", "");
		Thread.sleep(2000);

		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		Thread.sleep(2000);

		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)", "");
		Thread.sleep(2000);

		WebElement startbutton=driver.findElement(By.xpath("//*[text()='Start']//parent::button"));
		js.executeScript("arguments[0].scrollIntoView();", startbutton);

	}


	public void toast() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://leafground.com/drag.xhtml");
		driver.findElement(By.id("form:j_idt119")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ui-progressbar-label"),"100%"));
		String toasttxt =driver.findElement(By.className("ui-growl-title")).getText();
		System.out.println(toasttxt);
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		scroll s = new scroll();
		s.toast();
	}

}
