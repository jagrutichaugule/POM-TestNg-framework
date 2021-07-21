package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();	// In order to call constructor of TestBase class. It is mandatory before initialization to call the constructor and initialize the properties.
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginTitle();
		Assert.assertEquals(title, "Box — Secure Cloud Content Management, Workflow, and Collaboration","Login page title is not matching. Please check the URL.");
	}
	
	@Test(priority=2)
	public void boxLogoTest() {
		boolean flag = loginPage.validateBOXLogo();
		Assert.assertTrue(flag,"Application logo is not displayed properly.");
	}
	
	@Test(priority=3)
	@Parameters({"username","password"})
	public void loginTest(String username,String password) {
		homePage = loginPage.login(username, password);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
