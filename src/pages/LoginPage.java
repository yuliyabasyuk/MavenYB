package pages;

import org.openqa.selenium.support.ui.WebDriverWait;
import tests.InitializeLogging;

import data.IUser;
// import org.openqa.selenium.support.ui.WebDriverWait; // commented because this import never used?
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
// import helper.Helpers;

public class LoginPage {
	
//	// Constructor
//	public LoginPage(IOSDriver<?> ios, WebDriverWait wait) {
//		super(ios, wait);
//	}
	// Locators (later we may put them in separate classes or interfaces):
//	public static final String NAME_ATTRIBUTE = "name";
//	public static final String VALUE_ATTRIBUTE = "value";
	public static final String NAME_IMAGE = "Login_RegBox_Backgrnd.png"; //
	public static final String NAME_IMAGE_ATTR_TYPE = "name";
	//
//	private static final String SIGNIN_HELP_ID = "Sign in help?"; 				// link to the "Forgot your password?"
	private static final String USERNAME_FIELD_XPATH = "//XCUIElementTypeOther/XCUIElementTypeTextField";
	private static final String PASSWORD_FIELD_XPATH = "//XCUIElementTypeOther/XCUIElementTypeSecureTextField";
//	private static final String RMB_USERNAME_ID = "RememberMeButton";      		// 'Remebmer My Username' clickable text 
//	private static final String RMB_CHECKBOX_ID = "RemebmerMeCheckboxView_selected";  // CheckboxView_deselected|selected. Label: Remebmer Me Checkbox View
	private static final String LOGIN_IMAGE_ID = "Login_RegBox_Backgrnd.png";  	// AcsId for the credentials box. XPATH //XCUIElementTypeImage[@name="Login_RegBox_Backgrnd.png"]
	private static final String SIGNIN_BTN_ID = "Sign In"; 						// AcsId for the Sign In btn
//	private static final String FORGOT_PSWD_ID = "Forgot your password?";		// 'Forgot your password?' popup
//	private static final String FORGOT_PSWD_CANCEL_ID = "Cancel";				// 'Cancel' btn
//	private static final String FORGOT_PSWD_SEND_EMAIL_ID = "Send email";       // 'Send Email' btn
	private static final String GPS_POPUP_ID = "This application uses location data to display your location "
			+ "on the map and provide a list of nearby stations.";
	private static final String APNS_POPUP_ID = "Notifications may include alerts, sounds, and icon badges. "
			+ "These can be configured in Settings.";
	
	// Fields
	public IOSDriver<?> ios;
	public WebDriverWait wait;
	//
	private IOSElement usernameField;
	private IOSElement passwordField;
	private IOSElement signInBtn;
	private IOSElement loginImage;
	private String loginImageName;
	private String loginImageAttrType;
	private IOSElement gpsPopup;
	private IOSElement apnsPopup;
		
	// Constructor
	//public LoginPage(IOSDriver<?> ios, WebDriverWait wait) {
	public LoginPage(IOSDriver<?> ios) {
	//public LoginPage(IOSDriver<?> ios) {
		this.ios = ios;
		//this.wait = wait;
		//super(ios);
		//
		this.usernameField = (IOSElement) ios.findElementByXPath(USERNAME_FIELD_XPATH); // cast to (IOSElement) was added by eclipse
		this.passwordField = (IOSElement) ios.findElementByXPath(PASSWORD_FIELD_XPATH); // same as above
		this.signInBtn = (IOSElement) ios.findElementByAccessibilityId(SIGNIN_BTN_ID); // same as above
		//this.loginImage = (IOSElement) ios.findElementByAccessibilityId(LOGIN_IMAGE_ID); // run Inspector and check how to find logo image
		//this.loginImageName = (IOSElement) ios.findElementByAccessibilityId(NAME_IMAGE);
		//this.loginImageAttrType = (IOSElement) ios. (NAME_IMAGE_ATTR_TYPE); // ??
//		this.gpsPopup = (IOSElement) ios.findElementByAccessibilityId(GPS_POPUP_ID);
//		this.apnsPopup = (IOSElement) ios.findElementByAccessibilityId(APNS_POPUP_ID);
	}
	
	//public LoginPage(IOSDriver<?> ios) {
	public LoginPage(IOSDriver<?> ios, WebDriverWait wait) {
		// TODO Auto-generated constructor stub
		this.wait = wait;
		this.ios = ios;
	}

	// Page Object
	// get Data
	public IOSElement getLoginImage() {
		//return this.loginImage;
		return (IOSElement) ios.findElementByAccessibilityId(LOGIN_IMAGE_ID);
	}
	
	public IOSElement getUsernameField() {
		return this.usernameField;
	}
	
	public IOSElement getPasswordField() {
		return this.passwordField;
	}
	
	public IOSElement getSignInBtn() {
		return this.signInBtn;
	}
	
	public String getLoginImageName() {
		return this.loginImageName = NAME_IMAGE;
	}
	
	public String getLoginImageAttrType() {
		System.out.println(" in the \' getLoginImageAttrType() \'");
		// return this.loginImageAttrType;
		return this.loginImageAttrType = NAME_IMAGE_ATTR_TYPE;
	}
	
	public String getLoginImageAttributeText(String attribute_type) {
		System.out.println(" in the \'getLoginImageAttributeText(String attribute)\'  This method returns: " + getLoginImage().getAttribute(attribute_type).trim() ); // returns Login_RegBox_Backgrnd.png
		//return getLoginImage().getTagName().toLowerCase().trim(); // this returns xcuielementtypeimage
		return getLoginImage().getAttribute(attribute_type).trim(); // this return Login_RegBox_Backgrnd.png
	}
//	
//	public String getLoginImageAttributeNameText() {
//		return getLoginImageAttributeText(NAME_ATTRIBUTE);
//	}
	
	// set Data
	public void setUsernameField(String username) {
		getUsernameField().sendKeys(username);
	}
	
	public void clearLoginField() {
		getUsernameField().clear();
	}
	
	public void setUsernameFieldClear(String username) {
		clearLoginField();
		setUsernameField(username);
		InitializeLogging.getLogger().debug("DEBUG, entered username");
	}
	
	public void setPasswordField(String password) {
		getPasswordField().sendKeys(password);
	}
	
	public void clearPasswordField() {
		getPasswordField().clear();
		InitializeLogging.getLogger().debug("DEBUG, cleared passwd field");
	}
	
	public void setPasswordFieldClear(String password) {
		clearPasswordField();
		setPasswordField(password);
		InitializeLogging.getLogger().debug("DEBUG, entered passwd");
	}
	
//	public void clickUsernameField() {
//		getUsernameField().click();
//	}
//	
//	public void clickPasswordField() {
//		getPasswordField().click();
//	}
	
	public void clickSignIn() {
		getSignInBtn().click();
		InitializeLogging.getLogger().debug("DEBUG, clicked Sign In");
	}
	
	// end of classic page object (we end working with elements) //
	
	// hide keyboard
	public void closeKeyabord() {
		if (ios.isKeyboardShown()) {
			ios.hideKeyboard("Hide keyboard");
			System.out.println("DEBUG, closed keyboard");
		}
	}
	
	// Business logic:
//	public MapPage setLoginData(String username, String password) {
//		setUsernameFieldClear(username);
//		setPasswordFieldClear(password);
//		closeKeyabord();
//		clickSignIn();
//		try {
//			Thread.sleep(5000);
//			System.out.println("Was sleeping in the setLoginData()...");
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return new MapPage(ios);
//	}
	
//	public boolean isAlertPresent() {
//		ExpectedCondition<Alert> alert = ExpectedConditions.alertIsPresent();
//		System.out.println("Created alert ... in the isAlerPresent()");
//		return (alert != null);
//	}
//	
//	public void dismissAlerts() {
//		if (isAlertPresent()) {
//			ios.switchTo().alert().dismiss();
//			System.out.println("Dismissed the alert...");
//		}
//	}
//	public MapPage setLoginData(String username, String password) throws InterruptedException {
//		setUsernameFieldClear(username);
//		setPasswordFieldClear(password);
//		closeKeyabord();
//		clickSignIn();
//		Thread.sleep(1000);
//		//System.out.println("DEBUG, in the setLoginData ");
//		return new MapPage(ios, wait);
//	}
	/*public MapPage setLoginData(IUser user) throws InterruptedException {
		setUsernameFieldClear(user.getUsername());
		setPasswordFieldClear(user.getPassword());
		//closeKeyabord();
		clickSignIn();
		//Thread.sleep(1000);
		System.out.println("DEBUG, in the setLoginData ");
		return new MapPage(ios);
	}*/
	
	//rewrite setLoginData method
	public void setLoginDataDevice(IUser user) throws InterruptedException {
		setUsernameFieldClear(user.getUsername());
		setPasswordFieldClear(user.getPassword());
		closeKeyabord();
		clickSignIn();
	}
	
	public void setLoginDataSimulator(IUser user) throws InterruptedException {
		setUsernameFieldClear(user.getUsername());
		setPasswordFieldClear(user.getPassword());
		clickSignIn();
	}
//	
//	public MapPage successLogin(IUser validUserCred) throws Exception {
//		setLoginData(validUserCred);
//		System.out.println("sucessLogin method .. after setLoginData(validUserCred)  .. before return..");
//		//handle (dismiss) all system alerts
//	
//		// return new MapPage(ios, wait); // is creating an object of the class (of the MapPage), in the previous row we were transferred to the other page.
//		Thread.sleep(10000);
//		return new MapPage(ios, wait);
//	}
	
	//WebDriverWait wait1 = new WebDriverWait(ios, 10);
	//commented MapPage return
	public MapPage successLoginDevice(IUser validUserCred) throws Exception {
		setLoginDataDevice(validUserCred);
		InitializeLogging.getLogger().debug("Set login data for valid user");
		
		
		
		return new MapPage(ios);
	}
	public MapPage successLoginSimulator(IUser validUserCred) throws Exception {
		setLoginDataSimulator(validUserCred);
		InitializeLogging.getLogger().debug("Set login data for valid user");
		return new MapPage(ios);
	}
	
	public ValidatorLoginPage unsuccessfullLoginDevice(IUser invalidUser) throws Exception {
		setLoginDataDevice(invalidUser);
		InitializeLogging.getLogger().debug("Set login data for invalid user");
		return new ValidatorLoginPage(ios); //return this
	}
	
	public ValidatorLoginPage unsuccessfullLoginSimulator(IUser invalidUser) throws Exception {
		setLoginDataSimulator(invalidUser);
		InitializeLogging.getLogger().debug("Set login data for invalid user");
		return new ValidatorLoginPage(ios); //return this
	}
	
}