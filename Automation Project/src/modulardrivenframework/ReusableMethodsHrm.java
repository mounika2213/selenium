package modulardrivenframework;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReusableMethodsHrm {
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
	@Test(priority=0)
	public void login(String u,String p){
		driver.findElement(By.id("txtUsername")).sendKeys(u);
		driver.findElement(By.id("txtPassword")).sendKeys(p);
		driver.findElement(By.id("btnLogin")).click();
		Sleeper.sleepTightInSeconds(3);
		}
	@Test(priority=1)
	public void verifyStatus(){
		String actual=driver.findElement(By.linkText("Welcome Admin")).getText();
		String expected="Welcome Admin";
		if(expected.contains(actual)){
			System.out.println("pass");
		
	}
		else{
			System.out.println("fail");
		}
	}
		@Test(priority=2)
		public void logout(){
			driver.findElement(By.linkText("Welcome Admin")).click();
			driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
			}
		@AfterTest
		public void close(){
			driver.close();
				
			}
			
	
		
	}


