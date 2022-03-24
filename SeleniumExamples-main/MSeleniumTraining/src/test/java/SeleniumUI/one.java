package SeleniumUI;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class one {
	
	public static String browser;
	
	public static WebDriver driver;
	

	public static void main(String[] args) {
	
	System.out.println("Hello, Please select the browser for your test.");	
		
	Scanner scanner = new Scanner(System.in); 
		
	 browser = scanner.nextLine();
		
		
		switch (s) {
    
	case "Chrome":WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	break;
    
    case "Edge":WebDriverManager.edgedriver().setup();
	driver = new EdgeDriver();
	break;	
	
    case "IE":WebDriverManager.iedriver().setup();
	driver = new InternetExplorerDriver();
	break;
	
    default:
		break;
	}
	
	
	    driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("Himanshu Joshi");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3")).click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.close(); 
	}

}
