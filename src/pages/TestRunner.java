package pages;

//import org.junit.AfterClass;


//import org.junit.BeforeClass;
import org.testng.annotations.*;

//import org.testng.annotations.*;
//import org.testng.annotations.BeforeMethod;

import appl.AppSourcesRepo;
import appl.Application;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

//this class is configuring Application class but it is not starting the app yet.
public class TestRunner {
	@BeforeClass
	
	public void beforeClass() {
		System.out.println("@BeforeClass");
		// This is starting the app instead of ..new LoginPage(driver)
		//Application.get(AppSourcesRepo.getAppOnSimulator());
		Application.get(AppSourcesRepo.getApp());

	}

	@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass");
		//Application.remove();
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod");
		// Application.get().load();
		// Application.get().login();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod");
		// Application.get().logout();
	}

}