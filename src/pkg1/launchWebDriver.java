package pkg1;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class launchWebDriver {
	
	public static WebDriver driver;
	
	public void setupBrowser() {
	}
	
	public void launchApp(String url) {
			}
	
	public void testSearch(String strSearch) {
			}
	
	@Test 
	public void junitTestA() {
		try {
			System.out.println(System.getProperty("user.dir"));
//			System.setProperty("webdriver.chrome.driver","C:\\Users\\vforv\\eclipse-workspace\\MavenJunitFramework\\drivers\\chromedriver104.exe");  //500 exception - browser v106 mismatch driver v104 
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\drivers\\chromedriver106.exe");
			driver = new ChromeDriver();
			System.out.println("Browser launched");

//			launchApp("https://www.google.com");
 			String url = "https://www.google.com";
			System.out.println(url);
			driver.get(url);
			driver.navigate().to(url);
			System.out.println("Navigate to " + url);
			
			driver.manage().window().maximize();
			System.out.println("Maximize window");

			String strSearch = "Weather forecast";
			//Search
			if(driver.findElement(By.id("gb")).isDisplayed()) {
				System.out.println("header displayed");
			} else {
				System.out.println("header not displayed");
			}
			
			driver.findElement(By.xpath("//input")).sendKeys("By.xpath");
			System.out.println("Key in by xpath");
			Thread.sleep(1000);
			
//			driver.findElement(By.className("gLFyf gsfi")).sendKeys("By.className");   //InvalidSelectorException - compound class name - not acceptable by classname but can be used in xpath
			System.out.println(driver.findElement(By.className("XDyW0e")).isDisplayed());
			System.out.println("find by class name");
			Thread.sleep(1000);
			
//			driver.findElement(By.name("q")).sendKeys("By.name");
			driver.findElement(By.name("q")).clear(); 
			System.out.println("Key in by name");
			Thread.sleep(1000);
			
			System.out.println(driver.findElement(By.tagName("title")).getText());
			System.out.println("in by tag name");
			Thread.sleep(1000);
			
//			driver.findElement(By.linkText("https://about.google/?fg=1&utm_source=google-US&utm_medium=referral&utm_campaign=hp-header")).click();
			driver.findElement(By.linkText("About")).click();
			System.out.println("click By LinkText");
			Thread.sleep(1000);
			
			driver.navigate().back();
			Thread.sleep(1000);
			
			driver.findElement(By.partialLinkText("bou")).click();
			System.out.println("click By PartialLinkText");
			Thread.sleep(1000);

			driver.navigate().back();
			
			// # for id, . for class
			driver.findElement(By.cssSelector("#gbqfbb")).click();
			System.out.println("Click I'm feeling lucky - CSSselector!");
			Thread.sleep(1000);
			
			//xpath
			driver.findElement(By.xpath("//input[1]")).sendKeys(strSearch);
			System.out.println("By xpath - multiple ele");
			Thread.sleep(1000);
			
			WebElement btn = driver.findElement(By.xpath("//input[@class='gNO89b']"));
			if(btn.isEnabled()) {
				btn.click();
				System.out.println("Button click - Google Search");
				
			}else {
			
				driver.switchTo().activeElement().sendKeys(Keys.ENTER);
				System.out.println("Click Enter - Google Search");
			}
			
			//check if able to click element with xpath
			
			if(driver.getWindowHandles().isEmpty()) {
				System.out.println("all windows closed");
			} else {
				System.out.println(driver.getWindowHandles().size() + " windows open.");
				System.out.println("closing the remaining windows");
				driver.close();
//				driver.quit();
			}
			
		} catch(Exception e) {
			System.out.println("Exception occurred - main test - " + e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("End of Test");
		}
		
	}
	
//	@Test
//	public void testBSearch() {
//
//			testSearch("weather forecast");
//			System.out.println("Search Google");
//	}
	
	@AfterClass	//@Test
	public static void testCtearDown() {
		try {
			
			/*
			 * if(driver.getWindowHandles().isEmpty()) {
			 * System.out.println("all windows closed"); } else { driver.close(); //
			 * driver.quit(); System.out.println("closing the remaining windows"); }
			 */
			
		}catch(Exception e) {
			System.out.println("Exception occured - AfterClass");
			e.printStackTrace();
		}finally {
			System.out.println("That's all folks!");
		}
	}
}
