package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		
		logger.info("***** Starting TC_OO2_LoginTest *****");
		
		try {
		//from the homepage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		logger.info("****** login clicked *********");
		
		//from the loginpage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.setButton();
		logger.info("****** login page showed or not");
		
		//validation to be done from Myaccount page
		MyAccountPage my_ap = new MyAccountPage(driver);
		boolean targetPage =  my_ap.isMyAccountPageExists();
		Assert.assertEquals(targetPage, true,"Login failed");
		} catch(Exception e) {
			
			Assert.fail();
		}
		
		logger.info("****** Finished TC002_LoginTest ******");
		
	}
	
	
	
	
	
}
