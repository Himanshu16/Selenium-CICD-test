package TestNGBasics;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

class CarseleniumLogin {
	@BeforeTest
	
	public void acceptcookies()
	{
		System.out.println("selenium cookies accepted");
	}

	@Parameters({"url"})
	@Test(groups= {"login"})
	public void start(String selenium) {
		System.out.println(selenium);
		System.out.println("Car selenium login passed");
	}
	
	@Test
	public void test()
	{
		System.out.println("Fail but passed");
	}
	
	@AfterTest
	public void clearcookies()
	{
	System.out.println("selenium cookies cleared");	
	}
}