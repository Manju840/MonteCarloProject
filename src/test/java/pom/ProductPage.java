package pom;

import java.sql.Driver;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
//	@FindBy(xpath="//price-range//div[contains(@class,'price-range__range-group range-group')]//input[@aria-label='To price']")
//	private WebElement price;
	
	@FindBy(css="input[type='range'][aria-label='From price'], input[type='range'][aria-label='To price']")
	private WebElement priceSlider;
	
	@FindBy(xpath="//button[text()='Size'] ")
	private WebElement size;
	
	@FindBy(xpath="//label[contains(text(),'Single')] ")
	private WebElement SizeOption;
	
	@FindBy(xpath="//div[@class='block-swatch ']//label[contains(text(),'38')]")
	private WebElement size_38_M;
	
	
	@FindBy(xpath="//button[text()='Color']")
	private WebElement color;
	
	@FindBy(xpath="//div[@class='color-swatch  ']")
	private WebElement colorOption;
	
	@FindBy(xpath="//button[text()='Brand']")
	private WebElement brand;
	
	@FindBy(xpath="//label[contains(text(),'Monte Carlo')]")
	private WebElement brandOption;
	
	@FindBy(xpath="//label[contains(text(),'Rock.it') or input[id='filter.p.m.custom.brand-3']]")
	private WebElement rockItBrandOption;
	
	@FindBy(xpath="//button[text()='Availability']")
	private WebElement availability;
	
	@FindBy(xpath="//label[contains(text(),'In stock') or input[@class='checkbox']]")
	private WebElement instockOption;
	
	@FindBy(xpath="//button[text()='Sleeve']")
	private WebElement sleeve;
	
	@FindBy(xpath="//label[contains(text(),'Full Sleeve') or input[@class='checkbox']]")
	private WebElement fullSleeveOption;
	
	@FindBy(xpath="//product-item[contains(@class,'product-item')]//div[@class='product-item__info  ']//div[@class='title-wish']")
	private WebElement firstProduct;
	
	@FindBy(xpath="(//product-item[contains(@class,'product-item')]//div[@class='product-item__info  ']//div[@class='title-wish'])[3]")
	private WebElement fullSleeveThirdProduct;
	
	@FindBy(css = "input[id='filter.v.price.gte']")
	private WebElement fromPrice;
	
	@FindBy(css = "input[id='filter.v.price.lte']")
	private WebElement toPrice;
	
	@FindBy(xpath = "//div[@class='button-wrapper']//a[@data-action='clear-filters']")
	private WebElement clearFilter;
	
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
//	public WebElement getPrice() {
//		return price;
//	}

	public int getPriceSliderWidth() {
		return priceSlider.getSize().getWidth();
	}
	
	public WebElement getPriceSlider() {
		return priceSlider;
	}



	public int getMinVaue() {
		return Integer.parseInt(priceSlider.getAttribute("min"));
	}
	
	public int getMaxVaue() {
		return Integer.parseInt(priceSlider.getAttribute("max"));
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
	
	public void selectColor() {
		colorOption.click();
	}
	
	public void clickBrand() {
		brand.click();
	}
	
	public void selectBrand() {
		brandOption.click();
	}
	
	public void selectRockItBrandOption() {
		rockItBrandOption.click();
	}
	
	public void clickSleeve() {
		sleeve.click();
	}
	
	public void selectFullSleeve() {
		fullSleeveOption.click();
	}
	
	public void clickAvailability() {
		availability.click();
	}
	
	public void selectAvailability() {
		instockOption.click();
	}
	
	public void clickOnProduct() {
		firstProduct.click();
	}
	
	public void clickFullSleeveThirdProduct() {
		fullSleeveThirdProduct.click();
	}
	
	public void sendKeysFromPriceRange(String fromprice) {
		fromPrice.sendKeys(fromprice);
//		fromPrice.sendKeys(Keys.ENTER);
	}
	
	public void sendKeysToPriceRange(String toprice) {
		toPrice.sendKeys(toprice);
//		fromPrice.sendKeys(Keys.ENTER);
	}
	
	public void clickClearFilter() {
		clearFilter.click();
	}

}
