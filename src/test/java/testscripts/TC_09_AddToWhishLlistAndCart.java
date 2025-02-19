package testscripts;

import java.io.IOException;
import java.util.Collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import pom.AccountPage;
import pom.CartDrawer;
import pom.CollectionsPage;
import pom.Header;
import pom.LoginPage;
import pom.NavBar;
import pom.ProductDetails;

public class TC_09_AddToWhishLlistAndCart extends BaseClass {

	static Logger logger = LogManager.getLogger(TC_09_AddToWhishLlistAndCart.class);

	@Test
	public void tc_09_addToCart() throws EncryptedDocumentException, IOException, InterruptedException {

		logger.info("Starting test case: tc_09_addToCart");

		Header header = new Header(driver);
		logger.info("Clicking on Login/Signup button");
		header.clickLoginSignupButton();

		LoginPage loginPage = new LoginPage(driver);
		logger.info("Entering email");
		loginPage.enterEmail(dataUtilities.readingDataFromExcel("Sheet1", 1, 1));
		logger.info("Entering password");
		loginPage.enterPassword(dataUtilities.readingDataFromExcel("Sheet1", 1, 2));
		logger.info("Clicking login button");
		loginPage.clickLogin();

		AccountPage accPage = new AccountPage(driver);
		String accountPageTitle = accPage.getTitle(driver);
		logger.info("Verifying account page title");
		Assert.assertEquals(dataUtilities.readingDataFromExcel("PageTitles", 1, 1), accountPageTitle);

		CartDrawer cartDrawer = new CartDrawer(driver);
		NavBar navBar = new NavBar(driver);
		logger.info("Clicking on cart button");
		navBar.clickCartButton();
		logger.info("Getting empty cart text");
		cartDrawer.getEmptyCartText();
		logger.info("Starting shopping");
		cartDrawer.startShopping();

		CollectionsPage collections = new CollectionsPage(driver);
		logger.info("Clicking sort by button");
		collections.clickSortbyButton();
		logger.info("Selecting date low to high");
		collections.selectDateLowTHigh();
		logger.info("Clicking on second product");
		collections.clickSeconProduct();

		ProductDetails productDetails = new ProductDetails(driver);
		logger.info("Clicking add to cart button");
		productDetails.clickAddToCart();

		logger.info("Test case tc_09_addToCart completed successfully");

	}

}
