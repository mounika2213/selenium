  package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithAlertsTc1 {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	@BeforeTest
	public void open(){
		pr=new ProfilesIni();
		fp=pr.getProfile("mounikafirefox");
		driver=new FirefoxDriver();
		driver.get("https://www.tsrtconline.in/oprs-web/");
	}
	@Test
	public void alert(){
		driver.findElement(By.name("searchBtn")).click();
		Sleeper.sleepTightInSeconds(3);
		String text=driver.switchTo().alert().getText();
		System.out.println(text);
		Sleeper.sleepTightInSeconds(3);
		driver.switchTo().alert().accept();
		
	}

}
