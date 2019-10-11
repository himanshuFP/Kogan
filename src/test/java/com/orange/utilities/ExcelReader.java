package com.orange.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.orange.base.TestBase;

public class ExcelReader extends TestBase
{
	public String path;
	String Sheetname;
	String colName;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	int col_Num=0;
public ExcelReader(String path)
{
	this.path=path;
	try{
	fis=new FileInputStream(path);
	workbook=new XSSFWorkbook(fis);
	}
	catch(Exception e){e.printStackTrace();}
}

public String getCellData(String Sheetname,String colName,int rowNum)
{ 
	try{
	
		//System.out.println(Sheetname+colName+rowNum);
	
	
	int index=workbook.getSheetIndex(Sheetname);
	//System.out.println("index is "+index);
	sheet=workbook.getSheetAt(index);
	XSSFRow row=sheet.getRow(0);
	//System.out.println("This is row "+row);
	for(int i=0;i<row.getLastCellNum(); i++)
	{
		if(row.getCell(i).getStringCellValue().equals(colName ))
		{
			col_Num=i;
			//System.out.println(i);
		}
	}
	row=sheet.getRow(rowNum-1);
	//System.out.println("This is Row"+row);
	XSSFCell cell = row.getCell(col_Num);
	System.out.println("This is cell "+cell);
	if(cell.getCellType()==Cell.CELL_TYPE_STRING)
	{   System.out.println("cell string type");
		return cell.getStringCellValue();
	}
	
	else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
	{ //System.out.println("cell numberic type");
		return cell.getStringCellValue();
	}
	
	else if(cell.getCellType()==Cell.CELL_TYPE_BOOLEAN)
	{System.out.println("cell boolean type");
		return cell.getStringCellValue();
	}
	
	else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
	{System.out.println("cell blank type");
		return "";
	}
       
	}
    catch(Exception e)
   {
	e.printStackTrace();
   }
	return "None of these";
}

public int getRowCount(String sheetname)
{
	int index=workbook.getSheetIndex(sheetname);
	if(index==-1)
	{
		return 0;
	}
	else
	{
		/*sheet=workbook.getSheetAt(index);
		int number=sheet.getLastRowNum();
		System.out.println("This is the last row count"+number);
		return number;*/
		XSSFSheet sheet = workbook.getSheet(sheetname);
	   // XSSFRow row = sheet.getRow(0);
	   /* int colNum = row.getLastCellNum();
	    System.out.println("Total Number of Columns in the excel is : "+colNum);*/
	    int rowNum = sheet.getPhysicalNumberOfRows()+1;
	    System.out.println("Total Number of Rows in the excel is : "+rowNum);
	return rowNum;
	}
	
	
	

}
/*public static void main(String[] args) 
{
ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Excel\\Myexcel.xlsx");
System.out.println(excel.getCellData("AddExcelDP", "Last Name", 2));
}*/

public int getColumnCount(String sheetname)
{ XSSFSheet sheet = workbook.getSheet(sheetname);
XSSFRow row = sheet.getRow(0);
int colNum = row.getLastCellNum();
	return colNum;
	
}

}