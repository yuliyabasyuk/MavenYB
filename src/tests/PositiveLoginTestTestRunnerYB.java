package tests;
import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.IUser;
import data.UserRepository;
import io.appium.java_client.ios.IOSElement;
import appl.Application;
//import appl.CapabilitiesRepo;
import pages.LoginPage;
import pages.MapPage;
import pages.TestRunner;
import pages.ValidatorLoginPage;
import tests.InitializeLogging;

public class PositiveLoginTestTestRunnerYB extends TestRunner{
	@DataProvider
	public Object[][] TestUsers() {
		return new Object[][] { 
				{ UserRepository.get().dfrUser22Login() }//,
				//{ UserRepository.get().dfrInvUser23Login() }
				};
	}
	
	@Test(dataProvider = "TestUsers")

	public void checkLogin(IUser user) throws Exception {
		
		// Test steps.
		InitializeLogging.getLogger().debug("Debug - user: " + user);
		
		
		MapPage loginPage = Application.get().load().successLogin(user);
		//LoginPage loginPage = Application.get().load();
		//loginPage.successLogin(user);
		System.out.println("Debug - loginPage object: " + loginPage);
		
		/*
		try {
			IOSElement element = null;
			//element = (IOSElement) ios.findElementByAccessibilityId(
					//"This application uses location data to display your location on the map and provide a list of nearby stations.");
			element = (IOSElement) loginPage.ios.findElementByAccessibilityId("Allow \"ENT\" to access your location while you are using the app?");
			if(element != null) {
				loginPage.ios.findElementByAccessibilityId("Allow").click();
				System.out.println("Location popup is accepted");
			}
		}catch(Exception e) {
			//InitializeLogging.getLogger().info(e);
			System.out.println(e);
		}
		
		
		try {
			IOSElement element = null;
			//element = (IOSElement) ios.findElementByAccessibilityId(
					//"This application uses location data to display your location on the map and provide a list of nearby stations.");
			element = (IOSElement) loginPage.ios.findElementByAccessibilityId("Notifications may include alerts, sounds, and icon badges. These can be configured in Settings.");
			if(element != null) {
				loginPage.ios.findElementByAccessibilityId("Allow").click();
				System.out.println("Notification popup is accepted");
			}
		}catch(Exception e) {
			//InitializeLogging.getLogger().info(e);
			System.out.println(e);
		}
		*/
		
		//ValidatorLoginPage validatorLoginPage = loginPage.unsuccessfullLogin(user);
		//MapPage mapPage = (MapPage) loginPage;
		
		/* Check
		Assert.assertEquals(validatorLoginPage.getAuthErrPopupAttrPropertyValue(),
				ValidatorLoginPage.AUTH_ERR_POPUP_TEXT); 
		*/	
		

		// Post Conditions
		
		
	
	}

}
