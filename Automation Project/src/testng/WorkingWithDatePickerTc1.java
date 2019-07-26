package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithDatePickerTc1 {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	@BeforeTest
	public void open(){
		pr=new ProfilesIni();
		fp=pr.getProfile("mounikafirefox");
		driver=new FirefoxDriver(fp);
		driver.get("https://jqueryui.com/datepicker/");
	}
	@Test
	public void datepicker() throws InterruptedException{
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).sendKeys("11/07/2019");
	}
	

}
