package appl;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.ios.IOSDriver;
import pages.LoginPage;

/* The goal of the Application class is to start the AUT/driver here instead of the test case.
 * Written in style of the 'Factory Method Pattern'.
 * */
public class Application {

	/* IApp is abstract (interface), getDriver is a factory method */
	private interface IApp {
		IOSDriver<?> getDriver(AppSources appSources);
	}
	

	/* Two classes below implement the IApp interface and create their own 'getDriver()' methods */
	
	private static class Simulator implements IApp{
		public IOSDriver<?> getDriver(AppSources appSources) {
			return new IOSDriver<>(appSources.getServerURL(), appSources.getCapabilities());
		}
	}
	
	
	private static class PB2141IPadMini implements IApp {
		public IOSDriver<?> getDriver(AppSources appSources) {
			return new IOSDriver<>(appSources.getServerURL(), appSources.getCapabilities());
		}
	}
	

	public static enum Apps {
		//DEFAULT_TEMPORARY("PB2141IPadMini", new PB2141IPadMini());
		IPAD_MINI("PB2141IPadMini", new PB2141IPadMini()),
		SIMULATOR("Simulator", new Simulator());
		

		private String appName;
		// private String defaultAppPath;
		private IApp app;

		// Constructor
		private Apps(String appName, IApp app) {
			this.appName = appName;
			this.app = app;
		}

		public IOSDriver<?> runApp(AppSources appSources) {
			return app.getDriver(appSources);
		}

		// @Override
		// public String toString() {
		// return appName;
		// }

		// public String getDefaultAppPath() {
		// return defaultAppPath;
		// }
	}

	/*
	 * Use Singleton, Repository. Private static variable of the same (Application)
	 * class, it is the only instance of the class. Singleton guarantees that only
	 * one instance of object is running.
	 */
	private static volatile Application instance;

	// Fields
	private static IOSDriver<?> ios;
	private AppSources appSources;

	// Constructor
	private Application(AppSources appSources) {
		this.appSources = appSources;
	}

	// Two static factories, one without parameters:
	public static Application get() { 
		return get(null); 
	}

	// Second static factory with parameters:
	public static Application get(AppSources appSources) {
		if (instance == null) {
			synchronized (Application.class) {
				if (instance == null) {
					if (appSources == null) {
						appSources = AppSourcesRepo.getDefault();
					}
					instance = new Application(appSources);
					instance.init(); // init() is a method which calls other methods, e.g. initIOSDriver();
										// init() is method of the object.
				}
			}
		}
		return instance;
	}

	/*
	 * remove() method allows to quit the app during test and start another app
	 * (part of the test in one app, second part in the other app)
	 */
	public static void remove() {
		if (instance != null) {
			instance.quit();
		}
		instance = null;
	}

	/*
	 * init() contains list of methods which should be called to startDriver, to
	 * setWait; Init Strategy from the AppSources.
	 */
	public void init() {
		initIOSDriver();
		initWaits();
	}

	/*
	 * Method load() should load the application. // See video at 28:00 min. it
	 * should put app into initial state, otherwise further tests may fail
	 */
	public LoginPage load() {
		// logout(); // logout is needed to make sure that app state is initial and no
		// user is signed in.
		// System.out.println("Debug - \"LoginPage load()\" return new LoginPage(ios) "
		// + new LoginPage(ios));
		return new LoginPage(ios);
	}

	// public LoginPage login() {
	// logout();
	// getApp().get(getAppSources().getLoginUrl());
	// return new LoginPage(ios);
	// }

	// public LoginPage logout() {
	// //getApp().get(getAppSources().getLogoutUrl());
	// return new LoginPage(ios);
	// }

	public void quit() {
		if (getApp() != null) {
			getApp().quit();
		}
	}

	public static IOSDriver<?> getApp() {
		// TODO For parallel work
		return ios;
	}

	public AppSources getAppSources() {
		return appSources;
	}

	/*
	 * which app to start in using fabric method pattern
	 */
	private void initIOSDriver() {
		Apps currentApp = Apps.IPAD_MINI;
		// for (Apps app : Apps.values()) {
		// if
		// (app.toString().toLowerCase().contains(getAppSources().getApplicationName().toLowerCase()))
		// { // getAppName().toLowerCase())) {
		// currentApp = app;
		// break;
		// }
		// }
		this.ios = currentApp.runApp(this.getAppSources()); // add appSources instead of this.getAppSources()
															// Try to add here URL and initialize waits
	}

	/*
	 * This is the same as ios.manage().timeouts().implicitlyWait(30,
	 * TimeUnit.SECONDS);
	 */
	private void initWaits() {
		getApp().manage().timeouts().implicitlyWait(getAppSources().getImplicitTimeOut(), TimeUnit.SECONDS);
		//System.out.println("Debug - initWaits(): "
				//+ getApp().manage().timeouts().implicitlyWait(getAppSources().getImplicitTimeOut(), TimeUnit.SECONDS));
	}

}
