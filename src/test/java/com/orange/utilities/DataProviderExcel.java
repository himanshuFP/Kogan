package com.orange.utilities;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orange.base.TestBase;

public class DataProviderExcel extends TestBase
{
	@Test(dataProvider="sender")
public void receiver(String abc ,String def)
	
{
	//System.out.println(abc+"  "+def);
	
}

@DataProvider
public Object[][] sender()
{ 
	ExcelReader excel=new ExcelReader("C:\\Users\\Himanshu\\Desktop\\holycow.xlsx");
	//excel.getCellData("Login", "First Name", 2);
	System.out.println(excel.getRowCount("Sheet1"));
	System.out.println(excel.getColumnCount("Sheet1"));
	System.out.println(excel.getCellData("Sheet1","abcd",5));
	
Object[][]data=new Object[2][2];
data[0][0]="h1";
data[0][1]="h2";
data[1][0]="h3";
data[1][1]="h4";

return data ;
	
}
}
