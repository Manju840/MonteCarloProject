package testscripts;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.formula.functions.Address;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import pom.AccountPage;
import pom.AddressPage;
import pom.Header;
import pom.LoginPage;

public class TC_06_addAddress extends BaseClass{
	
	
	static Logger logger = LogManager.getLogger(TC_06_addAddress.class);

	@Test
	public void tc_06_addingAddress() throws EncryptedDocumentException, IOException {
		logger.info("Adding address started");
		Header header = new Header(driver);
		
		logger.info("clicking login/signup button");
		header.clickLoginSignupButton();
		logger.info("clicked login/signup button");
		LoginPage loginPage = new LoginPage(driver);
		logger.info("entering email");
		loginPage.enterEmail(dataUtilities.readingDataFromExcel("Sheet1", 1, 1));
		logger.info("entering password");
		loginPage.enterPassword(dataUtilities.readingDataFromExcel("Sheet1", 1, 2));
		logger.info("clicking login");
		loginPage.clickLogin();
		
		AccountPage accPage = new AccountPage(driver);
		logger.info("getting account page title");
		String AccountPageTitile = accPage.getTitle(driver);
		logger.info("Verifying the account page");
		Assert.assertEquals(dataUtilities.readingDataFromExcel("PageTitles", 1, 1), AccountPageTitile );
		
		AccountPage accountPage = new AccountPage(driver);
		logger.info("clicking addresses");
		accountPage.clickAddresses();
		
		AddressPage addressPage = new AddressPage(driver);
		logger.info("clicking add new addresses");
		addressPage.clickAddNewAdd();
		logger.info("entering first name");
		addressPage.enterFirstName(dataUtilities.readingDataFromProperty("firstName"));
		logger.info("entering last name");
		addressPage.enterLastName(dataUtilities.readingDataFromProperty("lastName"));
		logger.info("entering company name");
		addressPage.enterCompany(dataUtilities.readingDataFromProperty("companyName"));
		logger.info("entering phone");
		addressPage.enterPhone(dataUtilities.readingDataFromProperty("phoneNum"));
		logger.info("entering address one");
		addressPage.enterAddressOne(dataUtilities.readingDataFromProperty("add1"));
		logger.info("entering address two");
		addressPage.enterAddressTwo(dataUtilities.readingDataFromProperty("add2"));
		logger.info("entering city");
		addressPage.enterCity(dataUtilities.readingDataFromProperty("cityName"));
		logger.info("entering zipcode");
		addressPage.enterZip(dataUtilities.readingDataFromProperty("zipCode"));
		WebElement countrySelect = addressPage.getCountry();
		logger.info("selecting country");
		webUtilities.dropDownByValue(countrySelect, dataUtilities.readingDataFromProperty("country"));
		WebElement state = addressPage.getAddProvinc();
		if(state.isDisplayed()) {
			logger.info("selecting state");
			WebElement stateSelect = addressPage.getAddProvinc();
			webUtilities.dropDownByValue(stateSelect, dataUtilities.readingDataFromProperty("state"));
		}
		logger.info("clicking submit");
		addressPage.clickSubmitButton();
		String latestAddress = addressPage.getLastAddress();
		logger.info("verifying the address");
		SoftAssert sAssert = new SoftAssert();
		sAssert.assertEquals(dataUtilities.readingDataFromProperty("adressWithState"), latestAddress);
		sAssert.assertAll();
		logger.info("adding address completed");
		
	}
	

}
