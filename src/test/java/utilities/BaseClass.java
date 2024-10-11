package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BaseClass {

	public static WebDriver driver;

	public static Properties initializeProperties() {

		Properties prop = new Properties();
		String path = "C:\\Users\\Admin\\Downloads\\Amazon_Instrive_Task\\src\\test\\resources\\config\\Config.properties";
		File locFile = new File(path);
		try {
			
			FileInputStream fis = new FileInputStream(locFile);
			prop.load(fis);
			
		} catch (Throwable exp) {

			exp.printStackTrace();
			
		}
		return prop;
	}
}
