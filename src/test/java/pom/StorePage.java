package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.AddHasCasting;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtilities;

public class StorePage {
	
	@FindBy(id = "searchInput")
	private WebElement search;
	
	@FindBy(css = "a[class='directions-btn']")
	private WebElement getDirection;
	
	public StorePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void sendZip(String zp) {
		search.sendKeys(zp);
	}
	
	public void clickGetDirButton() {
		getDirection.click();
	}
}
