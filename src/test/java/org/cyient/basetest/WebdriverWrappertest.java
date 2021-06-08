package org.cyient.basetest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebdriverWrappertest {

	protected WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {

		String browser = "ch";
		if (browser.equalsIgnoreCase("ch")) {
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driverl", "src\\test\\resources\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			// System.setProperty("webdriver.gecko.driverl",
			// "src\\test\\resources\\driver\\geckodriver.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://demo.openemr.io/b/openemr");
		Thread.sleep(1000);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
