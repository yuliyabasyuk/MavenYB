package tests;
//package tests;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//import javax.websocket.DeploymentException;
//
//import org.junit.Assert;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import data.IUser;
//import data.UserRepository;
//import io.appium.java_client.ios.IOSDriver;
//import pages.AccountPage;
//import pages.CoachMarkPage;
//import pages.LoginPage;
//import pages.MapPage;
//import pages.PreferencesPage;
//
//////////////
//public class PositiveLoginTests {
//	public IOSDriver<?> ios;
//	public WebDriverWait wait;
//
//	@BeforeClass
//	public void SetupM() throws MalformedURLException {
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability("appWaitActivity", "*");
//		capabilities.setCapability("bundleId", "com.wsi.Pilotbrief.Debug.ENT");
//		capabilities.setCapability("platformName", "iOS");
//		capabilities.setCapability("platformVersion", "10.3.3");
//		capabilities.setCapability("deviceName", "WSI-SS-LV-iPad-mini-ios10.3.1");
//		capabilities.setCapability("udid", "214dea41a08e58587fb16540f2f5707f56d1aec0");
////		capabilities.setCapability("platformVersion", "11.4.1");
////		capabilities.setCapability("deviceName", "WSI-SS-LV-iPadAir-iOS11.4.1");
////		capabilities.setCapability("udid", "c0088e0cc97d48d7289135a0ae1d5ac46f86f8dc");
//		capabilities.setCapability("app",
//				"/Users/olaytar/PBAutoTest/apps/Pilotbrief.ENT-develop-5380.448-Debug-Staging-Development.ipa");
//		capabilities.setCapability("xcodeOrgId", "73CP3TPHE9");
//		capabilities.setCapability("xcodeSigningId", "iPhone Developer");
//		capabilities.setCapability("applicationName", "ENT");
//		capabilities.setCapability("automationName", "XCUITest");
//		capabilities.setCapability("noReset", "true");
//		capabilities.setCapability("fullReset", "false");
//
//		URL remoteURL = new URL("http://127.0.0.1:4723/wd/hub");
//		ios = new IOSDriver<>(remoteURL, capabilities);
//
//		// ios.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		// wait = new WebDriverWait(ios, 20);
//
//	}
//
//	//@DataProvider
//	public Object[][] testUsers() {
//		return new Object[][] { 
////			{ "ioptima_glbhazards@wsi.com", "weather" }, 
////			{ "dfrdemo2.5@wsi.com", "wsi" }
//			{ UserRepository.get().dfrUser22Login() },
//			{ UserRepository.get().dfrUser23Login() }
//		};
//	}
//
//	@Test(dataProvider = "testUsers")
//	public void checkLogin(IUser user)
//			throws NoSuchElementException, InterruptedException, DeploymentException {
//
//		// Preconditions
//		wait = new WebDriverWait(ios, 20);
//
//		// Steps
//		LoginPage loginPage = new LoginPage(ios, wait);
//		MapPage mapPage;
/////*
//		try {
//			//mapPage = loginPage.setLoginData(username, password);
//			mapPage = loginPage.setLoginData(user);
//		} catch (NoSuchElementException nsee) {
//			// nsee.printStackTrace();
//			//System.out.println("NSEE in the \"loginPage.setLoginData(username, password);\" ");
//			mapPage = new MapPage(ios, wait);
//			// ios.removeApp("com.wsi.Pilotbrief.Debug.ENT");
//		}
//
//		// MapPage mapPage = new MapPage(ios);
//
//		try {
//			//System.out.println("DEBUG, waiting before \"mapPage.dismissGpsAlert();\" ");
//			wait.until(ExpectedConditions.alertIsPresent());
//			//System.out.println("DEBUG, after wait, before mmapPage.dosmissGpsAlert()");
//			mapPage.dismissGpsAlert();
//			System.out.println("DEBUG, after \"mapPage.dismissGpsAlert(); \"");
//		} catch (Exception e) {
//			// e.printStackTrace();
//			System.out.println("E in the \"mapPage.dismissGpsAlert()\"!");
//		}
//
//		try {
//			//System.out.println("DEBUG, waiting before \"mapPage.dismissApnsAlert();\" ");
//			wait.until(ExpectedConditions.alertIsPresent());
//			//System.out.println("DEBUG, after wait, before \"mapPage.dismissApnsAlert();\" ");
//			mapPage.dismissApnsAlert();
//			System.out.println("DEBUG, after \"mapPage.dismissApnsAlert(); \"");
//		} catch (Exception e) {
//			// e.printStackTrace();
//			System.out.println("E in the \"mapPage.dismissApnsAlert()\"!");
//		}
//
//		try {
//			//System.out.println("DEBUG, waiting before \"mapPage.closeABDpopup(); \"");
//			Thread.sleep(4000);
//			wait.until(ExpectedConditions.visibilityOf(mapPage.getABDpopup())); // check if it works
//			System.out.println("DEBUG, after wait.until, before \"mapPage.closeABDpopup();\" ");
//			mapPage.closeABDpopup();
//			Thread.sleep(4000);
//			System.out.println("DEBUG, after \"mapPage.closeABDpopup(); \" ");
//		} catch (Exception e) {
//			// e.printStackTrace();
//			System.out.println("E in the \"mapPage.closeABDpopup();\"!");
//		}
//
//		CoachMarkPage coachMark = new CoachMarkPage(ios, wait);
//		if (coachMark != null ) System.out.println("DEBUG, created coachMark object..." );
//
//		try {
//			//System.out.println("DEBUG, waiting before \"wait.until(ExpectedConditions.visibilityOf(mapPage.getCoachMarksCloseBtn())); \"");
//			Thread.sleep(4000);
//			wait.until(ExpectedConditions.visibilityOf(mapPage.getCoachMarksCloseBtn()));
//			System.out.println("DEBUG, after wait.until, before \"coachMark.toMapFromCoachMarks(); \" ");
//			coachMark.toMapFromCoachMarks();
//			Thread.sleep(4000);
//			System.out.println("DEBUG, after \"coachMark.toMapFromCoachMarks(); \" ");
//		} catch (Exception e) {
//			// e.printStackTrace();
//			System.out.println("E in the \"coachMark.clickCoachMarksClose();\"!");
//		}
//
//		
//		// Check
//		Assert.assertEquals(mapPage.getMapTabText(), "MAP"); // check that we are at the 'Map' page after signing in.
//		System.out.println("DEBUG, signed in OK.  After \' Assert.assertEquals(mapPage.getMapTabText(), \"MAP\") \'");
//
//		// Post conditions | return to the Preferences
//		PreferencesPage preferences = new PreferencesPage(ios, wait);
//		if (preferences == null) System.out.println("DEBUG, doesn't create preferences object...");
//
//		preferences.clickPreferencesTab();
//		preferences.getAccountPage();
//
//		AccountPage account = new AccountPage(ios, wait);
//		if (account == null) System.out.println("DEBUG, doesn't create account object...");
//
//		account.logout();
//// */
//		// Check:
////		System.out.println("1. calling \'loginPage.getLoginImageName()' " + loginPage.getLoginImageName()); 			// constant. returns Login_RegBox_Backgrnd.png
////		System.out.println("2. calling \'loginPage.getLoginImageAttrType()\' " + loginPage.getLoginImageAttrType()); 	// returns attribute type - name
////		System.out.println("3. calling \'loginPage.getLoginImageAttributeText(loginPage.getLoginImageAttrType())\' " + loginPage.getLoginImageAttributeText(loginPage.getLoginImageAttrType()) ); // returns Login_RegBox_Backgrnd.png
//	
//		Assert.assertTrue(loginPage.getLoginImageAttributeText(loginPage.getLoginImageAttrType()).equals(loginPage.getLoginImageName()));  // check we are at the Login page e.g. logout() succeeded. 
//		Thread.sleep(5000);
//		//ios.closeApp();
//		
//		System.out.println("Closed the app. \n");
//
//	}
//
//	// /////
//	// @DataProvider
//	// public Object[][] invtestUsers() {
//	// return new Object[][] {
//	// {"hazards123@wsi.com", "weather123"},
//	// {"dfrdemo2.5@wsi.com", "wsi123"}
//	// };
//	// }
//	//
//	// @Test(dataProvider = "invtestUsers")
//	// public void checkInvLogin(String username, String password) throws Exception
//	// { // pass user object instead of supplying username and password
//	// // Preconditions
//	// IOSDriver<?> ios = null;
//	//
//	// // Steps
//	// ValidatorLoginPage validatorLoginPage = new LoginPage(ios)
//	// .unsuccessfullLogin(username, password);
//	// Thread.sleep(6000);
//	//
//	// // Check
//	// Assert.assertEquals(validatorLoginPage.getAuthenValidatorText(),
//	// validatorLoginPage.AUTHEN_ERROR); // getLoginAccountText() will not work for
//	// the Map page.
//	// // call method to dismiss the AUTHEN_ERROR popup
//	// Assert.assertTrue(validatorLoginPage.getLogoAttributeText().toLowerCase().contains(LoginPage.NAME_IMAGE));
//	//
//	// // Post conditions | return to previous state
//	// Thread.sleep(6000);
//	// //ios.quit();
//	// }
//
//}
