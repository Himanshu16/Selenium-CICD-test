package SeleniumPractice;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollingBehav {

	public static String browser = "chrome";
	public static WebDriver driver;
	
	public static String[] veggis = { "Brocolli", "Beetroot", "Beans", "Cucumber", "Mushroom", "Potato" };
	
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
		 driver.findElement(By.xpath("//div[@id='content'] //a[text()='Click to load get data via Ajax!']")).click();
		  WebDriverWait exw = new WebDriverWait(driver, Duration.ofSeconds(4));
		  exw.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));
		  
	System.out.println(driver.findElement(By.id("results")).getText());	
	}
	public static void main(String[] args) {

		ScrollingBehav se = new ScrollingBehav();
		
		se.driversetup();
		
		driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");

		driver.manage().window().maximize();
		
		
		se.logic();
		
		driver.quit();

	}

}
