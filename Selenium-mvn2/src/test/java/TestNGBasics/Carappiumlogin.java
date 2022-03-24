package TestNGBasics;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

class Carappiumlogin {
	@BeforeTest
	
	public void acceptcookies()
	{
		System.out.println("appium cookies accepted");
	}

	@Parameters({"url"})
	@Test(groups= {"login"})
	public void start(String appium) {
		System.out.println("Mobile app login");
		System.out.println(appium);
	}
	
	@Test
	public void test()
	{
		System.out.println("passed");
	}
	@AfterTest
	
	public void clearcookies()
	{
	System.out.println("Appium cookies cleared");	
	}
	
}