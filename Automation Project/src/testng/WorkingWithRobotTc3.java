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

public class WorkingWithRobotTc3 {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	@BeforeTest
	public void open(){
		pr=new ProfilesIni();
		fp=pr.getProfile("mounikafirefox");
		driver=new FirefoxDriver();
		driver.get("https://upload.photobox.com/en/");
	}
	@Test
	public void robot() throws InterruptedException, AWTException{
		
		Sleeper.sleepTightInSeconds(3);
		driver.findElement(By.id("computer_icone_name")).click();
		Sleeper.sleepTightInSeconds(3);
		driver.findElement(By.id("button_desktop")).click();
		Robot rb=new Robot();
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_C);
		rb.keyPress(KeyEvent.VK_B);
		rb.keyPress(KeyEvent.VK_PERIOD);
		rb.keyPress(KeyEvent.VK_J);
		rb.keyPress(KeyEvent.VK_P);
		rb.keyPress(KeyEvent.VK_G);
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_ENTER);
	}

}
