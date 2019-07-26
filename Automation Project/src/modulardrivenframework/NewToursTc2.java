package modulardrivenframework;


import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class NewToursTc2 {
	ReusableMethodsnewtours obj;
	FirefoxDriver driver;
	@Test
	public void tcLogin() throws InterruptedException{
		obj=new ReusableMethodsnewtours();
		obj.open();
		String actual=driver.findElement(By.xpath("//b[contains(text(),'Note: Your user name is Qa123.')]")).getTagName();
		String expected="a";
		if(actual.equals(expected)){
			obj.registerLink();
			String title=driver.getTitle();
			if(title.contains("Register")){
				System.out.println("pass");
			}
			else{
				System.out.println("fail");
			}
			
		}
		else{
			System.out.println("fail");
		}
		

}
}
