package SeleniumPractice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.stream.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StreamsT {

	public static String browser = "edge";
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

	
	
	
	public static void main(String[]args)
	{
		
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Himanshu");
		names.add("Surbhi");
		names.add("Nirvani");
		names.add("Ashmita");
		names.add("Sunil");
		names.add("Pratibha");
        System.out.println(names);
       Long c = names.stream().filter(x->x.contains("i")).count();
       System.out.println(c);
       
       long d =Stream.of("Himanshu","Ashmita","Nirvani").filter(h->h.startsWith("N")).count();
       System.out.println(d);
       
       names.stream().filter(z->z.length()>4).sorted().limit(7).forEach(z->System.out.println(z));
       
       Stream.of("Shiva","Vishnu","Bhrama").filter(s->s.length()<=5).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
       
       
       ArrayList<String> nameless = new ArrayList<String>();
       nameless.add("Womaniya");
       nameless.add("meniya");
       
     Stream<String> newStream =  Stream.concat(nameless.stream(), names.stream());
	newStream.sorted().forEach(s->System.out.println(s));
	
	}
	
}
