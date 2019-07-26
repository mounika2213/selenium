package apachepoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkingWithApachepoiTc8 {

	public static void main(String[] args) throws IOException,FileNotFoundException,NullPointerException{
		FileInputStream fis=new FileInputStream("C:\\Users\\Lenovo pc\\Desktop\\s1.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheet("sheet1");
		Row r;
		int rowc=ws.getLastRowNum();
		for(int i=0;i<rowc;i++){
				r=ws.getRow(i);
				int colc=r.getLastCellNum();
				for(int j=0;j<colc;j++){
					String data=r.getCell(j).getStringCellValue();
					System.out.print(data+" ");
				}
		
		System.out.println();
		}
				FileOutputStream fos=new FileOutputStream("C:\\Users\\Lenovo pc\\Desktop\\s1.xlsx");
				wb.write(fos);
			}
		
		
		

	}


