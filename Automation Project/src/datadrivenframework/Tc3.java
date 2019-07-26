package datadrivenframework;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tc3 {
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
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

}
	@Test
	public void data() throws FileNotFoundException,IOException{
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Sleeper.sleepTightInSeconds(3);
		WebElement pim=driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']/b"));
		Actions ac=new Actions(driver);
		ac.moveToElement(pim).build().perform();
		fis=new FileInputStream("C:\\Users\\Lenovo pc\\Desktop\\sample3.xlsx");
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet("sheet2");
		Row r;
		int rowc=ws.getLastRowNum();
		for(int i=1;i<=rowc;i++){
			r=ws.getRow(i);
			WebElement addempl=driver.findElement(By.linkText("Add Employee"));
			Sleeper.sleepTightInSeconds(3);
			addempl.click();
			Sleeper.sleepTightInSeconds(3);
			driver.findElement(By.name("firstName")).sendKeys(r.getCell(0).getStringCellValue());
			driver.findElement(By.id("middleName")).sendKeys(r.getCell(1).getStringCellValue());
			driver.findElement(By.id("lastName")).sendKeys(r.getCell(2).getStringCellValue());
			driver.findElement(By.id("employeeId")).sendKeys(r.getCell(3).getStringCellValue());
			driver.findElement(By.id("btnSave")).click();
			Sleeper.sleepTightInSeconds(3);
			String actual=driver.findElement(By.xpath("//*[@id='profile-pic']/h1")).getText();
			r.createCell(4).setCellValue(actual);
			String expected=r.getCell(0).getStringCellValue();
			if(actual.contains(expected)){
				r.createCell(5).setCellValue("pass");
			}
			else{
				r.createCell(5).setCellValue("fail");
			}
			fos=new FileOutputStream("C:\\Users\\Lenovo pc\\Desktop\\sample3.xlsx");
			wb.write(fos);
			fos.close();
		}
	}
}
