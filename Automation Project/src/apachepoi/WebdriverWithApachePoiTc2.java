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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebdriverWithApachePoiTc2 {
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
	public void data() throws FileNotFoundException,IOException{
		driver.findElement(By.linkText("REGISTER")).click();
		WebElement country=driver.findElement(By.name("country"));
		List<WebElement>values=country.findElements(By.tagName("option"));
		System.out.println(values.size());
		fis=new FileInputStream("C:\\Users\\Lenovo pc\\Desktop\\sample.xlsx");
		wb= new XSSFWorkbook(fis);
		ws=wb.getSheet("sheet1");
		//driver.findElement(By.linkText("REGISTER")).click();
		Row r;
		for(int i=0;i<values.size();i++){
		r=ws.createRow(i);
		r.createCell(0).setCellValue(values.get(i).getText());
		}
		fos=new FileOutputStream("C:\\Users\\Lenovo pc\\Desktop\\sample.xlsx");
		wb.write(fos);
		
		
		
		
		
		
	}

}
