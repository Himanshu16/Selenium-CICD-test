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

public class windowhandling {

	public static String browser = "chrome";
	public static WebDriver driver;

	// method to setup driver

	public void driversetup() {
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

	// method to write logical program
	void logic() {

		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[33]/a")).click();
		driver.findElement(By.xpath("//div[@class='example'] //a[@target='_blank']")).click();

		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentTab = it.next();
		String childTab = it.next();
		driver.switchTo().window(childTab);
		System.out.println(driver.findElement(By.xpath("//h3")).getText());
		driver.switchTo().window(parentTab);
		System.out.println(driver.findElement(By.xpath("//h3")).getText());

	}

	public static void main(String[] args) {

		windowhandling se = new windowhandling();

		se.driversetup();

		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		se.logic();

		// driver.quit();

	}

}
