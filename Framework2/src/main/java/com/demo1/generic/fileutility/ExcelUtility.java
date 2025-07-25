package com.demo1.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String  toGetDataFromExcelFile(String sheetname,int rownum,int cellno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testData/GenericUtility1.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		Row r=sh.getRow(rownum);
		Cell c=r.getCell(cellno);
		String data=c.getStringCellValue();
		return data;
		
		
	}
	
	
	public int toGetRowCount(String sheetname) throws EncryptedDocumentException, IOException
	{

		FileInputStream fis=new FileInputStream("./testData/GenericUtility1.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		int row=sh.getLastRowNum();
		return row;
		
		
	}
	
	
	public void toWriteBackToFile(String sheetname,int rowno,int cellno,String data) throws EncryptedDocumentException, IOException
	{ FileInputStream fis=new FileInputStream("./testData/GenericUtility1.xlsx");
	
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetname);
	Row r=sh.getRow(rowno);
	Cell cel=r.createCell(cellno);
	cel.setCellType(CellType.STRING);
	cel.setCellValue(data);
	
	FileOutputStream fos=new FileOutputStream("./testData/GenericUtility1.xlsx");
	wb.write(fos);
	wb.close();
	 
	}
	
	
}
