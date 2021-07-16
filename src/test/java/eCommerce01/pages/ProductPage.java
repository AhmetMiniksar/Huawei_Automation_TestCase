package eCommerce01.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPage extends BasePage {

	@FindBy(how = How.ID, using = "addToCart")
	private WebElement addCartButton;

	@FindBy(how = How.ID, using = "shoppingCart")
	private WebElement shoppingCartButton;

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	public void scrollToElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}

	public ProductPage goShoppingCart() throws InterruptedException {
		driver.get("https://checkout.hepsiburada.com/sepetim");
		return this;
	}

	public ProductPage addCart() throws InterruptedException {
		addCartButton.click();
		waitMin();
		return this;
	}

}
