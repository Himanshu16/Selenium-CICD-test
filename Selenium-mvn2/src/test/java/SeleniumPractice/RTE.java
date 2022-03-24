package SeleniumPractice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RTE {

	public static String browser = "chrome";
	public static WebDriver driver;

	// driver setup method
	static void driversetup() {
		if (browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
	}

	// Logical Method
	static void getLink() {
		driver.get("http://qaclickacademy.com/practice.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

        //entire page link count
		System.out.println("link count on entire page is " + driver.findElements(By.tagName("a")).size());
		
		//footer count
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println("link count on footer is " +footer.findElements(By.tagName("a")).size());
		
		//footer col
		
		WebElement col1 =footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println("link count on footer 1st col is "+ col1.findElements(By.tagName("a")).size());
	
		WebElement col2 =footer.findElement(By.xpath("//table/tbody/tr/td[2]/ul"));
		System.out.println("link count on footer 2nd col is "+ col2.findElements(By.tagName("a")).size());
		
		int size_col1 = col1.findElements(By.tagName("a")).size();
		int size_col2 = col2.findElements(By.tagName("a")).size();
		
		// clicking links open in new tabs
		
		String click_open_tab = Keys.chord(Keys.CONTROL,Keys.ENTER);
		
		for(int i=1;i<size_col1;i++)
		{
			col1.findElements(By.tagName("a")).get(i).sendKeys(click_open_tab);
			
		}
		
		for(int j=1;j<size_col2;j++)
		{
			col2.findElements(By.tagName("a")).get(j).sendKeys(click_open_tab);
			
		}
       // getting title of each tabs
		
		Set<String> getTitle = driver.getWindowHandles();
		Iterator<String> it=getTitle.iterator();
		
		while(it.hasNext()){
			
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			
		}
		
	    
		
		
		try {
		Thread.sleep(3);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		//driver.quit();
	}

	// main method
	public static void main(String[] args) {
		RTE obj = new RTE();

		obj.driversetup();
		obj.getLink();

	}

}
