package TestNGBasics;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

class Carapilogin {
	
	@BeforeSuite
	public void bfs()
	{
		System.out.println("I am before suite");
	}
	
	@AfterSuite
	public void afs()
	{
		System.out.println("I am after suite");
	}
	
	@BeforeMethod
	public void beforemothod()
	{
		System.out.println("before methods");
	}
	
	@BeforeTest
	
	public void acceptcookies()
	{
		System.out.println("Car API cookies accepted");
	}

	@Test(groups= {"login"})
	public void start() {
		System.out.println("API login");
	}
	
	@Test(dependsOnMethods= {"start"})
	public void verify() {
		System.out.println("depends on start verify login");
	}
	
	@Test
	public void test()
	{
		System.out.println("test pass");
	}
	
	@AfterTest
	
	public void clearcookies()
	{
	System.out.println("car api cookies cleared");	
	}
	
	
}