package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.TestBase;

public class UploadFilePage extends TestBase {

	// OR
	@FindBy(xpath="//span[contains(text(),'Uploading')]")
	WebElement uploading;
	
	@FindBy(xpath="//span[contains(text(),'Completed')]")
	WebElement completed;
	
	// Actions
	
	public HomePage fileUploadDialog(String filePath) {
		File file = new File(filePath);
		 
		StringSelection stringSelection= new StringSelection(file.getAbsolutePath());
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		Robot robot = null;
	    try {
	        robot = new Robot();
	    } catch (AWTException e) {
	        e.printStackTrace();
	    }
	    
	    robot.delay(1000);
	    
		robot.keyPress(KeyEvent.VK_META);
		robot.delay(300);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.delay(300);
		robot.keyRelease(KeyEvent.VK_META);
		robot.delay(300);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(3000);

		//Open Goto window		 
		robot.keyPress(KeyEvent.VK_META);
		robot.delay(300);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.delay(300);
		robot.keyPress(KeyEvent.VK_G);
		robot.delay(300);
		robot.keyRelease(KeyEvent.VK_META);
		robot.delay(300);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.delay(300);
		robot.keyRelease(KeyEvent.VK_G);
		robot.delay(500);
		 
		//Paste the clipboard value
		robot.keyPress(KeyEvent.VK_META);
		robot.delay(300);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(300);
		robot.keyRelease(KeyEvent.VK_META);
		robot.delay(300);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(500);
		 
		//Press Enter key to close the Goto window and Upload window
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(300);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(300);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(300);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(500);
		
		return new HomePage();
	}
}
