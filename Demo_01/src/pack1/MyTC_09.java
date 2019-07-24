package pack1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MyTC_09 
{
  @Test
  public void f() throws InterruptedException
  {
	  WebDriver driver;
	    System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver-v0.24.0-win32\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.w3schools.com/Js/tryit.asp?filename=tryjs_alert");
		driver.manage().window().maximize();
		driver.switchTo().frame(driver.findElement(By.name("iframeResult")));
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Thread.sleep(10000);
		String S=driver.switchTo().alert().getText();
		System.out.println(S);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.xpath("//span[text()='JavaScript Alert']")).getText());
  }
}
