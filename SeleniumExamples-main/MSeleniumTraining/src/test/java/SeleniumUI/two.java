package SeleniumUI;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class two {
	
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
		
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("facebook");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div[1]/a/h3")).click();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//System.out.println(driver.getPageSource());
		driver.findElement(By.id("email")).sendKeys("venom.himanshu@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Himanshu16@92");
		driver.findElement(By.xpath("//*[@id=\"u_0_d_fB\"]")).click();
		//driver.navigate().back();
		//driver.navigate().forward();
		//driver.close(); // it will close the current tab in the browser
		//driver.quit();  // it closes all the tabs in browser open by the Selenium Script

	}

}
