package testing.FitaSelenium10AMBatch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadiobuttonandCheckbox {

	WebDriver driver;

	public void radiobutton()
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/radio.xhtml");
		String radiobuttonPath = "//*[@id='j_idt87:console1']//td[3]//div[2]";
		driver.findElement(By.xpath(radiobuttonPath)).click();

		String classNAme = driver.findElement(By.xpath(radiobuttonPath)).getAttribute("class");
		System.out.println(classNAme);
		if(classNAme.contains("state-active"))
		{
			System.out.println("Radio button is clicked");
		}
	}

	public void radiobuttons(String actualbrowsername) throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/radio.xhtml");
		String radiobuttonPath = "//*[@id='j_idt87:console1']//td";
		List<WebElement> allbrowserElement = driver.findElements(By.xpath(radiobuttonPath));
		int size = allbrowserElement.size();
		for(int i=1;i<=size;i++)
		{
			String browserNAme = driver.findElement(By.xpath(radiobuttonPath+"["+i+"]//label")).getText();
			if(actualbrowsername.equalsIgnoreCase(browserNAme))
			{
				driver.findElement(By.xpath(radiobuttonPath+"["+i+"]//div[2]")).click();
			}
		}
		String classNAme = driver.findElement(By.xpath(radiobuttonPath)).getAttribute("class");
		System.out.println(classNAme);
		if(classNAme.contains("state-active"))
		{
			System.out.println("Radio button is clicked");
		}
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		RadiobuttonandCheckbox R = new RadiobuttonandCheckbox();
		R.radiobuttons("Safari");
	}

}
