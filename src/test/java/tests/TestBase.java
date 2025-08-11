package tests;

import java.util.concurrent.TimeUnit;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
  
public class TestBase {

	public static WebDriver driver;
	
	@BeforeSuite
	public void startDriver() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		
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
	
	
	
	
}
