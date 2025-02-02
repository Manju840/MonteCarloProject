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
import pom.RightSlidingCardPage;
import pom.WhishListPage;

public class TC_02_HandTowelProductAdding extends BaseClass{

	@Test
	public void tc_02_addHandTowl() throws EncryptedDocumentException, IOException, InterruptedException {
		
		Header header = new Header(driver);
		header.clickLoginSignupButton();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(dataUtilities.readingDataFromExcel("Sheet1", 1, 1));
		loginPage.enterPassword(dataUtilities.readingDataFromExcel("Sheet1", 1, 2));
		loginPage.clickLogin();
		AccountPage accPage = new AccountPage(driver);
		String AccountPageTitile = accPage.getTitle(driver);
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
