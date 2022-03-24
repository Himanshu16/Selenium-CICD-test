package Seleniumui1;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdown {
	
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
		
		/*driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		WebElement sdd = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); 
		
		Select dd = new Select(sdd);
		
		dd.selectByIndex(3);
		
		System.out.println(dd.getFirstSelectedOption().getText());
		
		/*bElement dcdd = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1"));
		
		Select cdd = new Select(dcdd);
		
		cdd.selectByIndex(5);
		
		System.out.println(cdd.getFirstSelectedOption().getText());
	
		
        driver.get("https://rahulshettyacademy.com/seleniumPractise");
		
        int i = 1;
        
        while (i<5) {
	
        	   driver.findElement(By.xpath("//div[@class=\"stepper-input\"]//following-sibling::a")).click();
           i++;	   
        }
        
        for (int i1 = 1; i1 < 7; i1++) {
			driver.findElement(By.xpath("")).click();
			
		}
        */
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BHO']")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='PNQ']")).click();
		
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("(//div[@id=\"ui-datepicker-div\"] //*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[3]/td[4]/a")).click();
    
	}

}
