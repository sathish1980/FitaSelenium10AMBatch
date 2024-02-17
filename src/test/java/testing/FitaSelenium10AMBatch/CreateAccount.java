package testing.FitaSelenium10AMBatch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateAccount {
	public void createAcc() throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(By.linkText("Create new account")).click();
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
		Thread.sleep(6000);
		driver.findElement(By.name("firstname")).sendKeys("sathish");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastname")));

		driver.findElement(By.name("lastname")).sendKeys("sathish");

		driver.findElement(By.xpath("//span[@class='_5k_3']//input[@value='1']")).click();

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		CreateAccount c = new CreateAccount();
		c.createAcc();
	}

}
