package testing.FitaSelenium10AMBatch;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

	public void Mouse() throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		Actions mouseac = new Actions(driver);
		mouseac.moveToElement(driver.findElement(By.xpath("//li[@class='vl-flyout-nav__js-tab']//*[text()='Electronics']"))).perform();
		Thread.sleep(2000);
		mouseac.moveToElement(driver.findElement(By.xpath("//*[text()='Computers and tablets']"))).click().perform();
	}

	public void Mousepart2() throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Actions mouseac = new Actions(driver);
		mouseac.moveToElement(driver.findElement(By.id("email"))).sendKeys("sathish").doubleClick().contextClick().perform();
	}

	public void Mousedraganddrop() throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/drag.xhtml");
		Actions mouseac = new Actions(driver);
		mouseac.moveToElement(driver.findElement(By.id("form:drag"))).dragAndDrop(driver.findElement(By.id("form:drag")), driver.findElement(By.id("form:drop_content"))).perform();
	}

	public void Mousedraganddropby() throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/drag.xhtml");
		Actions mouseac = new Actions(driver);

		mouseac.moveToElement(driver.findElement(By.xpath("(//*[@id='form:j_idt125']//span)[1]"))).dragAndDropBy(driver.findElement(By.xpath("(//*[@id='form:j_idt125']//span)[1]")),-50,0).perform();
		mouseac.moveToElement(driver.findElement(By.xpath("(//*[@id='form:j_idt125']//span)[2]"))).dragAndDropBy(driver.findElement(By.xpath("(//*[@id='form:j_idt125']//span)[2]")),-50,0).perform();

	}

	public void Mousewithkeyboard() throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Actions mouseac = new Actions(driver);
		mouseac.moveToElement(driver.findElement(By.id("email"))).sendKeys("sathish").perform();
		mouseac.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		Thread.sleep(1000);
		mouseac.keyDown(Keys.SHIFT).keyDown(Keys.TAB).keyUp(Keys.SHIFT).keyUp(Keys.TAB).keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).perform();
	}

	public void keyboard() throws InterruptedException, AWTException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Actions mouseac = new Actions(driver);
		mouseac.moveToElement(driver.findElement(By.id("email"))).sendKeys("sathish").doubleClick().contextClick().perform();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		MouseActions M = new MouseActions();
		M.keyboard();
	}

}
