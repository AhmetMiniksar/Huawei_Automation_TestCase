package eCommerce01.pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.Constants;

public class ShoppingPage extends BasePage {

	private String productUrl;

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/main/div[2]/div/div/div/div/div[2]/section/div[1]/div[4]/div/div/div/div/ul/li[3]/div/a")
	private WebElement product;

	@FindBy(how = How.CLASS_NAME, using = "page-2")
	private WebElement switchpage;

	public ShoppingPage(WebDriver driver) {
		super(driver);
	}

	public ShoppingPage selectProduct() throws InterruptedException {
		product.click();
		Thread.sleep(Constants.MIN_DELAY_TIME);
		return this;
	}

	public void clickSwitchPage() {
		switchpage.click();
	}

	public ShoppingPage nextPage() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,6000)");
		clickSwitchPage();
		return this;
	}

	public ShoppingPage setProductHref() {
		productUrl = Constants.MAIN_URL + product.getAttribute("href");
		return this;
	}

	public ShoppingPage checkProductAndPage(String productName, String page) {
		Assert.assertTrue(
				driver.getCurrentUrl().equals(Constants.MAIN_URL + "ara?q=" + productName + "&sayfa=" + page));
		return this;
	}

	public ShoppingPage checkClickedProductIsTrue() {
		Assert.assertEquals(this.productUrl, productUrl);
		return this;
	}

}
