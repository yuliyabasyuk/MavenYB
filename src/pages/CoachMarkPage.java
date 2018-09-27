//package pages;
//
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import io.appium.java_client.ios.IOSDriver;
//import io.appium.java_client.ios.IOSElement;
//
//public class CoachMarkPage {
//
//	// Locators
//	private static final String COACHMARK_ID = "CMScreenshot";
//	private static final String COACHMARK_CLOSE_BTN_ID = "CMDialogueSkipButton";
//	private static final String COACHMARK_NEXT_BTN_ID = "CMPaginationButton0"; // this one out of several radio btns.
//	
//	
//
//	// Fields
//	public IOSDriver<?> ios;
//	public WebDriverWait wait;
//	private IOSElement coachMarks;
//	private IOSElement coachMarksClose;
//	private IOSElement coachMarksNext;
//	
//
//	// Constructor
//	public CoachMarkPage(IOSDriver<?> ios, WebDriverWait wait) {
//		this.ios = ios;
//		this.wait = wait;
////		this.coachMarks = (IOSElement) ios.findElementByAccessibilityId(COACHMARK_ID);
////		this.coachMarksClose = (IOSElement) ios.findElementByAccessibilityId(COACHMARK_CLOSE_BTN_ID);
////		this.coachMarksNext = (IOSElement) ios.findElementByAccessibilityId(COACHMARK_NEXT_BTN_ID);
////		
//	}
//
//	// Page Object //
//	// get Data
//	public IOSElement getCoachMarks() {
//		return (IOSElement) ios.findElementByAccessibilityId(COACHMARK_ID);
//	}
//	
//	public IOSElement getCoachMarksClose() {
//		return (IOSElement) ios.findElementByAccessibilityId(COACHMARK_CLOSE_BTN_ID);
//	}
//	
//	public IOSElement getCoachMarksNext() {
//		return (IOSElement) ios.findElementByAccessibilityId(COACHMARK_NEXT_BTN_ID);
//	}
//	
//	// Set Data
//	public void clickCoachMarks() { // not sure we need this method.
//		getCoachMarks().click();
//	}
//	
//	public void clickCoachMarksClose() {
//		getCoachMarksClose().click(); 
//	}
//	
//	public void clickCoachMarksNext() {
//		getCoachMarksNext().click();
//	}
//	
//	
//
//	// Business logic
//	public MapPage toMapFromCoachMarks() throws InterruptedException {
//		clickCoachMarksClose();
//		// return a new page object representing the destination.
//		// return new LoginPage(ios, wait);
//		return new MapPage(ios, wait);
//	}
//	
//	public PreferencesPage toPreferencesFromCoachMarks() throws InterruptedException {
//		clickCoachMarksClose();
//		return new PreferencesPage(ios, wait);
//	}
//	
//	
//}
