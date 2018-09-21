package tests;
//package tests;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//
//import javax.websocket.DeploymentException;
//
//import org.junit.Assert;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import data.IUser;
//import data.UserRepository;
//import io.appium.java_client.ios.IOSDriver;
//
//import pages.LoginPage;
//
//import pages.ValidatorLoginPage;
//
//////////////
//public class NegativeLoginTests {
//	public IOSDriver<?> ios;
//	public WebDriverWait wait;
//
//	@BeforeClass
//	/* Here should arrive object of the app source....
//	 * Questions to answer: 1. how to pass object for capabilities from the AppSourcesRepository...
//	 * In the 'Steps' we should not create a new LoginPage, there should be something like this ... = Application.get().load() which will start the app on the device. 
//	 * For this purpose is needed to create an Application.class which will parse the AppSources, 
//	 * and which will start the browser with needed parameters.
//	 * 
//	 * 
//	 * */
//	public void SetupM() throws MalformedURLException {
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability("appWaitActivity", "*");
//		capabilities.setCapability("bundleId", "com.wsi.Pilotbrief.Debug.ENT");
//		capabilities.setCapability("platformName", "iOS");
//		capabilities.setCapability("platformVersion", "11.4.1");
//		capabilities.setCapability("deviceName", "WSI-SS-LV-iPad-mini-ios11.4.1");
//		capabilities.setCapability("udid", "214dea41a08e58587fb16540f2f5707f56d1aec0");
//		capabilities.setCapability("app",
//				"/Users/olaytar/PBAutoTest/apps/Pilotbrief.ENT-2.14.1-5391.126-Rel-Staging-AdHoc.ipa");
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
//	@DataProvider
//	public Object[][] invTestUsers() {
//		return new Object[][] { 
//			{ UserRepository.get().dfrInvUser22Login() },
//			{ UserRepository.get().dfrInvUser23Login() } };
//	}
//
//	//@Test(dataProvider = "invTestUsers")
//
//	/*
//	 * Instead of login and password -
//	 * "checkInvLogin(String username, String password)" here should be an object of
//	 * the user. Is needed to create a class which will describe the user.
//	 */
//	public void checkInvLogin(IUser user) throws NoSuchElementException, InterruptedException, DeploymentException {
//
//		// Preconditions
//		wait = new WebDriverWait(ios, 20);
//
//		// Steps
//
//		// LoginPage loginPage = Appl.get().load()
//		LoginPage loginPage = new LoginPage(ios, wait);
//		ValidatorLoginPage validatorLoginPage;
//
//		try {
//			// System.out.println("DEBUG, before \'validatorLoginPage =
//			// loginPage.unsuccessfullLogin(username, password);\'");
//			// validatorLoginPage = loginPage.unsuccessfullLogin(username, password);
//			validatorLoginPage = loginPage.unsuccessfullLogin(user);
//			// System.out.println("DEBUG, before
//			// \'wait.until(ExpectedConditions.alertIsPresent());\'");
//			// wait.until(ExpectedConditions.alertIsPresent());
//		} catch (Exception e) {
//			// e.printStackTrace();
//			System.out.println("E in the \"loginPage.unsuccessfullLogin(username, password);\" ");
//			validatorLoginPage = new ValidatorLoginPage(ios, wait);
//			// ios.quit();
//		}
//
//		// Check
//		// check that alert 'AUTHENTICATION ERROR' displayed after unsuccessful login.
//		Assert.assertEquals(validatorLoginPage.getAuthErrPopupAttrPropertyValue(),
//				ValidatorLoginPage.AUTH_ERR_POPUP_TEXT); // "AUTHENTICATION ERROR" - is a test data and shouldn't be
//															// hardcoded in the test.
//
//		System.out.println(
//				"DEBUG, after \'Assert.assertEquals(validatorLoginPage.getAuthErrPopupAttrPropertyValue(), ValidatorLoginPage.AUTH_ERR_POPUP_TEXT);\' "
//						+ validatorLoginPage.getAuthErrPopupAttrPropertyValue());
//
//		// Post conditions
//		try {
//			// System.out.println("DEBUG, before
//			// \'validatorLoginPage.dismissAuthErrPopup();\'");
//			validatorLoginPage.dismissAuthErrPopup();
//			// System.out.println("DEBUG, after
//			// \'validatorLoginPage.dismissAuthErrPopup();\'");
//		} catch (Exception e) {
//			// e.printStackTrace();
//			System.out.println("E in the \' validatorLoginPage.dismissAuthErrPopup() \'");
//		}
//
//	}
//
//}
