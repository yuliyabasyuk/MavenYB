package pages;


import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class PreferencesPage {
	// Locators
	private static final String PREFERENCES_TAB_ID = "PREFERENCES";
	private static final String PREFERENCES_PAGE_TITLE_ID = "Preferences";
	private static final String PREF_WEATHER_GPS_SOURCE__BTN_ID = "PreferencesWeatherAndGPSButton";
	private static final String PREF_ACCOUNT_BTN_ID = "PreferencesAccountButton";
	private static final String PREF_WHAT_IS_NEW_BTN_ID = "PreferencesWhatsNewButton";
	private static final String PREF_FEEDBACK_BTN_ID = "PreferencesSendFeedbackButton";
	private static final String PREF_ABD_BTN_ID = "PreferencesViewController.downloadMapTilesWhenOnlineSwitch";

	// Fields
	public IOSDriver<?> ios;
	public WebDriverWait wait;
	private IOSElement preferencesTab;
	private IOSElement preferencesPageTitle;
	private IOSElement preferencesWeatherGpsBtn;
	private IOSElement preferencesAccountBtn;
	private IOSElement preferencesWhatIsNewBtn;
	private IOSElement preferencesFeedbackBtn;
	private IOSElement preferencesAbdBtn;

	// Constructor
	// public PreferencesPage(IOSDriver<?> ios, WebDriverWait wait) {
	public PreferencesPage(IOSDriver<?> ios) {
		this.ios = ios;
//		this.wait = wait;
//		this.preferencesTab = (IOSElement) ios.findElementByAccessibilityId(PREFERENCES_TAB_ID);
//		this.preferencesPageTitle = (IOSElement) ios.findElementByAccessibilityId(PREFERENCES_PAGE_TITLE_ID);
//		this.preferencesWeatherGpsBtn = (IOSElement) ios.findElementByAccessibilityId(PREF_WEATHER_GPS_SOURCE__BTN_ID);
//		this.preferencesAccountBtn = (IOSElement) ios.findElementByAccessibilityId(PREF_ACCOUNT_BTN_ID);
//		this.preferencesWhatIsNewBtn = (IOSElement) ios.findElementByAccessibilityId(PREF_WHAT_IS_NEW_BTN_ID);
//		this.preferencesFeedbackBtn = (IOSElement) ios.findElementByAccessibilityId(PREF_FEEDBACK_BTN_ID);
//		this.preferencesAbdBtn = (IOSElement) ios.findElementByAccessibilityId(PREF_ABD_BTN_ID);
		
	}

	// Page Object //
	// Get Data
	public IOSElement getPreferencesTab() {
		//return this.preferencesTab;
		return (IOSElement) ios.findElementByAccessibilityId(PREFERENCES_TAB_ID);
	}
	public IOSElement getPreferencesPageTitle() {
		//return this.preferencesPageTitle;
		return (IOSElement) ios.findElementByAccessibilityId(PREFERENCES_PAGE_TITLE_ID);
	}
	
	public IOSElement getPreferencesWeatherGpsBtn() {
		//return this.preferencesWeatherGpsBtn;
		return (IOSElement) ios.findElementByAccessibilityId(PREF_WEATHER_GPS_SOURCE__BTN_ID);
	}
	
	public IOSElement getPreferencesAccountBtn() {
		//return this.preferencesAccountBtn;
		return (IOSElement) ios.findElementByAccessibilityId(PREF_ACCOUNT_BTN_ID);
	}
	
	public IOSElement getPreferencesWhatIsNewBtn() {
		//return this.preferencesWhatIsNewBtn;
		return (IOSElement) ios.findElementByAccessibilityId(PREF_WHAT_IS_NEW_BTN_ID);
	}
	
	public IOSElement getPreferencesFeedbackBtn() {
		//return this.preferencesFeedbackBtn;
		return (IOSElement) ios.findElementByAccessibilityId(PREF_FEEDBACK_BTN_ID);
	}
	
	public IOSElement getPreferencesAbdBtn() {
		//return this.preferencesAbdBtn;
		return (IOSElement) ios.findElementByAccessibilityId(PREF_ABD_BTN_ID);
	}
	
	// Methods 
	public void clickPreferencesTab() {
		//System.out.println("in the  \'clickPreferencesTab()\'");
		getPreferencesTab().click();
	}
	
	public void clickPreferencesAccountBtn() {
		//System.out.println("in the  \'clickPreferencesAccountBtn()\'");
		getPreferencesAccountBtn().click();
	}
	
	// Functional
	public AccountPage getAccountPage() {
		//System.out.println("in the \' AccountPage getAccountPage() \'");
		clickPreferencesAccountBtn();
		return new AccountPage(ios);
	}
	
	// Business logic
	//
}
