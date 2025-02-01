package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id="customer[email]")
	private WebElement emailInput;
	
	@FindBy(id="customer[password]")
	private WebElement passwordInput;
	
	@FindBy(xpath="//button[@type='submit']/span[text()='Login']")
	public WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String email) {
		emailInput.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
}
