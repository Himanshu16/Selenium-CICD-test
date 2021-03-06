package SeleniumPractice;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Iterator;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v94.network.model.Initiator;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class framesAssig2 {

	public static String browser = "chrome";
	public static WebDriver driver;

	static void driversetup() {
		if (browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
	}
	
	static void Logic() 
	{
		driver.findElement(By.partialLinkText("Nested Frames")).click();
		
		//System.out.println(driver.findElements(By.tagName("frame")).size());
		driver.switchTo().frame("frame-top"); 
		driver.switchTo().frame("frame-middle");
		 System.out.println(driver.findElement(By.id("content")).getText());
	}
	
	public static void main(String[]args)
	{
		framesAssig2 fr = new framesAssig2();
		fr.driversetup();
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		fr.Logic();
	}
}
