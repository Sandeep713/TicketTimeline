package TestNGAutomation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Client_Follows_UP extends Test_Files {
	@Test
	public void Client_Follows_Up() throws InterruptedException, IOException {
		System.out.println("=====Application Started=====");
		System.out.println("Page title is : " + driver.getTitle());
		String expectedTitle = "Ticket Timeline";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		Thread.sleep(6000);
		System.out.println("Going to click on client follows up tab");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hd-follow-up-tab")));
		driver.findElement(By.id("hd-follow-up-tab")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hd-follow-up-manager-button")));
		String URL = driver.getCurrentUrl();
		Reporter.log(URL, true);
		Assert.assertEquals(URL, "https://ticket-timeline-cert.cerner.com/-/hd-follow-up");
		mShot.multiScreenShot(driver);
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void SearchingReportedSource() throws IOException, InterruptedException {
		System.out.println("Going to click the Ticket from the manager");
		driver.findElement(By.xpath("//*[@id=\"hd-follow-up-tickets-table\"]/tbody/tr[1]/td[1]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Ticket Submitter:')]")));
		System.out.println("Searching for the word Reported Source:");
		String t = "Reported Source:";
		if (driver.getPageSource().contains("Reported Source:")) {
			System.out.println("Text: " + t + " is present. ");
		} else {
			System.out.println("Text: " + t + " is not present. ");
		}
		Thread.sleep(5000);
		mShot.multiScreenShot(driver);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//select[@id='question-1-false']")).click();
		Thread.sleep(2000);
		mShot.multiScreenShot(driver);
		List<WebElement> myList = driver.findElements(By.xpath("//select[@id='question-1-false']"));
		List<String> all_elements_text = new ArrayList<String>();

		for (int i = 0; i < myList.size(); i++) {

			all_elements_text.add(myList.get(i).getText());
			System.out.println(myList.get(i).getText());
		}
		System.out.println(all_elements_text);

	}

	@Test(priority = 2)
	public void TicketFollowUpOptionManagerTab() throws IOException, InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[contains(text(),'Assign back to SSO to complete Follow-Up')]")).click();
		String t = "Additional Comments:";
		if (driver.getPageSource().contains("Additional Comments:")) {
			System.out.println(t + " is present.");
		} else {
			System.out.println(t + " is not present.");
		}
		mShot.multiScreenShot(driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@id='question-1-false']")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Manager to complete Follow-Up')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='question-2-false']")).sendKeys("SL078309");
		Thread.sleep(3000);
		mShot.multiScreenShot(driver);
		driver.findElement(By.xpath("//select[@id='question-1-false']")).click();
		driver.findElement(By.xpath("//option[contains(text(),\"Assign to another Support Associate's Manager?\")]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='question-9-false']")).sendKeys("SL078309");
		mShot.multiScreenShot(driver);
	}

	@Test(priority = 3)
	public void TicketFollowUpOptionSSOTab() throws IOException, InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='hd-follow-up-sso-button']")).click();
		driver.findElement(By.xpath("//*[@id=\"hd-follow-up-tickets-table\"]/tbody/tr[4]/td[1]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Ticket Submitter:')]")));
		Thread.sleep(5000);
		mShot.multiScreenShot(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//select[@id='question-1-false']")).click();
		Thread.sleep(2000);
		mShot.multiScreenShot(driver); // By default Assign toanother Support Associate's Manager? is selected
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@id='question-1-false']")).click();
		driver.findElement(By.xpath("//option[contains(text(),'SSO Complete Follow-Up')]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		mShot.multiScreenShot(driver);
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void RefreshingTheTab() throws IOException, InterruptedException {
		driver.findElement(By.xpath("//a[@id='refresh-hd-follow-up-tickets']")).click();
		Thread.sleep(3000);
		mShot.multiScreenShot(driver);
		driver.findElement(By.xpath("//button[@id='hd-follow-up-manager-button']")).click();
		mShot.multiScreenShot(driver);
		Thread.sleep(2000);
	}

	@Test(priority = 5)
	public void VerifyingOthersOptionInDropdown() throws IOException, InterruptedException {
		driver.findElement(By.xpath("//button[@id='hd-follow-up-sso-button']")).click();
		driver.findElement(By.xpath("//*[@id=\"hd-follow-up-tickets-table\"]/tbody/tr[4]/td[1]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Ticket Submitter:')]")));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//select[@id='question-1-false']")).click();
		driver.findElement(By.xpath("//option[contains(text(),'SSO Complete Follow-Up')]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@id='question-7-false']")).click();
		mShot.multiScreenShot(driver);
		Thread.sleep(1000);
	}

	@Test(priority = 6)
	public void VerifyingManagerField() throws IOException, InterruptedException {
		//*[@id="ticket-number"]
		driver.findElement(By.xpath("//*[@id=\"ticket-number\"]")).click();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[@id=\"ticket-number\"]/form/input"))).doubleClick().build()
				.perform();
		driver.findElement(By.xpath("//*[@id=\"ticket-number\"]/form/input")).sendKeys(Keys.CONTROL, "c");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@id='question-1-false']")).click();
		driver.findElement(By.xpath("//option[contains(text(),\"Assign to another Support Associate's Manager?\")]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='question-4-false']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='question-4-false']")).sendKeys("ST091528");
		mShot.multiScreenShot(driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='question-4-false']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"hd-follow-up-comment\"]")).sendKeys("Test");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"hd-follow-up-questions-form\"]/div[6]/button")).click();
		mShot.multiScreenShot(driver); // *[@id="ticket-number"] /*
		Thread.sleep(2000);
		//*[@id="hd-follow-up-questions-form"]/div[6]/button
		driver.findElement(By.xpath("//*[@id=\"hd-follow-up-tickets-table_filter\"]/label/input")).click();
		// *[@id="hd-follow-up-tickets-table_filter"]/label/input Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='refresh-hd-follow-up-tickets']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"hd-follow-up-tickets-table_filter\"]/label/input")).click();
		driver.findElement(By.xpath("//*[@id=\"hd-follow-up-tickets-table_filter\"]/label/input"))
				.sendKeys(Keys.CONTROL, "v");
		mShot.multiScreenShot(driver);

	}
	
	
}
