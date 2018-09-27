package pages;


import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class MapPage {
	
	// Locators
	private static final String MAP_TAB_ID = "MAP";		// AcsId for the MAP btn at the bottom page.
	private static final String GPS_POPUP_ID = "This application uses location data to display your location "
			+ "on the map and provide a list of nearby stations.";
	private static final String APNS_POPUP_ID = "Notifications may include alerts, sounds, and icon badges. "
			+ "These can be configured in Settings.";
	private static final String RADAR_QPP_ID = "QuickPickButton.0039"; 	// AcsId for the 'Radar' layer on the QPP. 
	private static final String QSonQPP_ID = "MapToolBarSearchButton";
	private static final String ABDpopup_ID = "AlertMessageViewTitle"; 	// AcsId for the 'ABD' popup.
	private static final String ABDtoggle_ID = "SwitchMessage.Switch";
	private static final String ABD_OKbtn_ID = "OK";
	private static final String COACHMARK_CLOSE_BTN_ID = "CMDialogueSkipButton";
	
	
	// Fields
	public IOSDriver<?> ios;
	public WebDriverWait wait;
	
	private IOSElement mapTab;
	private IOSElement gpsPopup;
	private IOSElement apnsPopup;
	private IOSElement radarLayer;
	private IOSElement QSonQPP; 		// quick search on quick pick panel
	private IOSElement loginAccount; 	// this should characterise whether user succeeded to sign in.
	private IOSElement popupABD;
	private IOSElement popupABD_toggle;
	private IOSElement popupABD_OKbtn;
	private IOSElement coachMarksClose;
	
	// Constructor
	//public MapPage(IOSDriver<?> ios, WebDriverWait wait) {
	public MapPage(IOSDriver<?> ios) {
		this.ios = ios;
//		this.wait = wait;
//		this.mapTab = (IOSElement) ios.findElementByAccessibilityId(MAP_TAB_ID); 	
//		this.gpsPopup = (IOSElement) ios.findElementByAccessibilityId(GPS_POPUP_ID);
//		this.apnsPopup = (IOSElement) ios.findElementByAccessibilityId(APNS_POPUP_ID);
//		this.radarLayer = (IOSElement) ios.findElementByAccessibilityId(RADAR_QPP_ID);
//		this.QSonQPP = (IOSElement) ios.findElementByAccessibilityId(QSonQPP_ID); 
//		this.popupABD = (IOSElement) ios.findElementByAccessibilityId(ABDpopup_ID);
//		this.popupABD_toggle = (IOSElement) ios.findElementByAccessibilityId(ABDtoggle_ID);
//		this.popupABD_OKbtn = (IOSElement) ios.findElementByAccessibilityId(ABD_OKbtn_ID);
//		this.loginAccount = radarLayer;
//		this.coachMarksClose = (IOSElement) ios.findElementByAccessibilityId(COACHMARK_CLOSE_BTN_ID);
	}
	
	// Page Object //
	// Get Data
	public IOSElement getMapTab() {
		return (IOSElement) ios.findElementByAccessibilityId(MAP_TAB_ID); 
	}
	
	public IOSElement getGpsPopup() {
		return (IOSElement) ios.findElementByAccessibilityId(GPS_POPUP_ID);
	}

	public IOSElement getApnsPopup() {
		return (IOSElement) ios.findElementByAccessibilityId(APNS_POPUP_ID);
	}
	
	public IOSElement getRadarLayer() {
		return this.radarLayer;
	}
	
	public IOSElement getQSonQPP() {
		return this.QSonQPP;
	}
	
	public IOSElement getLoginAccount() {
		return this.loginAccount;
	}
	
	public IOSElement getABDpopup() {
		return (IOSElement) ios.findElementByAccessibilityId(ABDpopup_ID);
	}
	
	public IOSElement getABDpopupToggle() {
		return (IOSElement) ios.findElementByAccessibilityId(ABDtoggle_ID);
	}
	
	public IOSElement getABDpopupOKbtn() {
		return (IOSElement) ios.findElementByAccessibilityId(ABD_OKbtn_ID);
	}
	
	public IOSElement getCoachMarksCloseBtn() {
		return (IOSElement) ios.findElementByAccessibilityId(COACHMARK_CLOSE_BTN_ID);
	}
	
	// Functional
	public String getMapTabText() {
		System.out.println("in the \'getMapTabText()\' " + getMapTab().getText() );
		return getMapTab().getText();
	} 
	
	// set Data
	public void clickMapTab() {
		getMapTab().click();
	}
	
	public void clickQSOnQPP() {
		getQSonQPP().click();
	}
	
	public void clickRadarLayer() {
		getRadarLayer().click();
	}
	
	public void setABDpopupToggle() {
		getABDpopupToggle().click();
	}
	
	public void clickABDpopupOKbtn() {
		getABDpopupOKbtn().click();
		System.out.println("Debug: in the \'clickABDpopupOKbtn()\' after click() ");
	}
	
	public void clickCoachMarksCloseBtn() {
		getCoachMarksCloseBtn().click();
	}
	
//	public void clickLogout() throws InterruptedException {
//		// TODO
//		//getLogout().click();
//		ios.findElementByAccessibilityId("PREFERENCES").click();
//		Thread.sleep(3000);
//		ios.findElementByAccessibilityId("PreferencesAccountButton").click();
//		Thread.sleep(3000);
//		ios.findElementByAccessibilityId("Sign Out").click();
//		Thread.sleep(3000);
//	}
	
//	public boolean safeClick(IOSDriver<?> driver, IOSElement getElement) {
//		System.out.println("DEBUG, element is: " + getElement);
//		boolean state = false;
//		if (getElement != null) {
//			if (getElement.isEnabled()) {
//				state = true;
//			}
//		} 
//		return state;
//	}
	
	public boolean safeClick(IOSDriver<?> driver, WebDriverWait wait, IOSElement getElement) {
		boolean state = false;
		if ((getElement != null) && getElement.isEnabled()) {
			state = true;
		}
		//wait.until(ExpectedConditions.visibilityOf(getElement));
		return state;
		
	}
	
	public void dismissGpsAlert() {
		if (safeClick(ios, wait, getGpsPopup())) {
			ios.switchTo().alert().dismiss();
			System.out.println("dismissed the gpsPopup");
		}
	}
	
	public void dismissApnsAlert() {
		if (safeClick(ios, wait, getApnsPopup())) {
			ios.switchTo().alert().dismiss();
			System.out.println("dismissed the apnsPopup");
		}
	}
	
	// close Automatic Basemaps Downloads popup
	public CoachMarkPage closeABDpopup() {
		//setABDpopupToggle();
		clickABDpopupOKbtn();
		return new CoachMarkPage(ios);
	}
	
	public void closeCoachMarksPage() {
		//System.out.println("In the \'closeCoachMarksPage()\' ");
		clickCoachMarksCloseBtn();
	} 
	
	public PreferencesPage clickPreferences() {
		//System.out.println("In the \' clickPreferences()\' ");
		return new PreferencesPage(ios);
	}
	
//	// Business logic
//	public LoginPage logout() throws InterruptedException {
//		clickLogout();
//		// return a new page object representing the destination.
//		//return new LoginPage(ios, wait);
//		return new LoginPage(ios);
//	}
}
