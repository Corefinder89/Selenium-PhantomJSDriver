package Scenarios;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import SeleniumBase.SeleniumBaseClass;

public class Screenshots extends SeleniumBaseClass
{
	public void takeScreenshot() throws IOException
	{
		Calendar cal = Calendar.getInstance();
		String ScreenshotPath = "/Users/soumyajit/Documents/Selenium-GhostDriver/Screenshots/";
		WebDriver driver =  CheckDriverConfigurations();
		File screenshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotfile,new File(ScreenshotPath+cal.getTime()+".jpg"),true);
	}
}
