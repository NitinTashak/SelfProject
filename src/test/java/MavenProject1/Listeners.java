package MavenProject1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;


public class Listeners extends BaseClass implements ITestListener 
{
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> tlextentTest = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) 
	{
		test = extent.createTest(result.getMethod().getMethodName());
		tlextentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		tlextentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		tlextentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		try 
		{
			driver= (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
		try 
		{
			tlextentTest.get().addScreenCaptureFromPath(takeScreenshot(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result)
	{
		
	}

	@Override
	public void onStart(ITestContext context)
	{
		
	}

	@Override
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}

}
