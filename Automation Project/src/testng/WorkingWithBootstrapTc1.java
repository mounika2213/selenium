package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithBootstrapTc1 {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	@BeforeTest
	public void open(){
		pr=new ProfilesIni();
		fp=pr.getProfile("mounikafirefox");
		driver=new FirefoxDriver();
		driver.get("https://www.goibibo.com/");
		
	}
	@Test
	public void bootstrap(){
		driver.findElement(By.linkText("Sign In")).click();
		Sleeper.sleepTightInSeconds(3);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@id='authMobile']")).sendKeys("9876543210");
		driver.findElement(By.id("mobileSubmitBtn")).clear();
	}

}
