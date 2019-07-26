/*open browser navigate to national bank of Canada
 * go to credit cards
 * click on my credit
 * and getdata from all rows and all columns(webtable)
 */
package realtimetask;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tc3 {
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
	public void data() throws InterruptedException{
		WebElement credit=driver.findElement(By.xpath("//*[@id='1']"));
		Actions ac=new Actions(driver);
		ac.moveToElement(credit).build().perform();
		Thread.sleep(3000);
		WebElement mycredit=driver.findElement(By.linkText("mycredit"));
		mycredit.click();
		Thread.sleep(3000);
		//List<WebElement>tables=driver.findElements(By.tagName("table"));
		//System.out.println("no of tables are"+tables.size());
		WebElement table=driver.findElement(By.xpath("//*[@id='TableStatic-1']/div"));
		List<WebElement>nrows=table.findElements(By.tagName("tr"));
		for(int i=0;i<nrows.size();i++){
			List<WebElement>ncolumns=nrows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<ncolumns.size();j++){
				System.out.print(ncolumns.get(j).getText()+"");
			}
			System.out.println();
		}
		
		
				
	}

}
