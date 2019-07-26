package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithAdvUserInterTc6 {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	@BeforeTest
	public void open(){
		pr=new ProfilesIni();
		fp=pr.getProfile("mounikafirefox");
		driver=new FirefoxDriver();
		driver.get("https://www.flipkart.com/");
		Sleeper.sleepTightInSeconds(3);
	}
	@Test
	public void mouseMove(){
		
		WebElement men=driver.findElement(By.cssSelector("div#container li.Wbt_B2._3mmoXN > span"));
		Actions ac=new Actions(driver);
		ac.moveToElement(men);
		driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/ul/li[3]/ul/li/ul/li[1]/ul/li[4]/a")).click();
		
	}

}
