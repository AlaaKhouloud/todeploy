package com.back.Functionaltests;

 
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.*;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles( profiles={"test"})
public class FunctionalTest {
 
	public WebDriver driver;
	String baseurl = "http://localhost:4200/"; 
	public ExtentTest test; 
	
	
	@org.testng.annotations.Parameters({"browser"})
	@BeforeTest
	public void openBrowser(String browser) {  
		if(browser.equalsIgnoreCase("firefox")) {
			System.out.println("----Firefox test started----");
			File file = new File("E:\\BackEBanking\\geckodriver.exe");
			System.setProperty("webdriver.ff.driver", file.getAbsolutePath());
			driver = new FirefoxDriver();
			System.out.println("Firefox browser is open");
		}
		if(browser.equalsIgnoreCase("chrome")) {
			System.out.println("----Google Chrome test started----"); 
			File file = new File("E:\\BackEBanking\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
			System.out.println("Google Chrome browser is open");
		}
		
		driver.manage().window().maximize();
		System.out.println(browser + " Browser is maximized");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void seliniumElements() throws InterruptedException { 
		test.log(LogStatus.INFO , "Starting of selemium ...");
		
		driver.get(baseurl);
		test.log(LogStatus.PASS, "app client is open");
		System.out.println("app client is open");
		
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("test"); 
		System.out.println("enter login keywords");
		test.log(LogStatus.PASS , "sel autom search key");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='signin']")).click();
		test.log(LogStatus.WARNING , "click login");
		System.out.println("login click");
		Thread.sleep(3000); 
	}
	
	
}