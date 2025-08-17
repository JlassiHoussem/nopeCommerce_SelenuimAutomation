package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


 

public class TestBase2 {

	  public static String BaseURL = "http://demo.nopcommerce.com/";

	    protected ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	    @BeforeMethod
	    @Parameters(value = {"browser"})
	    public void setUp(@Optional("edge") String browser) throws MalformedURLException {
	        RemoteWebDriver remoteDriver;

	        if (browser.equalsIgnoreCase("chrome")) {
	            ChromeOptions options = new ChromeOptions();
	            options.setCapability("se:screenResolution", "1920x1080");
	            remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444/"), options);
	        } else if (browser.equalsIgnoreCase("edge")) {
	            EdgeOptions options = new EdgeOptions();
	            options.setCapability("se:screenResolution", "1920x1080");
	            remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444/"), options);
	        } else {
	            throw new IllegalArgumentException("Browser not supported: " + browser);
	        }

	        driver.set(remoteDriver);
	        getDriver().navigate().to(BaseURL);
	        getDriver().manage().window().maximize();
	    }

	    public WebDriver getDriver() {
	        return driver.get();
	    }

	    @AfterMethod
	    public void stopDriver() {
	        if (getDriver() != null) {
	           // getDriver().quit();
	            //driver.remove();
	        }
	    }
	}


/*
public class TestBase2 {

	public static String BaseURL= "http://demo.nopcommerce.com/";
	
	//for open multi webDriver
	protected ThreadLocal<RemoteWebDriver> driver= null;
	
	@BeforeClass
	@Parameters(value= {"browser"})
	public void setUp(@Optional("edge") String browser) throws MalformedURLException {
		driver = new ThreadLocal<>();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", browser);
		driver.set(new RemoteWebDriver(new URL("http://172.31.64.1:4444/wd/hub"
				+ ""),caps));
		getDriver().navigate().to(BaseURL);
	}
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	@AfterClass
	public void stopDriver() {
		getDriver().quit();
		driver.remove();
	}
	
	 
	
}
*/
