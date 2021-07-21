package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class LoginPage extends TestBase {
	
	// OR
	@FindBy(linkText="Log in")
	@CacheLookup
	WebElement loginLink;
	
	@FindBy(id="login-email")
	@CacheLookup
	WebElement emailid;
	
	@FindBy(id="login-submit")
	@CacheLookup
	WebElement emailSubmit;
	
	@FindBy(id="password-login")
	@CacheLookup
	WebElement password;
	
	@FindBy(id="login-submit-password")
	@CacheLookup
	WebElement passwordSubmit;
	
	@FindBy(xpath="//a[@class='box-logo']")
	@CacheLookup
	WebElement logo;
	
	//Initializing all element
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	WebDriverWait wait = new WebDriverWait(driver,50);
	
	public String validateLoginTitle() {
		return driver.getTitle();
	}
	
	public boolean validateBOXLogo() {
		return logo.isDisplayed();
	}
	
	public HomePage login(String email, String pass) {
		loginLink.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(emailid));
		emailid.sendKeys(email);
		emailSubmit.click();
		
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		password.sendKeys(pass);
		passwordSubmit.click();
		
		return new HomePage();
	}
	
	public String validateLogoutPage() {
		wait.until(ExpectedConditions.elementToBeClickable(emailid));
		
		return driver.getTitle();
	}
}
