package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonteCarloHomeLogoPage {

	@FindBy(xpath = "//a[normalize-space()='SHOP Blankets']")
	private WebElement shopBlanket;

	public MonteCarloHomeLogoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickShoBlanket() {
		shopBlanket.click();
	}

}
