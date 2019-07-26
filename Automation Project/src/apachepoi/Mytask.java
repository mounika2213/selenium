/*1.open browser navigate to newtours.com
  2.capture all link names and insert into excel */


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

public class Mytask {
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
		driver.get("http://www.google.com/");
	}
	@Test
	public void data() throws IOException,FileNotFoundException{
		fis=new FileInputStream("C:\\Users\\Lenovo pc\\Desktop\\sample2.xlsx");
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet("sheet2");
		List<WebElement>links=driver.findElements(By.tagName("a"));
		Row r;
		for(int i=0;i<links.size();i++){
			r=ws.createRow(i);
			r.createCell(0).setCellValue(links.get(i).getText());
			//if(links.get(i).getAttribute("name")){
				//r.createCell(0).setCellValue(links.get(i).);
			}
			
		//}
		fos=new FileOutputStream("C:\\Users\\Lenovo pc\\Desktop\\sample2.xlsx");
		wb.write(fos);
		
		
	}
	

}
