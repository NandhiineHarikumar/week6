package utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel_DeleteLead 
{
	public static String[][] readDataFromExcel(String excelFileName) throws IOException
	{
		XSSFWorkbook book = new XSSFWorkbook("./testData/"+excelFileName+".xlsx");
		XSSFSheet sheet = book.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		XSSFRow headerRow = sheet.getRow(0);
		short columnCount = headerRow.getLastCellNum();
		String[][] data = new String[rowCount][columnCount];
		for(int i=1;i<=rowCount;i++)
		{
			XSSFRow row = sheet.getRow(i);
			String stringCellValue = null;
			for(int j=0;j<columnCount;j++)
			{
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				if(cellType==cellType.STRING)
				{
					stringCellValue = cell.getStringCellValue();
				}
				else if(cellType==CellType.NUMERIC)
				{
					stringCellValue = String.valueOf((int)cell.getNumericCellValue());
				}
				data[i-1][j]=stringCellValue;
			}
		}
		return data;
	}
}
