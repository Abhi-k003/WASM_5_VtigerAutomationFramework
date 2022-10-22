package vtiger.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener
{

	
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		//Reporter.log(methodName+" ==>Test script Excicution started",true);
	}

	public void onTestSuccess(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS,methodName+" -----> Passed");
		//Reporter.log(methodName+" ==> Test Script passed",true);
	}

	public void onTestFailure(ITestResult result) 
	{
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();
		
		
		
		//String msg = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		
		String screenShotName = methodName+"-"+jLib.getSystemDateInFormat();
		test.log(Status.FAIL,methodName+" ---->failed");
		test.log(Status.FAIL,result.getThrowable());
		//Reporter.log(methodName+" ==>testScript failed because "+msg,true);
		try 
		{
			String path = wLib.takeScreenShot(BaseClass.sdriver, screenShotName);
			
			test.addScreenCaptureFromPath(path);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) 
	{
		//String msg = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+" ----> Skipped");
		test.log(Status.SKIP, result.getThrowable());
		//Reporter.log(methodName+" ==>testScript skipped because "+msg,true);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
	}

	public void onStart(ITestContext context) 
	{
		//start of suite execution
		ExtentSparkReporter htmlReports = new ExtentSparkReporter(".\\ExtentReports\\Report"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReports.config().setDocumentTitle("WASM-5-Vtiger Execution Report");
		htmlReports.config().setTheme(Theme.DARK);
		htmlReports.config().setReportName("Vtiger Report Name");
		
		report = new ExtentReports();
		report.attachReporter(htmlReports);
		report.setSystemInfo("Base_PlatForm", "Windows" );
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("Base_URL", "https://localhost:8888" );
		report.setSystemInfo("Reporter Name", "Abhishek k");
		
		
		
	}

	public void onFinish(ITestContext context) 
	{
		
		//end of suite execution
		report.flush();
	}
	
	

}
