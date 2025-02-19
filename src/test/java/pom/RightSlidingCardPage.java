package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.DataUtilities;

public class RightSlidingCardPage {

	@FindBy(css = "input[name='q']")
	private WebElement search;

	@FindBy(xpath = "(//span[@class='product-item-meta__title text--small'])[4]")
	private WebElement towel;

	public RightSlidingCardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void sendKeysSearch(String data) {
		search.sendKeys(data);
	}

	public void searchTowel() {
		towel.click();
	}

}
