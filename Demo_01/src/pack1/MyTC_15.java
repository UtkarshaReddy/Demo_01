package pack1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTC_15 
{
  @Test
  public void f() throws InterruptedException
  {
	  WebDriver driver;
	  System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver-v0.24.0-win32\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.get("http://demowebshop.tricentis.com/");
	  driver.manage().window().maximize();
	  WebDriverWait wait = new WebDriverWait(driver,60);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='q']")));
	  WebElement e = driver.findElement(By.xpath("//input[@name='q']"));
	  Actions act1 = new Actions(driver);
	  Thread.sleep(5000);
	  act1.keyDown(e,Keys.SHIFT).sendKeys("computer").keyUp(Keys.SHIFT).build().perform();
	  Thread.sleep(5000);
	  act1.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
	  Set<String> T_windows = driver.getWindowHandles();
		int count = T_windows.size(); 
		System.out.println(count);      
		for (String S:T_windows)
		{
			driver.switchTo().window(S);
			System.out.println(driver.getWindowHandle());	
		}
	  Thread.sleep(5000);
	  String expected_text = driver.findElement(By.xpath("//h1[contains (text(),'Build your')]")).getText();
	  String actual_text = "Build your own expensive computer";
	  System.out.println(expected_text);
	  System.out.println(actual_text);
	  Assert.assertEquals(expected_text,actual_text);
	 System.out.println("The web page has opened correctly");
  }
}
