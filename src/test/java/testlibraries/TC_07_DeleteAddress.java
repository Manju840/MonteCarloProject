package testlibraries;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import pom.AccountPage;
import pom.AddressPage;
import pom.Header;
import pom.LoginPage;

public class TC_07_DeleteAddress extends BaseClass{
	
	@Test
	public void tc_07_deleteAdd() throws EncryptedDocumentException, IOException {
		Header header = new Header(driver);
		header.clickLoginSignupButton();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(dataUtilities.readingDataFromExcel("Sheet1", 1, 1));
		loginPage.enterPassword(dataUtilities.readingDataFromExcel("Sheet1", 1, 2));
		loginPage.clickLogin();
		
		AccountPage accPage = new AccountPage(driver);
		String AccountPageTitile = accPage.getTitle(driver);
		Assert.assertEquals(dataUtilities.readingDataFromExcel("PageTitles", 1, 1), AccountPageTitile );
		
		AccountPage accountPage = new AccountPage(driver);
		accountPage.clickAddresses();
		
		AddressPage addressPage = new AddressPage(driver);
		addressPage.deletAddress();
//		webUtilities.alertAcceptPopup(driver);

	}

}
