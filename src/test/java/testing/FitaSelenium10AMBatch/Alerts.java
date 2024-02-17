package testing.FitaSelenium10AMBatch;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {

	public void alertimpl()
	{
		ChromeOptions c =new ChromeOptions();
		c.addArguments("--disable-notifications");
		c.addArguments("start-maximized");
		WebDriver driver= new ChromeDriver(c);
		//driver.manage().window().maximize();
		driver.get("https://leafground.com/alert.xhtml");
		driver.findElement(By.id("j_idt88:j_idt91")).click();
		driver.switchTo().alert().accept();
		String alerttext = driver.findElement(By.id("simple_result")).getText();
		System.out.println(alerttext);
		driver.findElement(By.id("j_idt88:j_idt104")).click();
		Alert a = driver.switchTo().alert();
		a.sendKeys("FITA");
		String t =a.getText();
		System.out.println(t);
		a.accept();
		String alerttexts = driver.findElement(By.id("confirm_result")).getText();
		System.out.println(alerttexts);
		driver.findElement(By.id("j_idt88:j_idt93")).click();
		driver.switchTo().alert().dismiss();
		String dis = driver.findElement(By.id("result")).getText();
		System.out.println(dis);
		driver.findElement(By.id("j_idt88:j_idt95")).click();

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("j_idt88:j_idt96")));

		driver.findElement(By.xpath("//*[@id='j_idt88:j_idt96']//a")).click();

		driver.get("https://www.spicejet.com/");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alerts A = new Alerts();
		A.alertimpl();
	}

}
