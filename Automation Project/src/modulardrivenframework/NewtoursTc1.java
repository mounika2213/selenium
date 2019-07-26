package modulardrivenframework;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class NewtoursTc1 {
	ReusableMethodsnewtours obj;
	FirefoxDriver driver;
	@Test
	public void tcLogin() throws InterruptedException{
		obj=new ReusableMethodsnewtours();
		obj.open();
		obj.registerLink();
		obj.registerPage("mouni", "tester", "9874561230t", "abc@gmail.com", "hyd", "hyde", "tg","518222t" ,"India", "Qa123", "Qa", "Qa");
		Thread.sleep(3000);
		String actual=driver.findElement(By.cssSelector("td:nth-child(1) p:nth-child(3) a:nth-child(1) font:nth-child(1) > b:nth-child(1)")).getText();
		String expected="Qa123";
		if(actual.contains(expected)){
			System.out.println("success");
		}
		else{
			System.out.println("fail");
			obj.close();
		}
		
	}

}
