package MavenProject1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage
{
	WebDriver driver;
	public SignInPage(WebDriver driver) 
	{
		this.driver=driver;
		
	} 
	@FindBy(css="[href*='signin']")
	private WebElement SigninButton;
	
	public WebElement signInButton()
	{
		return SigninButton;
	}

}
