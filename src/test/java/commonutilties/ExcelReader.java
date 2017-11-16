package commonutilties;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static FileInputStream fis;
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell col;
	
	public static String getCellData(int rownum , int cellnum) throws IOException{
		
		fis = new FileInputStream("C:\\Users\\teja\\Desktop\\test_poi.xlsx");
		book = new XSSFWorkbook(fis);
		sheet = book.getSheet("credentials");
		row = sheet.getRow(rownum);
		col = row.getCell(cellnum);
		return col.getStringCellValue();	
	}
	
	public static void main (String args[]) throws IOException{
		String rowcol00=getCellData(0,0);
		System.out.println(rowcol00);
		String rowcol01 =getCellData(0,1) ;
        System.out.println(rowcol01);
        String rowcol10 =getCellData(1,0) ;
        System.out.println(rowcol10);
}
}