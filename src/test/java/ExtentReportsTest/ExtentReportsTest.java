package ExtentReportsTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsTest {
	
	WebDriver driver; // driver is global variable
	ExtentReports extent;
	
	@BeforeMethod	
	public void Configuration() {
		
		String reportpathofdirectory = System.getProperty("user.dir")+"\\ExtendReports\\index.html";  // Dynamically create the project path instead of allocationig 
																						  // like C:\SATHISHA\JavaSelenium\QAMavenTestNGProject1
		
		ExtentSparkReporter report = new ExtentSparkReporter(reportpathofdirectory);
		
		report.config().setReportName("Omayo Test Report");
		report.config().setDocumentTitle("Omayo Test Report Title");
		
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Operating System", "Windows 10");
		extent.setSystemInfo("Tested By ", "Sathisha");
			
	}

	@Test
	public void metheodOne() {
		
		ExtentTest eTest = extent.createTest("TestOne");
		
		System.out.println("metheodOne executed");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		eTest.info("Chrome Launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://omayo.blogspot.com/");
		eTest.info("Navigated to Omayo Page");

		String actualtext = driver.findElement(By.id("pah")).getText();
		eTest.fail("MethodOne Failed");
		Assert.assertEquals("PracticeAutomationHereA", actualtext);
		

	}
	
	//Close the browser

	@AfterMethod
	public void closure() {   
	driver.close();
	extent.flush();

}
}
