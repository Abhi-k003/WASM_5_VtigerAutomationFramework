package vtiger.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation implements IRetryAnalyzer
{

	public boolean retry(ITestResult result) 
	{
		int count=0;
		int retryCount=0;
		while(count>retryCount)
		{
			count++;
			return true;
		}
		return false;
	}

}
