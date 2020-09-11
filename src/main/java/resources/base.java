package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeSuite;

public class base {

	public WebDriver driver;//making webDriver as public by declaring globally
	public Properties prop;// making properties as public by declaring it globally
	
	

	public WebDriver initializeDriver() throws IOException //method to initilize the driver
	{
		prop = new Properties();//creating object for properties
		FileInputStream fis = new FileInputStream("./src/main/java/resources/data.properties");
		prop.load(fis);//loading properties with file input stream
		String browserName =prop.getProperty("browser");//using prop getting browser
		System.out.println(browserName);

		String Name_1 = prop.getProperty("To_do1");
		String Name_2 = prop.getProperty("To_do2");


		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\GeckoDriver\\geckodriver.exe");  
			driver= new FirefoxDriver();  
		}
		else if (browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\IE Driver Server\\IEDriverServer.exe");  
			driver=new InternetExplorerDriver();  
		}
		else if (browserName.equals("safari"))
		{
			System.setProperty("webdriver.safari.driver", "D:\\IE Driver Server\\IEDriverServer.exe");  
			driver = new SafariDriver();   
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver; //returning driver
	}

	

}

