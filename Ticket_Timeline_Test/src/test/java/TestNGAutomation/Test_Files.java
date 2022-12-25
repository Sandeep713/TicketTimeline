package TestNGAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

import multiScreenShot.MultiScreenShot;

public class Test_Files {
	public String baseUrl = "https://ticket-timeline-cert.cerner.com/-/raw-data";
	String driverPath = "C:\\ChromeDriver\\d\\chromedriver.exe";
	//MultiScreenShot mShot = new MultiScreenShot("C:\\ChromeDriver\\d\\TestMultiScreenShot_Screenshots\\","ClientFollowsup");
	MultiScreenShot mShot = new MultiScreenShot("C:\\ChromeDriver\\","AuditTab_scrshot");
	//MultiScreenShot mShot = new MultiScreenShot("C:\\ChromeDriver\\","ClientFollowsup_scrshot");
	public WebDriver driver;

	@BeforeTest
	public void basicSetup() throws InterruptedException {
		Reporter.log("=====Browser Started=====", true);
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		Thread.sleep(3000);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(12000);
		driver.findElement(By.xpath("//button[text()='Send Me a Push ']")).click();
		Thread.sleep(10000); 
	}

	/*
	 * @AfterTest public void closeApplication() {
	 * Reporter.log("=====Browser Closed=====", true); driver.quit();
	 * 
	 * }
	 */

}