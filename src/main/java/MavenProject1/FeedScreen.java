package MavenProject1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeedScreen
{
	WebDriver driver;
	public FeedScreen(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	} 
	@FindBy(css="[class*='global-nav__me artdeco-dropdown artdeco-dropdown']")
	private WebElement dropButton;
	
	@FindBy(css="[href='/m/logout/']")
	private WebElement logout;
	
	@FindBy(css="[class='full-width mt4 artdeco-button artdeco-button--muted artdeco-button--2 artdeco-button--secondary ember-view']")
	private WebElement logout2;
	
	public WebElement dropButton()
	{
		return dropButton;
	}
	public WebElement logout()
	{
		return logout;
	}
	public WebElement logout2()
	{
		return logout2;
	}
	


}
