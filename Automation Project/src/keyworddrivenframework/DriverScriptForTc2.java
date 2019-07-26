package keyworddrivenframework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DriverScriptForTc2 {
	@Test
	public void Tc1login() throws IOException,FileNotFoundException, InterruptedException{
		OrangeHrmKeywordOperations key1=new OrangeHrmKeywordOperations();
		FileInputStream fis=new FileInputStream("C:\\Users\\Lenovo pc\\Desktop\\sample3.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheet("sheet3");
		Row r;
		int rowc=ws.getLastRowNum();
		for(int i=1;i<=rowc;i++){
			r=ws.getRow(i);
			String rumnode=r.getCell(4).getStringCellValue();
			if(rumnode.equals("Y")){
				String keyword=r.getCell(3).getStringCellValue();
				if(keyword.equals("launchBrowser")){
					key1.launchBrowser();
					}
				else if(keyword.equals("login")){
					key1.login();
				}
				else if(keyword.equals("addUser")){
					key1.addUser();
				}
				else if(keyword.equals("deleteUser")){
					key1.deleteUser();
				}
				else if(keyword.equals("employeeList")){
					key1.employeeList();
				}
				else if(keyword.equals("logout")){
					key1.logout();
				}
				else if(keyword.equals("closeBrowser")){
					key1.closeBrowser();
				}
			}
		}
	}
}
