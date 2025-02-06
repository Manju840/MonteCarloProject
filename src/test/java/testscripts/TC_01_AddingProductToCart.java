package testscripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import pom.AccountPage;
import pom.Header;
import pom.LoginPage;
import pom.NavBar;
import pom.ProductDetails;
import pom.ProductPage;
import pom.WhishListPage;

public class TC_01_AddingProductToCart extends BaseClass{
	
	static Logger logger = LogManager.getLogger(TC_01_AddingProductToCart.class);

	@Test
	public void verifyAddToWhishlistAndCart() throws Exception {
		logger.info("Test case verifyAddToWhishlistAndCart started");

        try {
            Header header = new Header(driver);
            header.clickLoginSignupButton();
            logger.info("Clicked on Login/Signup button");

            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterEmail(dataUtilities.readingDataFromExcel("Sheet1", 1, 1));
            logger.debug("Entered email: " + dataUtilities.readingDataFromExcel("Sheet1", 1, 1));
            loginPage.enterPassword(dataUtilities.readingDataFromExcel("Sheet1", 1, 2));
            logger.debug("Entered password");
            loginPage.clickLogin();
            logger.info("Clicked on Login button");

            AccountPage accPage = new AccountPage(driver);
            String AccountPageTitile = accPage.getTitle(driver);
            logger.info("Navigated to Account Page");

            Assert.assertEquals(dataUtilities.readingDataFromExcel("PageTitles", 1, 1), AccountPageTitile);
            logger.info("Verified Account Page title");

            NavBar navbar = new NavBar(driver);
            WebElement homeFur = navbar.getHomeFurnishing();
            webUtilities.mouseHover(homeFur, driver);
            logger.info("Hovered over Home Furnishing");
            
            webUtilities.waitForElementToBeClickable(navbar.getAcComforter());
            navbar.clicAcComforter();
            logger.info("Clicked on AC Comforter");

            ProductPage productpage = new ProductPage(driver);
            productpage.clickSize();
            logger.info("Clicked on Size filter");
            productpage.selectSize();
            logger.debug("Selected Size");
            productpage.clickColor();
            logger.info("Clicked on Color filter");
            webUtilities.waitForElementToBeVisible(productpage.getColorOption());
            productpage.selectColor();
            logger.debug("Selected Color");
            productpage.clickBrand();
            logger.info("Clicked on Brand filter");
            productpage.selectBrand();
            logger.debug("Selected Brand");
            productpage.clickAvailability();
            logger.info("Clicked on Availability filter");
            productpage.selectAvailability(webUtilities);
            logger.debug("Selected Availability");
            try {
            productpage.clickOnProduct(webUtilities);
            }catch(Exception e) {
            	productpage.clickOnProduct(webUtilities);

            }
            logger.info("Clicked on a product");

            ProductDetails productDetails = new ProductDetails(driver);
            String wishListingItemTitle = productDetails.getWishListedItemTitle().getText();
            logger.debug("Got wishlisted item title: " + wishListingItemTitle);
            productDetails.clickWishListProduct();
            logger.info("Clicked on Wish List Product");

            header.clickWishListButton();
            logger.info("Clicked on Wish List button");

            WhishListPage wish = new WhishListPage(driver);
            String wishListPageTitle = wish.getTitle(driver);
            Assert.assertEquals(dataUtilities.readingDataFromExcel("PageTitles", 1, 0), wishListPageTitle);
            logger.info("Verified Wish List Page title");
            String wishListedText = wish.getWishListItem().getText();
            logger.debug("wishListedText"+wishListedText);
            SoftAssert sAssert = new SoftAssert();
            sAssert.assertEquals(wishListingItemTitle, wishListedText);
            logger.info("Verified wishlisted item text");
            wish.clickAddToCart();
            logger.info("Clicked on Add to Cart");
            sAssert.assertAll();
            

        } catch (Exception e) {
            logger.error("An error occurred: ", e);
            throw e;
        }

        logger.info("Test case verifyAddToWhishlistAndCart completed");
		
		
	}

}
