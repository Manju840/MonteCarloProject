package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetails {

	@FindBy(xpath="//div[@class='product_wishlist']//a")
	private WebElement wishListProduct;
	
	@FindBy(xpath=" //product-meta/h1")
	private WebElement wishListedItemTitle;
	
	@FindBy(xpath="(//div[contains(@class,'block-swatch is-disabled')]/label)[3]")
	private WebElement productDetailSize;
	
	@FindBy(xpath="//div[contains(@class,'product-form__quantity')]")
	private WebElement quantity;
	
	@FindBy(xpath="//quantity-selector[@class='quantity-selector']/button[2]")
	private WebElement plusButton;
	
	@FindBy(xpath = "//button[contains(@class,'accordion')]")
	private WebElement prodDetailDesc;
	
	@FindBy(xpath = "//div[@class='yash-blog-text shreyh']/h2[text()='Manufacturer Address']/following::p")
	private WebElement manFacAddress;
	
	@FindBy(xpath = "//div[@class='flits-tingle-modal-popup-header']//p[contains(@class,'popup-header-title')]")
	private WebElement whatsEmailPopup;

	@FindBy(id="pincode")
	private WebElement pincodeTextBox;
	
	@FindBy(id="check-pincode")
	private WebElement checkPincodeButton;
	
	@FindBy(linkText = "Our Stores")
	private WebElement ourStore;
	
	public ProductDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void clickWishListProduct() {
		wishListProduct.click();
	}
	public WebElement getWishListedItemTitle() {
		return wishListedItemTitle;
	}
	
	public void clickProductDetailSize() {
		productDetailSize.click();
	}
	
	public WebElement getQuantity() {
		return quantity;
	}
	
	public void clickPlus() {
		plusButton.click();
	}
	
	public void clickProdDesc() {
		prodDetailDesc.click();
	}
	
	
	public String getManFacAddress() {
		return manFacAddress.getText();
	}
	public void enterPincode(String pinCode) {
		pincodeTextBox.sendKeys(pinCode);
	}
	
	public void clickCheckPincode() {
		checkPincodeButton.click();
	}
	
	public void clickOurStore() {
		ourStore.click();
	}
	public WebElement getWhatsEmailPopup() {
		return whatsEmailPopup;
	}
	
	
	
	
	
}
