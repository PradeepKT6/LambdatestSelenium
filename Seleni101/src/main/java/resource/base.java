package resource;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class base {
	public WebDriver driver;

	@Parameters({"browser"})
	@BeforeClass
	public WebDriver initializeDriver(String browser) throws IOException {
		System.out.println("Browser name is:" + browser);
		
		if (browser.equals("chrome")) {
			// WebDriverManager.chromedriver().setup();
		//	System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Seleni101\\BrowserDrivers\\chromedriver.exe");
			DesiredCapabilities caps=new DesiredCapabilities();
			caps.setBrowserName(browser);
            caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
			driver = new RemoteWebDriver(new URL(" http://192.168.0.195:4444\n"),caps);
			//driver.get("https://www.lambdatest.com/selenium-playground/");
		}

				else if (browser.equals("edge")) {
					
					DesiredCapabilities caps1=new DesiredCapabilities();
					caps1.setBrowserName(browser);
					//caps1.setBrowserName(DesiredCapabilities.edge().getBrowserName());
		            caps1.setCapability(CapabilityType.BROWSER_NAME, "edge");
					driver = new RemoteWebDriver(new URL(" http://192.168.0.195:4444\n"),caps1);
					/*
					 * System.setProperty("webdriver.edge.driver",
					 * "D:\\Selenium\\Seleni101\\BrowserDrivers\\msedgedriver.exe"); driver = new
					 * EdgeDriver();
					 */
		}
				else if (browser.equals("firefox")) {
					
					DesiredCapabilities caps2=new DesiredCapabilities();
					caps2.setBrowserName(browser);
					//caps1.setBrowserName(DesiredCapabilities.edge().getBrowserName());
		            caps2.setCapability(CapabilityType.BROWSER_NAME, "firefox");
					driver = new RemoteWebDriver(new URL(" http://192.168.0.195:4444\n"),caps2);
					/*
					 * System.setProperty("webdriver.edge.driver",
					 * "D:\\Selenium\\Seleni101\\BrowserDrivers\\msedgedriver.exe"); driver = new
					 * EdgeDriver();
					 */
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}
	@AfterClass
	
	public void Teardown() {
		//driver.close();
	}
}
