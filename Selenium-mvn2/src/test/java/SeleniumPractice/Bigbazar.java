package SeleniumPractice;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bigbazar {

	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) {

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

	
		driver.get("https://shop.bigbazaar.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String[] itemNeeded = {"apple","Rosemarry"};
		
		driver.findElement(By.xpath("//div[@class='loginCross']")).click();
		
		//driver.switchTo().alert().dismiss();
		
		driver.findElement(By.id("edc-search")).sendKeys("fruits");
		driver.findElement(By.id("edc-search")).sendKeys(Keys.ENTER);
		
		List<WebElement>Product= driver.findElements(By.cssSelector("div[class=product-name]"));
		
		for(int i=0;i<Product.size();i++)
		{
			String[] name = Product.get(i).getText().split(" ");
			String updatedName = name[0].trim();
			
			if(updatedName.contains("itemNeeded"))
			{
				
				driver.findElement(By.xpath("//div[@class='cart-action-web'] //div[@class='cartflag']/span")).click();
			
			}
		}
		
		
		
		
		
	}

}
