package org.cyinet.pagetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DashBoardPage {

	private By mouse = By.xpath("//div[text()='Patient/Client']");
	private By details = By.xpath("//div[text()='Patients']");

	protected WebDriver driver;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getDashBoardPageTitle() {
		return driver.getTitle().trim();
	}

	public void mousehoverPatientClient() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(mouse)).perform();
		;
	}

	public void patientDetails() {
		driver.findElement(details).click();
	}

}
