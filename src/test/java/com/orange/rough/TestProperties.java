package com.orange.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestProperties {
/*public static void main(String[] args) throws IOException {
	Properties config=new Properties();
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
	config.load(fis);
	System.out.println(config.getProperty("browser"));
	
	
	Properties OR=new Properties();
	fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
	OR.load(fis);
	System.out.println(OR.getProperty("xpath"));
	
}*/

@Test(dataProvider="sender")
public void receiver(String row ,String col)
{
System.out.println(row);
System.out.println(col);
}

@DataProvider
public Object[][]sender()
{
	Object[][] data=new Object[2][2];
	data[0][0]="admin";
	data[0][1]="admin";
	
	data[1][0]="admin";
	data[1][1]="admin";
	
	return data; 
	
	

}



}
