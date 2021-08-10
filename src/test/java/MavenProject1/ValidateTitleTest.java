package MavenProject1;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ValidateTitleTest extends BaseClass
{
	WebDriver driver;
	public static Logger log =LogManager.getLogger(BaseClass.class.getName());
	@BeforeTest
	public void bl() throws IOException
	{
		driver = browserLaunch();
		log.info("ValidateTitleTest-Browser is launched");
		driver.get(prop.getProperty("link"));
		log.info("ValidateTitleTest-Navigated to link");
	}
	@Test
	public void validateTitle()
	{
		Assert.assertTrue(driver.getTitle().equals("LinkedIn India: Log In or Sign Up"));
		log.info("ValidateTitleTest-Title verified");
		
	}
	@AfterTest
	public void cb()
	{
		driver.close();
	}
}
