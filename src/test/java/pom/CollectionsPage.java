package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CollectionsPage {
	
	@FindBy(xpath = "//div[@class='custom-tems slick-slide slick-active' and @data-slick-index='4']//a")
	private WebElement stoleItem;
	
	@FindBy(xpath = "(//button[@aria-controls='sort-by-popover'])[2]")
	private WebElement sortByButton;
	
	@FindBy(xpath = "//label[@class='popover__choice-item']/following::span[contains(text(),'old to new')]")
	private WebElement dateLowTHigh;
	
	@FindBy(xpath = "((//product-item[contains(@class,'product-item')])[2]//a)[3]")
	private WebElement secondProduct;
	
	public CollectionsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickonStole() {
		stoleItem.click();
	}
	
	public void clickSortbyButton() {
		sortByButton.click();
	}
	
	public void selectDateLowTHigh() {
		dateLowTHigh.click();
	}

	public WebElement getSecondProduct() {
		return secondProduct;
	}
	
	public void clickSeconProduct() {
		secondProduct.click();
	}

}
