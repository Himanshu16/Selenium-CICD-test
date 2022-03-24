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
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assisment {
	
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
	    
		driver.findElement(By.xpath("//div[@id='travelOptions'] //input[@value='RoundTrip']")).click();
		
		driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_originStation1']")).click();
		
		//driver.findElement(By.xpath("//div[contains(@id,'originStation1_CTNR')] //a[@value='BHO']")).click();
		/*
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		//driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_destinationStation1']")).click();
		
		//driver.findElement(By.xpath("//div[contains(@id,'destinationStation1_CTNR')] //a[@value='PNQ']")).click();
		
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		//Assert.assertFalse(false);
		//System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		//Assert.assertTrue(true);
		//System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
	
		
		Assert.assertEquals((driver.findElements(By.xpath("//div[@id=\"discount-checkbox\"] //input[@type='checkbox']")).size()), 8);
		//System.out.println(driver.findElements(By.xpath("//div[@id=\"discount-checkbox\"] //input[@type='checkbox']")).size());
		System.out.println("Test is passes");
	
		
		/*
		
		// Actual exercise of class
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
		
		
		
		 int i=1;
		
	 for(i=1;i>=3;i++)
	 {
		driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
	 }

		driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
		driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
		
		driver.findElements(By.xpath("//div[@id='checkbox-example']/fieldset/label")).size();
		Assert.assertEquals(driver.findElements(By.xpath("//div[@id='checkbox-example']/fieldset/label")).size(), 3);
		
		System.out.println(driver.findElements(By.xpath("//div[@id='checkbox-example']/fieldset/label")).size());
		//driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/fieldset/label[1]")).click();
		 
		*/
		
	}
	}
	
	
