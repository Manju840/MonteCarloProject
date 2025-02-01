package testlibraries;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import pom.AccountPage;
import pom.Header;
import pom.LoginPage;
import pom.NavBar;
import pom.ProductDetails;
import pom.ProductPage;

public class TC_04_InitiateCheckout extends BaseClass {
	
	@Test
	public void tc_04_initiateCheckout() throws EncryptedDocumentException, IOException, InterruptedException {
		Header header = new Header(driver);
		header.clickLoginSignupButton();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(dataUtilities.readingDataFromExcel("Sheet1", 1, 1));
		loginPage.enterPassword(dataUtilities.readingDataFromExcel("Sheet1", 1, 2));
		loginPage.clickLogin();
		
		AccountPage accPage = new AccountPage(driver);
		String AccountPageTitile = accPage.getTitle(driver);
		
		Assert.assertEquals(dataUtilities.readingDataFromExcel("PageTitles", 1, 1), AccountPageTitile );
		
		NavBar navbar = new NavBar(driver);
		WebElement womensSection = navbar.getWoMensSection();
		webUtilities.mouseHover(womensSection, driver);
		navbar.clickWomenImage();
		
		ProductPage productpage = new ProductPage(driver);
		productpage.clickOnProduct();
		
		ProductDetails productDetails = new ProductDetails(driver);
		productDetails.clickProductDetailSize();
		
		if(productDetails.getQuantity().isDisplayed()) {
			productDetails.clickPlus();
		}
		
		
	}

}
