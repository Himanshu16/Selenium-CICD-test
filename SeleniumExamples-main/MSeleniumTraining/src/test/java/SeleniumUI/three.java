package SeleniumUI;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class three {
	
	public static String browser = "Edge";
	public static WebDriver driver;
	public static void main(String[] args) {
		
		if(browser.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
			
		}
		
		else if(browser.equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\'username\']")).sendKeys("username");
		driver.findElement(By.xpath("//*[@id=\'password\']")).sendKeys("QWERTY");
		driver.findElement(By.xpath("//*[@id=\'Login\']")).click();
		
		System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getText());	
	    
	
	}

}
