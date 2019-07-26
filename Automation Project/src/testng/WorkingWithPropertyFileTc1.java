package testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithPropertyFileTc1 {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	FileInputStream fis;
	@BeforeTest
	public void open(){
		pr=new ProfilesIni();
		fp=pr.getProfile("mounikafirefox");
		driver=new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	@Test
	public void login() throws IOException{
		 fis=new FileInputStream("C:\\Users\\Lenovo pc\\mouni\\Automation Project\\locators.properties");
		 Properties prt=new Properties();
		 prt.load(fis);
		 driver.findElement(By.id(prt.getProperty("user"))).sendKeys("Admin");
		 driver.findElement(By.id(prt.getProperty("pass"))).sendKeys("admin123");
		 driver.findElement(By.id(prt.getProperty("login"))).click();
	}

}
