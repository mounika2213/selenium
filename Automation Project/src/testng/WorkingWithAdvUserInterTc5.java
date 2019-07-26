package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithAdvUserInterTc5 {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	@BeforeTest
	public void open(){
		pr=new ProfilesIni();
		fp=pr.getProfile("mounikafirefox");
		driver=new FirefoxDriver();
		driver.get("https://jqueryui.com/slider/");
	}
	@Test
	public void data(){
		driver.switchTo().frame(0);
		WebElement slider=driver.findElement(By.id("slider"));
		Actions ac=new Actions(driver);
		int loc=slider.getLocation().x;
		ac.dragAndDropBy(slider,30,loc ).build().perform();
	}

}
