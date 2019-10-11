package com.orange.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.orange.utilities.ExcelReader;



public class TestBase 
{
	public static WebDriver driver; 
	public static Properties config=new Properties();
	public static Properties OR=new Properties();
	public static FileInputStream fis;
	public static Logger log=Logger.getLogger("devpinoyLogger");
	//public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Excel\\Myexcel.xlsx");

	
	//public static ExcelReader excel=new ExcelReader("himanshu");
	@BeforeSuite
	public void Setup()
{ log.debug("Setup Method started");
if(driver==null)
{

try {
	fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
} catch (FileNotFoundException e) {
	
	e.printStackTrace();
}
try 
{
	config.load(fis);	
} 
catch (IOException e) 
{
	
	e.printStackTrace();
}

if(config.getProperty("browser").equals("firefox"))
{  System.out.println(config.getProperty("browser"));
	System.setProperty(("webdriver.gecko.driver"),System.getProperty("user.dir")+"/src/test/resources/Executable/geckodriver.exe");
	
	driver=new FirefoxDriver();
	log.debug("Firefox initiated");
}

if(config.getProperty("browser").equals("chrome"))
{
	System.setProperty(("webdriver.chrome.driver"),System.getProperty("user.dir")+"/src/test/resources/Executable/chromedriver.exe");
	
	driver=new ChromeDriver();
	log.debug("chrome initiated");
	
}

if(config.getProperty("browser").equals("ie"))
{
	System.setProperty(("webdriver.ie.driver"),System.getProperty("user.dir")+"/src/test/resources/Executable/IEDriverServer.exe");
	driver=new InternetExplorerDriver();
}

driver.get(config.getProperty("url"));
log.debug("URL collected from config property file");
driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);

}	
}

@AfterSuite
	public void TearDown()
{
	log.debug("Tear down initiated and going to close bye bye");
if(driver!=null){driver.quit();}	
}
}
