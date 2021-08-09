package MavenProject1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BaseClass 
{
	WebDriver driver;
	Properties prop;
	@Test
	public WebDriver browserLaunch() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\globalfile.properties");
		prop = new Properties();
		prop.load(fis);
		
		String link =prop.getProperty("link");
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\\\main\\\\java\\\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(link);
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		}
		return driver;
	}
	

}
