package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtilities {
	
	public String readingDataFromProperty(String data) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(AutoConstant.propertyFilePath));
		return properties.getProperty(data);
	}
	
	public String readingDataFromExcel(String sheetName, int rowNumber, int cellNumber) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(AutoConstant.excelFilePath);
		Workbook wb =WorkbookFactory.create(fis);
		return wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
	}
	
	public String readDataFromPropertyFile(String key) throws FileNotFoundException, IOException {
		Properties property = new Properties();
		property.load(new FileInputStream("./montecarlodata.properties"));
		return property.getProperty(key);
		
	}

}
