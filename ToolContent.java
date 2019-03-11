package com.vishadstool.autoprogram;
import java.net.URL;
import java.sql.Driver;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverCommandExecutor;


import java.lang.Object;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.firefox.FirefoxDriver;
	//comment the above line and uncomment below line to use Chrome
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;
import java.io.IOException;	
	

public class ToolContent extends Exception {
	
//public static void main (String[] args){
	WebDriver driver;
	WiniumDriver driver1;
	DesktopOptions option = new DesktopOptions();
	
	/*
	 * Universal method to accept browser, to be created later/ Once you figure out how to create a pop up window to happen 
	 * before and then in take parameters and transfer them through the code to individual browser methods.   
	 * 
	 */
	public void universalbrowser() {
	
		
	}
	
		/*
		 *	To enable Chrome Browser
		 */
	public void chromeBrowser() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Project\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://google.com");
		
	}
	
	/*
	 *	To enable Firefox Browser
	 */
	public void firefoxBrowser() {
	
		System.setProperty("webdriver.gecko.driver","C:\\Selenium Project\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://google.com");
	}
	
	/*
	 *	To enable IE Browser
	 */
	public void ieBrowser() {
		
		System.setProperty("webdriver.ie.driver","C:\\Selenium Project\\Drivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("https://google.com");
	}
	
	/*
	 *	To enable Windows application
	 */
	public void windowApplication()  {
		
		DesktopOptions option = new DesktopOptions();
		option.setApplicationPath("C:\\Windows\\System32\\calc.exe");
		try {
			WiniumDriver driverWin = new WiniumDriver(new URL("http://localhost:9999"), option);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	/*
	 * Actions 
	 * 
	 */
	public void clickAction(String locator) {
		 
		driver.findElement(By.xpath(locator)).click();
		
		
		
		
	}
	
	public void WaitAction(int waitTime) {
		 
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
		
	}
	
	public void get(String url){
		driver.get(url);
	}
	
	
	public void windowHandler(){
		
		String winHandleBefore = driver.getWindowHandle();
		driver.switchTo().window(winHandleBefore);
		
	}
	
	public void close(){
		driver.close();
		
	}

	public void quit(){
		driver.quit();
	}
	
	//validate text as true or false. 
	public Boolean validateText(String expectedText, String xpath){
		
		String actualText = driver.findElement(By.xpath(xpath)).getText();
		 
		if (actualText.equals(expectedText)){
			return true;
		}else{
			
			return false;
		}
		
	}
	
	
	
	
	
	
}

//}






/*
 * @BeforeTest
public static void setupEnvironment(){
    options = new DesktopOptions(); //Instantiate Winium Desktop Options
    options.setApplicationPath("C:\\Windows\\System32\\calc.exe");
    File driverPath = new File("C:\\Winium\\Winium.Desktop.Driver.exe");
    System.setProperty("webdriver.winium.desktop.driver","C:\\Winium\\Winium.Desktop.Driver.exe");
    service = new WiniumDriverService.Builder().usingDriverExecutable(driverPath).usingPort(9999).withVerbose(true)
            .withSilent(false).buildDesktopService();
    try {
        service.start();
    } catch (IOException e) {
        System.out.println("Exception while starting WINIUM service");
        e.printStackTrace();
    }
}

@BeforeMethod
public void startDriver(){
    driver = new WiniumDriver(service,options);
}

@AfterMethod
public void stopDriver(){
    driver.close();
}

@AfterTest
public void tearDown(){
    service.stop();
}
 * 
 * 
 */
	