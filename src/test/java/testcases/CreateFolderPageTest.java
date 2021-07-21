package testcases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CreateFolderPage;
import pages.HomePage;
import pages.LoginPage;

public class CreateFolderPageTest extends TestBase {
	
	LoginPage loginPage;
	CreateFolderPage createFolderPage;
	HomePage homePage;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	Date date = new java.util.Date();
    
	public String folderName = "TestFolder" + sdf.format(date);
	public String invite = "test123@gmail.com";
	
	public CreateFolderPageTest() {
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
	public void createFolderTest() {
		createFolderPage = homePage.newFolderCreate();
		
		String title = createFolderPage.dialogTitle();
		Assert.assertEquals(title,"Create a New Folder","Create folder window is not displayed.");
		
		homePage = createFolderPage.createFolder(folderName, invite, "");
		
		boolean flag = homePage.validateUpload(folderName);
		Assert.assertTrue(flag, "Folder name is not present in the list.");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
