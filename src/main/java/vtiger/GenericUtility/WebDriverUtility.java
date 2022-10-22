package vtiger.GenericUtility;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * this class contains all generic methods related to web driver actions 
 * @author ABHISHEK K
 *
 */
public class WebDriverUtility 
{
	/**
	 * this method is use to maximize the the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) 
	{
		driver.manage().window().maximize();
		
		
	}
	/**
	 * this method is use to wait for 20 seconds to load entire Dom structure
	 * @param driver
	 */
	//DOM:-Document object model
	public void waitForElementsToLoadInDom(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
	}
	/**
	 * this method will wait TO LOAD a particular element
	 * @param driver
	 * @param element
	 */
	public void waitForElementToLoad(WebDriver driver,WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	/**
	 * this method is use to wait until element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	/**
	 * this method will wait for particular element to perform click operation
	 * if the element is not interactive it will wait foe 1 second
	 * @param element
	 * @throws InterruptedException
	 */
	public void customWaitAndClickOnElement(WebElement element) throws InterruptedException 
	{
		int count=0;
		while(count>10)
		{
		 try 
		 {
			element.click();
			break;
			
		 } 
		 catch (Exception e) 
		 {
			Thread.sleep(1000);
			count++;
		 }
		
	    }
	}
	/**
	 * this method will handle drop down by select class using index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index) 
	{
		Select s = new Select(element);
		s.selectByIndex(index);
		
	}
	/**
	 * this method will handle drop down by select class using visible text
	 * @param element
	 * @param visibleText
	 */
	public void handleDropDown(WebElement element,String visibleText) 
	{
		Select s = new Select(element);
		s.selectByVisibleText(visibleText);
		
	}
	/**
	 * this method will handle drop down by select class using value
	 * @param value
	 * @param element
	 */
	public void handleDropDown(String value,WebElement element) 
	{
		Select s = new Select(element);
		s.selectByValue(value);
		
	}
	/**
	 * thia method is going to perform double click anywhere in wegpage
	 * @param driver
	 */
	public void doubleClickOn(WebDriver driver) 
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
		
	}
	/**
	 * this method will perform double click on perticular web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickOn(WebDriver driver,WebElement element) 
	{
	 Actions act = new Actions(driver);
	 act.doubleClick(element).perform();
		
	}
	/**
	 * this method will perform mouse hover action on a perticular element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOn(WebDriver driver,WebElement element) 
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	/**
	 * this method will perform mouse hover action on offset value
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void mouseHoverOn(WebDriver driver,int x,int y) 
	{
		Actions act = new Actions(driver);
		act.moveByOffset(x,y).perform();
	}
	/**
	 * this method will perform right click on the page
	 * @param driver
	 */
	public void rightClickOn(WebDriver driver) 
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * this method will perform right click on particular web element
	 * @param driver
	 * @param element
	 */
	public void rightClickOn(WebDriver driver,WebElement element) 
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
		
	}
	/**
	 * this method will perform drag from src Element and drop to target Element action
	 * @param driver
	 * @param srcElement
	 * @param targetElement
	 */
	public void dragAndDrop(WebDriver driver,WebElement srcElement,WebElement targetElement) 
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, targetElement).perform();
		
	}
	/**
	 * this method will show alert Text and return it to the caller
	 * @param driver
	 * @return
	 */
	public String getTextInAlert(WebDriver driver) 
	{
	String alertText = driver.switchTo().alert().getText();
	return alertText;
		
	}
	/**
	 * this method will accept/click ok on the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) 
	{
		driver.switchTo().alert().accept();
		
	}
	/**
	 * this method will perform dismiss/cancel action on alert popup 
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) 
	{
		driver.switchTo().alert().dismiss();
		
	}
	/**
	 * this method will switch to the window with respect to the window title
	 * @param driver
	 * @param partialTitle
	 */
	public void switchToWindow(WebDriver driver,String partialTitle) 
	{
		//step1:- get all window handles
		Set<String> windowIds = driver.getWindowHandles();
		
		//step2:-iterate tru all window Ids
		Iterator<String> it = windowIds.iterator();
		
		//step3:-navigate inside the windows
		while(it.hasNext())//loop until windowidss exits
		{
			//capture all the window ids
			String winId = it.next();
			
			//switch the window and capture the title
			String currentTitle = driver.switchTo().window(winId).getTitle();
			if (currentTitle.contains(partialTitle)) 
			{
				break;
				
			}
		}
		
	}
	/**
	 * this methos will switch to frame based on index num/value
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index) 
	{
		driver.switchTo().frame(index);
	}
	/**
	 * this method will will switch to frame based on id or name
	 * @param driver
	 * @param idOrName
	 */
	public void switchToFrame(WebDriver driver,String idOrName) 
	{
		driver.switchTo().frame(idOrName);
		
	}
	/**
	 * this method will switch to frame based on element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element) 
	{
		driver.switchTo().frame(element);
		
	}
	/**
	 * this method will  take screenshot and return the destination path 
	 * @param driver
	 * @param screenShotName
	 * @return 
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver,String screenShotName) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		java.io.File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ".\\ScreenShots\\"+screenShotName+".png";
		java.io.File dst = new java.io.File(path);
		FileUtils.copyFile(src, dst);
		//Files.copy(src, dst); both are crt but for above file utils we need to add commons io dependency from mvn repository
		return dst.getAbsolutePath();//uesed for reporting in listners
	}
	/**
	 * this methos is use to scroll based on x and y co-ordinates
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.ScrollBy(0,500)", "");
		
	}
	/** 
	 * this method will scroll into that particular element
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("argument[0].scrollIntoView", element);
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",element );
		
	}
}
