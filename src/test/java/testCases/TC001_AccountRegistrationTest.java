package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
  /*
	public WebDriver driver;
	
	
	@BeforeClass
	public void setup() {
		
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		 
		 driver.quit();
		 
	 }
	 */
	 
	@Test(groups ={"Regression","Master"})
	public void verify_account_registration() {
		HomePage hb = new HomePage(driver);
		
		hb.clickMyAccount();
		hb.clickRegister();
		
		AccountRegistrationPage actpage= new AccountRegistrationPage(driver);
		//actpage.setFirstName("John");
		actpage.setFirstName(randomString().toUpperCase());
		actpage.setLastName(randomString().toUpperCase());
		actpage.setEmail(randomString()+"@gmail.com");
		actpage.setTelephone(randomNumber());
		
		
		String password = randomAlphaNumeric();
		actpage.setPassword(password);
		actpage.setConfirmPassword(password);
		
		actpage.setChkdPolicy();
		actpage.clickContinue();
		String confmsg = actpage.getConfirmationMessage();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	}
	
	/*
	@SuppressWarnings("deprecation")
	public String randomString() {
		
		
		String generatedString = RandomStringUtils.randomAlphabetic(10); 
		 return generatedString;
		
	}
	
    @SuppressWarnings("deprecation")
	public String randomNumber() {
		
		
		String generatedNumber= RandomStringUtils.randomNumeric(10); 
		 return generatedNumber;
		
	
    }
    
    @SuppressWarnings("deprecation")
	public String randomAlphaNumeric() {
		
    	String generatedString = RandomStringUtils.randomAlphabetic(10);
		String generatedNumber = RandomStringUtils.randomNumeric(10); 
		 return (generatedString+"@"+generatedNumber);
		
	
    }
	*/
	
}
