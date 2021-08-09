package MavenProject1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage
{
	WebDriver driver;
	public LogInPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	} 
	@FindBy(id="username")
	private WebElement userName;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(css="[aria-label='Sign in']")
	private WebElement signInButton;
	
	public WebElement userName()
	{
		return userName;
	}
	public WebElement password()
	{
		return password;
	}
	public WebElement signInButton()
	{
		return signInButton;
	}


}
