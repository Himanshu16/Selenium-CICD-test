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

public class Cleartrip {

	public static String browser = "Edge";
	public static WebDriver driver;

	public static void main(String[] args) {

		if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		}

		else if (browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.get("https://www.cleartrip.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//p[text()='One way']")).click();

		driver.findElement(By.xpath("//div[contains(@class,'homeCalender')] //div[contains(@class,'flex-nowrap')]"))
				.click();

		driver.findElement(By.xpath("//div[contains(@class,'DayPicker-Day--today')]/div/div")).click();

		driver.findElement(By.xpath("(//div[contains(@class, 'row pt-3 pb-4 p-relative px-')] //select)[1]")).click();

		WebElement adults = driver
				.findElement(By.xpath("(//div[contains(@class, 'row pt-3 pb-4 p-relative px-')] //select)[1]"));
		Select adult = new Select(adults);
		adult.selectByValue("5");

		driver.findElement(By.xpath("//a //strong[text()='More options:']")).click();

		driver.findElement(By.xpath("//div[contains(@class,'row p-relative ')] //select")).click();

		WebElement class_of_travel = driver.findElement(By.xpath("//div[contains(@class,'row p-relative ')] //select"));

		Select travel = new Select(class_of_travel);

		travel.selectByValue("Business");

		driver.findElement(By.xpath("//input[@placeholder='Airline name' or type='text']")).sendKeys("emirates");

		driver.findElement(
				By.xpath("//p[@class=\"to-ellipsis o-hidden ws-nowrap c-inherit fs-3\" or text()='Emirates (EK)']"))
				.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//button[text()='Search flights']")).click();

		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());

	}
}
