package appl;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;
/*
// Interfaces
interface IAppWaitActivity {
	IBundleId setAppWaitActivity(String appWaitActivity);
}

interface IBundleId {
	IPlatformName setBundleId(String bundleId);
}

interface IPlatformName {
	IPlatformVersion setPlatformName(String platformName);
}

interface IPlatformVersion {
	IDeviceName setPlatformVersion(String platformVersion);
}

interface IDeviceName {
	IUdid setDeviceName(String deviceName);
}

interface IUdid {
	IAppPath setUdid(String udid);
}

interface IAppPath {
	IXcodeOrgId setAppPath(String appPath);
}

interface IXcodeOrgId {
	IXcodeSigningId setXcodeOrgId(String xcodeOrgId);
}

interface IXcodeSigningId {
	IApplicationName setXcodeSigningId(String xcodeSigningId);
}

interface IApplicationName {
	IAutomationName setApplicationName(String applicationName);
}

interface IAutomationName {
	INoReset setAutomationName(String automationName);
}

interface INoReset {
	IFullReset setNoReset(String noReset);
}

interface IFullReset {
	ICapabilitiesBuilder setFullReset(String fullReset);
}

interface ICapabilitiesBuilder {
	ICapabilities build();
}

public class Capabilities implements IAppWaitActivity, IBundleId, IPlatformName,  
IPlatformVersion, IDeviceName, IUdid, IAppPath, IXcodeOrgId, IXcodeSigningId, 
IApplicationName, IAutomationName, INoReset, IFullReset, ICapabilities, ICapabilitiesBuilder {
	
	public DesiredCapabilities capabilities = new DesiredCapabilities();
	
	// Fields
	private String appWaitActivity="appWaitActivity"; 	// "*"
	private String bundleId="bundleId"; 				// "com.wsi.Pilotbrief.Debug.ENT"
	private String platformName="platformName"; 		// "iOS"
	private String platformVersion="platformVersion"; 	// "11.4.1"
	private String deviceName="deviceName"; 			// "WSI-SS-LV-iPad-mini-ios11.4.1"
	private String udid="udid"; 						// "214dea41a08e58587fb16540f2f5707f56d1aec0"
	private String appPath="appPath";					// "/Users/olaytar/PBAutoTest/apps/Pilotbrief.ENT-2.14.1-5391.126-Rel-Staging-AdHoc.ipa"
	private String xcodeOrgId="xcodeOrgId"; 			// "73CP3TPHE9"
	private String xcodeSigningId="xcodeSigningId"; 	// "iPhone Developer"
	private String applicationName="applicationName"; 	// "ENT"
	private String automationName="automationName"; 	// "XCUITest"
	private String noReset="noReset"; 					// "true"
	private String fullReset="fullReset"; 				// "false"

	
	// Constructor
	private Capabilities() {

	}

	// Static Factory
	public static IAppWaitActivity get() { 	// public static ICapabilities get()
		return new Capabilities(); 			// return constructor (because it is private)
		
	}

	// Getters
	public String getAppWaitActivity() {
		return appWaitActivity;
	}

	public String getBundleId() {
		return bundleId;
	}

	public String getPlatformName() {
		return platformName;
	}

	public String getPlatformVersion() {
		return platformVersion;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public String getUdid() {
		return udid;
	}

	public String getAppPath() {
		return appPath;
	}

	public String getXcodeOrgId() {
		return xcodeOrgId;
	}

	public String getXcodeSigningId() {
		return xcodeSigningId;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public String getAutomationName() {
		return automationName;
	}

	public String getNoReset() {
		return noReset;
	}

	public String getFullReset() {
		return fullReset;
	}
	
	// Setters 
	public IBundleId setAppWaitActivity(String appWaitActivity) {
		//this.appWaitActivity = appWaitActivity;
		capabilities.setCapability(this.appWaitActivity, appWaitActivity);
		return this;
	}

	public IPlatformName setBundleId(String bundleId) {
		//this.bundleId = bundleId;
		capabilities.setCapability(this.bundleId, bundleId);
		return this;
	}

	public IPlatformVersion setPlatformName(String platformName) {
		//this.platformName = platformName;
		capabilities.setCapability(this.platformName, platformName);
		return this;
	}

	public IDeviceName setPlatformVersion(String platformVersion) {
		//this.platformVersion = platformVersion;
		capabilities.setCapability(this.platformVersion, platformVersion);
		return this;
	}

	public IUdid setDeviceName(String deviceName) {
		//this.deviceName = deviceName;
		capabilities.setCapability(this.deviceName, deviceName);
		return this;
	}

	public IAppPath setUdid(String udid) {
		//this.udid = udid;
		capabilities.setCapability(this.udid, udid);
		return this;
	}

	public IXcodeOrgId setAppPath(String appPath) {
		//this.appPath = appPath;
		//capabilities.setCapability(this.appPath, appPath);
		capabilities.setCapability(MobileCapabilityType.APP, appPath);
		return this;
	}

	public IXcodeSigningId setXcodeOrgId(String xcodeOrgId) {
		//this.xcodeOrgId = xcodeOrgId;
		capabilities.setCapability(this.xcodeOrgId, xcodeOrgId);
		return this;
	}

	public IApplicationName setXcodeSigningId(String xcodeSigningId) {
		//this.xcodeSigningId = xcodeSigningId;
		capabilities.setCapability(this.xcodeSigningId, xcodeSigningId);
		return this;
	}

	public IAutomationName setApplicationName(String applicationName) {
		//this.applicationName = applicationName;
		//capabilities.setCapability(this.applicationName, applicationName);
		capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME, applicationName);
		return this;
	}

	public INoReset setAutomationName(String automationName) {
		//this.automationName = automationName;
		capabilities.setCapability(this.automationName, automationName);
		return this;
	}

	public IFullReset setNoReset(String noReset) {
		//this.noReset = noReset;
		//capabilities.setCapability(this.noReset, noReset);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, noReset);
		return this;
	}

	public ICapabilitiesBuilder setFullReset(String fullReset) {
		//this.fullReset = fullReset;
		//capabilities.setCapability(this.fullReset, fullReset);
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, fullReset);
		return this;
	}
	
	public ICapabilities build() {
		return this;
	}

	public DesiredCapabilities getCapabilities() {
		return capabilities;
	}

}

*/


// Interfaces
interface IAppWaitActivity {
	IBundleId setAppWaitActivity(String appWaitActivity);
}

interface IBundleId {
	IPlatformName setBundleId(String bundleId);
}

interface IPlatformName {
	IPlatformVersion setPlatformName(String platformName);
}

interface IPlatformVersion {
	IDeviceName setPlatformVersion(String platformVersion);
}

interface IDeviceName {
	IUdid setDeviceName(String deviceName);
}

interface IUdid {
	IAppPath setUdid(String udid);
}

interface IAppPath {
	ICapabilitiesBuilder setAppPath(String appPath);
}
/*
interface IAppPath {
	IXcodeOrgId setAppPath(String appPath);
}

interface IXcodeOrgId {
	IXcodeSigningId setXcodeOrgId(String xcodeOrgId);
}

interface IXcodeSigningId {
	IApplicationName setXcodeSigningId(String xcodeSigningId);
}

interface IApplicationName {
	IAutomationName setApplicationName(String applicationName);
}

interface IAutomationName {
	INoReset setAutomationName(String automationName);
}

interface INoReset {
	IFullReset setNoReset(String noReset);
}

interface IFullReset {
	ICapabilitiesBuilder setFullReset(String fullReset);
}
*/
interface ICapabilitiesBuilder {
	ICapabilities build();
}

public class Capabilities implements IAppWaitActivity, IBundleId, IPlatformName,  
IPlatformVersion, IDeviceName, IUdid, IAppPath, /*IXcodeOrgId, IXcodeSigningId, 
IApplicationName, IAutomationName, INoReset, IFullReset,*/ ICapabilities, ICapabilitiesBuilder {
	
	public DesiredCapabilities capabilities = new DesiredCapabilities();
	
	// Fields
	private String appWaitActivity="appWaitActivity"; 	// "*"
	private String bundleId="bundleId"; 				// "com.wsi.Pilotbrief.Debug.ENT"
	private String platformName="platformName"; 		// "iOS"
	private String platformVersion="platformVersion"; 	// "11.4.1"
	private String deviceName="deviceName"; 			// "WSI-SS-LV-iPad-mini-ios11.4.1"
	private String udid="udid"; 						// "214dea41a08e58587fb16540f2f5707f56d1aec0"
	private String appPath="appPath";					// "/Users/olaytar/PBAutoTest/apps/Pilotbrief.ENT-2.14.1-5391.126-Rel-Staging-AdHoc.ipa"
	//private String xcodeOrgId="xcodeOrgId"; 			// "73CP3TPHE9"
	//private String xcodeSigningId="xcodeSigningId"; 	// "iPhone Developer"
	//private String applicationName="applicationName"; 	// "ENT"
	//private String automationName="automationName"; 	// "XCUITest"
	//private String noReset="noReset"; 					// "true"
	//private String fullReset="fullReset"; 				// "false"

	
	// Constructor
	private Capabilities() {

	}

	// Static Factory
	public static IAppWaitActivity get() { 	// public static ICapabilities get()
		return new Capabilities(); 			// return constructor (because it is private)
		
	}

	// Getters
	public String getAppWaitActivity() {
		return appWaitActivity;
	}

	public String getBundleId() {
		return bundleId;
	}

	public String getPlatformName() {
		return platformName;
	}

	public String getPlatformVersion() {
		return platformVersion;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public String getUdid() {
		return udid;
	}

	public String getAppPath() {
		return appPath;
	}
/*
	public String getXcodeOrgId() {
		return xcodeOrgId;
	}

	public String getXcodeSigningId() {
		return xcodeSigningId;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public String getAutomationName() {
		return automationName;
	}

	public String getNoReset() {
		return noReset;
	}

	public String getFullReset() {
		return fullReset;
	}
	*/
	
	// Setters 
	public IBundleId setAppWaitActivity(String appWaitActivity) {
		//this.appWaitActivity = appWaitActivity;
		capabilities.setCapability(this.appWaitActivity, appWaitActivity);
		return this;
	}

	public IPlatformName setBundleId(String bundleId) {
		//this.bundleId = bundleId;
		capabilities.setCapability(this.bundleId, bundleId);
		return this;
	}

	public IPlatformVersion setPlatformName(String platformName) {
		//this.platformName = platformName;
		capabilities.setCapability(this.platformName, platformName);
		return this;
	}

	public IDeviceName setPlatformVersion(String platformVersion) {
		//this.platformVersion = platformVersion;
		capabilities.setCapability(this.platformVersion, platformVersion);
		return this;
	}

	public IUdid setDeviceName(String deviceName) {
		//this.deviceName = deviceName;
		capabilities.setCapability(this.deviceName, deviceName);
		return this;
	}

	public IAppPath setUdid(String udid) {
		//this.udid = udid;
		capabilities.setCapability(this.udid, udid);
		return this;
	}
	
	public ICapabilitiesBuilder  setAppPath(String appPath) {
		capabilities.setCapability(MobileCapabilityType.APP, appPath);
		return this;
	}
/*
	public IXcodeOrgId setAppPath(String appPath) {
		//this.appPath = appPath;
		//capabilities.setCapability(this.appPath, appPath);
		capabilities.setCapability(MobileCapabilityType.APP, appPath);
		return this;
	}

	public IXcodeSigningId setXcodeOrgId(String xcodeOrgId) {
		//this.xcodeOrgId = xcodeOrgId;
		capabilities.setCapability(this.xcodeOrgId, xcodeOrgId);
		return this;
	}

	public IApplicationName setXcodeSigningId(String xcodeSigningId) {
		//this.xcodeSigningId = xcodeSigningId;
		capabilities.setCapability(this.xcodeSigningId, xcodeSigningId);
		return this;
	}

	public IAutomationName setApplicationName(String applicationName) {
		//this.applicationName = applicationName;
		//capabilities.setCapability(this.applicationName, applicationName);
		capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME, applicationName);
		return this;
	}

	public INoReset setAutomationName(String automationName) {
		//this.automationName = automationName;
		capabilities.setCapability(this.automationName, automationName);
		return this;
	}

	public IFullReset setNoReset(String noReset) {
		//this.noReset = noReset;
		//capabilities.setCapability(this.noReset, noReset);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, noReset);
		return this;
	}

	public ICapabilitiesBuilder setFullReset(String fullReset) {
		//this.fullReset = fullReset;
		//capabilities.setCapability(this.fullReset, fullReset);
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, fullReset);
		return this;
	}
	*/
	public ICapabilities build() {
		return this;
	}

	public DesiredCapabilities getCapabilities() {
		return capabilities;
	}

}



