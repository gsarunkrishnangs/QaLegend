package com.qalegend.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.qalegend.constants.Constants;
import com.qalegend.utilities.WaitUtility;

public class BaseFile {

	protected WebDriver driver;
	public Properties prop;
	public FileInputStream fs;

	public void initializeBrowser(String browser) throws Exception {
		
		try {
			prop = new Properties();
			fs = new FileInputStream(Constants.CONFIGFILE);
			prop.load(fs);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("Edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new RuntimeException("Invalid browser request recieved");
		}
		
		 driver.get(prop.getProperty("url"));
         driver.manage().window().maximize();
		
	}
	
		
		@BeforeMethod(alwaysRun = true)
		@Parameters({"browser","baseurl"})

        public void setup(String browser_name, String url) throws Exception {
			
		initializeBrowser(browser_name);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
	}

	@AfterMethod(alwaysRun = true)

	public void closeBrowser(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			takeScreenShot(result);
		}

		driver.quit();
	}

	public void takeScreenShot(ITestResult result) throws IOException { // ITestResult = TestNG listener

		TakesScreenshot takescreenshot = (TakesScreenshot) driver; // TakesScreenshot = Interface

		File screenshot = takescreenshot.getScreenshotAs(OutputType.FILE); // getScreenshotAs = Method used for taking
																			// screenshot
		FileUtils.copyFile(screenshot, new File("./ScreenShot/" + result.getName() + ".png"));

	}

}
