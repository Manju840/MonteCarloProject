package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(Listener.class)
public class BaseClass {
	
	public static WebDriver driver;
	public DataUtilities dataUtilities = new DataUtilities();
	public WebDriverUtilities webUtilities = new WebDriverUtilities();
	
	@BeforeMethod
	public void opeApp() throws EncryptedDocumentException, IOException {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(dataUtilities.readingDataFromExcel("Sheet1", 1, 0));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@AfterMethod
	public void closeApp(){
		driver.quit();
	}

}
