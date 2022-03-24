package testng;

import org.testng.annotations.Test;

class getStarted {

	@Test
	public void start() {
		System.out.println("Pass ");
	}
	
	@Test
	public void test()
	{
		System.out.println("Fail but passed");
	}
}