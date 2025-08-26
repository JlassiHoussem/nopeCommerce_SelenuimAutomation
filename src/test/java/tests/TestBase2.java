package tests;

import java.net.MalformedURLException;

import java.net.URL;

import org.junit.BeforeClass;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import data.LoadProperties;

public class TestBase2 {
	
	//Sauce Labs Configuration
	//public static final String USERNAME = LoadProperties.sauceLabsData.getProperty("username");
	//public static final String ACCESS_KEY = LoadProperties.sauceLabsData.getProperty("accesskey");
	//public static final String sauceURL =  "http://"+USERNAME+":"+ACCESS_KEY+LoadProperties.sauceLabsData.getProperty("selenuimURL");


	  public static String BaseURL = "http://demo.nopcommerce.com/";

	    protected ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	    @BeforeMethod
	    @Parameters(value = {"browser"})
	    public void setUp(@Optional("firefox") String browser) throws MalformedURLException {
	        RemoteWebDriver remoteDriver;

	      //Selenuim grid local
	        if (browser.equalsIgnoreCase("chrome")) {
	            ChromeOptions options = new ChromeOptions();
	            options.setCapability("se:screenResolution", "1920x1080");
	            remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
	        } else if (browser.equalsIgnoreCase("edge")) {
	            EdgeOptions options = new EdgeOptions();
	            options.setCapability("se:screenResolution", "1920x1080");
	            remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
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
	            getDriver().quit();
	            driver.remove();
	        }
	    }
	}


/*
public class TestBase2 {

    public static String BaseURL = "http://demo.nopcommerce.com/";

    // Thread-safe driver for parallel runs
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        RemoteWebDriver remoteDriver;

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

        } else {
            throw new IllegalArgumentException("❌ Unsupported browser: " + browser);
        }

        driver.set(remoteDriver);
        getDriver().manage().window().maximize();
        getDriver().navigate().to(BaseURL);

        System.out.println("✅ Started session: " + browser + " on thread " + Thread.currentThread().getId());
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    @AfterClass(alwaysRun = true)
    public void stopDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}

*/

/*
public class TestBase2 {

    // Sauce Labs Configuration
    public static final String USERNAME = LoadProperties.sauceLabsData.getProperty("username");
    public static final String ACCESSKEY = LoadProperties.sauceLabsData.getProperty("accesskey");
    // Example URL: "@ondemand.eu-central-1.saucelabs.com/wd/hub"
    public static final String sauceURL = "https://" + USERNAME + ":" + ACCESSKEY
            + LoadProperties.sauceLabsData.getProperty("selenuimURL");

    public static String BaseURL = "http://demo.nopcommerce.com/";

    // Thread-safe driver for parallel execution
    protected ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        RemoteWebDriver remoteDriver;

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.setCapability("platformName", "Windows 11");
           // options.setCapability("browserVersion", "latest");

            // Sauce Labs options
            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("build", "Regression Build 1");
            sauceOptions.setCapability("name", "Chrome Test");
            options.setCapability("sauce:options", sauceOptions);

            remoteDriver = new RemoteWebDriver(new URL(sauceURL), options);

        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.setCapability("platformName", "Windows 11");
           // options.setCapability("browserVersion", "latest");

            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("build", "Regression Build 1");
            sauceOptions.setCapability("name", "Edge Test");
            options.setCapability("sauce:options", sauceOptions);

            remoteDriver = new RemoteWebDriver(new URL(sauceURL), options);

        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        // Set ThreadLocal driver
        driver.set(remoteDriver);

        // Navigate to AUT
        getDriver().navigate().to(BaseURL);
        getDriver().manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod
    public void stopDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}
*/
/*
public class TestBase2 {

    // Sauce Labs Configuration
    public static final String USERNAME = LoadProperties.sauceLabsData.getProperty("username");
    public static final String ACCESSKEY = LoadProperties.sauceLabsData.getProperty("accesskey");
    // Example: "@ondemand.eu-central-1.saucelabs.com:443/wd/hub"
    public static final String sauceURL = "https://" + USERNAME + ":" + ACCESSKEY
            + LoadProperties.sauceLabsData.getProperty("selenuimURL");

    public static String BaseURL = "http://demo.nopcommerce.com/";

    protected ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        RemoteWebDriver remoteDriver;

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setCapability("platformName", "Windows 11");
            browserOptions.setCapability("browserVersion", "latest");

            // Sauce-specific options
            browserOptions.setCapability("sauce:options", new org.openqa.selenium.MutableCapabilities() {{
                setCapability("build", "Java-Test-Build-1");
                setCapability("name", "My_Chrome_Test");
            }});

            remoteDriver = new RemoteWebDriver(new URL(sauceURL), browserOptions);

        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions browserOptions = new EdgeOptions();
            browserOptions.setPlatformName("Windows 11");
            browserOptions.setBrowserVersion("latest");

            // Sauce-specific options
            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("build", "Java-Test-Build-1");
            sauceOptions.setCapability("name", "My_Edge_Test");

            browserOptions.setCapability("sauce:options", sauceOptions);

            remoteDriver = new RemoteWebDriver(new URL(sauceURL), browserOptions);
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
            getDriver().quit();
            driver.remove();
        }
    }
}
 
/*
public class TestBase2 {
	
	//Sauce Labs Configuration
	public static final String USERNAME = LoadProperties.sauceLabsData.getProperty("username");
	public static final String ACCESS_KEY = LoadProperties.sauceLabsData.getProperty("accesskey");
	public static final String sauceURL =  "http://"+USERNAME+":"+ACCESS_KEY+LoadProperties.sauceLabsData.getProperty("selenuimURL");


	  public static String BaseURL = "http://demo.nopcommerce.com/";

	    protected ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	    @BeforeMethod
	    @Parameters(value = {"browser"})
	    public void setUp(@Optional("edge") String browser) throws MalformedURLException {
	        RemoteWebDriver remoteDriver;

	      //Selenuim grid local
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

*/
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
		
		//Selenuim grid local
		driver.set(new RemoteWebDriver(new URL("http://172.31.64.1:4444/wd/hub"
				+ ""),caps));
				
	    //Run on sauceLabs on cloud
	     * driver.set(new RemoteWebDriver(new URL(sauceURL),caps));		
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
