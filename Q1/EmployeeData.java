package PROJECT_SAMPLE;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class EmployeeData {

	
		@Test
	    public void readExcel() throws IOException{

	   

	    File file =    new File("C:\\Users\\HOME\\Downloads\\Comprehensive Ass\\Q1\\EmpData.xlsx");

	   

	    FileInputStream inputStream = new FileInputStream(file);

	    Workbook  workbook = new XSSFWorkbook(inputStream);  

	    Sheet sheet = workbook.getSheet("Sheet1");

	   

	    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

	   

	    for (int i = 0; i < rowCount+1; i++) {

	        Row row = sheet.getRow(i);

	        

	        for (int j = 0; j < row.getLastCellNum(); j++) {

	           

	            System.out.print(row.getCell(j).toString()+"   ") ;

	        }

	        System.out.println();
	    } 

	    }  

	   

}


