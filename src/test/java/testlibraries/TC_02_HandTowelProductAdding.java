package testlibraries;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import pom.RightSlidingCardPage;
import pom.WhishListPage;

public class TC_02_HandTowelProductAdding extends BaseClass{
	
	static Logger logger = LogManager.getLogger(TC_02_HandTowelProductAdding.class);

	@Test
	public void tc_02_addHandTowl() throws EncryptedDocumentException, IOException, InterruptedException {
		
		logger.info("addTowel test case started");
		Header header = new Header(driver);
		logger.info("clicking login/signup button");
		header.clickLoginSignupButton();
		logger.info("clicked login/signup button");
		
		LoginPage loginPage = new LoginPage(driver);
		logger.info("entering email");
		loginPage.enterEmail(dataUtilities.readingDataFromExcel("Sheet1", 1, 1));
		logger.info("email entered");
		logger.info("enntering password");
		loginPage.enterPassword(dataUtilities.readingDataFromExcel("Sheet1", 1, 2));
		logger.info("entered password");
		loginPage.clickLogin();
		AccountPage accPage = new AccountPage(driver);
		logger.info("getting account page title");
		String AccountPageTitile = accPage.getTitle(driver);
		logger.info("verifying the account page title");
		Assert.assertEquals(dataUtilities.readingDataFromExcel("PageTitles", 1, 1), AccountPageTitile );
		
		NavBar navBar = new NavBar(driver);
		navBar.clickSearchBar();
		
		RightSlidingCardPage rightSlidingCardPage = new RightSlidingCardPage(driver);
		rightSlidingCardPage.sendKeysSearch(dataUtilities.readingDataFromProperty("searchItem"));
		rightSlidingCardPage.searchTowel();
		
		ProductDetails productDetails = new ProductDetails(driver);
		productDetails.clickWishListProduct();
		
		header.clickWishListButton();
		
		WhishListPage wishListPage = new WhishListPage(driver);
		WebElement wishListedItem = wishListPage.getFirstWishElement();
		webUtilities.waitForElementToBeVisible(wishListedItem);
		webUtilities.mouseHover(wishListedItem, driver);
		wishListPage.clickFirstCloseButton();
	}
}
