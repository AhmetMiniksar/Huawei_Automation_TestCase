package eCommerce01.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.Constants;

public class HomePage extends BasePage {

	@FindBy(how = How.CLASS_NAME, using = "desktopOldAutosuggestTheme-input")
	private WebElement searchBox;

	@FindBy(how = How.CLASS_NAME, using = "SearchBoxOld-buttonContainer")
	private WebElement searchIcon;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void setSearchTextBox(String productName) {
		searchBox.sendKeys(productName);
	}

	public void clickSearchButton() {
		searchIcon.click();
	}

	public HomePage searchProduct(String productName) throws InterruptedException {
		setSearchTextBox(productName);
		waitMin();
		clickSearchButton();
		return this;
	}

	public HomePage isPageOpenedForSearch(String productName) throws InterruptedException {
		waitMin();
		Assert.assertEquals(driver.getCurrentUrl().toString(), Constants.SEARCH_URL + productName);		
		return this;
	}

	public HomePage isPageOpened() throws InterruptedException {
		Assert.assertTrue(driver.getTitle().toString().contains("Türkiye'nin En Büyük Online Alýþveriþ Sitesi Hepsiburada.com"));	
		waitMin();
		return this;
	}

}
