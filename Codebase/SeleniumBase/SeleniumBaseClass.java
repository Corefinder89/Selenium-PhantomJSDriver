package SeleniumBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumBaseClass
{
	FileReader instream;
	private PhantomJSDriver driver;
	
	public String getURLFromConfigFile(String variable)
	{
		String value="";
		try
		{
			/*
			 * Get the present user working directory
			 */
			final String dir = System.getProperty("user.dir");
	        System.out.println("Current directory for URL is = " + dir);
	        /*
	         * Absolute path for config.properties file
	         */
			String path="/Users/soumyajit/Documents/Selenium-GhostDriver/Codebase/Configuration/Config.properties";
			/*
			 * instream is an instance of FileReader and will read the contents of the config.properties file
			 */
			instream = new FileReader(path);
			Properties prop = new Properties();
			/*
			 * Load the contents of the file read using the load method of the properties class
			 */
			prop.load(instream);
			/*
			 * The variable value will store the value of the variable that has been passed as
			 * an argument
			 */
			value = prop.getProperty(variable);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not found");
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			System.out.println("I/O Exception");
			e.printStackTrace();
		}
		/*
		 * Return the value of the corresponding variable to the calling program
		 */
		return value;
	}
	
	public String getUsernamefromConfigFile(String variable)
	{
		String value="";
		try
		{
			/*
			 * Get the present user working directory
			 */
			final String dir = System.getProperty("user.dir");
	        System.out.println("Current directory for username is = " + dir);
	        /*
	         * Absolute path for config.properties file
	         */
			String path="/Users/soumyajit/Documents/Selenium-GhostDriver/Codebase/Configuration/Config.properties";
			/*
			 * instream is an instance of FileReader and will read the contents of the config.properties file
			 */
			instream = new FileReader(path);
			Properties prop = new Properties();
			/*
			 * Load the contents of the file read using the load method of the properties class
			 */
			prop.load(instream);
			/*
			 * The variable value will store the value of the variable that has been passed as
			 * an argument
			 */
			value = prop.getProperty(variable);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not found");
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			System.out.println("I/O Exception");
			e.printStackTrace();
		}
		/*
		 * Return the value of the corresponding variable to the calling program
		 */
		return value;
	}
	
	public String getPasswordfromConfigFile(String variable)
	{
		String value="";
		try
		{
			/*
			 * Get the present user working directory
			 */
			final String dir = System.getProperty("user.dir");
	        System.out.println("Current directory for password is = " + dir);
	        /*
	         * Absolute path for config.properties file
	         */
			String path="/Users/soumyajit/Documents/Selenium-GhostDriver/Codebase/Configuration/Config.properties";
			/*
			 * instream is an instance of FileReader and will read the contents of the config.properties file
			 */
			instream = new FileReader(path);
			Properties prop = new Properties();
			/*
			 * Load the contents of the file read using the load method of the properties class
			 */
			prop.load(instream);
			/*
			 * The variable value will store the value of the variable that has been passed as
			 * an argument
			 */
			value = prop.getProperty(variable);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not found");
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			System.out.println("I/O Exception");
			e.printStackTrace();
		}
		/*
		 * Return the value of the corresponding variable to the calling program
		 */
		return value;
	}
	
	public WebDriver CheckDriverConfigurations()
	{
		/*Desired capabilities is used to configure the driver instance of webdriver. All driver instances can be configured using
		 *desired capability class	
		 */
	    Capabilities caps = new DesiredCapabilities();
	    /*
	     * Enable javascript for browser
	     */
	    ((DesiredCapabilities) caps).setJavascriptEnabled(true);
	    /*
	     * Set capability to take screenshot
	     */
		 ((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
		 /*
		  * Set capability for the executable path for phantomjs
		  */
		 ((DesiredCapabilities) caps).setCapability(
		        PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
		        "//Users//soumyajit//Documents//Zippers//phantomjs//bin//phantomjs"
		    );
		 /*
		  * return capability instance to increase reusability of capability
		  */
		 
		 this.driver = new PhantomJSDriver(caps);
		 return driver;	
	}
}