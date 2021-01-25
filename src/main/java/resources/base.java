package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public Properties prop;
	public WebDriver driver;
	
	public WebDriver driverinitialize() throws IOException {
				
		prop =new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\prop.properties");
		prop.load(file);
		String browsername = prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Naveen Kumar Y\\Desktop\\Selenium\\chromedriver.exe");
			 driver =new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Naveen Kumar Y\\Desktop\\Selenium\\IEDriverServer.exe");
			 driver =new InternetExplorerDriver();
		}
		else if (browsername.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Naveen Kumar Y\\Desktop\\Selenium\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		return driver;
	}
	
	//capture screen shot
	public String getscreenshot(String name,WebDriver driver) throws IOException {
		TakesScreenshot T =  (TakesScreenshot) driver;
		File f= T.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"\\reports\\"+name+".png";
		FileUtils.copyFile(f, new File(dest));
		return dest;
	}
	
}
