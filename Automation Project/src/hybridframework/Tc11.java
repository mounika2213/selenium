package hybridframework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;


import modulardrivenframework.ReusableMethodsHrm;

public class Tc11 {
	ProfilesIni pr;
	FirefoxProfile fp;
	FirefoxDriver driver;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet ws;
	FileOutputStream fos;
	ReusableMethodsHrm obj;
	Screenshot ss;
	@Test
	public void login() throws IOException{
		obj=new ReusableMethodsHrm();
		ss=new Screenshot();
		obj.open();
	    ss.capture123(driver, "C:\\Users\\Lenovo pc\\Pictures\\Screenshots\\hybrid.png");
		fis=new FileInputStream("C:\\Users\\Lenovo pc\\Desktop\\sample2.xlsx");
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet("sheet2");
		Row r;
		int rowc=ws.getLastRowNum();
		System.out.println(rowc);
		for(int i=0;i<=rowc;i++){
			r=ws.getRow(i);
			obj.login(r.getCell(0).getStringCellValue(), r.getCell(1).getStringCellValue());
			String Expected=r.getCell(2).getStringCellValue();
			String Actual=driver.getCurrentUrl();
			r.createCell(3).setCellValue(Actual);
			if(Expected.equals(Actual)){
				r.createCell(4).setCellValue("pass");
			}
			else{
				r.createCell(4).setCellValue("fail");
			}
			driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
			fos=new FileOutputStream("C:\\Users\\Lenovo pc\\Desktop\\sample2.xlsx");
			wb.write(fos);
	}

}
}
