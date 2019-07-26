package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithadvUserInterTc2 {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	@BeforeTest
	public void open(){
		pr=new ProfilesIni();
		fp=pr.getProfile("mounikafirefox");
		driver=new FirefoxDriver();
		driver.get("https://www.mercurytravels.co.in/");
	}
	@Test
	public void mouseMove(){
		WebElement mouse=driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[10]/a"));
		Actions ac=new Actions(driver);
		ac.moveToElement(mouse).build().perform();
		driver.findElement(By.linkText("Careers")).click();
	}

}
