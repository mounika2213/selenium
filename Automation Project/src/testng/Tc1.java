package testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tc1 {
	FirefoxDriver driver;
	@BeforeTest
	public void open(){
		driver=new FirefoxDriver();
		driver.get("http://www.flipkart.com");
		
		
	}
	@Test
	public void data(){
		List<WebElement>links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
	}

}
