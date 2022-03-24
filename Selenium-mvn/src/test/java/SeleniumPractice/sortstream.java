package SeleniumPractice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sortstream {

	public static String browser = "chrome";
	public static WebDriver driver;

	// method for driver setup

	void driverSetup() {
		if (browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}

	// method for basic navigation and getting url

	void basics()

	{
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}

   void logics() {
	   
	   driver.findElement(By.xpath("//tr/th[1]")).click();
	   
	   List<WebElement>names =driver.findElements(By.xpath("//tr/td[1]"));
   }
	
	
	public static void main(String[]args)
	{
		sortstream ss =new sortstream();
		
		ss.driverSetup();
		ss.basics();
		ss.logics();
		
		
 
	
	}
	
}
