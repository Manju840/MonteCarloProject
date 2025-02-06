package genericLibraries;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class WebDriverUtilities {
	
	private WebDriverWait wait;
	public WebDriverUtilities(WebDriver driver) {
//	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    }
	
	public WebElement waitForElementToBeVisible(WebElement locator) {
        return wait.until(ExpectedConditions.visibilityOf(locator));
    }
	
	public WebElement waitForElementToBeClickable(WebElement locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
	
	public WebElement waitForElementToRefreshed(WebElement ele) {
		return wait.until(ExpectedConditions.refreshed(
			    ExpectedConditions.elementToBeClickable(ele)
				));
	}
	
	public WebElement waitForElementToRefreshedVisible(WebElement ele) {
		return wait.until(ExpectedConditions.refreshed(
			    ExpectedConditions.visibilityOf(ele)
				));
	}
	public void mouseHover(WebElement ele, WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
	}
	
	public void doubleClick(WebElement ele, WebDriver driver) {
		Actions action = new Actions(driver);
		action.doubleClick(ele).perform();
	}
	
	public void rightClick(WebElement ele, WebDriver driver) {
		Actions action = new Actions(driver);
		action.contextClick(ele).perform();
	}
	
	public void dropDown(WebElement ele, String text) {
		Select select = new Select(ele);
		select.selectByVisibleText(text);
	}
	
	public void dropDownByValue(WebElement ele, String text) {
		Select select = new Select(ele);
		select.selectByValue(text);
	}
	
	public void frameWithWebElementAddress(WebElement ele, WebDriver driver) {
		driver.switchTo().frame(ele);
	}
	
	public void frameWithIndex( int index, WebDriver driver) {
		driver.switchTo().frame(index);
	}
	
	public void switchToDefault( int index, WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void alertAcceptPopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void alertDismisspopup(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void alertPopupText(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		Reporter.log(alert.getText(),true);
	}
	
	public void scrollbarTopToBottom(WebDriver driver) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
		javascriptExecutor.executeScript("window.scrollBy(0,5000");
	}
	
	public void scrollbarBottomTopTo(WebDriver driver) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
		javascriptExecutor.executeScript("window.scrollBy(0,-5000");
	}
	
	public void scrolltoEle(WebElement ele, WebDriver driver) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView();",ele);
	}
	
	public void switchChildWindow(WebDriver driver) {
		Set<String> child = driver.getWindowHandles();
		for(String ch:child) {
			driver.switchTo().window(ch);
		}
	}
	
	public void multipleTabs(int index, WebDriver driver) {
		Set<String> child = driver.getWindowHandles();
		ArrayList<String> arrayList = new ArrayList<String>(child);
		driver.switchTo().window(arrayList.get(index));
	}
	
	public void waitElement(WebElement ele, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitElementClcik(WebElement ele, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
	}

}
