package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class LogoutPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	@Parameters({"username","password"})
	public void setUp(String username,String password) {
		initialization();
		
		loginPage = new LoginPage();
		homePage = loginPage.login(username,password);
	}
	
	@Test(priority=1)
	public void logoutTest() {
		String homePageTitle = homePage.validateHomePage();
		Assert.assertEquals(homePageTitle, "All Files | Powered by Box","Homepage title is not matching.");
		
		loginPage = homePage.logout();
		
		String logoutPageTitle = loginPage.validateLogoutPage();
		Assert.assertEquals(logoutPageTitle, "Box | Login","Page title after Logout action is not matching.");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
