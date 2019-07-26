/*  open browse navigate nbc.ca.com
 * go to mortgage
 * select mortgage insurance
 * and click on eligible for the mortgage loan insurance offer
 *verify whether text is present or not*/
 
package realtimetask;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tc4 {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	@BeforeTest
	public void open(){
		pr=new ProfilesIni();
		fp=pr.getProfile("mounikafirefox");
		driver=new FirefoxDriver(fp);
		driver.get("https://www.nbc.ca/personal/mastercard-credit-cards/my-credit.html");
	}
	@Test
	public void data() throws InterruptedException,ElementNotVisibleException{
		WebElement mortage=driver.findElement(By.xpath("//*[@id='3']"));
		Actions ac=new Actions(driver);
		ac.moveToElement(mortage).build().perform();
		Thread.sleep(3000);
		WebElement insurance=driver.findElement(By.linkText("Mortgage insurance"));
		insurance.click();
		WebElement mort=driver.findElement(By.xpath("//p[contains(text(),'Eligibility for the mortgage loan insurance offer')]"));
		mort.click();
		Thread.sleep(3000);
		WebElement text=driver.findElement(By.xpath("/html/body/div[5]/div/div[5]/div[2]/div/div/div[3]/div/div[2]"));
		if(text.isDisplayed()){
			System.out.println("text is displayed");
		}
		else{
			System.out.println("fail");
		}
		
		
		
		
	}

}

