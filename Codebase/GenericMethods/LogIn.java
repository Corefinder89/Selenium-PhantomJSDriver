package GenericMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;
import SeleniumBase.SeleniumBaseClass;

public class LogIn extends SeleniumBaseClass
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
   
	@Test
	public void LogIn_Generic() throws InterruptedException
	{
		WebDriver driver = new PhantomJSDriver(CheckDriverConfigurations());
		
        /*
         * 1. Load page for the respective URL
         * 2. Wait for some time to get the respective element
         */
        driver.get(url);
        System.out.println("Event: Entered URL: " +url); 
        s.WaitForElement(30000);
       
        /*
         * 1. Get xpath of the sign in button
         * 2. Clcik on Sign In link
         * 3. Wait for sometime for the required element to load
         */
        driver.findElement(By.xpath("//a[contains(text(),'SIGN IN')]")).click();
        System.out.println("Event: Clicked on Sign IN");
        s.WaitForElement(30000);
        
        /*
         * 1. Get the xpath for username.
         * 2. Enter the required username in the desired field.
         * 3. Wait for sometime for the required element to load.
         */
        driver.findElement(By.name("email")).sendKeys(username);
        System.out.println("Event: Entered username: " +username);
        s.WaitForElement(30000);
        
        /*
         * 1. Get the xpath for password.
         * 2. Enter the required password in the desired field.
         * 3. Wait for sometime for the next element to load.
         */
        driver.findElement(By.name("password")).sendKeys(password);
        System.out.println("Event: Entered password: " +password);
        s.WaitForElement(30000);
        
        /*
         * 1. Get the xpath for the button LOGIN
         * 2. Click on the button LOGIN
         * 3. Wait for sometime for the next element to load.
         */
        driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]")).click();
        System.out.println("Event: Clicked on Login");
        s.WaitForElement(30000);
        
        driver.quit();
	}
}

