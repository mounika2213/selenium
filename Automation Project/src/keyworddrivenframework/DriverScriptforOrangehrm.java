package keyworddrivenframework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DriverScriptforOrangehrm {
	@Test
	public void Tc1login() throws IOException,FileNotFoundException{
		OrangeHrmKeyword key=new OrangeHrmKeyword();
		FileInputStream fis=new FileInputStream("C:\\Users\\Lenovo pc\\Desktop\\sample3.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheet("sheet2");
		Row r;
		int rowc=ws.getLastRowNum();
		for(int i=1;i<=rowc;i++){
			r=ws.getRow(i);
			String rumnode=r.getCell(4).getStringCellValue();
			if(rumnode.equals("Y")){
				String keyword=r.getCell(3).getStringCellValue();
				if(keyword.equals("launchBrowser")){
					key.launchBrowser();
				}
				else if(keyword.equals("navigate")){
					key.navigate();
				}
				else if(keyword.equals("enterUsername")){
					key.enterUsername();
				}
				else if(keyword.equals("enterPassword")){
					key.enterPassword();
				}
				else if(keyword.equals("login")){
					key.login();
				}
				
			}
		}
		
		
			
		}
	}


