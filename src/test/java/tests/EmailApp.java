package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class EmailApp {

	WebDriver driver;
	
	@Test
	public void Emial_Test() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		//1. Go to http://live.demoguru99.com/index.php/backendlogin/
		driver.get("http://live.demoguru99.com/index.php/backendlogin/");    
		
		//2. Login the credentials provided 
		driver.findElement(By.id("username")).sendKeys("user01");
		driver.findElement(By.id("login")).sendKeys("guru99com");  
		driver.findElement(By.xpath("//input[@type='submit']")).click(); 
		driver.findElement(By.xpath("//*[@id='message-popup-window']/div[1]/a")).click(); 
		
		Thread.sleep(5000);     
		
		//3. Go to Sales > Order menu
		driver.findElement(By.xpath("//*[@id='nav']/li[1]")).click();
		driver.findElement(By.xpath("//*[@id='nav']/li[1]/ul/li[1]/a")).click(); 
		
		//4. Select CSV in Export to Dropdown and Click Export button
		WebElement DropDown = driver.findElement(By.xpath("//*[@id='sales_order_grid_export']"));    
		Select select = new Select(DropDown);
		select.selectByVisibleText("CSV");
		driver.findElement(By.xpath("//button[@title='Export']")).click();    
		
		//5. Read download file and display all order information in console windows
		String filePath = System.getProperty("user.home")+"/Downloads/orders.csv";   
	
		//6. Attached this export file and email to another email id
		
	}
}
