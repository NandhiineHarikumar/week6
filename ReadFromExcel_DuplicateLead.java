package utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel_DuplicateLead 
{
	public static String[][] readFromExcel_DuplicateLead(String excelFileName) throws IOException
	{
		XSSFWorkbook  book = new XSSFWorkbook("./testData/"+excelFileName+".xlsx");
		XSSFSheet sheet = book.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		XSSFRow headerRow = sheet.getRow(0);
		short columnCount = headerRow.getLastCellNum();
		String[][] data=new String[rowCount][columnCount];
		for(int i=1;i<=rowCount;i++)
		{
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<columnCount;j++)
			{
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				String cellValue=null;
				if(cellType==cellType.STRING)
				{
					cellValue= cell.getStringCellValue();
				}
				else if(cellType==CellType.NUMERIC)
				{
					double numericCellValue = cell.getNumericCellValue();
					//System.out.println("numericCellValue"+numericCellValue);
					int tempValue = (int)numericCellValue;
					//System.out.println(tempValue);
					cellValue = String.valueOf(tempValue);
				}
				data[i-1][j]=cellValue;
				System.out.println(cellValue);
			}
		}
		return data;
	}
}
