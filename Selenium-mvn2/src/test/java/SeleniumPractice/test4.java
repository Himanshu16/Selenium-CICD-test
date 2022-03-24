package SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test4 {
	
	public static String browser ="Chrome";
	public static WebDriver driver;
	
	void setup()
	{
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	}
	
	public static void main(String[]args)
	{
		test4 ts = new test4();
		ts.setup();
		
		driver.get("https://www.google.com");
		
	}
}
