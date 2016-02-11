package GenericMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

import SeleniumBase.SeleniumBaseClass;

public class LogIn extends SeleniumBaseClass<Object>
{
	String url = getDatafromConfigFile("url");
	String username = getDatafromConfigFile("username");
	String password = getDatafromConfigFile("password");
	Sleep s = new Sleep();
   
	@Test
	public void LogIn_Generic() throws InterruptedException
	{
		WebDriver driver = new PhantomJSDriver(CheckDriverConfigurations());
		
        // Load page for the respective URL
        driver.get(url);
        System.out.println("Event: Entered URL: " +url); 
        s.WaitForElement(30000);
       
        driver.findElement(By.xpath("//a[contains(text(),'SIGN IN')]")).click();
        System.out.println("Event: Clicked on Sign IN");
        s.WaitForElement(30000);
        
        driver.findElement(By.name("email")).sendKeys(username);
        System.out.println("Event: Entered username: " +username);
        s.WaitForElement(30000);
        
        driver.findElement(By.name("password")).sendKeys(password);
        System.out.println("Event: Entered password: " +password);
        s.WaitForElement(30000);
        
        driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]")).click();
        System.out.println("Event: Clicked on Login");
        s.WaitForElement(30000);
        
        driver.quit();
	}
}

