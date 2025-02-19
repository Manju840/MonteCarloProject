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
import pom.MonteCarloPage;
import pom.QuickBuyDrawer;

public class TC_10_ProductVerification extends BaseClass {

	static Logger logger = LogManager.getLogger(TC_10_ProductVerification.class);

	@Test
	public void tc_10_verifyProduct() throws InterruptedException, EncryptedDocumentException, IOException {

		logger.info("Verify product started");
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

		AccountPage accountPage = new AccountPage(driver);
		logger.info("clicking on montecarlo logo");
		header.clickMonteCarloLogo();

		MonteCarloPage monteCarloPage = new MonteCarloPage(driver);
		String monteCarloPageTitle = monteCarloPage.getMonteCarloTitle(driver);
		logger.info("verifying the montecarlo page ");
		Assert.assertEquals(monteCarloPageTitle, dataUtilities.readingDataFromProperty("MonteLogoPageTitle"));
		logger.info("scrolling to shop trends");
		webUtilities.scrolltoEle(monteCarloPage.getShopTrendsText(), driver);
		logger.info("clicking on new arrivals");
		monteCarloPage.clickNewArrival();
		webUtilities.waitForElementToBeVisible(monteCarloPage.getFeaturedCollDiv());
		webUtilities.mouseHover(monteCarloPage.getFeaturedCollDiv(), driver);
		logger.info("clicking on arrow");
		monteCarloPage.clickNextArrow();
		webUtilities.waitForElementToBeVisible(monteCarloPage.getGetNewArrivalProdElement());
		webUtilities.mouseHover(monteCarloPage.getGetNewArrivalProdElement(), driver);

		monteCarloPage.hoverAndClickNewArrivalProduct(6, driver, webUtilities);
		QuickBuyDrawer quickBuyDrawer = new QuickBuyDrawer(driver);
		logger.info("selecting the size");
		quickBuyDrawer.selectAnySize();
		logger.info("increase count");
		quickBuyDrawer.clickIncreaseCountBtn();
		logger.info("clicking view details");
		quickBuyDrawer.clickViewDetailsBtn();
		logger.info("verify product completed");
	}

}
