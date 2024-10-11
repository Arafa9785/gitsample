package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.BaseClass;

public class MyHooks {
	
	WebDriver driver;
	
	@Before
	public void browserSetup() {
		
		Properties prop = BaseClass.initializeProperties();
		DriverFactory.initializeBrowser(prop.getProperty("browser"));
		driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://www.amazon.in/");
	}
	
	
	@After
	public void tearDown() {
		
		driver.quit();

	}

}
