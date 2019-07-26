package testng;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithDatePickerTc2 {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	@BeforeTest
	public void open(){
		pr=new ProfilesIni();
		fp=pr.getProfile("mounikafirefox");
		driver=new FirefoxDriver(fp);
		driver.get("https://www.spicejet.com/");
	}
	@Test
	public void date() throws InterruptedException{
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById('ctl00_mainContent_view_date1').value='12/07'");
		js.executeScript("document.getElementById('ctl00_mainContent_view_date2').value='18/07'");
		

	}

}
