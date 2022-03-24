package SeleniumPractice;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Iterator;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v94.network.model.Initiator;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowhandlingAssig {

	public static String browser = "chrome";
	public static WebDriver driver;
	
	// method to setup driver
	
	public  void driversetup() {
		if (browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equals("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	}
	
   //	method to write logical program
	 void logic()
	{
		 
		 Actions ac = new Actions(driver);
		 
		 driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
		 
		 Set<String> windows =driver.getWindowHandles();
		 Iterator <String> its = windows.iterator();
		 String currentTab =its.next();
		 String newTab =its.next();
		 driver.switchTo().window(newTab);		 
		 
		driver.findElement(By.xpath("//p[@class='im-para red'] //a")).getText();
		System.out.println(driver.findElement(By.xpath("//p[@class='im-para red'] //a")).getText()); 
		
		String emailid = driver.findElement(By.xpath("//p[@class='im-para red'] //a")).getText();
		
		driver.switchTo().window(currentTab);
		driver.findElement(By.id("username")).sendKeys(emailid);
		 
		 /* WebDriverWait exw = new WebDriverWait(driver, Duration.ofSeconds(4));
		  exw.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));
		  
	System.out.println(driver.findElement(By.id("results")).getText());	*/
	}
	public static void main(String[] args) {

		windowhandlingAssig se = new windowhandlingAssig();
		
		se.driversetup();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		
		
		
		se.logic();
		
		//driver.quit();

	}

}
