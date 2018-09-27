package appl;

import java.net.URL;


import org.openqa.selenium.remote.DesiredCapabilities;


/* Class AppSource in the data package.
	It class is starting the app. It provides metadata:
	- Which app to start;
	- Which Timeout (implicit/explicit); 
	- Logging strategy;
	- How to start driver
	Use builder to pass arguments to the constructor.
	https://jlordiales.me/2012/12/13/the-builder-pattern-in-practice/
 * */

public class AppSources {
	// Fields
		
	private URL serverURL; 		
	private DesiredCapabilities capabilities = CapabilitiesRepo.get().SetCapabilities("Simulator");	
	private long implicitTimeOut;
	
	
	
	/*
	switch(true) {
		case device.equals("Simulator"): capabilities = CapabilitiesRepo.get().SetSimulatorCapabilities(); 
		break;
		
		case device.equals("iPadMini"): capabilities = CapabilitiesRepo.get().SetIPadMiniCapabilities();	
		break;
		
		default: System.out.println("Capabilities are not found");
			
	
	}
	
	*/
	// private long explicitTimeOut;
	//
	// Logger Strategy
	// private String loggerStrategy;
	//
	// URLs
	// private String loginUrl;
	// private String logoutUrl;
	//
	// Connect to DB
	// Selenium Version

	/*
	 * Constructor. It is private, which means that this class can not be directly
	 * instantiated from the client code.
	 */
	private AppSources(AppSourcesBuilder builder) {
		this.serverURL = builder.serverURL;
		this.capabilities = builder.capabilities;
		this.implicitTimeOut = builder.implicitTimeOut;
	}

	// Getters - - - - - - - - - - - - - - - - - - - - - - - - - -
	public URL getServerURL() {
		return serverURL;
	}
	
	
	public DesiredCapabilities getCapabilities() {
		return capabilities;
	}
	
	
	
	public long getImplicitTimeOut() {
		return implicitTimeOut;
	}

	// Setters - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// No setters because fields are set when calling builder.

	/* Builder class. The builder uses the 'Fluent Interface' idiom to make the
	 * client code more readable  */
	
	public static class AppSourcesBuilder {
		private URL serverURL;
		private DesiredCapabilities capabilities;
		private long implicitTimeOut;
		
		public AppSourcesBuilder(URL serverURL, DesiredCapabilities capabilities) {
			this.serverURL = serverURL;
			this.capabilities = capabilities;
		}
		
		
		public AppSourcesBuilder serverURL(URL serverURL) {
			this.serverURL = serverURL;
			return this;
		}
		
		public AppSourcesBuilder capabilities(DesiredCapabilities capabilities) {
			this.capabilities = capabilities;
			return this;
		}
		
		
		public AppSourcesBuilder implicitTimeOut(long implicitTimeOut) {
			this.implicitTimeOut = implicitTimeOut;
			return this;
		}
		
		public AppSources build() {
			return new AppSources(this);
		}
	}

//	public String getLogoutUrl() {
//		// TODO 	
//		return null;
//	}

	// Create a new AppSource object. Example:

//	public AppSources getAppSources() {
//	return new AppSources.AppSourcesBuilder(getServerURL(), getCapabilities())
//			.implicitTimeOut(15000)
//			.build();
//}

}
