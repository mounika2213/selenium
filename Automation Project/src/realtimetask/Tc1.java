/*open browser navigate to nbk.com
//mouse move to finacial institutions
//click on cash management
//verify account services text present or not*/
/*open browser navigate to nbk.com
//mouse move to finacial institutions
//click on cash management
//verify account services text present or not*/
package realtimetask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tc1 {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	@BeforeTest
	public void open(){
		pr=new ProfilesIni();
		fp=pr.getProfile("mounikafirefox");
		driver=new FirefoxDriver(fp);
		driver.get("https://www.nbp.com.pk/");
	
	/*ChromeDriver driver;
	@BeforeTest
	public void open(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo pc\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");*/
	}
	@Test
	public void data() throws InterruptedException{
		Thread.sleep(3000);
		WebElement finacial=driver.findElement(By.xpath("//*[@id='stUI112_txt']"));
		Actions ac=new Actions(driver);
		ac.moveToElement(finacial).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='stUI116_cnt']")).click();
		Thread.sleep(3000);
		//String actual=driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr/td[2]/table[2]/tbody/tr/td/table/tbody/tr[2]/td[2]/p/strong")).getText();
		//String expected="Account Services";
		/*if(actual.contains(expected)){
			System.out.println("pass");
		}
		else{
			System.out.println("fail");
		}*/
		WebElement text=driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr/td[2]/table[2]/tbody/tr/td/table/tbody/tr[2]/td[2]/p/strong"));
		if(text.isDisplayed()){
			System.out.println("pass");
		}
		else{
			System.out.println("fail");
		}
		
	}
}