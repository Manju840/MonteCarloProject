package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhishListPage {

	@FindBy(xpath="//div[contains(@class,'flits-box-card')]//p[contains(@class,'flits-product-name')]")
	private WebElement wishListedItem;
	
	@FindBy(xpath="//div[contains(@class,'flits-box')]//div//div//div//button[text()='Add to Cart']")
	private WebElement addToCart;
	
	@FindBy(xpath = "//div[@class='flits-product-item-main']")
	private WebElement firstWishElement;
	
	@FindBy(xpath = "(//div[@class='flits-product-item-main'])[1]//button[contains(@class,'flits-remove-product')]")
	private WebElement closeButtonOfFirstEle;

	public WhishListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddToCart() {
		addToCart.click();
	}
	
	public WebElement getWishListItem() {
		return wishListedItem;
	}
	
	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public WebElement getFirstWishElement() {
		return firstWishElement;
	}
	
	
	
	public void clickFirstCloseButton() {
		closeButtonOfFirstEle.click();
	}
	
	
}
