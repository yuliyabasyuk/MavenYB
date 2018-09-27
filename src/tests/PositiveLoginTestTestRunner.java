package tests;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import appl.Application;
import data.IUser;
import data.UserRepository;
import io.appium.java_client.ios.IOSDriver;
import pages.AccountPage;
import pages.CoachMarkPage;
import pages.LoginPage;
import pages.MapPage;
import pages.PreferencesPage;
import pages.TestRunner;

public class PositiveLoginTestTestRunner extends TestRunner{
	public IOSDriver<?> ios;
	public WebDriverWait wait;
	
	@DataProvider
	public Object[][] TestUsers() {
		return new Object[][] { 
				{ UserRepository.get().dfrUser22Login() },
				{ UserRepository.get().dfrUser23Login() }
				};
	}
	
	@Test(dataProvider = "TestUsers")

	public void checkLogin(IUser user) throws Exception {
		
		// Test steps.
		InitializeLogging.getLogger().debug("Debug - user: " + user);
		
		LoginPage loginPage = Application.get().load();
		
		MapPage mapPage;
		// sign in
		try {
			mapPage = loginPage.successLoginDevice(user); 
			System.out.println("DEBUG: after \'mapPage = loginPage.setLoginData(user);\' ");
		} catch (NoSuchElementException nsee) {
			InitializeLogging.getLogger().info(nsee);
			// nsee.printStackTrace();
			mapPage = new MapPage(ios);
		}

		// handle GPS popup
		try {
			mapPage.dismissGpsAlert();
			System.out.println("DEBUG: after \"mapPage.dismissGpsAlert();\" ");
		} catch (Exception e) {
			System.out.println("E in the \"mapPage.dismissGpsAlert()\"!");
			//InitializeLogging.getLogger().info(e);
			//e.printStackTrace();
		}
		
		// handle APNS
		try {
			mapPage.dismissApnsAlert();
			System.out.println("DEBUG: after \"mapPage.dismissApnsAlert();	\" ");
		} catch (Exception e) {
			//InitializeLogging.getLogger().info(e);
			//e.printStackTrace();
			System.out.println("E in the \"mapPage.dismissApnsAlert()\"!");
		}
		
		CoachMarkPage coachMark;
		// handle Automatic Basemap Downloads
		try {
			coachMark = mapPage.closeABDpopup();
			System.out.println("DEBUG: after \"coachMark = mapPage.closeABDpopup(); \" ");
		} catch (Exception e) {
			//InitializeLogging.getLogger().info(e);
			//e.printStackTrace();
			System.out.println("E in the \"mapPage.closeABDpopup();\"!");
			coachMark = new CoachMarkPage(ios);
		}
		
		// handle CoachMarks
		try {
			coachMark.toMapFromCoachMarks();
			System.out.println("DEBUG: after \"coachMark.toMapFromCoachMarks(); \" ");
		} catch (Exception e) {
			//InitializeLogging.getLogger().info(e);
			//e.printStackTrace();
			System.out.println("E in the \"coachMark.toMapFromCoachMarks();\"!");
		}

		
		// Check Sign In
		Assert.assertEquals(mapPage.getMapTabText(), "MAP"); // check that we are at the 'Map' page after signing in.
		System.out.println("DEBUG, signed in OK.  After \'Assert.assertEquals(mapPage.getMapTabText(), \"MAP\")\'");

		
		// Post conditions | return to the Preferences
		PreferencesPage preferences;

		try {
			preferences = mapPage.clickPreferences();
			if (preferences.getPreferencesTab() != null) {
				preferences.clickPreferencesTab();
			}	
		} catch (Exception e) {
			e.printStackTrace();
			preferences = new PreferencesPage(ios);
		}
		
		AccountPage account;
		try {
			account = preferences.getAccountPage();
		}
		catch  (Exception e) {
			e.printStackTrace();
			account = new AccountPage(ios);
		}
		
		account.logout();

		// Check after logout:
//		System.out.println("1. calling \'loginPage.getLoginImageName()' " + loginPage.getLoginImageName()); 			// constant. returns Login_RegBox_Backgrnd.png
//		System.out.println("2. calling \'loginPage.getLoginImageAttrType()\' " + loginPage.getLoginImageAttrType()); 	// returns attribute type - name
//		System.out.println("3. calling \'loginPage.getLoginImageAttributeText(loginPage.getLoginImageAttrType())\' " + loginPage.getLoginImageAttributeText(loginPage.getLoginImageAttrType()) ); // returns Login_RegBox_Backgrnd.png
	
		Assert.assertTrue(loginPage.getLoginImageAttributeText(loginPage.getLoginImageAttrType()).equals(loginPage.getLoginImageName()));  // check we are at the Login page e.g. logout() succeeded. 
		System.out.println("DEBUG, done.");
	
	
	}

}
