package Seleniumui1;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class e2e {
	
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
		
		
		driver.get("https://corporate.spicejet.com/default.aspx");
		
		driver.manage().window().maximize();	
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//div[@id='travelOptions'] //input[@value='RoundTrip']")).click();
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//div[@id=\"ctl00_mainContent_ddl_originStation1_CTNR\"] //a[@value='BHO']")).click();
		
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//div[@id=\"ctl00_mainContent_ddl_destinationStation1_CTNR\"] //a[@value='PNQ']")).click();
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
		  System.out.println("Pass");
		  Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Fails");
			Assert.assertFalse(false);
		}
		
		driver.findElement(By.xpath("//div[@id='discount-checkbox'] //label[@for='ctl00_mainContent_chk_friendsandfamily']")).click();
		
		driver.findElement(By.id("divpaxinfo")).click();
		
		driver.findElement(By.xpath("//select[@id=\"ctl00_mainContent_ddl_Adult\"]")).click();
		
		WebElement adult = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Adult']"));
		
		Select dropdown = new Select(adult);
		
		dropdown.selectByValue("5");
	   
		driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).click();
		
		WebElement money = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select amount = new Select(money);
		
		amount.selectByValue("EUR");
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
	    //Select no = new Select() driver.findElement(By.id("ctl00_mainContent_ddl_Adult")).click();
		
	}
		}
	
	
