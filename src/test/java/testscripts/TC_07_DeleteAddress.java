package testscripts;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import pom.AccountPage;
import pom.AddressPage;
import pom.Header;
import pom.LoginPage;

public class TC_07_DeleteAddress extends BaseClass{
	
	static Logger logger = LogManager.getLogger(TC_07_DeleteAddress.class);
	
	@Test
	public void tc_07_deleteAdd() throws EncryptedDocumentException, IOException {
		
		logger.info("delete Address started");
		Header header = new Header(driver);
		logger.info("clicking login/signup");
		header.clickLoginSignupButton();
		
		LoginPage loginPage = new LoginPage(driver);
		logger.info("entering email");
		loginPage.enterEmail(dataUtilities.readingDataFromExcel("Sheet1", 1, 1));
		logger.info("entering password");
		loginPage.enterPassword(dataUtilities.readingDataFromExcel("Sheet1", 1, 2));
		logger.info("clicking on login");
		loginPage.clickLogin();
		
		AccountPage accPage = new AccountPage(driver);
		String AccountPageTitile = accPage.getTitle(driver);
		logger.info("verifying the account page title");
		Assert.assertEquals(dataUtilities.readingDataFromExcel("PageTitles", 1, 1), AccountPageTitile );
		
		AccountPage accountPage = new AccountPage(driver);
		logger.info("clicking on addresses");
		accountPage.clickAddresses();
		
		AddressPage addressPage = new AddressPage(driver);
		logger.info("deleting the first addresses");
		addressPage.deletAddress();

	}

}
