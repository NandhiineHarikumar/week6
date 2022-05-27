package utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadFromExcel_EditLead 
{
	public  static String[][] readDataFromExcel(String excelFileName) throws IOException
	{
		XSSFWorkbook book = new XSSFWorkbook("./testData/"+excelFileName+".xlsx");
		XSSFSheet sheet = book.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		System.out.println(rowCount);
		XSSFRow headerRow = sheet.getRow(0);
		short columnCount = headerRow.getLastCellNum();
		String[][] inputData = new String[rowCount][columnCount];
		for(int i=1;i<=rowCount;i++)
		{
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<columnCount;j++)
			{
				XSSFCell cell = row.getCell(j);
				String stringCellValue = null;
				if(cell.getCellType()==CellType.STRING) 
				{
					stringCellValue = cell.getStringCellValue(); 
				}
				else if(cell.getCellType()==CellType.NUMERIC) 
				{
					stringCellValue = String.valueOf((int)(cell.getNumericCellValue()));
				}
				System.out.println(stringCellValue);
				inputData[i-1][j]=stringCellValue;
			}
		}
		return inputData;
	}
}
