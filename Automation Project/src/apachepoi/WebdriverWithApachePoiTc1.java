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

public class WebdriverWithApachePoiTc1 {
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
		driver.get("http://www.google.com");
	}
	@Test
	public void data() throws FileNotFoundException,IOException{
		fis=new FileInputStream("C:\\Users\\Lenovo pc\\Desktop\\sample.xlsx");
		wb= new XSSFWorkbook(fis);
		ws=wb.getSheet("sheet1");
		Row r;
		r=ws.createRow(0);
		String data=driver.findElement(By.linkText("Gmail")).getText();
		r.createCell(0).setCellValue(data);
		System.out.println(data);
		fos=new FileOutputStream("C:\\Users\\Lenovo pc\\Desktop\\sample.xlsx");
		wb.write(fos);
		
		
	}

}
