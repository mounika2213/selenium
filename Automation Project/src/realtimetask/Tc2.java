/*open browser navigate to dawn.com
 * search for fathima text
 * if text is there capture text else test case fail
 */
package realtimetask;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tc2 {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	@BeforeTest
	public void open(){
		pr=new ProfilesIni();
		fp=pr.getProfile("mounikafirefox");
		driver=new FirefoxDriver(fp);
		driver.get("https://www.dawn.com/");

}
	@Test
	public void fathima() throws IOException{
		List<WebElement>text=driver.findElements(By.tagName("body"));
		if(text.contains("fathima")){
			System.out.println("pass");
			}
		else{
			File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils. copyFile(srcfile,new File("C:\\Users\\Lenovo pc\\Pictures\\Screenshots\\fathima.png"));
			
			
		}
		
	}
	
	}

