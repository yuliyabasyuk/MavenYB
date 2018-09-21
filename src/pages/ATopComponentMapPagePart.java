//package pages;
//
//import org.openqa.selenium.support.ui.Select;
//
//import io.appium.java_client.ios.IOSDriver;
//import io.appium.java_client.ios.IOSElement;
//
//// Create abstract class which describes few elements on the page 
//// which is/are common for all other pages in the app.
//// Later this class will be extended by other classes.
//
//public abstract class ATopComponentMapPagePart {
//
//	public static enum ChangeLanguageFields { // enum is object of the class 'ChangeLanguageFields'
//		UKRAINIAN("українська"), 
//		RUSSIAN("русский"), 
//		ENGLISH("english");
//		
//		// Fields
//		private String field;
//		
//		// Constructor
//		private ChangeLanguageFields(String field) {
//			this.field = field;
//		}
//
//		@Override
//		public String toString() {
//			return field;
//		}
//	}
//
//	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//
//	public static final String CLASS_ATTRIBUTE = "class";
//	public static final String SRC_ATTRIBUTE = "src";
//	public static final String VALUE_ATTRIBUTE = "value";
//
//	// Fields
//
//	protected IOSDriver<?> driver; 	// we don't need this in case this class will extend other one which has the driver.
//									// Just write in the constructor super(driver); 
//	//
//	private IOSElement titleMessage;
//	private Select changeLanguage;
//
//	protected ATopPage(IOSDriver<?> driver) {
//		this.driver = driver;
//		this.titleMessage = driver.findElement(By.cssSelector("div.col-md-7.col-xs-12"));
//		this.changeLanguage = new Select(driver.findElement(By.id("changeLanguage")));
//	}
//
//	// PageObject
//
//	// get Data
//
//	public IOSElement getTitleMessage() {
//		return this.titleMessage;
//	}
//
//	public Select getChangeLanguage() {
//		return this.changeLanguage;
//	}
//
//	public IOSElement getChangeLanguageSelected() {
//		return getChangeLanguage().getFirstSelectedOption();
//	}
//
//	// Functional
//
//	public String getTitleMessageText() {
//		return getTitleMessage().getText().trim();
//	}
//
//	public String getChangeLanguageSelectedText() {
//		return getChangeLanguageSelected().getText().trim();
//	}
//
//	public ChangeLanguageFields getSelectedLanguage() {
//		ChangeLanguageFields currentLanguage = ChangeLanguageFields.UKRAINIAN;
//		for (ChangeLanguageFields language : ChangeLanguageFields.values()) {
//			if (language.toString().contains(getChangeLanguageSelectedText())) {
//				currentLanguage = language;
//				break;
//			}
//		}
//		return currentLanguage;
//	}
//
//	// set Data
//
//	// public void setChangeLanguage(String language) { // Code Smell
//	public void setChangeLanguage(ChangeLanguageFields language) {
//		getChangeLanguage().selectByVisibleText(language.toString());
//	}
//
//}
