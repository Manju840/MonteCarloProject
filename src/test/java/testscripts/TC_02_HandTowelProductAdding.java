package testscripts;

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
        logger.info("entering password");
        loginPage.enterPassword(dataUtilities.readingDataFromExcel("Sheet1", 1, 2));
        logger.info("entered password");
        loginPage.clickLogin();
        logger.info("clicked login button");
        
        AccountPage accPage = new AccountPage(driver);
        logger.info("getting account page title");
        String AccountPageTitle = accPage.getTitle(driver);
        logger.info("verifying the account page title");
        Assert.assertEquals(dataUtilities.readingDataFromExcel("PageTitles", 1, 1), AccountPageTitle);
        logger.info("account page title verified");
        
        NavBar navBar = new NavBar(driver);
        logger.info("clicking search bar");
        navBar.clickSearchBar();
        logger.info("clicked search bar");
        
        RightSlidingCardPage rightSlidingCardPage = new RightSlidingCardPage(driver);
        logger.info("entering search item");
        rightSlidingCardPage.sendKeysSearch(dataUtilities.readingDataFromProperty("searchItem"));
        logger.info("search item entered");
        logger.info("searching for towel");
        rightSlidingCardPage.searchTowel();
        logger.info("searched for towel");
        
        ProductDetails productDetails = new ProductDetails(driver);
        logger.info("clicking wishlist product");
        productDetails.clickWishListProduct();
        logger.info("clicked wishlist product");
        
        logger.info("clicking wishlist button");
        header.clickWishListButton();
        logger.info("clicked wishlist button");
        
        WhishListPage wishListPage = new WhishListPage(driver);
        logger.info("getting first wishlist element");
        WebElement wishListedItem = wishListPage.getFirstWishElement();
        logger.info("waiting for element to be visible");
        webUtilities.waitForElementToBeVisible(wishListedItem);
        logger.info("element is visible");
        logger.info("hovering over wishlist item");
        webUtilities.mouseHover(wishListedItem, driver);
        logger.info("hovered over wishlist item");
        logger.info("clicking close button on wishlist item");
        wishListPage.clickFirstCloseButton();
        logger.info("clicked close button on wishlist item");
	}
}
