package eCommerce01.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utils.Constants;

public class LoginPage extends BasePage {
	
	@FindBy(how = How.ID, using = "txtUserName")		
	private WebElement emailBox;
	
	@FindBy(how = How.ID, using = "txtPassword")		
	private WebElement passwordBox; 
	
	@FindBy(how = How.ID, using = "btnLogin")		
	private WebElement loginButton;
	
	@FindBy(how = How.ID, using = "login")
	private WebElement signIn;
	
	public LoginPage(WebDriver driver) {
		super(driver);		
	}
	
	public void setUser_email(String email) {		
		emailBox.clear();
		emailBox.sendKeys(email);		
	}
	
	public void setUser_password(String password) {		
		passwordBox.clear();
		passwordBox.sendKeys(password);
		
	}
	
	public void clickLoginButton() {
		
		loginButton.click();
		
	}
	
	public void clickSignIn() {
		
		signIn.click();
	}
	
	public LoginPage userLogin(String email, String password) throws InterruptedException {		
		setUser_email(email);
		setUser_password(password);
		clickLoginButton();
		waitMin();		
		return this;		
	}
	
	public LoginPage hoverlogin() {		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"myAccount\"]/span/span[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();        
        clickSignIn();        
        return this;
	}
	
}
