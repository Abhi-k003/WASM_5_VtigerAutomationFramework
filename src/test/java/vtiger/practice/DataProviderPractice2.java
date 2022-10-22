package vtiger.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.GenericUtility.ExcelFileUtility;

public class DataProviderPractice2 
{
	@Test(dataProvider = "Industry")
	public void dataProPrac2(String orgName,String industryType)
	{
		System.out.println(orgName+" "+industryType);
	}

	@DataProvider(name = "Industry")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		ExcelFileUtility eUtil = new ExcelFileUtility();
		return eUtil.readMultipleDataFromExcel("MultipleOrg");
		
	}
}
