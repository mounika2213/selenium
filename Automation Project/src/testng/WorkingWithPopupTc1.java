package testng;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithPopupTc1 {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	@BeforeTest
	public void open(){
		pr=new ProfilesIni();
		fp=pr.getProfile("mounikafirefox");
		driver=new FirefoxDriver();
		driver.get("https://www.rediff.com/");
	}
	@Test
	public void data(){
		String parent=driver.getWindowHandle();
		Set<String>pops=driver.getWindowHandles();
		Iterator<String>it=pops.iterator();
		while (it.hasNext()) {
			String popUpHandle=it.next().toString();
			if (!popUpHandle.contains(parent)) {
				driver.switchTo().window(popUpHandle);
				Sleeper.sleepTightInSeconds(3);
				driver.close();
				
			}
			
		}
			
		}
	}


