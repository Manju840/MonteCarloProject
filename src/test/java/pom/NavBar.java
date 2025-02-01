package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavBar {
	
	@FindBy(xpath="//li[@data-item-title='HOME FURNISHING']/a")
	private WebElement homeFurnishing;
	
	@FindBy(xpath="//li[@class='linklist__item']/a[text()='AC Comforter']")
	private WebElement acComforter;
	
	@FindBy(xpath = "//span[text()='Cart']")
	private WebElement cartButton;
	
	@FindBy(xpath="//li[@data-item-title='MEN']/a")
	private WebElement mens;
	
	@FindBy(xpath="//li[@class='linklist__item']/a[text()='Round Neck Sweaters']")
	private WebElement roundNeckSweaters;
	
	@FindBy(xpath="//li[@data-item-title='WOMEN']/a ")
	private WebElement womens;
	
	@FindBy(xpath="(//div[contains(@class,'mega-menu__images-wrapper')]//a[contains(@class,'mega-menu__image-push')])[2]")
	private WebElement womenImage;
	
	
	
	public NavBar(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getHomeFurnishing() {
		return homeFurnishing;
	}
	
	public void clicAcComforter() {
		acComforter.click();
	}
	
	public void clickCartButton() {
		cartButton.click();
	}
	
	public WebElement getMensSection() {
		return mens;
	}
	
	public void clickRoundNeckSweaters() {
		roundNeckSweaters.click();
	}
	
	public WebElement getWoMensSection() {
		return womens;
	}
	
	public void clickWomen() {
		womens.click();
	}
	
	public void clickWomenImage() {
		womenImage.click();
	}
}
