package appl;

import java.net.URL;

/* This class is a helper or utility class, it is written using static design pattern. */

public final class AppSourcesRepo { 		// final - don't allow to extend this class.

	/* Constructor. It is set as private so that no other constructor is used and so
	 * that nobody could call it to create object if this class. */
	private AppSourcesRepo() {

	}

	// Methods
	// ??? write method getPB2.xxDebugDemo();
	
	public static AppSources getDefault() {
		//return getAppOnIPadMini();
		return getApp();
	}
	
	// Method to start app on the iPad
	public static AppSources getApp()  {
		
		try {
			URL remote = new RemoteServerURL().getRemoteURL();
			System.out.println("Debug - Remote url: " + remote);
			return new AppSources.AppSourcesBuilder(remote, CapabilitiesRepo.get().SetCapabilities("PB2141IPadMini"))
								.implicitTimeOut(18)
								.build();	
		}
		catch (Exception e) {
			System.out.println("Exception " + e);
			
		}
		return null;
	}

	// Add Method to start app on the iPad Air
	// TODO

	// .getResource("/lib/chromedriver.exe").getPath().substring(1); // path to the
	// folder on file system - workspace_name/project_name/target/test-classes/

}