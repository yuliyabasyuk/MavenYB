package appl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesRepo {

	// Use Singleton, Repository
	private static volatile CapabilitiesRepo instance; // volatile - doesn't cache.

	// Constructor
	private CapabilitiesRepo() {

	}

	// static factory to return instance.
	public static CapabilitiesRepo get() {
		if (instance == null) {
			synchronized (CapabilitiesRepo.class) {
				if (instance == null) {
					instance = new CapabilitiesRepo();
				}
			}
		}
		return instance;
	}

	DesiredCapabilities capabilities = new DesiredCapabilities();

	public DesiredCapabilities SetCapabilities(String deviceName) {
		if (deviceName.equals("Simulator")) {
			capabilities = CapabilitiesRepo.get().SetSimulatorCapabilities();
		} else {
			if (deviceName.equals("PB2141IPadMini")) {
				capabilities = CapabilitiesRepo.get().SetIPadMiniCapabilities();
			}

		}
		
		return capabilities;

	}

	// Methods which use builder to set capabilities.
	// Create several methods for each device and needed application.
	/*
	 * public DesiredCapabilities SetCapabilitiesM() { return Capabilities.get()
	 * .setAppWaitActivity("*") .setBundleId("com.wsi.Pilotbrief")
	 * .setPlatformName("iOS") .setPlatformVersion("11.4.1")
	 * .setDeviceName("WSI-SS-LV-iPad-mini-ios11.4.1")
	 * .setUdid("214dea41a08e58587fb16540f2f5707f56d1aec0") .setAppPath(
	 * "/Users/olaytar/PBAutoTest/apps/Pilotbrief.ENT-2.14.1-5391.126-Rel-Staging-AdHoc.ipa")
	 * // try to use here something like this
	 * .getResource("/lib/chromedriver.exe").getPath().substring(1);
	 * .setXcodeOrgId("73CP3TPHE9") .setXcodeSigningId("iPhone Developer")
	 * .setApplicationName("WSI Pilotbrief") .setAutomationName("XCUITest")
	 * .setNoReset("true") .setFullReset("false") .build() .getCapabilities();
	 * 
	 * }
	 */

	/*
	 * public DesiredCapabilities SetCapabilitiesM() { return Capabilities.get()
	 * .setAppWaitActivity("*") .setBundleId("com.wsi.Pilotbrief.Debug.ENT")
	 * .setPlatformName("iOS") .setPlatformVersion("11.0.1")
	 * .setDeviceName("iPad Pro 9.7-inch")
	 * .setUdid("94EF5502-2E7F-4BDC-BCC1-C401A297A91C")
	 * .setAppPath("/Users/ybasi/Apps/Stage.Pilotbrief.ENT.app") // try to use here
	 * something like this
	 * .getResource("/lib/chromedriver.exe").getPath().substring(1); .build()
	 * .getCapabilities();
	 * 
	 * }
	 */

	// Simulator
	public DesiredCapabilities SetSimulatorCapabilities() {
		Properties prop = new Properties();
		InputStream input = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();

		try {

			input = new FileInputStream("./src/appl/Capabilities_Simulator_iPadPro9.7_11.0.1");
			// load a properties file
			prop.load(input);

			capabilities.setCapability("appWaitActivity", prop.getProperty("appWaitActivity"));
			capabilities.setCapability("deviceName", prop.getProperty("deviceName"));
			capabilities.setCapability("platformName", prop.getProperty("platformName"));
			capabilities.setCapability("platformVersion", prop.getProperty("platformVersion"));
			capabilities.setCapability("udid", prop.getProperty("udid"));
			capabilities.setCapability("bundleId", prop.getProperty("bundleId"));
			capabilities.setCapability("app", prop.getProperty("app"));
			capabilities.setCapability("noReset", prop.getProperty("noReset"));
			capabilities.setCapability("fullReset", prop.getProperty("fullReset"));

			input.close();

		} catch (IOException io) {
			io.printStackTrace();
		}
		return capabilities;
	}

	// Device OLL
	public DesiredCapabilities SetIPadMiniCapabilities() {
		Properties prop = new Properties();
		InputStream input = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();

		try {

			input = new FileInputStream("./src/appl/Capabilities_iPadMini_11.4.1");
			// load a properties file
			prop.load(input);

			capabilities.setCapability("appWaitActivity", prop.getProperty("appWaitActivity"));
			capabilities.setCapability("deviceName", prop.getProperty("deviceName"));
			capabilities.setCapability("platformName", prop.getProperty("platformName"));
			capabilities.setCapability("platformVersion", prop.getProperty("platformVersion"));
			capabilities.setCapability("udid", prop.getProperty("udid"));
			capabilities.setCapability("bundleId", prop.getProperty("bundleId"));
			capabilities.setCapability("app", prop.getProperty("app"));
			capabilities.setCapability("xcodeOrgId", prop.getProperty("xcodeOrgId"));
			capabilities.setCapability("xcodeSigningId", prop.getProperty("xcodeSigningId"));
			capabilities.setCapability("applicationName", prop.getProperty("applicationName"));
			capabilities.setCapability("automationName", prop.getProperty("automationName"));
			capabilities.setCapability("noReset", prop.getProperty("noReset"));
			capabilities.setCapability("fullReset", prop.getProperty("fullReset"));

			input.close();

		} catch (IOException io) {
			io.printStackTrace();
		}
		return capabilities;
	}

}
