package testng;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithAutoItTc3 {
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
	public void robot() throws InterruptedException, IOException {
		
		Sleeper.sleepTightInSeconds(3);
		driver.findElement(By.id("computer_icone_name")).click();
		Sleeper.sleepTightInSeconds(3);
		driver.findElement(By.id("button_desktop")).click();
		Thread.sleep(3000);
		java.lang.Runtime.getRuntime().exec("C:\\Users\\Lenovo pc\\Desktop\\autoitfile3.exe");

}
}
