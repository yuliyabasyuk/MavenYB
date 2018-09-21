package pages;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class AccountPage {
	
		// Locators
		private static final String ACCOUNT_PAGE_ID = "Account";	
		private static final String BACK_2_PREFERENCES_BTN_ID = "Preferences";
		private static final String SIGN_OUT_BTN_ID="Sign Out";
		
		
		// Fields
		public IOSDriver<?> ios;
		public WebDriverWait wait;
		private IOSElement accountPage;
		private IOSElement back2PreferencesBtn;
		private IOSElement signOutBtn;
	
		
		// Constructor
		public AccountPage(IOSDriver<?> ios, WebDriverWait wait) {
		//public AccountPage(IOSDriver<?> ios) {
			this.ios = ios;
			this.wait = wait;
//			this.accountPage = (IOSElement) ios.findElementByAccessibilityId(ACCOUNT_PAGE_ID);
//			this.back2PreferencesBtn = (IOSElement) ios.findElementByAccessibilityId(BACK_2_PREFERENCES_BTN_ID);
//			this.signOutBtn = (IOSElement) ios.findElementByAccessibilityId(SIGN_OUT_BTN_ID);
		}
			
		// Page Object //
		// Get Data
		public IOSElement getAccountPage() {
			//return this.accountPage;
			return (IOSElement) ios.findElementByAccessibilityId(ACCOUNT_PAGE_ID);
		}
		
		public IOSElement getBack2PreferencesBtn() {
			//return this.back2PreferencesBtn;
			return (IOSElement) ios.findElementByAccessibilityId(BACK_2_PREFERENCES_BTN_ID);
		}
		
		public IOSElement getSignOutBtn() {
			//return this.signOutBtn;
			return (IOSElement) ios.findElementByAccessibilityId(SIGN_OUT_BTN_ID);
		}
		
		// Methods
		
		public void clickBack2Preferences() {
			getBack2PreferencesBtn().click();
			
		}
		
		public void clickSignOutBtn() {
			System.out.println("in the \'clickSignOutBtn() \' ");
			getSignOutBtn().click();
		}
		
		// Functional
		
		public PreferencesPage back2Preferences() {
			System.out.println("in the \'back2Preferences()\'");
			 clickBack2Preferences();
			 return new PreferencesPage(ios, wait);
		}
		
		public LoginPage logout() {
			System.out.println("in the \' LoginPage logout()\'");
			clickSignOutBtn();
			System.out.println("after call to the \'clickSignOutBtn(); \'");
			return new LoginPage(ios, wait);
		}
}
