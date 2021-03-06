package testngsample;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HierarchyTest {
	
	@BeforeSuite
	public void beforesuite()
	{
		System.out.println("this is before suite");
	}
	
	@AfterSuite
	public void aftersuite() {
		System.out.println("this is after suite");
	}
	
	@BeforeClass
	public void beforeclass() {
		System.out.println("this is before class");
	}
	
	@AfterClass
	public void afterclass() {
		System.out.println("this is after class");
	}
	
	@BeforeTest
	public void beforetest() {
		System.out.println("This is before test");
	}
	
	@AfterTest
	public void aftertest() {
		System.out.println("This is after test");
	}
	
	@Test
	public void test() {
		System.out.println("this is test");
	}
	
	@BeforeMethod
	public void beforemethod() {
		System.out.println("this is before method");
	}
	
	@AfterMethod
	public void aftermethod() {
		System.out.println("This is after method");
	}
}
