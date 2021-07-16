package eCommerce01.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utils.Constants;

public class BasePage {
	
	public WebDriver driver;
	
	BasePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitMin() throws InterruptedException {
		Thread.sleep(Constants.MIN_DELAY_TIME);		
	}
	public void waitMax() throws InterruptedException {
		Thread.sleep(Constants.MAX_DELAY_TIME);		
	}
}
