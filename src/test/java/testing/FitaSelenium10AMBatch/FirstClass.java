package testing.FitaSelenium10AMBatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {

	public void Launch()
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		//WebDriver driver1= new EdgeDriver();
		/*driver.navigate().to("https://www.gmail.com/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();*/
		WebElement username = driver.findElement(By.id("email"));
		username.sendKeys("sathish");
		username.clear();
		driver.findElement(By.name("pass")).sendKeys("kumar");
		//driver.findElement(By.name("login")).click();
		//driver.findElement(By.linkText("Forgotten password?")).click();
		driver.findElement(By.partialLinkText("pass")).click();

		//driver.findElement(By.className("inputtext _55r1 _6luy _9npi"));
		//driver.manage().window().minimize();
		// driver.close();
		//driver.quit();



	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstClass F = new FirstClass();
		F.Launch();
	}

}
