package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
	
	@FindBy(xpath = "//li[@class='wishlist']//a")
	private WebElement wishListButton;

	@FindBy(xpath = "//li[@class='login']/a")
	private WebElement loginSignupButton;
	
	@FindBy(xpath = "(//span[@class='header__logo']/a)[3]")
	private WebElement homeMonteCarloLogo;
	
	@FindBy(xpath = "//span[@class='header__logo']/a")
	private WebElement monteCarloLogo;

	public Header(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickWishListButton() {
		wishListButton.click();
	}

	public void clickLoginSignupButton() {
		loginSignupButton.click();
	}
	
	public void clicHomeMonteCarloLogo() {
		homeMonteCarloLogo.click();
	}
	
	public void clickMonteCarloLogo() {
		monteCarloLogo.click();
	}

}
