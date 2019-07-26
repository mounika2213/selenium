package modulardrivenframework;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReusableMethodsnewtours {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	@BeforeTest
	public void open(){
		pr=new ProfilesIni();
		fp=pr.getProfile("mounikafirefox");
		driver=new FirefoxDriver(fp);
		driver.get("http://newtours.demoaut.com/");
	}
	@Test
	public void registerLink(){
		driver.findElement(By.linkText("REGISTER")).click();
	}
	@Test(priority=1)
	public void registerPage(String f,String l,String pho,String email,String addr,String city,String state,String coun,String pos,String usr,String psw,String cpsw){
		driver.findElement(By.name("firstName")).sendKeys(f);
		driver.findElement(By.name("lastName")).sendKeys(l);
		driver.findElement(By.name("phone")).sendKeys(pho);
		driver.findElement(By.name("userName")).sendKeys(email);
		driver.findElement(By.name("address1")).sendKeys(addr);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("state")).sendKeys(state);
		driver.findElement(By.name("postalCode")).sendKeys(pos);
		driver.findElement(By.name("country")).sendKeys(coun);
	    driver.findElement(By.name("email")).sendKeys(usr);
		driver.findElement(By.name("password")).sendKeys(psw);
		driver.findElement(By.name("confirmPassword")).sendKeys(cpsw);
		driver.findElement(By.name("register")).click();
		
		
	}
	@AfterTest
	public void close(){
		driver.close();
	}
	

}
