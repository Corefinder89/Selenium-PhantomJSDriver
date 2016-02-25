package Scenarios;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import SeleniumBase.SeleniumBaseClass;

public class Scenarios extends SeleniumBaseClass
{
	/*
	 * Get required URL from the SeleniumBase class
	 */
	String url = getURLFromConfigFile("url");
	/*
	 * Get required username from the SeleniumBase class
	 */
	String username = getUsernamefromConfigFile("username");
	/*
	 * Get required password from the SeleniumBase class
	 */
	String password = getPasswordfromConfigFile("password");
	/*
	 * Use to call the method WaitForElement() from the Sleep class
	 */
	Sleep s = new Sleep();
   /*
    * Declare instance of phantomjs driver
    */
	WebDriver driver = CheckDriverConfigurations();
	
	/*
	 * Declare SoftAssert to continue process even if assertion fails
	 */
	SoftAssert softAssert = new SoftAssert();
	
	boolean flag;
	
	@BeforeTest
	public void getCurrentPage()
	{
		/*
		 * Put an implicit wait before hitting the URL so that the driver can configure the seetings for the particular driver instance
		 */
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		/*
		 * 1. Get the page for the desired URL.
		 * 2. Wait for sometime for the required element to load.
		 */
		driver.get(url);
        System.out.println("Event 1: Entered URL: " +url); 
        s.WaitForElement(30000);
	}
	
	@Test(priority=1)
	public void SignIn() throws InterruptedException
	{
        /*
         * 1. Get xpath of the sign in button
         * 2. Clcik on Sign In link
         * 3. Wait for sometime for the required element to load
         */
        driver.findElement(By.xpath("//a[contains(text(),'SIGN IN')]")).click();
        System.out.println("Event 2: Clicked on Sign IN");
        s.WaitForElement(3000);
        
        /*
         * 1. Get the xpath for username.
         * 2. Enter the required username in the desired field.
         * 3. Wait for sometime for the required element to load.
         */
        driver.findElement(By.name("email")).sendKeys(username);
        System.out.println("Event 3: Entered username: " +username);
        s.WaitForElement(3000);
        
        /*
         * 1. Get the xpath for password.
         * 2. Enter the required password in the desired field.
         * 3. Wait for sometime for the next element to load.
         */
        driver.findElement(By.name("password")).sendKeys(password);
        System.out.println("Event 4: Entered password: " +password);
        s.WaitForElement(3000);
        
        /*
         * 1. Get the xpath for the button LOGIN
         * 2. Click on the button LOGIN
         * 3. Wait for sometime for the next element to load.
         */
        driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]")).click();
        System.out.println("Event 5: Clicked on Login");
        s.WaitForElement(3000);
        
        /* 
         * 1. Get the following email from the webpage.
         * 2. Store the element into a String variable.
         * 3. Assertion applied to check whether the correct user has logged into the system or not
         * 4. Check assertion by using AssertTrue based on the boolean variable value flag
         */
        String actual_element_signin = "TESTSTAGING3@MAILINATOR.COM";
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'teststaging3@mailinator.com')]"));
        String expected_element_signin = element.getText().toString();
        System.out.println("Event 6: Expected element is: " +expected_element_signin);
        if(expected_element_signin.equals(actual_element_signin))
        	flag = true;
        else
        	flag = false;
        softAssert.assertTrue(flag);
	
        System.out.println("Event 7: Assertion for log in passed");
        s.WaitForElement(30000);
	}
	
	@Test(priority=2)
	public void General_Functions() throws InterruptedException
	{
		/*
		 * 1. Click on Book Room Cleaning
		 * 2. Click on the button Book Room Cleaning
		 * 3. Wait for sometime for the next element to load
		 */
		WebElement scroll = driver.findElement(By.xpath("//div[@class='row wrapper']"));
		scroll.sendKeys(Keys.PAGE_DOWN);
		 System.out.println("Event 8: Scrolled down below the page");
		 s.WaitForElement(3000);
		 WebElement element1 = driver.findElement(By.xpath("//a[contains(text(),'Room cleaning')]"));
		 element1.click();
		 System.out.println("Event 8: Clicked on room cleaning");
		 s.WaitForElement(3000);
		
		/*
		 * 1. Get the following email from the webpage
		 * 2. Store the element into a String variable.
		 * 3. Assertion applied to check whether the correct page has been loaded or not
		 * 4. Check assertion by AssertTrue based on the boolean variable value flag  
		 */
//		WebElement element2 = driver.findElement(By.xpath("//h3[contains(text(),'Your Custom Room Cleaning')]"));
//		String expected_element = element2.getText().toString();
//		System.out.println("Event 9: Expected element when the spot booking page loads: " +expected_element);
	}
	
	@AfterTest
	public void FinishAutomation()
	{
		/*
		 * Exit phantomjs driver execution
		 */
		driver.quit();
	}
}

