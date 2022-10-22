package vtiger.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPracticeTest 
{
	@Test(dataProvider = "product")//we can give getData or name but fot name we need to create name in @Dataprovider and we can"t give getData in @Test we should give products
	public void addProductToCartTest(String name,String model,int price,String specification,int quantity)
	{
		System.out.println(name+"-"+model+"-"+price+"-"+specification+"-"+quantity);
	}
	
	@DataProvider(name = "product")
	public Object[][] getData()
	{
		Object[][] d = new Object[4][5];
		
		d[0][0] = "Name";
		d[0][1] = "Model";
		d[0][2] = 0000;
		d[0][3] = "Specification";
		d[0][4] = 00;
		
		d[1][0] = "iphone";
		d[1][1] = "13 PRO MAX";
		d[1][2] = 130000;
		d[1][3] = "security";
		d[1][4] = 10;
		
		d[2][0] = "Nokia";
		d[2][1] = "8.1+";
		d[2][2] = 20000;
		d[2][3] = "build";
		d[2][4] = 15;
		
		d[3][0] = "Samsung";
		d[3][1] = "s22+";
		d[3][2] = 100000;
		d[3][3] = "OS";
		d[3][4] = 20;
		
		return d;
		
	}
	@DataProvider(name = "Wishlist")
	public Object[][] data()
	{
		Object[][] d = new Object[2][3];
		return d;
	}

}
