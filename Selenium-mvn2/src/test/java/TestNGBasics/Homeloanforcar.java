package TestNGBasics;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

class Homeloanforcar {
	@BeforeTest
	
	public void acceptcookies()
	{
		System.out.println("Home loan cookies accepted");
	}

	@Test
	public void start() {
		System.out.println("get loan");
	}
	
	@Test
	public void test()
	{
		System.out.println("passed");
	}
	@AfterTest
	public void clearcookies()
	{
	System.out.println("Home Loan cookies cleared");	
	}
	}