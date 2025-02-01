package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

public class AddressPage {

	@FindBy(xpath = "//button[contains(@class,'account__address account__address')]")
	private WebElement addNewAdd;
	
	@FindBy(id = "address-new[first_name]")
    private WebElement firstNameBox;
    
    @FindBy(id = "address-new[last_name]")
    private WebElement lastNameBox;
    
    @FindBy(id="address-new[phone]")
    private WebElement phoneBox;
    
    @FindBy(id="address-new[company]")
    private WebElement companyBox;
    
    @FindBy(id="address-new[address1]")
    private WebElement add1Box;
    
    @FindBy(id="address-new[address2]")
    private WebElement add2Box;
    
    @FindBy(id="address-new[city]")
    private WebElement cityBox;
    
    @FindBy(id="address-new[zip]")
    private WebElement zipBox;
    
    @FindBy(id = "address-new[country]")
    private WebElement country;
	
    @FindBy(id = "address-new[province]")
    private WebElement addProvinc;
    
    @FindBy(css = "button[type='submit'][is='loader-button']")
    private WebElement submitButton;
    
    @FindBy(xpath = "//div[@class='account__addresses-list']//div[@class='account__address-actions']/form")
	private WebElement firstAddress;
    
    @FindBy(xpath = "//div[@class='account__address-details']/p")
    private List<WebElement> addressList;
	
    
	public AddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddNewAdd() {
		addNewAdd.click();
	}

	public void enterFirstName(String name) {
        firstNameBox.sendKeys(name);
    }
    
    public void enterLastName(String name) {
        lastNameBox.sendKeys(name);
    }
    
    public void enterCompany(String text) {
        companyBox.sendKeys(text);
    }
    
    public void enterPhone(String text) {
        phoneBox.sendKeys(text);
    }
    
    public void enterAddressOne(String text) {
        add1Box.sendKeys(text);
    }
    
    public void enterAddressTwo(String text) {
        add2Box.sendKeys(text);
    }
    
    public void enterCity(String text) {
        cityBox.sendKeys(text);
    }
    
    public void enterZip(String text) {
        zipBox.sendKeys(text);
    }

	public WebElement getCountry() {
		return country;
	}

	public WebElement getAddProvinc() {
		return addProvinc;
	}
	
	public void clickSubmitButton() {
		submitButton.click();
	}
	
	public void deletAddress() {
		if(firstAddress.isDisplayed()) {
			firstAddress.submit();
		}
		else {
			System.out.println("No addresses to delete");
		}
		
	}
	
	public String getLastAddress() {
		int size = addressList.size();
		if(size > 0) {
			
			return addressList.get(size - 1).getText();
		}
		return "";
		
		
	}
    
    
    
    
}
