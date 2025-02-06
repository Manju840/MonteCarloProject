package testscripts;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	
	static Logger logger = LogManager.getLogger(TC_05_ManufactureAddress.class);
	
	@Test
	public void tc_05_ManufactureAdd() throws EncryptedDocumentException, IOException, InterruptedException {
		
		logger.info("Test Case TC_05_ManufactureAdd started");

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
        logger.info("Verifying Account Page title");
        String AccountPageTitile = accPage.getTitle(driver);
        Assert.assertEquals(dataUtilities.readingDataFromExcel("PageTitles", 1, 1), AccountPageTitile);

        logger.info("Clicking on Home Monte Carlo Logo");
        header.clicHomeMonteCarloLogo();

        MonteCarloHomeLogoPage homeLogo = new MonteCarloHomeLogoPage(driver);
        logger.info("Clicking on Shop Blanket");
        homeLogo.clickShoBlanket();

        ProductPage productPage = new ProductPage(driver);
        logger.info("Clicking on a product");
        productPage.clickOnProduct(webUtilities);

        ProductDetails productDetails = new ProductDetails(driver);
        logger.info("Clicking on Product Description");
        productDetails.clickProdDesc();

        logger.info("Getting Manufacturer Address");
        String address = productDetails.getManFacAddress(webUtilities);
        logger.info("Extracting Pincode from Address");
        String pincode = extractPinCode(address);
        logger.info("Clicking on Our Store");
        productDetails.clickOurStore();

        StorePage storePage = new StorePage(driver);
        logger.info("Sending Pincode to Store Page");
        storePage.sendZip(pincode);
        logger.info("Clicking on Get Directions button");
        storePage.clickGetDirButton();

        logger.info("Test Case TC_05_ManufactureAdd completed");
    }

    public static String extractPinCode(String address) {
        logger.info("Extracting Pincode from Address");
        String[] parts = address.split("[,\\s-]+");
        for (String part : parts) {
            if (part.length() == 6 && part.matches("\\d{6}")) {
                return part;
            }
        }
        logger.warn("Pincode not found");
        return "Pincode not found";
	}	
}
