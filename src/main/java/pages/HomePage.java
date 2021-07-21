package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class HomePage extends TestBase{
	
	// OR
	@FindBy(xpath="//button[contains(@class,'ProfileButton')]")
	WebElement profileBtn;
	
	@FindBy(linkText="Log Out")
	WebElement logoutBtn;
	
	@FindBy(xpath="//span[contains(text(),'New')]")
	WebElement newBtn;
	
	@FindBy(xpath="//li[contains(@class,'CreateItemMenuItem')]")
	List<WebElement> newMenuList;
	
	@FindBy(xpath="//span[contains(text(),'Upload')]")
	WebElement uploadBtn;
	
	@FindBy(xpath="//li[contains(@class,'UploadMenuItem')]")
	List<WebElement> uploadMenuList;
	
	@FindBy(className="item-name")
	List<WebElement> itemName;
	
	@FindBy(xpath="//button[@class='close-btn']")
	WebElement notificationClose;
	
	//Initializing all element
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	
	WebDriverWait wait = new WebDriverWait(driver,30);
	
	public String validateHomePage() {
		return driver.getTitle();
	}
	
	public CreateFolderPage newFolderCreate() {
		
		Actions a = new Actions(driver);
		a.moveToElement(newBtn).click().build().perform();
		
		for(int i = 0;i < newMenuList.size();i++) {
			if(newMenuList.get(i).getText().equals("Folder")) {
				newMenuList.get(i).click();
				break;
			}
		}
		
		return new CreateFolderPage();
	}
	
	public UploadFilePage fileUpload() {
		
		Actions a = new Actions(driver);
		a.moveToElement(uploadBtn).click().build().perform();
		
		for(int i = 0;i < uploadMenuList.size();i++) {
			if(uploadMenuList.get(i).getText().equals("File")) {
				uploadMenuList.get(i).click();
				break;
			}
		}
		
		return new UploadFilePage();
	}
	
	public LoginPage logout() {
		profileBtn.click();
		
		logoutBtn.click();
		
		return new LoginPage();
	}
	
	public boolean validateUpload(String name) {
		boolean flag = false;
		
		wait.until(ExpectedConditions.visibilityOf(notificationClose));
		
		for(int i = 0;i < itemName.size();i++) {
			if(itemName.get(i).getText().equals(name)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
}
