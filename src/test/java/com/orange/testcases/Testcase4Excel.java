package com.orange.testcases;

import com.orange.utilities.ExcelReader;

public class Testcase4Excel
{
	public static void main(String[] args)
	{
		ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Excel\\Myexcel.xlsx");
		System.out.println(excel.getCellData("Login", "First Name", 2));
	}
}