package tests;

import org.apache.log4j.BasicConfigurator;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

public class InitializeLogging {

	static {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		System.setProperty("current.date.time", dateFormat.format(new Date()));
	}
	
	private final static Logger logger = Logger.getLogger(InitializeLogging.class);

	public static Logger getLogger() {
		return logger;
	}

	@Test
	public void loggingConfig() {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("/Users/olaytar/eclipse-workspace3/MavenYB/src/appl/log4j.properties");
	}

}
