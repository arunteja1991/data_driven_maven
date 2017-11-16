package base;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import commonutilties.ExcelRead;

public class BaseTest {
	
	protected static WebDriver driver;
	public Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelRead excel = new ExcelRead("C:\\Users\\teja\\Downloads\\Video\\SELENIUM_CLASSES\\test.xlsx");
	public static Properties config = new Properties();
	public static Properties OR  = new Properties();
	public static FileInputStream fis;
	
	
	
	@BeforeSuite
	public void setup() throws IOException{
		PropertyConfigurator.configure("C:\\Users\\teja\\workspace\\DataDrivenFramework\\src\\test\\resources\\log4j.properties");
	
		
			fis = new FileInputStream("C:\\Users\\teja\\workspace\\DataDrivenFramework\\src\\test\\resources\\properties\\Config.properties");
			config.load(fis);
			log.debug("Config properties are loaded");
			fis = new FileInputStream("C:\\Users\\teja\\workspace\\DataDrivenFramework\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fis);
			log.debug("Or properties are loaded");
		
		if(config.getProperty("browser").equals("firefox")){
			driver = new FirefoxDriver();
			 log.debug("Firefox opened");
		}else if (config.getProperty("browser").equals("chrome")){
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\teja\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
			log.debug("chrome opened");
		}
		
		driver.get(config.getProperty("url"));
		log.debug("url opened");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.debug("time is waiting");
		}
		
	
	@AfterSuite
	public void TeaDown(){
		driver.quit();
		log.debug("BROWSER CLOSED");
}
}