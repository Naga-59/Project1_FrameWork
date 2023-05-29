package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LogInPage;
import testBase.BaseClass;
import utilities.DataProviderUtilities;
import pageObjects.LogOutPage;

public class Tc_001_LogInTest extends BaseClass{
//(dataProvider="LogInDatas",dataProviderClass=DataProviderUtilities.class)
	//String Username, String Password
	@Test
	void test_LogIn() {
		logger.debug("*** Application logs ***");
		logger.info("*** Starting Tc_001_Login_Test ***");

		
			LogInPage lp=new LogInPage(driver);

			//Thread.sleep(5000);
			logger.info("*** login username has provided ***");
			lp.username(rb.getString("UserName")); //from config.properties
			//lp.username(Username);

			logger.info("*** Login password has provided ***");
			lp.password(rb.getString("Password")); //from config.properties
			//lp.password(Password);

			logger.info("*** successfully login button submitted ***");
			lp.submitButton();

			Assert.assertEquals(true, lp.home_logos());

			//boolean hl=lp.home_logos();

			LogOutPage lo=new LogOutPage(driver);
			lo.logoutOption();
			lo.logOutButton();
			Assert.assertEquals(true, lp.logInLog());


			//		if(Exp.equals("InValid")) {
			//			if(hl==true) {
			//				LogOutPage lo=new LogOutPage(driver);
			//				lo.logoutOption();
			//				lo.logOutButton();
			//				Assert.assertEquals(false, lp.logInLog());
			//			}
			//			else {
			//				Assert.assertTrue(true);
			//			}
			//		}
		


		logger.info("****Finished TC_001_Login****");
	}

}
