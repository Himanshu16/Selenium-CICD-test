package SeleniumPractice;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class waitexe {

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
		 
		 ac.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		 
		 WebElement move = driver.findElement(By.id("twotabsearchtextbox"));
		 
		 ac.moveToElement(move).click().keyDown(Keys.LEFT_SHIFT).sendKeys("aquarium heater").doubleClick().build().perform();
		 
		 ac.moveToElement(driver.findElement(By.id("nav-link-accountList"))).contextClick().build().perform();
		 
		 
		 /* WebDriverWait exw = new WebDriverWait(driver, Duration.ofSeconds(4));
		  exw.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));
		  
	System.out.println(driver.findElement(By.id("results")).getText());	*/
	}
	public static void main(String[] args) {

		waitexe se = new waitexe();
		
		se.driversetup();
		
		driver.get("http://www.amazon.co.in");

		driver.manage().window().maximize();
		
		
		se.logic();
		
		//driver.quit();

	}

}
