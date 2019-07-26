package testng;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithJavaScriptTc1 {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	@BeforeTest
	public void open(){
		pr=new ProfilesIni();
		fp=pr.getProfile("mounikafirefox");
		driver=new FirefoxDriver();
		driver.get("https://www.gmail.com/");
	}
	@Test
	public void login(){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("document.getElementById(id='identifierId').value='mounireddy.7416'");
		 js.executeScript("document.getElementByXpath(//*[@id='identifierNext']/span/span).click()");
         js.executeScript("document.getElementByName('password').value='7416371713'");
		 js.executeScript("document.getElementByXpath('//*[@id='passwordNext']/span/span').Click()");
	}
	}


