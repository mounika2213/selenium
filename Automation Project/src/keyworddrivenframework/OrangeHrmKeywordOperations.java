package keyworddrivenframework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class OrangeHrmKeywordOperations {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	public void launchBrowser(){
	pr=new ProfilesIni();
	fp=pr.getProfile("mounikafirefox");
	driver=new FirefoxDriver(fp);
	driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
	}
	public void login(){
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		}
	public void addUser() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']/b")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Add Employee")).click();
		driver.findElement(By.id("firstName")).sendKeys("tester");
		driver.findElement(By.id("middleName")).sendKeys("qa");
		driver.findElement(By.id("lastName")).sendKeys("testing");
		driver.findElement(By.id("employeeId")).sendKeys("0039t");
		driver.findElement(By.id("btnSave")).click();
		}
	public void deleteUser() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("ohrmList_chkSelectRecord_18")).click();
		driver.findElement(By.id("btnDelete")).click();
		//Thread.sleep(3000);
		//driver.switchTo().alert().accept();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		}
	public void employeeList() throws InterruptedException{
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		Thread.sleep(3000);
		WebElement table=driver.findElement(By.id("frmList_ohrmListComponent"));
		List<WebElement>nrows=table.findElements(By.tagName("tr"));
		for(int i=0;i<nrows.size();i++){
			List<WebElement>ncols=nrows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<ncols.size();j++){
				System.out.print(ncols.get(j).getText());
			}
			System.out.println();
			
		}
	}
		public void logout(){
			driver.findElement(By.linkText("Welcome Admin")).click();
			driver.findElement(By.linkText("Logout")).click();
		}
		public void closeBrowser(){
			driver.close();
		
	}
	


}
