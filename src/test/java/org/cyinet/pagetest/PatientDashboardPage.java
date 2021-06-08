package org.cyinet.pagetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientDashboardPage {

	private By frame = By.xpath("//iframe[@name='pat']");
	private By dashboard = By.xpath("//h2[contains(text(),'Medical Record')]");
	protected WebDriver driver;

	public PatientDashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public void swicthToFrame() throws InterruptedException {
		Thread.sleep(1000);
		driver.switchTo().frame(driver.findElement(frame));
	}

	public String patientDashboard() {
		String actualValue = driver.findElement(dashboard).getText().trim();
		return actualValue;
	}

}
