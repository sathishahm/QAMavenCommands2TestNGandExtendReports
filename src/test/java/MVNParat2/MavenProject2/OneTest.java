package MVNParat2.MavenProject2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OneTest {
	WebDriver driver; // driver is global variable

	@Test
	public void metheodOne() {
		
		System.out.println("metheodOne executed");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://omayo.blogspot.com/");

		String actualtext = driver.findElement(By.id("pah")).getText();

		Assert.assertEquals("PracticeAutomationHere", actualtext);
	

	}
	
	//Close the browser

	@AfterMethod
	public void closure() {   
	driver.close();

	}

}
