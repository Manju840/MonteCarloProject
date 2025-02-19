package pom;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtilities;

public class MonteCarloPage {

	@FindBy(xpath = "//h3[text()='SHOP TRENDS']")
	private WebElement shopTrendsText;

	@FindBy(xpath = "//button[text()='New Arrival']")
	private WebElement newArrivalButton;

	@FindBy(xpath = "//div[@class='featured-collections '] ")
	private WebElement featuredCollDiv;

	@FindBy(xpath = "(//button[contains(@class,'prev-next-button--next')])[2]")
	private WebElement nextArrowButton;

	@FindBy(xpath = "(//product-item[contains(@class,'product-item')][5]//a)[7]") // (//product-item[contains(@class,'product-item')][5]//a)[7]/following::button[1]
	private WebElement getNewArrivalProdElement;

	@FindBy(xpath = "(*//product-list[2]//product-item/div[2])")
	private List<WebElement> allNewArrivalProducts;

	@FindBy(xpath = "*//product-list[2]//product-item/div[2]/div[1]/button[1]")
	private List<WebElement> newAllArrivalProductQuickViewListBtn;

	@FindBy(xpath = "(*//product-list[2]//div[@class=\"product-item__image-wrapper product-item__image-wrapper--multiple\"])[6]/following::a")
	private WebElement newArrivalProductInfo;

	public MonteCarloPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getShopTrendsText() {
		return shopTrendsText;
	}

	public void clickNewArrival() {
		newArrivalButton.click();
	}

	public WebElement getFeaturedCollDiv() {
		return featuredCollDiv;
	}

	public void clickNextArrow() {
		nextArrowButton.click();
	}

	public WebElement getGetNewArrivalProdElement() {
		return getNewArrivalProdElement;
	}

//	public WebElement getNewArrivalquickViewButton() {
//		return newArrivalquickViewButton;
//	}
//	
//	public void clickNewArrQuickView() {
//		newArrivalquickViewButton.click();
//	}

	public List<WebElement> getAllNewArrivalProducts() {
		return allNewArrivalProducts;
	}

	public WebElement getNewArrivalProductInfo() {
		return newArrivalProductInfo;
	}

	public WebElement getNewArrivalProductElement(int index) {
		return allNewArrivalProducts.get(index);
	}

	public List<WebElement> getNewArrivalProductQuickViewBtn(int index) {
		return newAllArrivalProductQuickViewListBtn;
	}

	public void hoverAndClickNewArrivalProduct(int index, WebDriver driver, WebDriverUtilities webUtilities) {
		WebElement product = getNewArrivalProductElement(index);
		webUtilities.mouseHover(product, driver);
		newAllArrivalProductQuickViewListBtn.get(index).click();
	}

	public String getMonteCarloTitle(WebDriver driver) {
		return driver.getTitle();
	}

}
