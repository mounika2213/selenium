package testnglisteners;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(testnglisteners.Tc1.class)
public class WorkingWithTestnglistenerTc1 {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	@BeforeTest
	public void open(){
		pr=new ProfilesIni();
		fp=pr.getProfile("mounikafirefox");
		driver=new FirefoxDriver();
		driver.get("http://www.hdnicewallpapers.com/Wallpaper-Download/Cute-Baby/Cute-Baby-Boy-in-Winter-Cap-Wallpaper");
	}
	@Test
	public void robot() throws AWTException, InterruptedException{
		driver.findElement(By.xpath("//*[@id='DL']/div")).click();
		Robot rb=new Robot();
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
	    rb.keyPress(KeyEvent.VK_ENTER);
		
	}

}
