import java.io.FileInputStream;  
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class Program 
{
	public static void main(String[] args) throws IOException 
	{
		FileInputStream file = new FileInputStream("C:/Users/annap/Desktop/vzorek_dat.xlsx");
		Workbook wb = new XSSFWorkbook(file);	
		PrimeNumber prime = new PrimeNumber();
		boolean flag=false;
		System.out.println("Prime numbers from the file: \n");
		Map<Integer, List<String>> data = new HashMap<>();
		int i = 0;
		for (Row row : wb.getSheetAt(0)) {
		    data.put(i, new ArrayList<String>());
		    for (Cell cell : row) {
		      
		    	if(cell.getStringCellValue() != "" && i > 0) 
		    	{
		         	flag = prime.checkNum(Integer.parseInt(cell.getStringCellValue()));
		         	if(flag == true)
		         	System.out.println(Integer.parseInt(cell.getStringCellValue()));
		        }		        
		    }
		    i++;
		}
		
		file.close();
		wb.close();
	}
}
