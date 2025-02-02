package testlibraries;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.formula.functions.Address;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import pom.AccountPage;
import pom.AddressPage;
import pom.Header;
import pom.LoginPage;

public class TC_06_addAddress extends BaseClass{
	
	private static final WebDriver WebDriver = null;

	@Test
	public void tc_06_addingAddress() throws EncryptedDocumentException, IOException {
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
		addressPage.clickAddNewAdd();
		addressPage.enterFirstName(dataUtilities.readingDataFromProperty("firstName"));
		addressPage.enterLastName(dataUtilities.readingDataFromProperty("lastName"));
		addressPage.enterCompany(dataUtilities.readingDataFromProperty("companyName"));
		addressPage.enterPhone(dataUtilities.readingDataFromProperty("phoneNum"));
		addressPage.enterAddressOne(dataUtilities.readingDataFromProperty("add1"));
		addressPage.enterAddressTwo(dataUtilities.readingDataFromProperty("add2"));
		addressPage.enterCity(dataUtilities.readingDataFromProperty("cityName"));
		addressPage.enterZip(dataUtilities.readingDataFromProperty("zipCode"));
		WebElement countrySelect = addressPage.getCountry();
		webUtilities.dropDownByValue(countrySelect, dataUtilities.readingDataFromProperty("country"));
		WebElement state = addressPage.getAddProvinc();
		if(state.isDisplayed()) {
			WebElement stateSelect = addressPage.getAddProvinc();
			webUtilities.dropDownByValue(stateSelect, dataUtilities.readingDataFromProperty("state"));
		}
		
		addressPage.clickSubmitButton();
		String latestAddress = addressPage.getLastAddress();
		Assert.assertEquals(dataUtilities.readingDataFromProperty("adressWithState"), latestAddress);
		
	}
	

}
