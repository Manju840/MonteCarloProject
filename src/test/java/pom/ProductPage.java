package pom;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtilities;

public class ProductPage {

	@FindBy(css = "input[type='range'][aria-label='From price'], input[type='range'][aria-label='To price']")
	private WebElement priceSlider;

	@FindBy(xpath = "//button[text()='Size'] ")
	private WebElement size;

	@FindBy(xpath = "//label[contains(text(),'Single')] ")
	private WebElement SizeOption;

	@FindBy(xpath = "//div[@class='block-swatch ']//label[contains(text(),'38')]")
	private WebElement size_38_M;

	@FindBy(xpath = "//button[text()='Color']")
	private WebElement color;

	@FindBy(xpath = "//div[contains(@class,'color-swatch')]/div/label")
	private WebElement colorOption;

	@FindBy(xpath = "//button[text()='Brand']")
	private WebElement brand;

	@FindBy(xpath = "//label[contains(text(),'Monte Carlo')]")
	private WebElement brandOption;

	@FindBy(css = "input[value='Rock.it']")
	private WebElement rockItBrandOption;

	@FindBy(xpath = "//button[text()='Availability']")
	private WebElement availability;

	@FindBy(xpath = "//label[contains(text(),'In stock') or input[@class='checkbox']]")
	private WebElement instockOption;

	@FindBy(xpath = "//button[text()='Sleeve']")
	private WebElement sleeve;

	@FindBy(css = "input[value='Full Sleeve']")
	private WebElement fullSleeveOption;

	@FindBy(xpath = "//product-item[contains(@class,'product-item')]//div[@class='product-item__info  ']//div[@class='title-wish']/a")
	private WebElement firstProduct;

	@FindBy(xpath = "(//div[@class='title-wish'])[3]/a")
	private WebElement fullSleeveThirdProduct;

	@FindBy(css = "input[id='filter.v.price.gte']")
	private WebElement fromPrice;

	@FindBy(css = "input[id='filter.v.price.lte']")
	private WebElement toPrice;

	@FindBy(xpath = "//div[@class='button-wrapper']//a[@data-action='clear-filters']")
	private WebElement clearFilter;

	@FindBy(xpath = "//product-list[contains(@class,'product-facet__product-list')]")
	private WebElement productListDiv;

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public int getPriceSliderWidth() {
		return priceSlider.getSize().getWidth();
	}

	public WebElement getPriceSlider() {
		return priceSlider;
	}

	public void clickSize() {
		size.click();
	}

	public void selectSize() {
		SizeOption.click();
	}

	public void selectSIze_38_M() {
		size_38_M.click();
	}

	public void clickColor() {
		color.click();
	}

	public WebElement getColorOption() {
		return colorOption;
	}

	public void selectColor() {
		colorOption.click();
	}

	public WebElement getBrand() {
		return brand;
	}

	public void clickBrand() {
		brand.click();
	}

	public void selectBrand() {
		brandOption.click();
	}

	public WebElement getRockItBrandOption() {
		return rockItBrandOption;
	}

	public void selectRockItBrandOption() {
		rockItBrandOption.click();
	}

	public void clickSleeve() {
		sleeve.click();
	}

	public WebElement getFullSleeveOption() {
		return fullSleeveOption;
	}

	public void selectFullSleeve() {
		fullSleeveOption.click();
	}

	public void clickAvailability() {
		availability.click();
	}

	public void selectAvailability(WebDriverUtilities web) {
		web.waitForElementToBeClickable(instockOption);
		instockOption.click();
	}

	public void clickOnProduct(int index, WebDriverUtilities webDriverUtilities, WebDriver driver) {

		webDriverUtilities.waitForElementToRefreshedVisible(productListDiv);
		WebElement product = driver
				.findElement(By.xpath("(//div[@id='facet-main']//product-item[@class='product-item  hhh Byee'])["
						+ index + "]//div[@class='title-wish']/a"));
		webDriverUtilities.scrolltoEle(product, driver);
		webDriverUtilities.waitElementClcik(product, driver);
		product.click();
	}
	
	public void clickOnBlanketProduct(WebDriverUtilities web, WebDriver driver) {
		web.waitForElementToRefreshedVisible(productListDiv);
		firstProduct.click();
	}

	public void clickOnProduct(WebDriverUtilities web) {
		web.waitForElementToRefreshedVisible(productListDiv);
		web.waitForElementToBeClickable(firstProduct);
		firstProduct.click();
	}

	public WebElement getFullSleeveThirdProduct() {
		return fullSleeveThirdProduct;
	}

	public void clickFullSleeveThirdProduct() {
		fullSleeveThirdProduct.click();
	}

	public void sendKeysFromPriceRange(String fromprice) {
		fromPrice.sendKeys(fromprice);
	}

	public void sendKeysToPriceRange(String toprice) {
		toPrice.sendKeys(toprice);
	}

	public void clickClearFilter() {
		clearFilter.click();
	}

}
