package eCommerce01.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShoppingCartPage extends BasePage {

	@FindBy(how = How.CLASS_NAME, using = "product_delete_1zR-0")
	private WebElement removeProduct;
	
	public static String deletedProductPageUrl = "https://checkout.hepsiburada.com/sepetim";

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	public ShoppingCartPage removeProduct() throws InterruptedException {
		removeProduct.click();
		waitMin();
		return this;

	}

	public ShoppingCartPage isProductRemoved() {
		Assert.assertTrue(driver.findElements(By.id("onboarding_item_list")).size() == 0);
		return this;
	}

}
