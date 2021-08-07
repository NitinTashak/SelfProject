package MavenProject1;

import java.io.IOException;

import org.testng.annotations.Test;

public class LoginClass extends BaseClass 
{
	@Test
	public void signInClick() throws IOException
	{
		browserLaunch();
		SignInPage obj = new SignInPage(driver);
		obj.signInButton().click();
	}

}
