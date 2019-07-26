package apachepoi;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mytask2 {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet ws;
	FileOutputStream fos;
	@BeforeTest
	public void open(){
		pr=new ProfilesIni();
		fp=pr.getProfile("mounikafirefox");
		driver=new FirefoxDriver(fp);
		driver.get("http://newtours.demoaut.com/");
	}
	@Test
	public void data() throws IOException,FileNotFoundException{
		fis=new FileInputStream("C:\\Users\\Lenovo pc\\Desktop\\sample2.xlsx");
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet("sheet1");
		Row r;
		String text=driver.findElement(By.xpath("//html//body//div//table//tbody//tr//td[2]//table//tbody//tr[4]//td//table//tbody//tr//td[2]//table//tbody//tr[2]//td[1]//table[1]//tbody//tr[3]//td//table//tbody//tr[1]//td[1]//font")).getText();
		r=ws.createRow(0);
		r.createCell(0).setCellValue(text);
		if(text.contains("Atlanta to Las Vegas")){
			r.createCell(1).setCellValue("pass");
		}
			else{
				r.createCell(1).setCellValue("fail");
			}
			

	fos=new FileOutputStream("C:\\Users\\Lenovo pc\\Desktop\\sample2.xlsx");
	wb.write(fos);

}
}

	
