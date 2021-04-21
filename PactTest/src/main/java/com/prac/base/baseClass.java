package com.prac.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import com.prac.utils.excelUtils;
import com.prac.utils.fileUtils;

public class baseClass {
	
	public WebDriver driver;
	public  SoftAssert sAssert = new SoftAssert();
	public static Logger _log = Logger.getLogger(baseClass.class);
	
	public  baseClass() {
		//DOMConfigurator.configure("src\\main\\resources\\log4j.xml");
	}
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		
		MDC.put("testMethodName",  "SetUp");
		MDC.put("testClassName",this.getClass());
		
		createDriver();
		
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(fileUtils.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(fileUtils.getProperty("implcitelyWaitTime")),TimeUnit.SECONDS);
		
	}
	
	
	public void createDriver() throws MalformedURLException {
		
		String browser = fileUtils.getProperty("browser");
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			_log.info("Started chrome driver");
			driver.manage().window().maximize();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			_log.info("Started firefox driver");
			driver.manage().window().maximize();
			break;

		case "remote_firefox":
			DesiredCapabilities capabilities =  DesiredCapabilities.firefox();
			URL url = new URL("http://localhost:4444/wd/hub");
			driver = new RemoteWebDriver(url, capabilities);
			break;
			
		default:
			break;
		}
	}
	
	@AfterClass
	public void quitDriver() {
		driver.quit();
	}
	
	@BeforeMethod
	public void beforeTest(Method testMethod) {

		MDC.put("testMethodName",  testMethod.getName());
		_log.info("******************************Started executing test case"+getClass().getName()+":"+ testMethod.getName()+"********************************");
		
		
		String url = fileUtils.getProperty("url");
		driver.get(url);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	
		_log.info("Entered URL: "+ fileUtils.getProperty("url"));
		
		
	}
	
	@AfterMethod
	public void afterTest(Method testMethod) {
		_log.info("******************************completed executing test case"+getClass().getName()+":"+ testMethod.getName()+"********************************");
	}
	
	@DataProvider (name = "Default")
	public Object[][] getTestData(Method testMethod) throws IOException{
		
		String className = getClass().getName().split("\\.")[getClass().getName().split("\\.").length-1];
		return excelUtils.readTestData(className,testMethod.getName());
		
	}

	
}
