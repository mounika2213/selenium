package hybridframework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

import modulardrivenframework.ReusableMethodsnewtours;

public class Tc12 {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet ws;
	FileOutputStream fos;
	ReusableMethodsnewtours obj1;
	@Test
	public void tc2login() throws IOException,FileNotFoundException{
		obj1.open();
		obj1.registerLink();
		fis=new FileInputStream("C:\\Users\\Lenovo pc\\Desktop\\sample3.xlsx");
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet("sheet1");
		Row r;
		int rowc=ws.getLastRowNum();
		System.out.println(rowc);
		for(int i=0;i<=rowc;i++){
			r=ws.getRow(i);
			obj1.registerPage(r.getCell(0).getStringCellValue(), r.getCell(1).getStringCellValue(), r.getCell(2).getStringCellValue(), r.getCell(3).getStringCellValue(), r.getCell(4).getStringCellValue(), r.getCell(5).getStringCellValue(), r.getCell(6).getStringCellValue(), r.getCell(7).getStringCellValue(), r.getCell(8).getStringCellValue(), r.getCell(9).getStringCellValue(), r.getCell(10).getStringCellValue(), r.getCell(11).getStringCellValue());
			String actual=driver.findElement(By.xpath("//html//body//div//table//tbody//tr//td[2]//table//tbody//tr[4]//td//table//tbody//tr//td[2]//table//tbody//tr[3]//td//p[3]//a//font//b")).getText();
			r.createCell(12).setCellValue(actual);
			if(actual.contains(r.getCell(9).getStringCellValue())){
				r.createCell(13).setCellValue("pass");
			}
			else{
				r.createCell(13).setCellValue("fail");
			}
			driver.navigate().back();
			
			
			
			
		}
		fos=new FileOutputStream("C:\\Users\\Lenovo pc\\Desktop\\sample3.xlsx");
		wb.write(fos);
		fos.close();


	}
	

}

