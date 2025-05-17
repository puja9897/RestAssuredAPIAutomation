package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	String fileName = System.getProperty("user.dir") + "\\testData\\UserData.xls";

	@DataProvider(name = "Data")
	public String[][] UserCreation() {

		int ttlRows = ExcelUtility.getRowCount(fileName, "Data");
		int ttlColumns = ExcelUtility.getColCount(fileName, "Data");

		String data[][] = new String[ttlRows - 1][ttlColumns];

		for (int i = 1; i < ttlRows; i++) {
			for (int j = 0; j < ttlColumns; j++) {
				data[i - 1][j] = ExcelUtility.getCellValue(fileName, "Data", i, j);
			}
		}
		return data;
	}
	

}
