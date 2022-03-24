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

public class SampleClass {

	public static String browser = "chrome";
	public static WebDriver driver;
	
	public static String[] veggis = { "Brocolli", "Beetroot", "Beans", "Cucumber", "Mushroom", "Potato" };
	
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
	
	public void addItems() {
		
		{

			int j = 0;

			List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

			for (int i = 0; i < products.size(); i++)

			{

				// Brocolli - 1 Kg

				// Brocolli, 1 kg

				String[] name = products.get(i).getText().split("-");

				String formattedName = name[0].trim();

				// format it to get actual vegetable name

				// convert array into array list for easy search

				// check whether name you extracted is present in arrayList or not-

				List productList = Arrays.asList(veggis);

				if (productList.contains(formattedName))

				{

					j++;

					// click on Add to cart

					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

					if (j == veggis.length)

					{

						break;

					}

				}

			}
		}
	}

	public static void main(String[] args) {

		SampleClass se = new SampleClass();
		
		se.driversetup();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		se.addItems();
		
		driver.findElement(By.xpath("//div[@class='cart'] //img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class=\"cart-preview active\"] //button")).click();
		driver.findElement(By.cssSelector("div[class='promoWrapper'] input[type='text']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("div[class='promoWrapper'] button[class='promoBtn']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class=\"promoInfo\"] ")));
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='wrapperTwo']/label")));
		
		driver.quit();

	}

}
