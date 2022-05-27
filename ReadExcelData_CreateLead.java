package utilities;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelData_CreateLead 
{
	public static String[][] readData(String excelFileName) throws IOException
	{
		//open Excel sheet
		XSSFWorkbook book = new XSSFWorkbook("./testData/"+excelFileName+".xlsx");
		//get the sheet
		XSSFSheet sheet = book.getSheetAt(0);
		//get row count
		int rowCount = sheet.getLastRowNum();
		//get column count
		XSSFRow headerRow = sheet.getRow(0);
		short colCount = headerRow.getLastCellNum();
		
		//creating a 2d array to store the data from excel
		String[][] data = new String[rowCount][colCount];
		//get data from sheet
		for(int i=1;i<=rowCount;i++)
		{
			//get each row
			XSSFRow eachRow= sheet.getRow(i);
			for(int j=0;j<colCount;j++)
			{
				//get each column
				XSSFCell eachCell = eachRow.getCell(j);
				//get data in each column/cell
				String value = eachCell.getStringCellValue();
				data[i-1][j]=value;
				System.out.print(value+"\t");
			}
			System.out.println();
		}
		return data;
	}
}
