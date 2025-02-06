package testscripts;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.StaleElementReferenceException;
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

	static Logger logger = LogManager.getLogger(TC_03_VerifyPincode.class);
	
	@Test
	public void tc_03_VerifyPincode() throws EncryptedDocumentException, IOException, InterruptedException {
			
		logger.info("VerifyPincode test case started");

        Header header = new Header(driver);
        logger.info("Clicking login/signup button");
        header.clickLoginSignupButton();
        logger.info("Clicked login/signup button");
        
        LoginPage loginPage = new LoginPage(driver);
        logger.info("Entering email");
        loginPage.enterEmail(dataUtilities.readingDataFromExcel("Sheet1", 1, 1));
        logger.info("Email entered");
        logger.info("Entering password");
        loginPage.enterPassword(dataUtilities.readingDataFromExcel("Sheet1", 1, 2));
        logger.info("Password entered");
        loginPage.clickLogin();
        logger.info("Clicked login button");
        
        AccountPage accPage = new AccountPage(driver);
        logger.info("Getting account page title");
        String AccountPageTitle = accPage.getTitle(driver);
        logger.info("Verifying the account page title");
        Assert.assertEquals(dataUtilities.readingDataFromExcel("PageTitles", 1, 1), AccountPageTitle);
        logger.info("Account page title verified");
        
        NavBar navbar = new NavBar(driver);
        logger.info("Clicking men's section");
        navbar.clickMensSection();
        logger.info("Clicked men's section");
        // WebElement mensSection = navbar.getMensSection();
        // webUtilities.mouseHover(mensSection, driver);
        logger.info("Clicking round neck sweaters");
        navbar.clickRoundNeckSweaters();
        logger.info("Clicked round neck sweaters");
        
        ProductPage productpage = new ProductPage(driver);
        logger.info("Clicking size");
        productpage.clickSize();
        logger.info("Clicked size");
        logger.info("Selecting size 38 M");
        productpage.selectSIze_38_M();
        logger.info("Selected size 38 M");
        logger.info("Waiting for brand element to be clickable");
        webUtilities.waitForElementToBeClickable(productpage.getBrand());
        logger.info("Clicking brand");
        productpage.clickBrand();
        logger.info("Clicked brand");
        logger.info("Waiting for RockIt brand option to be refreshed");
        webUtilities.waitForElementToRefreshed(productpage.getRockItBrandOption());
        logger.info("Selecting RockIt brand option");
        productpage.selectRockItBrandOption();
        logger.info("Selected RockIt brand option");
        logger.info("Clicking sleeve");
        productpage.clickSleeve();
        logger.info("Clicked sleeve");
        logger.info("Waiting for full sleeve option to be clickable");
        webUtilities.waitForElementToBeClickable(productpage.getFullSleeveOption());
        logger.info("Selecting full sleeve option");
        productpage.selectFullSleeve();
        logger.info("Selected full sleeve option");
        try {
            logger.info("Waiting for full sleeve third product to be refreshed");
            webUtilities.waitForElementToRefreshed(productpage.getFullSleeveThirdProduct());
            logger.info("Clicking full sleeve third product");
            productpage.clickFullSleeveThirdProduct();
            logger.info("Clicked full sleeve third product");
        } catch (StaleElementReferenceException e) {
            logger.warn("Caught StaleElementReferenceException, retrying");
            logger.info("Waiting for full sleeve third product to be clickable");
            webUtilities.waitForElementToBeClickable(productpage.getFullSleeveThirdProduct());
            logger.info("Clicking full sleeve third product");
            productpage.clickFullSleeveThirdProduct();
            logger.info("Clicked full sleeve third product");
        }
        
        ProductDetails productDetails = new ProductDetails(driver);
        logger.info("Entering pincode");
        productDetails.enterPincode(dataUtilities.readingDataFromExcel("InputParameters", 0, 2));
        logger.info("Pincode entered");
        logger.info("Clicking check pincode button");
        productDetails.clickCheckPincode();
        logger.info("Clicked check pincode button");
        
        logger.info("VerifyPincode test case completed");
}
	
}
