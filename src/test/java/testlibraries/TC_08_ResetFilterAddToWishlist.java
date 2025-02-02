package testlibraries;

import java.io.FileNotFoundException;
import java.io.IOException;

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

	@Test
	public void tc_08_resetFilter() throws FileNotFoundException, IOException {
		
		NavBar navbar = new NavBar(driver);
		navbar.clickWomen();
		
		CollectionsPage collectionsPage = new CollectionsPage(driver);
		collectionsPage.clickonStole();
		
		ProductPage productPage = new ProductPage(driver);
		productPage.sendKeysFromPriceRange(dataUtilities.readingDataFromProperty("fromPrice0"));
		
		productPage.sendKeysToPriceRange(dataUtilities.readingDataFromProperty("toPrice500"));
		
		productPage.clickClearFilter();
		productPage.sendKeysFromPriceRange(dataUtilities.readingDataFromProperty("fromPrice299"));
		productPage.sendKeysToPriceRange(dataUtilities.readingDataFromProperty("toPrice2000"));
		
		productPage.clickOnProduct();
		
		ProductDetails productDetails = new ProductDetails(driver);
		productDetails.clickWishListProduct();
		
		String emailPopupText = productDetails.getWhatsEmailPopup().getText().trim();
		System.out.println("emailPopupText"+"\""+emailPopupText+"\"");
		Assert.assertEquals(dataUtilities.readingDataFromProperty("whatsEmail"), emailPopupText);
		
		Header header = new Header(driver);
		header.clickWishListButton();
		
		
		
		
	}
}
