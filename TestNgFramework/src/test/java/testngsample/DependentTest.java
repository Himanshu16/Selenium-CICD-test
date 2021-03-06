package testngsample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class DependentTest {
	
	public static String browser = "chrome";
	public static WebDriver driver;
	
	@Test
	public  void driversetup() {
		if (browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
	}

	@Test(dependsOnMethods ={"driversetup"})
	public void geturl() {
		driver.get("www.facbook.com");
	}
	
	@Test(dependsOnMethods ={"geturl"})
	
	public void gettitle(){
		String title = driver.getTitle();
		System.out.println(title);
	}

	
}
