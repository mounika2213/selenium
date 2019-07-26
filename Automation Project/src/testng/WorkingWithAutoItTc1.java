package testng;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithAutoItTc1 {
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
	public void robot() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//*[@id='DL']/div")).click();
		Thread.sleep(3000);
		java.lang.Runtime.getRuntime().exec("E:\\autoit file.exe");
		

}
}
