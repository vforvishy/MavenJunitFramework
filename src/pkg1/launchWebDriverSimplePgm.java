package pkg1;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class launchWebDriverSimplePgm {
	
	public static WebDriver driver;
	
	public void setupBrowser() {
		System.out.println(System.getProperty("user.dir"));
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\vforv\\eclipse-workspace\\MavenJunitFramework\\drivers\\chromedriver104.exe");  //500 exception - browser v106 mismatch driver v104 
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\drivers\\chromedriver106.exe");
		driver = new ChromeDriver();
		System.out.println("Browser launched");
	}
	
	public void launchApp(String url) {
		System.out.println(url);
		driver.get(url);
		driver.navigate().to(url);
		System.out.println("Navigate to " + url);
	}
	
	public void testSearch(String strSearch) {
		if(driver.findElement(By.id("gb")).isDisplayed()) {
			System.out.println("header displayed");
		} else {
			System.out.println("header not displayed");
		}
		
		driver.findElement(By.xpath("//input")).sendKeys("By.xpath");
		System.out.println("Key in by xpath");

		driver.findElement(By.className("gLFyf gsfi")).sendKeys("By.className");
		System.out.println("Key in by class name");
		
		driver.findElement(By.name("q")).sendKeys("By.name");
		System.out.println("Key in by name");
		
		System.out.println(driver.findElement(By.tagName("title")).getText());
		System.out.println("in by tag name");
		
		driver.findElement(By.linkText("https://about.google/?fg=1&utm_source=google-US&utm_medium=referral&utm_campaign=hp-header")).click();
		System.out.println("click By LinkText");
		
		driver.navigate().back();
		
		driver.findElement(By.partialLinkText("https://about.google")).click();
		System.out.println("click By PartialLinkText");

		driver.navigate().back();
		
		// # for id, . for class
		driver.findElement(By.cssSelector("#gbqfbb")).click();
		System.out.println("I'm feeling lucky - CSSselector!");
		
		//xpath
		driver.findElement(By.xpath("//input[1]")).sendKeys(strSearch);
		System.out.println("By xpath - multiple ele");
	}
	
	@Test 
	public void testA() {
		try {
			setupBrowser();
			launchApp("https://www.google.com");
		} catch(Exception e) {
			System.out.println("Exception occurred - " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testBSearch() {

			testSearch("weather forecast");
			System.out.println("Search Google");
	}
	
	@AfterClass	//@Test
	public static void testCtearDown() {
		try {
			driver.close();
			
			if(driver.getWindowHandles().isEmpty()) {
				System.out.println("all windows closed");
			} else {
				driver.quit();
				System.out.println("closing the remaining windows");
			}
			
		}catch(Exception e) {
			System.out.println("Exception occured");
			e.printStackTrace();
		}finally {
			System.out.println("That's all folks!");
		}
	}
}
