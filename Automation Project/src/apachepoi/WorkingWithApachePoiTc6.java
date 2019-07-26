package apachepoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkingWithApachePoiTc6 {

	public static void main(String[] args) throws IOException,FileNotFoundException {
		FileInputStream fis=new FileInputStream("C:\\Users\\Lenovo pc\\Desktop\\sample.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheet("sheet1");
		Row r;
		r=ws.getRow(0);
		String data=r.getCell(0).getStringCellValue();
		System.out.println(data);
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Lenovo pc\\Desktop\\sample.xlsx");
		wb.write(fos);

	}

}
