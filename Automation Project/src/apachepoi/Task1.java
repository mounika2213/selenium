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

public class Task1 {
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
		driver.get("https://www.timeanddate.com/worldclock/");
	}
	@Test
	public void data() throws IOException,FileNotFoundException, InterruptedException{
		fis=new FileInputStream("C:\\Users\\Lenovo pc\\Desktop\\sample.xlsx");
		wb= new XSSFWorkbook(fis);
		ws=wb.getSheet("sheet1");
		Row r;
		String part1="/html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[";
		String part2="]/td[1]";
		for(int i=1;i<37;i++){
			String output=driver.findElement(By.xpath(part1+i+part2)).getText();
			//System.out.println(output);
			r=ws.createRow(i);
			r.createCell(0).setCellValue(output);
		}
		fos=new FileOutputStream("C:\\Users\\Lenovo pc\\Desktop\\sample.xlsx");
		wb.write(fos);
		
	}

}
