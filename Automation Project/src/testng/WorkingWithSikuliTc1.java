package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithSikuliTc1 {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	@BeforeTest
	public void open(){
		pr=new ProfilesIni();
		fp=pr.getProfile("mounikafirefox");
		driver=new FirefoxDriver();
		driver.get("https://www.seleniumhq.org/download/");
	}
	@Test
	public void orangehrm() throws FindFailed{
		driver.findElement(By.linkText("3.141.59")).click();
		Screen sc=new Screen();
		Pattern Pt=new Pattern("C:\\Users\\Lenovo pc\\Pictures\\Capture.PNG");
		sc.click(Pt);
		
	}

}
