package testng;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithAutoItTc2 {
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
	public void robot() throws InterruptedException, IOException {
		driver.findElement(By.linkText("3.141.59")).click();
		Thread.sleep(3000);
		java.lang.Runtime.getRuntime().exec("C:\\Users\\Lenovo pc\\Desktop\\autoit file1.exe");
		

}
}
