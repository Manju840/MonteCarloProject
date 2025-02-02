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
import pom.CartDrawer;
import pom.Header;
import pom.LoginPage;
import pom.NavBar;
import pom.ProductDetails;
import pom.ProductPage;
import pom.SearchDrawer;
import pom.SearchedProductsPage;

public class TC_04_InitiateCheckout extends BaseClass {
	
	static Logger logger = LogManager.getLogger(TC_01_AddingProductToCart.class);
	
	@Test
	public void tc_04_initiateCheckout() throws EncryptedDocumentException, IOException, InterruptedException {
//		Header header = new Header(driver);
//		header.clickLoginSignupButton();
//		
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.enterEmail(dataUtilities.readingDataFromExcel("Sheet1", 1, 1));
//		loginPage.enterPassword(dataUtilities.readingDataFromExcel("Sheet1", 1, 2));
//		loginPage.clickLogin();
//		
//		AccountPage accPage = new AccountPage(driver);
//		String AccountPageTitile = accPage.getTitle(driver);
//		
//		Assert.assertEquals(dataUtilities.readingDataFromExcel("PageTitles", 1, 1), AccountPageTitile );
//		
//		NavBar navBar = new NavBar(driver);
//		navBar.clickSearchBar();
//		
//		SearchDrawer searchDrawer = new SearchDrawer(driver);
//		searchDrawer.enterSearchDrawer("women hooded jackets");
//		
//		searchDrawer.clickViewAllResultsBtn();
//		SearchedProductsPage searchedPrdouPage = new SearchedProductsPage(driver);
//		webUtilities.waitForElementToBeVisible(searchedPrdouPage.selectProduct(1)).click();
//		
//		ProductPage productpage = new ProductPage(driver);
//		
//		ProductDetails productDetails = new ProductDetails(driver);
//		productDetails.clickProductDetailSize();
//		
//		if(productDetails.getQuantity().isDisplayed()) {
//			productDetails.clickPlus();
//		}
//		
//		productDetails.clickAddToCart();
//		CartDrawer drawer = new CartDrawer(driver);
//		drawer.clickInitiateCheckoutBtn();
		
		
		logger.info("Test Case TC_04_InitiateCheckout started");

        Header header = new Header(driver);
        logger.info("Clicking on Login/Signup button");
        header.clickLoginSignupButton();
        
        LoginPage loginPage = new LoginPage(driver);
        logger.info("Entering email");
        loginPage.enterEmail(dataUtilities.readingDataFromExcel("Sheet1", 1, 1));
        logger.info("Entering password");
        loginPage.enterPassword(dataUtilities.readingDataFromExcel("Sheet1", 1, 2));
        logger.info("Clicking on Login button");
        loginPage.clickLogin();
        
        AccountPage accPage = new AccountPage(driver);
        String AccountPageTitle = accPage.getTitle(driver);
        logger.info("Verifying Account Page title");
        Assert.assertEquals(dataUtilities.readingDataFromExcel("PageTitles", 1, 1), AccountPageTitle);
        
        NavBar navBar = new NavBar(driver);
        logger.info("Clicking on Search bar");
        navBar.clickSearchBar();
        
        SearchDrawer searchDrawer = new SearchDrawer(driver);
        logger.info("Entering search term 'women hooded jackets'");
        searchDrawer.enterSearchDrawer("women hooded jackets");
        
        logger.info("Clicking on View All Results button");
        searchDrawer.clickViewAllResultsBtn();
        SearchedProductsPage searchedProdPage = new SearchedProductsPage(driver);
        logger.info("Selecting the first product from search results");
//        webUtilities.waitForElementToBeVisible(searchedProdPage.selectProduct(1));
//        if(searchedProdPage.selectProduct(1).isDisplayed()) {
//        	logger.info("selected element is visible");
//        	searchedProdPage.clicOnSelected(searchedProdPage.selectProduct(1));
//        }
        searchedProdPage.clicOnSelected(searchedProdPage.selectProduct(1));
        ProductPage productPage = new ProductPage(driver);
        
        ProductDetails productDetails = new ProductDetails(driver);
        logger.info("Selecting product size");
        productDetails.clickProductDetailSize();
        
        if(productDetails.getQuantity().isDisplayed()) {
            logger.info("Increasing product quantity");
            productDetails.clickPlus();
        }
        
        logger.info("Adding product to cart");
        productDetails.clickAddToCart();
        CartDrawer drawer = new CartDrawer(driver);
        logger.info("Clicking on Initiate Checkout button");
        drawer.clickInitiateCheckoutBtn();
        
        logger.info("Test Case TC_04_InitiateCheckout completed");
		
	}

}
