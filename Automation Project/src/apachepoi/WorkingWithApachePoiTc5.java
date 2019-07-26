package apachepoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkingWithApachePoiTc5 {

	public static void main(String[] args) throws FileNotFoundException,IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\Lenovo pc\\Desktop\\s1.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheet("sheet1");
		Row r;
		int rowc=ws.getLastRowNum();
		for(int i=0;i<=rowc;i++){
			r=ws.getRow(i);
			r.createCell(0).setCellValue("testing");
			
			FileOutputStream fos=new FileOutputStream("C:\\Users\\Lenovo pc\\Desktop\\s1.xlsx");
			wb.write(fos);
			//System.out.println("output inserted");
		}
		System.out.println("output inserted");

	}

}
