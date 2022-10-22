package vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CreateContactFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		// Step1:- load the File from File input stream
		 FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
				
		//step2:- Create workbook from workbook factory
		 Workbook wb = WorkbookFactory.create(fis);
		 
		 //Step3:- navigate to sheet
		Sheet sh = wb.getSheet("Organization");
		
		//step4:- navigate to Row
		Row row = sh.getRow(1);
		
		//navigate to cell
		Cell cell = row.getCell(2);
		
		//step6:- read that particular cell value
		String value = cell.getStringCellValue();
		System.out.println(value);
				
				

	}

}
