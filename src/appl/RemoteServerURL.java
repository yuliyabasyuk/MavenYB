package appl;

import java.net.URL;
import java.net.MalformedURLException;

public class RemoteServerURL {

	public String serverURL = "http://127.0.0.1:4723/wd/hub";
	
	public URL getRemoteURL() throws MalformedURLException {

		return new URL(serverURL);
	
	}
}
