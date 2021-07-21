package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.UploadFilePage;

public class UploadFileTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	UploadFilePage uploadFilePage;
	
	public String filePath = "/Users/scorpio/Desktop/Letter.pdf";
	
	public UploadFileTest() {
		super();
	}
	
	@BeforeMethod
	@Parameters({"username","password"})
	public void setUp(String username,String password) {
		initialization();
		
		loginPage = new LoginPage();
		homePage = loginPage.login(username,password);
	}
	
	@Test()
	public void uploadFileTest() {
		uploadFilePage = homePage.fileUpload();
		
		homePage = uploadFilePage.fileUploadDialog(filePath);
		
		String[] arrOfStr = filePath.split("/");
		String fileName = arrOfStr[(arrOfStr.length)-1];
		
		System.out.println(fileName);
		
		boolean uploadFlag = homePage.validateUpload(fileName);
		
		Assert.assertTrue(uploadFlag, "File name not present in the list. File not uploaded correctly.");	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
