package TestNGAutomation;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Audit_Tab extends Test_Files {
	@Test
	public void AuditTab() throws InterruptedException, IOException {
		System.out.println("=====Application Started=====");
		System.out.println("Page title is : " + driver.getTitle());
		String expectedTitle = "Ticket Timeline";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		Thread.sleep(6000);
		System.out.println("Going to click Audit tab");
		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='audit-tool-tab']")));
		driver.findElement(By.xpath("//a[@id='audit-tool-tab']")).click();
		Thread.sleep(6000);
		String URL = driver.getCurrentUrl();
		Reporter.log(URL, true);
		Assert.assertEquals(URL, "https://ticket-timeline-cert.cerner.com/-/audits");
		Date currentdate = new Date();
		currentdate.toString().replace(" ", "-").replace(":", "-");
		mShot.multiScreenShot(driver);
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void CreatingtheAuditTicket() throws IOException, InterruptedException {
		System.out.println("Creating the Audit Ticket");
		driver.findElement(By.id("audit-current-ticket-label")).click();
		Thread.sleep(2000);
		mShot.multiScreenShot(driver);
		System.out.println("Clicking load phone without ticket button ");
		driver.findElement(By.id("load-phone-without-ticket-button")).click();
		Set<String> a = driver.getWindowHandles();
		Iterator<String> it = a.iterator();
		String chlwnd = it.next();
		driver.switchTo().window(chlwnd);
		System.out.println("Page title " + driver.getTitle());
		System.out.println("Phone Audit Without Ticket popup window is displayed");
		Thread.sleep(2000);
		mShot.multiScreenShot(driver);
		driver.findElement(By.xpath("//button[@title='Ticket System']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Remedy')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("no-ticket-associate-select")).sendKeys("ST091528");
		Thread.sleep(3000);
		driver.findElement(By.id("no-ticket-associate-select")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.id("audit-without-ticket-submit")).click();
		Thread.sleep(1000);
		System.out.println("New audit ticket is created");
		mShot.multiScreenShot(driver);
		Thread.sleep(2000);
		List<WebElement> AllCheckboxes = driver.findElements(By.xpath("//*[text()='Yes']"));
		int size = AllCheckboxes.size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			Thread.sleep(1000);
			AllCheckboxes.get(i).click();
		}
		mShot.multiScreenShot(driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@id='audit-notes']")).sendKeys("test");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		mShot.multiScreenShot(driver);
		Thread.sleep(3000);

	}

	@Test(priority = 2)
	public void LoadAuditTicket() throws IOException, InterruptedException {
		System.out.println("Entering the min date ");
		driver.findElement(By.id("audit-date-min")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "10/01/2022");
		System.out.println("Entering the max date ");
		driver.findElement(By.id("audit-date-max")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "11/30/2022");
		System.out.println("Entering the Team Lead");
		driver.findElement(By.id("audit-team-lead")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "Abdul Rashad");
		Thread.sleep(2000);
		driver.findElement(By.id("audit-team-lead")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("audit-ticket-submitter-dropdown")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//option[contains(text(),'Associate Opened')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Generate List')]")).click();
		System.out.println("Wait until tickets are displayed ");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//textarea[@id='audit-notes']")));
		Thread.sleep(6000);
		mShot.multiScreenShot(driver);
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		mShot.multiScreenShot(driver);
		Thread.sleep(2000);
		List<WebElement> AllCheckboxes = driver.findElements(By.xpath("//*[text()='Yes']"));
		int size = AllCheckboxes.size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			Thread.sleep(1000);
			AllCheckboxes.get(i).click();
		}
			mShot.multiScreenShot(driver);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//textarea[@id='audit-notes']")).sendKeys("test");
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
			mShot.multiScreenShot(driver);
			//Thread.sleep(3000);
		
	}

	/*
	 * @Test(priority = 3) public void LoadingManagerTicket() throws IOException,
	 * InterruptedException { System.out.println("Selecting the ticket"); //
	 * driver.findElement(By.xpath(
	 * "//*[@id=\"audit-ticket-table\"]/tbody/tr[1]/td[1]")).click();
	 * System.out.println("Selected ticket is loaded"); JavascriptExecutor jse =
	 * (JavascriptExecutor) driver; jse.executeScript("window.scrollBy(0,250)");
	 * Thread.sleep(2000); mShot.multiScreenShot(driver); Thread.sleep(1000);
	 * driver.findElement(By.xpath("//label[contains(text(),'na')]")).click();
	 * driver.findElement(By.xpath("//textarea[@id='audit-notes']")).sendKeys("test"
	 * );
	 * driver.findElement(By.xpath("//input[@id='audit-associate-id']")).sendKeys(
	 * Keys.chord(Keys.CONTROL, "a"), "ST091528"); Thread.sleep(2000);
	 * driver.findElement(By.xpath("//input[@id='audit-associate-id']")).sendKeys(
	 * Keys.ENTER); Thread.sleep(2000);
	 * driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
	 * Thread.sleep(1000); mShot.multiScreenShot(driver); Thread.sleep(2000); }
	 * 
	 * @Test(priority = 4) public void ClickingAuditSummaryIcon() throws
	 * IOException, InterruptedException {
	 * System.out.println("Selecting the audit-summary-icon"); //
	 * *[@id="audit-summary-icon"]/i
	 * driver.findElement(By.xpath("//*[@id=\"audit-summary-icon\"]/i")).click();
	 * System.out.println("Audit Summary Icon is displayed with data"); Set<String>
	 * a = driver.getWindowHandles(); Iterator<String> it = a.iterator(); String
	 * chlwnd = it.next(); driver.switchTo().window(chlwnd);
	 * System.out.println("Page title " + driver.getTitle()); Thread.sleep(2000);
	 * mShot.multiScreenShot(driver); driver.close(); //
	 * driver.findElement(By.xpath(
	 * "//*[@id=\"audit-ticket-table\"]/tbody/tr[2]/td[1]")).click(); //
	 * Thread.sleep(1000); //
	 * driver.findElement(By.xpath("//label[contains(text(),'na')]")).click(); //
	 * driver.findElement(By.xpath("//textarea[@id='audit-notes']")).sendKeys("test"
	 * ); //
	 * driver.findElement(By.xpath("//input[@id='audit-associate-id']")).sendKeys(
	 * Keys.chord(Keys.CONTROL, // "a"), "ST091528"); // Thread.sleep(2000); //
	 * driver.findElement(By.xpath("//input[@id='audit-associate-id']")).sendKeys(
	 * Keys.ENTER); //
	 * driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
	 * // Thread.sleep(1000); // mShot.multiScreenShot(driver);
	 * 
	 * }
	 */
}
