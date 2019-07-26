package datadrivenframework;

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

public class Tc1 {
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
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
		
	}
	@Test
	public void datadrive() throws IOException,FileNotFoundException,NullPointerException{
		fis=new FileInputStream("C:\\Users\\Lenovo pc\\Desktop\\sample3.xlsx");
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet("sheet1");
		Row r;
		int rowc=ws.getLastRowNum();
		System.out.println(rowc);
		for(int i=0;i<=rowc;i++){
			r=ws.getRow(i);
			System.out.println(i);
			driver.findElement(By.id("txtUsername")).clear();
			driver.findElement(By.id("txtUsername")).sendKeys(r.getCell(0).getStringCellValue());
			driver.findElement(By.id("txtPassword")).clear();
			driver.findElement(By.id("txtPassword")).sendKeys(r.getCell(1).getStringCellValue());
			driver.findElement(By.id("btnLogin")).click();
			String Expected=r.getCell(2).getStringCellValue();
			String Actual=driver.getCurrentUrl();
			r.createCell(3).setCellValue(Actual);
			//r.createCell(3).setCellValue(Actual);
			if(Expected.equals(Actual)){
				r.createCell(4).setCellValue("pass");
			}
			else{
				r.createCell(4).setCellValue("fail");
			}
			driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
			fos=new FileOutputStream("C:\\Users\\Lenovo pc\\Desktop\\sample3.xlsx");
			wb.write(fos);
		}
		//fos=new FileOutputStream("C:\\Users\\Lenovo pc\\Desktop\\sample2.xlsx");
		//wb.write(fos);
		
		
	}

}
