package SeleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment {

	public static String browser = "chrome";
	public static WebDriver driver;

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
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}

	//logical method 
	
	void logical() 
	{
      // WebElement checkboxId =driver.findElement(By.xpath("//div[@id='checkbox-example']"));
      
       driver.findElement(By.xpath("//div[@id='checkbox-example'] //fieldset/label[3]/input")).click();
      
      String Option =driver.findElement(By.xpath("//div[@id='checkbox-example'] //fieldset/label[3]")).getText();
      
      System.out.println(Option);
      
      WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
     
      Select select = new Select(dropdown);
      
      select.selectByVisibleText(Option);
      
      driver.findElement(By.id("name")).sendKeys(Option);
      driver.findElement(By.id("alertbtn")).click();
      String alertText = driver.switchTo().alert().getText();
      
      if(alertText.contains(Option))
      {
    	   Assert.assertTrue(true);
    	   System.out.println("Pass");
      }
      else
      {
    	  Assert.assertFalse(false);
    	  System.out.println("Fail");
    	  
      }
      
      
      
       
       //driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[3]/input")).click();
       
       //System.out.println(checkboxId.findElements(By.tagName("label")).size());
       
		
	}
 
	//main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Assignment as = new Assignment();

		as.driverSetup();
		as.basics();
		as.logical();

	}

}
