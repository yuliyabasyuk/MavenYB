package tests;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.IUser;
import data.UserRepository;

import appl.Application;
//import appl.CapabilitiesRepo;
import pages.LoginPage;

import pages.TestRunner;
import pages.ValidatorLoginPage;


public class NegativeLoginTestTestRunner extends TestRunner {

	@DataProvider
	public Object[][] invTestUsers() {
		return new Object[][] { 
				{ UserRepository.get().dfrInvUser22Login() }//,
				//{ UserRepository.get().dfrInvUser23Login() }
				};
	}
	
	@Test(dataProvider = "invTestUsers")

	public void checkInvLogin(IUser user) throws Exception {
		//logger.info("Start");
		
		// Precondition.
		//
		// Test steps.
		System.out.println("Debug - user: " + user);
		
		LoginPage loginPage = Application.get().load().unsuccessfullLogin(user);
		InitializeLogging.getLogger().debug("LoginPage object: " + loginPage);
		InitializeLogging.getLogger().debug("Check debug by logger");
		
		//ValidatorLoginPage validatorLoginPage = loginPage.unsuccessfullLogin(user);
		ValidatorLoginPage validatorLoginPage = (ValidatorLoginPage) loginPage;
		
		// Check
		Assert.assertEquals(validatorLoginPage.getAuthErrPopupAttrPropertyValue(),
				ValidatorLoginPage.AUTH_ERR_POPUP_TEXT); 
														

		// Post Conditions
		try {
			validatorLoginPage.dismissAuthErrPopup();
		} catch (Exception e) {
			System.out.println("E in the \' validatorLoginPage.dismissAuthErrPopup() \'");
			// e.printStackTrace();
		}
		
	
	}

}