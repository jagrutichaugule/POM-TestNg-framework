package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class CreateFolderPage extends TestBase {

	// OR
	@FindBy(name="folder-name")
	WebElement folderName;
	
	@FindBy(xpath="//textarea[contains(@placeholder,'Enter email')]")
	WebElement invitePeople;
	
	@FindBy(name="invite-permission")
	WebElement invitePermission;
	
	@FindBy(xpath="//button[@data-resin-target='primarybutton']")
	WebElement createBtn;
	
	@FindBy(xpath="//button[@data-resin-target='cancel']")
	WebElement cancelBtn;
	
	@FindBy(xpath="//div[@class='modal-header']//span")
	WebElement createFolderDialog;
	
	public CreateFolderPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	
	public String dialogTitle() {
		return createFolderDialog.getText();
	}
	
	public HomePage createFolder(String folderName, String enterEmail, String permission) {
		
		this.folderName.sendKeys(folderName);
		invitePeople.sendKeys(enterEmail);
		
		if(permission.isEmpty() == false) {
			Select perm = new Select(invitePermission);
			perm.selectByVisibleText(permission);
		}
		
		createBtn.click();
		
		return new HomePage();
		
	}
}
