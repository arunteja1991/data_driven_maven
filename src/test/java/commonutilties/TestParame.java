package commonutilties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParame {
	
	static ExcelRead excel = new ExcelRead("C:\\Users\\teja\\Downloads\\Video\\SELENIUM_CLASSES\\test.xlsx");
	
	@Test(dataProvider= "getData")
	public void testLogin(String username, String password){
		
	}
	
	@DataProvider
public static Object[][] getData(){
		
		
		String sheetname = "testlogin";
		int rows = excel.getRowCount(sheetname);
		int cols = excel.getColumnCount(sheetname);
		System.out.println("the number of rows :" +rows);
		System.out.println("the number of columns :" +cols);
		Object [][] data = new Object[rows-1][cols];
		for (int rowNum = 2; rowNum<=rows;rowNum++ ){
			for(int colNum=0; colNum<cols; colNum++){
				data[rowNum-2][colNum]=excel.getCellData(sheetname, colNum, rowNum);
			}
		}
		return data;
		
	}
}
