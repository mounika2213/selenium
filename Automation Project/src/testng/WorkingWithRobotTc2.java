package testng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithRobotTc2 {
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
	public void robot() throws InterruptedException, AWTException{
		driver.findElement(By.linkText("3.141.59")).click();
		Sleeper.sleepTightInSeconds(3);
		Robot rb=new Robot();
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_ENTER);
		
	}

}
