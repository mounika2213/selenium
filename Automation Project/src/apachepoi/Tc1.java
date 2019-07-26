package apachepoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Tc1 {

	public static void main(String[] args) throws FileNotFoundException,IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\Lenovo pc\\Desktop\\s1.xlsx");
        XSSFWorkbook wbo=new XSSFWorkbook(fis);
		XSSFSheet wso=wbo.getSheet("Sheet1");
		Row r;
		r=wso.createRow(2);
		r.createCell(2).setCellValue("mounika");
		System.out.println("output is inserted");
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Lenovo pc\\Desktop\\s1.xlsx");
		wbo.write(fos);
		
		

	}

} 
