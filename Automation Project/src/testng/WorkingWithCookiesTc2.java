package testng;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithCookiesTc2 {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	@BeforeTest
	public void open(){
		pr=new ProfilesIni();
		fp=pr.getProfile("mounikafirefox");
		driver=new FirefoxDriver();
		driver.get("https://www.mirror.co.uk/");
	}
	@Test
	public void cookieCount(){
		Set<Cookie>nCookie=driver.manage().getCookies();
		System.out.println(nCookie.size());
		driver.manage().deleteAllCookies();
		nCookie=driver.manage().getCookies();
		System.out.println(nCookie.size());
		
	}

}
