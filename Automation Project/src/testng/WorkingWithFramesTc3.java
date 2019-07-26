package testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithFramesTc3 {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	@BeforeTest
	public void open(){
		pr=new ProfilesIni();
		fp=pr.getProfile("mounikafirefox");
		driver=new FirefoxDriver();
		driver.get("http://www.angelfire.com/super/badwebs/");
	}
	@Test
	public void data123(){
		List<WebElement>frames=driver.findElements(By.tagName("frames"));
		for(int i=0;i<frames.size();i++){
			driver.switchTo().frame(i);
			try{
			
				driver.findElement(By.xpath("/html/body/p[5]/b/a/font")).click();
				break;
			
		}
			catch(Exception e){
			System.out.println(e);
		}
			driver.switchTo().defaultContent();
	}
	}
}

