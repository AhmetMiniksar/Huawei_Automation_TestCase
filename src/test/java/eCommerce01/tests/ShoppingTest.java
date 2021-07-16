package eCommerce01.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import eCommerce01.pages.HomePage;
import eCommerce01.pages.LoginPage;
import eCommerce01.pages.ProductPage;
import eCommerce01.pages.ShoppingCartPage;
import eCommerce01.pages.ShoppingPage;
import models.ScreenshotStatus;
import utils.Constants;
import utils.Screenshot;

public class ShoppingTest {

	WebDriver driver;

	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.get(Constants.MAIN_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void shoppingTest() throws InterruptedException, IOException {

		HomePage homePage = new HomePage(driver);
		homePage.isPageOpened();

		LoginPage login = new LoginPage(driver);
		login.hoverlogin()
			 .userLogin("adfagfgafsgasgasf@gmail.com", "Test_1212");

		String productName = "huawei";
		homePage.searchProduct(productName)
				.isPageOpenedForSearch(productName);

		ShoppingPage shoppingPage = new ShoppingPage(driver);

		shoppingPage.nextPage()
					.checkProductAndPage(productName, "2")
					.setProductHref()
					.selectProduct()
					.checkClickedProductIsTrue();

		ProductPage productPage = new ProductPage(driver);
		Thread.sleep(Constants.MIN_DELAY_TIME);
		
		productPage.addCart()
					.goShoppingCart();

		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		shoppingCartPage.removeProduct()
						.isProductRemoved();

		Screenshot.takeScreenshot(driver, productName, ScreenshotStatus.SUCCESS);

	}

	@After
	public void close() {

		driver.close();

	}

}
