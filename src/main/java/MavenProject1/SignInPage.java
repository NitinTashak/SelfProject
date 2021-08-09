package MavenProject1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage
{
	WebDriver driver;
	public SignInPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	} 
	@FindBy(css="[href*='signin']")
	private WebElement SigninButton;
	
	public LogInPage signInButton()
	{
		SigninButton.click();
		LogInPage lp = new LogInPage(driver);
		return lp;
	}

}
