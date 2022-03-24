package Seleniumui1;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Suggestdropdown {
	
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
			
			
			driver.get("https://www.google.co.in/");
			driver.findElement(By.name("q")).sendKeys("India is");
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			List<WebElement> options = driver.findElements(By.cssSelector("ul[class=\"G43f7e\"] li"));
			
			for(WebElement option:options)
			{
				if(option.getText().equalsIgnoreCase("India is my country"))
				{
					option.click();
					
					driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
					break;
				}
			}
			
		}
	}
}