package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CollectionsPage {
	
	@FindBy(xpath = "//div[@class='custom-tems slick-slide slick-active' and @data-slick-index='4']//a")
	private WebElement stoleItem;
	
	public CollectionsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickonStole() {
		stoleItem.click();
	}

}
