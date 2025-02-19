package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	@FindBy(xpath = "//li[contains(@class,'Addresses')]//a[text()='Addresses']")
	private WebElement addresses;

	public AccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public void clickAddresses() {
		addresses.click();
	}

}
