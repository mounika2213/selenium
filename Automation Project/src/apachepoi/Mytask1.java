package apachepoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mytask1 {
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
		Sleeper.sleepTightInSeconds(3);
		List<WebElement>links=driver.findElements(By.tagName("a"));
		Row r;
		/*for(int i=0;i<links.size();i++){
			r=ws.getRow(i);
			r.createCell(1).setCellValue(links.get(i).getText());
			if(r.getCell(0).getStringCellValue().equals(links.get(i).getText())){
				r.createCell(2).setCellValue("pass");
			}
			else{
				r.createCell(2).setCellValue("fail");
			}*/
		int rowc=ws.getLastRowNum();
		for(int i=0;i<rowc;i++){
			r=ws.getRow(i);
			r.createCell(1).setCellValue(links.get(i).getText());
			if(r.getCell(0).getStringCellValue().equals(links.get(i).getText())){
				r.createCell(2).setCellValue("pass");
			}
			else{
				r.createCell(2).setCellValue("fail");
				
			}
		fos=new FileOutputStream("C:\\Users\\Lenovo pc\\Desktop\\sample2.xlsx");
			wb.write(fos);
			
				
			}
		}

}

