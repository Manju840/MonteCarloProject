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

public class TC_03_VerifyPincode extends BaseClass {

	@Test
	public void tc_03_VerifyPincode() throws EncryptedDocumentException, IOException, InterruptedException {
		

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
	WebElement mensSection = navbar.getMensSection();
	webUtilities.mouseHover(mensSection, driver);
	navbar.clickRoundNeckSweaters();
	
	ProductPage productpage = new ProductPage(driver);
	productpage.clickSize();
	productpage.selectSIze_38_M();
	productpage.clickBrand();
	webUtilities.waitForElementToBeClickable(productpage.getRockItBrandOption());
	productpage.selectRockItBrandOption();
	productpage.clickSleeve();
	productpage.selectFullSleeve();
	Thread.sleep(3000);
	productpage.clickFullSleeveThirdProduct();
	
	ProductDetails productDetails = new ProductDetails(driver);
	productDetails.enterPincode(dataUtilities.readingDataFromExcel("InputParameters", 0, 2));
	productDetails.clickCheckPincode();	
	}
}
