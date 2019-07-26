package keyworddrivenframework;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class OrangeHrmKeyword {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	public void launchBrowser(){
		pr=new ProfilesIni();
		fp=pr.getProfile("mounikafirefox");
		driver=new FirefoxDriver(fp);
	}
	public void navigate(){
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
		}
	public void enterUsername(){
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		}
	public void enterPassword(){
		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("admin123");
		
	}
	public void login(){
		driver.findElement(By.id("btnLogin")).click();
	}

}
