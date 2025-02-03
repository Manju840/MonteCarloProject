package testlibraries;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import pom.AccountPage;
import pom.Header;
import pom.LoginPage;
import pom.MonteCarloHomeLogoPage;
import pom.ProductDetails;
import pom.ProductPage;
import pom.StorePage;

public class TC_05_ManufactureAddress extends BaseClass{
	
	
	
	@Test
	public void tc_05_ManufactureAdd() throws EncryptedDocumentException, IOException, InterruptedException {
		
		Header header = new Header(driver);
		header.clickLoginSignupButton();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(dataUtilities.readingDataFromExcel("Sheet1", 1, 1));
		loginPage.enterPassword(dataUtilities.readingDataFromExcel("Sheet1", 1, 2));
		loginPage.clickLogin();
		
		AccountPage accPage = new AccountPage(driver);
		String AccountPageTitile = accPage.getTitle(driver);
		Assert.assertEquals(dataUtilities.readingDataFromExcel("PageTitles", 1, 1), AccountPageTitile );
		
		header.clicHomeMonteCarloLogo();
		
		MonteCarloHomeLogoPage homeLogo = new MonteCarloHomeLogoPage(driver);
		homeLogo.clickShoBlanket();
		
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnProduct();
		
		ProductDetails productDetails = new ProductDetails(driver);
		productDetails.clickProdDesc();
		Thread.sleep(1000);
		String address = productDetails.getManFacAddress();
		System.out.println("addressText"+address);
		String pincode = extractPinCode(address);
		System.out.println("pincode"+pincode);
		productDetails.clickOurStore();
		
		StorePage storePage = new StorePage(driver);
		storePage.sendZip(pincode);
		storePage.clickGetDirButton();
	}
	
	public static String extractPinCode(String address) {
		String[] parts = address.split("[,\\s-]+");
		for (String part : parts) {
			if (part.length() == 6 && part.matches("\\d{6}")) {
				return part;
			}
		}
		return "Pincode not found";
	}

}
