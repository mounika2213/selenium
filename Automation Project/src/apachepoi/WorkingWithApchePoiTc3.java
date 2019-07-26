package apachepoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkingWithApchePoiTc3 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\Lenovo pc\\Desktop\\sample.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheet("sheet1");
		Row r;
		r=ws.createRow(0);
		for(int i=0;i<10;i++){
			//r=ws.createRow(0);
			r.createCell(i).setCellValue("testing");
			//System.out.println("output is inserted");
			FileOutputStream fos=new FileOutputStream("C:\\Users\\Lenovo pc\\Desktop\\sample.xlsx");
			wb.write(fos);
		}
		System.out.println("output is inserted");
		

	}

}
