package com.RCCTest.Utilities;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class XLUtilityFile {
	public FileInputStream input;
	public OutputStream output;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String path;
	
	public XLUtilityFile(String path) {
		this.path=path;
	}
	public int getrowcount(String sheetname) throws IOException{
		input=new FileInputStream(path);
		workbook=new XSSFWorkbook(input);
		sheet=workbook.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		input.close();
		return rowcount;
		
	}
	
	public int getcellcount(String sheetname,int rownum) throws IOException{
		input=new FileInputStream(path);
		workbook=new XSSFWorkbook(input);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		input.close();
		return cellcount;
		
	}
	
	public String getcellvalue(String sheetname,int rownum,int cellnum) throws IOException
	{
		input=new FileInputStream(path);
		workbook=new XSSFWorkbook(input);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
	    cell=row.getCell(cellnum);
	    
	    DataFormatter formatter=new DataFormatter();
	    String data;
	    
	    try {
	    	data=formatter.formatCellValue(cell);
	    }
			
		 catch (Exception e)
	    {
			data=" ";
		}
	
		workbook.close();
		input.close();
		return data;
	
	}
	
	public void setcellvalue(String sheetname,int rownum,int cellnum,String data) throws IOException
	{
		input=new FileInputStream(path);
		workbook=new XSSFWorkbook(input);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
	    cell=row.createCell(cellnum);
	    cell.setCellValue(data);
	
	    output=new FileOutputStream(path);
	    workbook.write(output);
	    workbook.close();
	    input.close();
	    output.close();
	
	}
	
	
	
	
}
