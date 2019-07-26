package modulardrivenframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.Test;

public class Tc2 {
	ReusableMethodsHrm obj;
	FirefoxDriver driver;
	@Test
	public void loginTc2()throws NullPointerException, InterruptedException{
		obj=new ReusableMethodsHrm();
		obj.open();
		obj.login("Admin", "admin123");
		obj.verifyStatus();
		Thread.sleep(3000);
		//WebElement pim=driver.findElement(By.cssSelector("div.menu:nth-child(2) ul:nth-child(1) li:nth-child(2) a.firstLevelMenu:nth-child(1) > b:nth-child(1)"));
	   // Actions ac=new Actions(driver);
	   //ac.moveToElement(pim).build().perform();
		driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']/b")).click();
		Sleeper.sleepTightInSeconds(3);
		driver.findElement(By.linkText("Add Employee")).click();
		Sleeper.sleepTightInSeconds(3);

		driver.findElement(By.id("middleName")).sendKeys("QA");
		driver.findElement(By.id("lastName")).sendKeys("testing");
		driver.findElement(By.id("employeeId")).sendKeys("0036t");
		driver.findElement(By.id("btnSave")).click();
		Sleeper.sleepTightInSeconds(3);
		String actual=driver.findElement(By.xpath("//*[@id='profile-pic']/h1")).getText();
		String expected="Tester QA testing";
		if(actual.contains(expected)){
			System.out.println("pass");
		}
		else{
			System.out.println("fail");
		}
		obj.logout();
		obj.close();
	

		
	
		
		
		
	}

}
