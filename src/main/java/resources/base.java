package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public Properties prop;
	public WebDriver driver;
		
	// driver initialize bases on the type of driver put in properties file
	public WebDriver driverinitialize() throws IOException {
				
		prop =new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\prop.properties");
		prop.load(file);
		String browsername = prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
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
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	
	}
	

