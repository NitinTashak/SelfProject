package MavenProject1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidateHeaderTest extends BaseClass
{
	WebDriver driver;
	public static Logger log =LogManager.getLogger(BaseClass.class.getName());
	@BeforeTest
	public void bl() throws IOException
	{
		driver = browserLaunch();
		log.info("ValidateHeaderTest-Browser launchedk");
		driver.get(prop.getProperty("link"));
		log.info("ValidateHeaderTest-Navigated to link");
	}
	@Test
	public void validateHeader()
	{
		SignInPage sp = new SignInPage(driver);
		Assert.assertTrue(sp.headerText().getText().equals("Welcome to your professional community"));
		log.info("ValidateHeaderTest-Header is verified");
	}
	@AfterTest
	public void cb()
	{
		driver.close();
	}
}
