package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDataDrivenTest extends BaseClass {
	
	@Test(dataProvider="LoginData" , dataProviderClass=DataProviders.class , groups="DataDriven")
	public void verify_loginDDT(String email, String pwd, String exp) {
	logger.info("***** TC003_LoginDDTtestStarted *****");
	
	try
	{HomePage hp = new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();

	//from the loginpage
	LoginPage lp = new LoginPage(driver);
	lp.setEmail(p.getProperty("email"));
	lp.setPassword(p.getProperty("password"));
	lp.setButton();
	
	//validation to be done from Myaccount page
	MyAccountPage my_ap = new MyAccountPage(driver);
	boolean targetPage =  my_ap.isMyAccountPageExists();
	
	if(exp.equalsIgnoreCase("Valid")) {
		if (targetPage==true) {
			my_ap.clickLogout();
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}
	
	if(exp.equalsIgnoreCase("Invalid")) {
		if (targetPage==true) {
			my_ap.clickLogout();
			Assert.assertTrue(false);
		}else {
			Assert.assertTrue(true);
		}
	}
	}
	catch(Exception e) {
		Assert.fail();
	}
	logger.info("***** TC003 ended *****");
	
	

	}
}

