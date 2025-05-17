package api.utilities;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtility {
	public static FileInputStream inputStream;
	public static HSSFWorkbook workBook;
	public static HSSFSheet excelSheet;
	public static HSSFRow row;
	public static HSSFCell cell;

	public static String getCellValue(String fileName, String sheetName, int rowNo, int cellNo) {
		try {
			inputStream = new FileInputStream(fileName);
			workBook = new HSSFWorkbook(inputStream);
			excelSheet = workBook.getSheet(sheetName);
			cell = excelSheet.getRow(rowNo).getCell(cellNo);
			workBook.close();

			switch (cell.getCellType()) {
				case STRING:
					return cell.getStringCellValue();
				case NUMERIC:
					return String.valueOf(cell.getNumericCellValue());
				case BOOLEAN:
					return String.valueOf(cell.getBooleanCellValue());
				default:
					return "";
			}
		} catch (Exception e) {
			return "";
		}
	}

	public static int getRowCount(String fileName, String sheetName) {
		try {
			inputStream = new FileInputStream(fileName);
			workBook = new HSSFWorkbook(inputStream);
			excelSheet = workBook.getSheet(sheetName);
			int ttlRows = excelSheet.getLastRowNum() + 1;
			workBook.close();
			return ttlRows;
		} catch (Exception e) {
			return 0;
		}
	}

	public static int getColCount(String fileName, String sheetName) {
		try {
			inputStream = new FileInputStream(fileName);
			workBook = new HSSFWorkbook(inputStream);
			excelSheet = workBook.getSheet(sheetName);
			int ttlCells = excelSheet.getRow(0).getLastCellNum();
			workBook.close();
			return ttlCells;
		} catch (Exception e) {
			return 0;
		}
	}

	public String getStringData(int sheetIndex, int row, int column) {
		return workBook.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}

	public String getStringData(String sheetName, int row, int column) {
		return workBook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}

	public double getNumericData(String sheetName, int row, int column) {
		return workBook.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}

}
