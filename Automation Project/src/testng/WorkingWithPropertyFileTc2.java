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

public class WorkingWithPropertyFileTc2 {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	FileInputStream fis;
	@BeforeTest
	public void open(){
		pr=new ProfilesIni();
		fp=pr.getProfile("mounikafirefox");
		driver=new FirefoxDriver();
		driver.get("http://newtours.demoaut.com/");
	}
	@Test
	public void regis() throws IOException{
		fis=new FileInputStream("C:\\Users\\Lenovo pc\\mouni\\Automation Project\\newtours.properties");
		Properties prt=new Properties();
		prt.load(fis);
		driver.findElement(By.linkText(prt.getProperty("regis"))).click();
		driver.findElement(By.name(prt.getProperty("fname"))).sendKeys("mounika");
		driver.findElement(By.name(prt.getProperty("lname"))).sendKeys("ananth");
		driver.findElement(By.name(prt.getProperty("Phone"))).sendKeys("9876543310");
		driver.findElement(By.id(prt.getProperty("Email"))).sendKeys("mounireddy.7416@gmail.com");
		driver.findElement(By.name(prt.getProperty("Addr"))).sendKeys("sananthnagar");
		driver.findElement(By.name(prt.getProperty("City"))).sendKeys("hyd");
        driver.findElement(By.name(prt.getProperty("State"))).sendKeys("telangana");
        driver.findElement(By.name(prt.getProperty("Postal"))).sendKeys("518002");
		driver.findElement(By.name(prt.getProperty("Country"))).sendKeys("India");
		driver.findElement(By.id(prt.getProperty("Email1"))).sendKeys("mounireddy.7416@gmail.com");
		driver.findElement(By.name(prt.getProperty("pass"))).sendKeys("123");
		driver.findElement(By.name(prt.getProperty("cpass"))).sendKeys("123");
		driver.findElement(By.name(prt.getProperty("button"))).click();
	}

}
