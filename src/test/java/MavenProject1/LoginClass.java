package MavenProject1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginClass extends BaseClass 
{
	WebDriver driver;
	@BeforeTest
	public void bt() throws IOException
	{
		driver=browserLaunch();
	}
	@Test (dataProvider="readExcel")
	public void signInClick(String TC, String un, String pwd) throws InterruptedException
	{
		driver.get(prop.getProperty("link"));
		
		SignInPage obj = new SignInPage(driver);
		LogInPage lp =obj.signInButton();
		lp.userName().sendKeys(un);
		lp.password().sendKeys(pwd);
		lp.signInButton().click();
		if(TC.equalsIgnoreCase("positive"))
		{
			System.out.println("positiva wala");
			System.out.println(driver.getTitle());
			FeedScreen fs = new FeedScreen(driver);
			fs.dropButton().click();
			WebDriverWait wait = new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.visibilityOf(fs.logout()));
			fs.logout().click();
			//if(fs.logout2().isDisplayed())
			//fs.logout2().click();
		}
		else
		{
			System.out.println("Negative wala");
		}
	}
	@DataProvider
	public Object[][] readExcel() throws IOException
	{
		Iterator<Sheet> itrsheet =new XSSFWorkbook(new FileInputStream("C:\\Users\\Nitin.Takshak\\Desktop/LoginData.xlsx")).iterator();
		Object[][] obj = null;
		while(itrsheet.hasNext())
		{
			Sheet sh = itrsheet.next();
			if(sh.getSheetName().equalsIgnoreCase("TestDataSheet"))
			{
						
				int lastRow =sh.getLastRowNum();
				int lastCell = sh.getRow(0).getLastCellNum();
				Row rw;
				Cell cl;
				
				obj = new Object[lastRow][lastCell];
				
				for(int i=1; i<=lastRow; i++)
				{
					rw= sh.getRow(i);
					for(int k=0 ;k<lastCell; k++)
					{
						cl=rw.getCell(k);
						if(cl.getCellType().equals(CellType.STRING))
						{
							String cellValue= cl.getStringCellValue();
							obj[i-1][k]=cellValue;
						}
						else
						{
							double cellValue=cl.getNumericCellValue();
							obj[i-1][k]=cellValue;
						}
						
					}
				}
							
				
			}
		}
		return obj;
	}

}
