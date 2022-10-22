package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class contains generic methods related to excel sheet to read and insert the value
 * @author ABHISHEK K
 *
 */
public class ExcelFileUtility 
{
/**
 * this method will read the data from excel sheet and return it to caller
 * @param sheet
 * @param row
 * @param cell
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String readDataFromExcelSheet(String sheet,int row,int cell) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row r = sh.getRow(row);
		Cell cel = r.getCell(cell);
		String value = cel.getStringCellValue();
		//after getting value we need to close the workbook
		wb.close();
		return value;
	}
	/**
	 * this method will return the number of rows present in particular sheet
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int lastRow = sh.getLastRowNum();
		wb.close();
		return lastRow;
		
	}
	/**
	 * this method will insert the data into excel sheet or file
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheet,int row,int cell,String value) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row r = sh.getRow(row);
		Cell cel = r.createCell(cell);
		cel.setCellValue(value);//i can't use int or any other variable i need to use String variable only to give any value
		
		FileOutputStream fos = new FileOutputStream(ConstantsUtility.ExcelFilePath);
		wb.write(fos);
		wb.close();
		
	}
	/**
	 * this method is uesd to execute multiple  set ofdata in test script 
	 * hence it will return 2 dimensional object array so that it can be directly used in dataprovider 
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		short lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++) 
		{
		 for(int j=0;j<lastCell;j++)
		 {
			data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
		 }
		}
		return data;
		
	}
	

}
