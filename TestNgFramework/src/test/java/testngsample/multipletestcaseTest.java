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

public class multipletestcaseTest {
	//adding priority 

	@Test(priority=1, groups="test")
	public void gama () {
		System.out.println("this is gama test");
	}
	
	@Test(priority=1, groups="test")
	public void alpha() {
		System.out.println("this is alpha test");
	}

	@Test(priority=1, groups="test")
	public void beta() {
		System.out.println("this is beta test");
	}
	
	@Test(groups="testone")
	public void aplhaone()
	{
		System.out.println("this is alphaone");
	}
	@Test(groups="testone")
	public void betaaone()
	{
		System.out.println("this is betaone");
	}
	@Test(groups="testone")
	public void gamaone()
	{
		System.out.println("this is gamaone");
	}

}
