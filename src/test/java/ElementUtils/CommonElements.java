package ElementUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonElements {


	public void WaitForClickable(WebDriver driver,By path)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(path));

	}

	public void WaitForVisibilitOf(WebDriver driver,By path)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(path));

	}

	public void WaitForFrameandSwitchintTO(WebDriver driver,String path)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(path));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void ClickOnButton(WebElement buttonElement)
	{
		if(buttonElement.isDisplayed())
			buttonElement.click();
	}

	public void EnterTextinTextBox(WebElement textElement,String TexttobeEnter)
	{
		if(textElement.isDisplayed())
		{
			textElement.clear();
			textElement.sendKeys(TexttobeEnter);
		}
	}

	public String RetriveTextFromElement(WebElement textElement)
	{
		if(textElement.isDisplayed())
		{
			return textElement.getText();
		}
		return null;
	}

	public String RetriveAttributeFromElement(WebElement textElement,String attribute)
	{
		if(textElement.isDisplayed())
		{
			return textElement.getAttribute(attribute);
		}
		return null;
	}

	public String screenshot(WebDriver driver,String filename) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(System.getProperty("user.dir")+"//Screenshot//"+filename+".png");
		FileUtils.copyFile(sourceFile,destinationFile);
		return destinationFile.toString();
	}
}
