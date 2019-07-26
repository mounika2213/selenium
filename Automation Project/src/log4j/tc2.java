package log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class tc2 {
	private static Logger log=Logger.getLogger(tc2.class);
	public static void main(String[] args) {
		DOMConfigurator.configure("log4j(2).xml");
		ProfilesIni pr=new ProfilesIni();
		FirefoxProfile fp=pr.getProfile("mounikafirefox");
		log.info("profile created");
		FirefoxDriver driver=new FirefoxDriver(fp);
		log.info("success browse opened");
		driver.get("http://www.google.com");
		log.info("succs page navigated");
		 

	}

}
