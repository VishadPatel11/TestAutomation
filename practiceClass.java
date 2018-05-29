import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.firefox.FirefoxDriver;
	//comment the above line and uncomment below line to use Chrome
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.*;
import java.io.IOException;	
	

public class practiceClass extends Exception {
	
	
	public static void main(String[] args) {
        // declaration and instantiation of objects/variables
		/*
		 * comment the below 2 lines and uncomment following 2 lines to use Chrome
		 * System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
		 * WebDriver driver = new ChromeDriver();
		 */
		System.setProperty("webdriver.chrome.driver","/Users/vishadpatel10990/Desktop/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		
    	/*
    	 * launch Firefox/Chrome and direct it to the Base URL & create a wait for 30 seconds.
    	 */
        String baseUrl = "http://www.facebook.com";
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     
     
        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
    
        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        	
        	if (actualTitle.contentEquals(expectedTitle)){
            	System.out.println("Test Passed!");
        	} else {
            	System.out.println("Test Failed");
        	}
        
      
        
        /*
         * Send input values to email and password fields using ids.
         * 
         */						
        driver.findElement(By.id("email")).sendKeys("vishad");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("email")).clear();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("email")).sendKeys("vishadpatel10990@gmail.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("pass")).sendKeys("Krishna99");
        
        //Click Buttons 
        driver.findElement(By.id("loginbutton")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
       /*
        * Validate login is successful
        */
       WebElement loggedInUser = driver.findElement(By.xpath(".//*[contains(@id,"pagelet_bluebar")]/descendant::*[contains(text(),"Vishad")]"));
         	if(Assert.assertEquals(loggedInUser.getText(),"Vishad")){
        	 System.out.println("Login test passed");
         	}else
         	{
         		System.out.println("Login test failed");
         	}
        
      
        System.exit(0); 
        
        /*
         * close Fire fox/Chrome/IE
         */
        driver.close();
	
	}
}
