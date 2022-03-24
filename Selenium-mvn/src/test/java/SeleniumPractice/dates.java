package SeleniumPractice;

import java.time.Duration;
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

public class dates {

	public static String browser = "chrome";
	public static WebDriver driver;
	public static String val ="Greenville-Spartanburg International Airport (Roger Milliken Field) (GSP) Greer";
	public static String val2 ="Albuquerque International Sunport (ABQ) Albuquerque";

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
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	//logical method 
	
	void Fromlogical() 
	{
		// for start location boarding point
		
		driver.findElement(By.name("travel_from")).sendKeys("sp");
		List<WebElement> TF_options = driver.findElements(By.cssSelector("div[class='optionDiv']"));
		
		for(WebElement option:TF_options)
		{
			if(option.getText().equalsIgnoreCase(val))
			{
				option.click();
				
				driver.findElement(By.name("travel_from")).sendKeys(Keys.ENTER);
				break;
			}
		}
		
		//for end drop off location
		
		driver.findElement(By.name("travel_to")).sendKeys("s");
		List<WebElement>DF_options= driver.findElements(By.cssSelector("div[class='optionDiv']"));

		for(WebElement option:DF_options)
		{
			if(option.getText().equalsIgnoreCase(val2))
			{
				option.click();
				driver.findElement(By.name("travel_to")).sendKeys(Keys.ENTER);
				break;
			}
		}
		
		//select month
		
		driver.findElement(By.xpath("//*[@id='travel_date']")).click();
		while(!driver.findElement(By.xpath("//div[@class='datepicker-days'] //th[@class='datepicker-switch']")).getText().contains("December"))
		{
			driver.findElement(By.xpath("//table[@class=' table-condensed'] //th[@class='next']")).click();
		}
		
		//select the date 
		
		driver.findElement(By.id("travel_date")).click();
		
	    List<WebElement> Bdate = driver.findElements(By.xpath("//td[@class='day']"));
		
		int count =driver.findElements(By.xpath("//td[@class='day']")).size();
		
		for(int i=0;i<count;i++)
		{
		   String text = driver.findElements(By.xpath("//td[@class='day']")).get(i).getText();
		   
		   if(text.equalsIgnoreCase("23"))
		   {
			   driver.findElements(By.xpath("//td[@class='day']")).get(i).click();
			   break;
		   }
			
		}
		
		
	}
 
	 //main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		dates as = new dates();

		as.driverSetup();
		as.basics();
		as.Fromlogical();
       
	}

}
