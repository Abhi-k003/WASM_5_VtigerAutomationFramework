package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * this class contains all generic methods related to property file to read data from property file
 * @author ABHISHEK K
 *
 */
public class PropertyFileUtility 
{
	/**
	 * this method will read the specific key value from the property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException 
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.PropertyFilePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
		
	}

}
