package testng;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithjavaScriptTc4 {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	@BeforeTest
	public void open(){
		pr=new ProfilesIni();
		fp=pr.getProfile("mounikafirefox");
		driver=new FirefoxDriver(fp);
		driver.get("https://in.yahoo.com/");
	}
	@Test
	public void scroll() throws InterruptedException{
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//Scroll upto 50
		//js.executeScript("window.scrollBy(0,5000)");
		//scroll upto pageend
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		//scroll upto elementpresent
		js.executeScript("document.getElementById('yui_3_18_0_3_1562858412377_1371').scrollIntoView()");
		
		
	}
}
