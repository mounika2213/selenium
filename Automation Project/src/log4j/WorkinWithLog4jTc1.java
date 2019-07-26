package log4j;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkinWithLog4jTc1 {
	private static Logger log=Logger.getLogger(WorkinWithLog4jTc1.class);
	 ProfilesIni pr;
    FirefoxProfile fp;
    FirefoxDriver driver;
    @BeforeTest
    public void open(){
    	DOMConfigurator.configure("log4j.xml");
	pr=new ProfilesIni();
	fp=pr.getProfile("mounikafirefox");
	driver=new FirefoxDriver(fp);
	log.info("succ browser opened");
	driver.get("http://www.hdnicewallpapers.com/Wallpaper-Download/Cute-Baby/Cute-Baby-Boy-in-Winter-Cap-Wallpaper");
	log.info("success page navigated");
}
@Test
public void robot() throws AWTException, InterruptedException{
	driver.findElement(By.xpath("//*[@id='DL']/div")).click();
	Robot rb=new Robot();
	Thread.sleep(3000);
	rb.keyPress(KeyEvent.VK_DOWN);
	log.info("succes cursor moved to down");
	Thread.sleep(3000);
    rb.keyPress(KeyEvent.VK_ENTER);
   log.info("success cursor clicked enter");
}	
}