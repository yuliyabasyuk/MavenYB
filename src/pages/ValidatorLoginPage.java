package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import tests.InitializeLogging;

public class ValidatorLoginPage extends LoginPage {

	// Locators:
	public static final String AUTH_ERR_POPUP_ID = "AlertMessageViewTitle"; 
	public static final String AUTH_ERR_POPUP_ATTR_PROPERTY = "value";
	public static final String AUTH_ERR_POPUP_TEXT = "AUTHENTICATION ERROR";
	public static final String AUTH_ERR_POPUP_OK_BTN_ID = "OK";

	// Fields:
	
	// Constructor: 
//	public ValidatorLoginPage(IOSDriver<?> ios, WebDriverWait wait) {
//		super(ios, wait); 	// Initialize parent class
//	}
	public ValidatorLoginPage(IOSDriver<?> ios) {
		super(ios); 	// Initialize parent class
	}

	// Get Data
	public IOSElement getAuthErrPopupId() {
		return (IOSElement) ios.findElementByAccessibilityId(AUTH_ERR_POPUP_ID);
	}

	public String getAuthErrPopupAttrPropertyValue() {
		return getAuthErrPopupId().getAttribute(AUTH_ERR_POPUP_ATTR_PROPERTY).trim(); // expected to receive AUTHENTICATION ERROR
	}
	
	public IOSElement getAuthErrPopupOKBtn() {
		return (IOSElement) ios.findElementByAccessibilityId(AUTH_ERR_POPUP_OK_BTN_ID);
	}
	
	// Set Data 
	
	// Methods
	
	public void dismissAuthErrPopup() {
		//if (getAuthErrPopupAttrPropertyValue() == AUTH_ERR_POPUP_TEXT) getAuthErrPopupOKBtn().click();
		getAuthErrPopupOKBtn().click();
		InitializeLogging.getLogger().debug("Dismissed AUTHENTICATION ERROR popup");
	}
}
