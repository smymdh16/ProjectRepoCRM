package com.demo1.generic.webdriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
		
	public String toCaptureUrl(WebDriver driver)
	{
		String url=driver.getCurrentUrl();
		return url;
	}
	//Implicit Wait----------------------------------------------------------
		public void toWaitImplicitly(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		}
		
		//Explicit Wait
		public void waitForElementPresent(WebDriver driver,WebElement ele)
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(12));
			wait.until(ExpectedConditions.visibilityOf(ele));
		}
	
		//Handling frames-------------------------------------------------
		public void switchToFrame(WebDriver driver,int index)
		{
			driver.switchTo().frame(index);
			
		}
		
		public void switchToFrame(WebDriver driver,String name)
		{
			driver.switchTo().frame(name);
		}


		public void switchToFrame(WebDriver driver,WebElement ele)
		{
			driver.switchTo().frame(ele);
		}
		
		//Switching between the windows---------------------------------
		//By url
		public void toSwitchToWindowByUrl(WebDriver driver,String Partialurl)
		{
			Set<String> set=driver.getWindowHandles();
			Iterator<String> it=set.iterator();
			while(it.hasNext())
			{ String id=it.next();
				driver.switchTo().window(id);
				String aurl=driver.getCurrentUrl();
				if(aurl.contains(Partialurl))
				{
					break;
				}
				
			}
		}
		//By Title
		public void toSwitchToWindowByTitle(WebDriver driver,String PartialTitle)
		{
			Set<String> set=driver.getWindowHandles();
			Iterator<String> it=set.iterator();
			while(it.hasNext())
			{ String id=it.next();
				driver.switchTo().window(id);
				String atitle=driver.getTitle();
				if(atitle.contains(PartialTitle))
				{
					break;
				}
				
			}
		}
		
		//Handling Alert-------------------------
		public void switchToAlertToAccept(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		public void switchToAlertToDismiss(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		public void switchToAlertToGettext(WebDriver driver)
		{
			String text=driver.switchTo().alert().getText();
			System.out.println(text);
		}
		public void switchToAlertToSendkeys(WebDriver driver,String text)
		{
			driver.switchTo().alert().sendKeys(text);
		}
		
		//Handling Dropdowns----------------------------------------
		public void selectByValueDropdown(WebElement ele,String text)
		{
			Select s=new Select(ele);
			s.selectByValue(text);
			
		}
		public void selectByVisibleText(WebElement ele,String text)
		{
			Select s=new Select(ele);
			s.selectByVisibleText(text);
		}
		public void selectByIndex(WebElement ele,int index)
		{
			Select s=new Select(ele);
			s.selectByIndex(index);
		}
		
		//Handling mouse actions
		public void moveToElement(WebDriver driver,WebElement ele)
		{
			Actions act=new Actions(driver);
			act.moveToElement(ele).perform();
		}
		
		public void doubleClick(WebDriver driver,WebElement ele)
		{
			Actions act=new Actions(driver);
			act.doubleClick(ele).perform();
			
		}
		
		public void dragAndDrop(WebDriver driver,WebElement src,WebElement target)
		{
			Actions act=new Actions(driver);
			act.dragAndDrop(src, target).perform();
			
		}
		public void ToRightClick(WebDriver driver,WebElement ele)
		{
			Actions act=new Actions(driver);
			act.contextClick(ele).perform();
			
		}
		
		
		//To Maximize the Browser --------------------------------------------------
		public void toMaximize(WebDriver driver)
		{
			driver.manage().window().maximize();
		}
		
		
		//To Take screenshot of entire webpage---------------------------------------
		public void toCaptureScreenshot(WebDriver driver,int n) throws IOException
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File temp=ts.getScreenshotAs(OutputType.FILE);
			String path="./Screenshots/error_"+n+".png";
			File src=new File(path);
			FileHandler.copy(temp, src);
		}
		
		public void toCaptureWebElementScreenshot(WebDriver driver,int n,WebElement ele) throws IOException
		{
			
			File temp=ele.getScreenshotAs(OutputType.FILE);
			String path="./Screenshots/error_"+n+".png";
			File src=new File(path);
			FileHandler.copy(temp, src);
		}
		
		public void toScrollToElement(WebDriver driver,WebElement ele)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true)",ele);
		}
		
		
		public void toScrollToBottom(WebDriver driver,WebElement ele)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			
		}
}
