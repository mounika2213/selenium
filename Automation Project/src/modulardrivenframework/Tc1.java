package modulardrivenframework;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Tc1 {
	ReusableMethodsHrm obj;
	FirefoxDriver driver;
	@Test
	public void tc1Login(){
		obj=new ReusableMethodsHrm();
		obj.open();
		obj.login("Admin", "admin123");
		obj.verifyStatus();
		obj.logout();
		obj.close();
	}

}
