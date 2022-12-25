package TestNGAutomation;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Raw_Tab extends Test_Files {
	@Test
	public void RawTab() throws InterruptedException, IOException {

		System.out.println("=====Application Started=====");
		System.out.println("Page title is : " + driver.getTitle());
		String expectedTitle = "Ticket Timeline";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		Thread.sleep(6000);
		String URL = driver.getCurrentUrl();
		Reporter.log(URL, true);
		Assert.assertEquals(URL, "https://ticket-timeline-cert.cerner.com/-/raw-data");
		mShot.multiScreenShot(driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ticket-number']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ticket-number']/form/input")).sendKeys("CRQ000002947500");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='ticket-search-overlay-icon']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(text(),'Name')]")));
		mShot.multiScreenShot(driver);
		String t = "Name";
		if (driver.getPageSource().contains("Name")) {
			System.out.println("Name text: " + t + " is present. ");
		} else {
			System.out.println("Text: " + t + " is not present. ");
		}
		if (driver.getPageSource().contains("Value")) {
			System.out.println("Value text: " + t + " is present. ");
		} else {
			System.out.println("Text: " + t + " is not present. ");
		}
		Thread.sleep(2000);

	}

	@Test(priority = 1)
	public void WorkDetailsTab() throws IOException, InterruptedException {
		System.out.println("Clicking the Work Details Tab");
		driver.findElement(By.xpath("//a[contains(text(),'Work Details')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(text(),'Type')]")));
		Thread.sleep(2000);
		mShot.multiScreenShot(driver);
		String t = "Name";
		if (driver.getPageSource().contains("Type")) {
			System.out.println("Type text: " + t + " is present. ");
		} else {
			System.out.println("Type text: " + t + " is not present. ");
		}
		if (driver.getPageSource().contains("Summary")) {
			System.out.println("Summary text: " + t + " is present. ");
		} else {
			System.out.println("Summary ext: " + t + " is not present. ");
		}
		if (driver.getPageSource().contains("Description")) {
			System.out.println("Description text: " + t + " is present. ");
		} else {
			System.out.println("Description text: " + t + " is not present. ");
		}
		Thread.sleep(2000);

	}

	@Test(priority = 2)
	public void AuditLogTab() throws IOException, InterruptedException {
		System.out.println("Clicking the Audit Log Tab");
		driver.findElement(By.xpath("//a[contains(text(),'Audit Logs')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Audit Logs')]")));
		Thread.sleep(2000);

		mShot.multiScreenShot(driver);
		String t = "Name";
		if (driver.getPageSource().contains("Ticket Number")) {
			System.out.println("Ticket Number text: " + t + " is present. ");
		} else {
			System.out.println("Ticket Number text: " + t + " is not present. ");
		}
		if (driver.getPageSource().contains("UTN")) {
			System.out.println("UTN text: " + t + " is present. ");
		} else {
			System.out.println("UTN text: " + t + " is not present. ");
		}
		Thread.sleep(2000);

	}

	@Test(priority = 3)
	public void RelatedTicketsTab() throws IOException, InterruptedException {
		System.out.println("Clicking the Related Tickets Tab");
		driver.findElement(By.xpath("//a[contains(text(),'Related Tickets')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(text(),'Open_dt')]")));
		Thread.sleep(2000);
		mShot.multiScreenShot(driver);
		String t = "Name";
		if (driver.getPageSource().contains("Ticket Number")) {
			System.out.println("Ticket Number text: " + t + " is present. ");
		} else {
			System.out.println("Ticket Number text: " + t + " is not present. ");
		}
		if (driver.getPageSource().contains("Status")) {
			System.out.println("Status text: " + t + " is present. ");
		} else {
			System.out.println("Status text: " + t + " is not present. ");
		}
	}
}