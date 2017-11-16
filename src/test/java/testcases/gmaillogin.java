package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class gmaillogin extends BaseTest{
	
	@Test(dataProvider="getData")
	public void openbrowser(String username, String password){
	driver.findElement(By.id(OR.getProperty("username"))).sendKeys("");
	 log.debug("user name typed");
	driver.findElement(By.xpath(OR.getProperty("unextbut"))).click();
	 log.debug("submit button clicked");
	driver.findElement(By.name(OR.getProperty("password"))).sendKeys("");
	 log.debug("password entered");
	driver.findElement(By.xpath(OR.getProperty("pnextbut"))).click();
	 log.debug("submit button ");
	driver.quit();
	 log.debug("chrome closed");

}
	
	@DataProvider
	public static Object[][] getData(){
			
			
			String sheetname = "testlogin";
			int rows = excel.getRowCount(sheetname);
			int cols = excel.getColumnCount(sheetname);
			/*System.out.println("the number of rows :" +rows);
			System.out.println("the number of columns :" +cols);*/
			Object [][] data = new Object[rows-1][cols];
			for (int rowNum = 2; rowNum<=rows;rowNum++ ){
				for(int colNum=0; colNum<cols; colNum++){
					data[rowNum-2][colNum]=excel.getCellData(sheetname, colNum, rowNum);
				}
			}
			return data;
			
		}
}