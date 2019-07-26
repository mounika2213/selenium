package apachepoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkingWithApachePoiTc4 {

	public static void main(String[] args) throws FileNotFoundException,IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\Lenovo pc\\Desktop\\s1.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheet("sheet1");
		Row r;
		r=ws.getRow(2);
		r.createCell(1).setCellValue("manual");
		System.out.println("output is inserted");
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Lenovo pc\\Desktop\\s1.xlsx");
		wb.write(fos);

	}

}
