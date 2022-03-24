package SeleniumUI;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class rediff {
	
	public static String browser = "Chrome";
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
		
		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[title*=' Sign in']")).click();
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("HEllo");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("HEllo");
		//driver.findElement(By.xpath("//*[@id=\'password\']")).sendKeys("QWERTY");
		driver.findElement(By.cssSelector("[title*='Sign']")).click();
		
		System.out.println(driver.findElement(By.cssSelector("[id=\"div_login_error\"]")).getText());	
	    
	
	}

}
