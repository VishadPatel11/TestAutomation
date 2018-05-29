import org.openqa.selenium.support.ui.Select;

import java.util.List;
//import org.openqa.selenium.firefox.FirefoxDriver;
	//comment the above line and uncomment below line to use Chrome
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.*;
import java.io.IOException;	
	

public class practiceClass {
	
	
	public static void main(String[] args) {
        // declaration and instantiation of objects/variables
    	System.setProperty("webdriver.chrome.driver","/Users/vishadpatel10990/Desktop/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		//System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
    	
        String baseUrl = "http://www.facebook.com";
        //String expectedTitle = "Welcome: Mercury Tours";
        //String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
       
        			/* 			
       //Send input to fields 
        driver.findElement(By.id("email")).sendKeys("vishad");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("newvishad");
        driver.findElement(By.id("pass")).sendKeys("passwordvishad");
        
        //Click Buttons 
        //driver.findElement(By.id("loginbutton")).click();
        
       //select 1 or more listing from dropdowns //drpMonth.selectByVisibleText(1);
        Select drpMonth = new Select (driver.findElement(By.name("birthday_month"))); 
        drpMonth.selectByVisibleText("Sep");
        
        Select drpDay = new Select (driver.findElement(By.name("birthday_day"))); 
        drpDay.selectByVisibleText("9");
        
        Select drpYear = new Select (driver.findElement(By.name("birthday_year"))); 
        drpYear.selectByVisibleText("1990");
        
        //select something by partial text
         driver.findElement(By.partialLinkText("Forgot account?")).click();
         
         //selecting a image link
         driver.findElement(By.cssSelector("a[title=\"Go to Facebook Home\"]")).click();
         
         //select something within a table
         //driver.findElement(By.xpath(".//descendant::*[contains(text(),\"fourth cell\")]").getText());
        	//or 
         driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText();
        
        			 
        //move mouse over some element 
        WebElement logInLink = driver.findElement(By.xpath("//input[@value=\"Log In\"]"));
         Actions builder = new Actions(driver);
        builder.moveToElement(logInLink).build().perform();

        //perform keyboard Keys for example hitting "Shift"
        WebElement userName = driver.findElement(By.id("email"));
        Actions builderUserName = new Actions(driver);
        builderUserName.moveToElement(userName) //this is to move to the element 
        .click()  //this is to click on the field
        .keyDown(userName, Keys.SHIFT)  //this is to turn on all caps
        .sendKeys(userName, "vishvish")   //this is to actually input the entries
        .keyUp(userName, Keys.SHIFT)   //this is to uncaps on keyboard
        .doubleClick(userName)    //this is to highlight all the text i entered.
        //.contextClick()   //this is to right click on the field on the mouse.
        .build().perform();   //build and perform the actions
        */
        
        //mouse click and hold THEN drag and drop                
        WebElement userName = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("pass"));      
        Actions builderUserName = new Actions(driver);
        builderUserName.moveToElement(userName) //this is to move to the element 
        .click()  //this is to click on the field
        .keyDown(userName, Keys.SHIFT)  //this is to turn on all caps
        .sendKeys(userName, "vishvish")   //this is to actually input the entries
        .keyUp(userName, Keys.SHIFT)   //this is to uncaps on keyboard
        .doubleClick(userName).build().perform();   //this is to highlight all the text i entered.
        //.dragAndDrop(userName, password).build().perform();
        
        
        
        
       //how to upload files 
       WebElement uploadElement= driver.findElement(By.id("uploadfile_0"));
       uploadElement.sendKeys("C:\\newhtml.html");
       
        
        
        
        
        
        
        
        
        System.exit(0); 
        
        

        // get the actual value of the title
        //actualTitle = driver.getTitle();

        
       

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        //if (actualTitle.contentEquals(expectedTitle)){
         //   System.out.println("Test Passed!");
        //} else {
          //  System.out.println("Test Failed");
        //}
       
        //close Fire fox/Chrome/IE
        driver.close();
	
        
        
	}
}
