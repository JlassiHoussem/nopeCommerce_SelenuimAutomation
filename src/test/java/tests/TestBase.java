package tests;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
  
public class TestBase {

	public static WebDriver driver;
	
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName) 
	{
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver = new ChromeDriver(); 
		}

		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver = new FirefoxDriver(); 
		}

		else if (browserName.equalsIgnoreCase("ie")) 
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.navigate().to("http://demo.nopcommerce.com/");	
	}
	
	@AfterSuite
	public void stopDriver()
	{
		//driver.quit();
	} 

}

/*
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
  
public class TestBase {

	public static WebDriver driver;
	
	
	@BeforeSuite
	@Parameters(("browser"))
	public void startDriver(@Optional("firefox")String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", 
		    System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver= new ChromeDriver(); 
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", 
			System.getProperty("user.dir")+"/drivers/geckodriver.exe");	
			driver= new FirefoxDriver();
		}
		
		else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", 
			System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");	
			driver= new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	    driver.navigate().to("https://demo.nopcommerce.com/software");
	  
	}
	
	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
	} 
}
	
/*
 * // TODO Auto-generated method stub
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--incognito");
				//Elimine le captcha
				chromeOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36");

		 		chromeOptions.addArguments("--disable-search-engine-choice-screen");
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestBase {

    public static WebDriver driver;

    public static void initialize() {
        // Setup ChromeDriver with WebDriverManager
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // Pretend to be a normal Chrome browser
        options.addArguments("start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");

        // Realistic User-Agent (change version occasionally)
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) " +
                "Chrome/122.0.0.0 Safari/537.36");

        // Disable automation detection
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        driver = new ChromeDriver(options);

        // Remove "navigator.webdriver" from JS
        ((org.openqa.selenium.JavascriptExecutor) driver)
        .executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");

        driver.get("https://demo.nopcommerce.com/software");
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
*/




/*
 *
package tests;

import java.util.concurrent.TimeUnit;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
  
public class TestBase {

	public static WebDriver driver;
	
	
	@BeforeSuite
	public void startDriver() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		
		// TODO Auto-generated method stub
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--incognito");
				//Elimine le captcha
				chromeOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36");

		 		chromeOptions.addArguments("--disable-search-engine-choice-screen");
		
	    driver= new ChromeDriver();  
	    driver.manage().window().maximize();


	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	    driver.navigate().to("https://demo.nopcommerce.com/software"); 
	}
	
	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
	} 
	
	
	
	
}*/
