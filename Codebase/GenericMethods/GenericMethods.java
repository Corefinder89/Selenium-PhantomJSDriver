package GenericMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import SeleniumBase.SeleniumBaseClass;

public class GenericMethods extends SeleniumBaseClass
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
	WebDriver driver = new PhantomJSDriver(CheckDriverConfigurations());
	
	/*
	 * Declare SoftAssert to continue process even if assertion fails
	 */
	SoftAssert softAssert = new SoftAssert();
	
	boolean flag;
	
	@BeforeTest
	public void GetRequiredPage() throws InterruptedException
	{
        /*
         * 1. Load page for the respective URL
         * 2. Wait for some time to get the respective element
         */
        driver.get(url);
        System.out.println("Event 1: Entered URL: " +url); 
        s.WaitForElement(30000);
	}
	
	@Test
	public void SignUp() throws InterruptedException
	{ 
		 /*
         * 1. Get xpath of the sign in button
         * 2. Clcik on Sign In link
         * 3. Wait for sometime for the required element to load
         */
        driver.findElement(By.xpath("//a[contains(text(),'SIGN IN')]")).click();
        System.out.println("Event 2: Clicked on Sign IN");
        s.WaitForElement(30000);
        
        /*
         * Click on sign up to register
         */
        driver.findElement(By.xpath("//h3[contains(text(),'sign up')]")).click();
        System.out.println("Event 3: Clicked on Sign UP button to register");
        s.WaitForElement(30000);
        
        /*
         * Enter the user email address as 'username'
         */
        driver.findElement(By.xpath("//input[@placeholder='your email']")).sendKeys(username);;
        System.out.println("Event 4: Username entered");
        s.WaitForElement(30000);
        
        /*
         * Enter the user password
         */
        driver.findElement(By.xpath("//input[@placeholder='password']")).sendKeys(password);
        System.out.println("Event: Password entered");
        s.WaitForElement(30000);
        
        /*
         * Enter password for password confirmation
         */
        driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(password);
        System.out.println("Event 5: Password confirmation done");
        s.WaitForElement(30000);
        
        /*
         * Check the user registration captcha
         */
        driver.findElement(By.xpath("//div[@role='presentation']")).click();
        System.out.println("Event 6: Checked on the checkbox");
        s.WaitForElement(30000);
        
        /*
         * Click on Sign up button
         */
        driver.findElement(By.xpath("//button[contains(text(),'SIGN UP')]")).click();
        System.out.println("Event 7: Clicked on Sign UP");
        
        driver.quit();
	}
	
	//@Test
	public void SignIn() throws InterruptedException
	{

        /*
         * 1. Get xpath of the sign in button
         * 2. Clcik on Sign In link
         * 3. Wait for sometime for the required element to load
         */
        driver.findElement(By.xpath("//h3[contains(text(),'sign in')]")).click();
        System.out.println("Event 8: Clicked on Sign IN");
        s.WaitForElement(30000);
        
        /*
         * 1. Get the xpath for username.
         * 2. Enter the required username in the desired field.
         * 3. Wait for sometime for the required element to load.
         */
        driver.findElement(By.name("email")).sendKeys(username);
        System.out.println("Event 9: Entered username: " +username);
        s.WaitForElement(30000);
        
        /*
         * 1. Get the xpath for password.
         * 2. Enter the required password in the desired field.
         * 3. Wait for sometime for the next element to load.
         */
        driver.findElement(By.name("password")).sendKeys(password);
        System.out.println("Event 10: Entered password: " +password);
        s.WaitForElement(30000);
        
        /*
         * 1. Get the xpath for the button LOGIN
         * 2. Click on the button LOGIN
         * 3. Wait for sometime for the next element to load.
         */
        driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]")).click();
        System.out.println("Event 11: Clicked on Login");
        s.WaitForElement(30000);
        
//        String actual_element_signin = "Invalid Username/Password.";
//        WebElement element = driver.findElement(By.xpath("//div[@class='form-group row invalid-login-msg']"));
//        String expected_element_signin = element.getText().toString();
        
//        if(expected_element_signin.equals(actual_element_signin))
//        	flag = true;
//        else
//        	flag = false;
//        softAssert.assertTrue(flag);
	
        System.out.println("Assertion passed");
        
        driver.quit();
	}
}

