package testscripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import pom.CollectionsPage;
import pom.Header;
import pom.NavBar;
import pom.ProductDetails;
import pom.ProductPage;

public class TC_08_ResetFilterAddToWishlist extends BaseClass {

	static Logger logger = LogManager.getLogger(TC_08_ResetFilterAddToWishlist.class);

	@Test
	public void tc_08_resetFilter() throws FileNotFoundException, IOException {

		logger.info("ResetFilter started");
		NavBar navbar = new NavBar(driver);
		logger.info("clicking on women section");
		navbar.clickWomen();

		CollectionsPage collectionsPage = new CollectionsPage(driver);
		logger.info("clicking on stole");
		collectionsPage.clickonStole();

		ProductPage productPage = new ProductPage(driver);
		logger.info("entering the price from");
		productPage.sendKeysFromPriceRange(dataUtilities.readingDataFromProperty("fromPrice0"));
		logger.info("entering the price to");
		productPage.sendKeysToPriceRange(dataUtilities.readingDataFromProperty("toPrice500"));
		logger.info("clearing the filter");
		productPage.clickClearFilter();
		logger.info("again entering the price from");
		productPage.sendKeysFromPriceRange(dataUtilities.readingDataFromProperty("fromPrice299"));
		logger.info("again entering the price to");
		productPage.sendKeysToPriceRange(dataUtilities.readingDataFromProperty("toPrice2000"));
		logger.info("clicking on any product");
		productPage.clickOnProduct(webUtilities);

		ProductDetails productDetails = new ProductDetails(driver);
		logger.info("clicking on whishlist");
		productDetails.clickWishListProduct();

		String emailPopupText = productDetails.getWhatsEmailPopup().getText().trim();
		logger.info("verifying the text of popup");
		Assert.assertEquals(dataUtilities.readingDataFromProperty("whatsEmail"), emailPopupText);

		Header header = new Header(driver);
		logger.info("clicking on whishlist button");
		header.clickWishListButton();
		logger.info("resetFilter completed");

	}
}
