package org.cyinet.pagetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddNewPatientPage {

	private By frame = By.xpath("//iframe[@name='pat']");
	private By honorific = By.id("form_title");
	private By fisrtname = By.id("form_fname");
	private By lastname = By.id("form_lname");
	private By dob = By.id("form_DOB");
	private By prefix = By.id("form_sex");
	private By create = By.id("create");
	private By backf = By.xpath("//iframe[@id='modalframe']");
	private By confirm = By.xpath("//input[@value='Confirm Create New Patient']");
	private By alert = By.xpath("//div[@class='closeDlgIframe']");

	protected WebDriver driver;

	public AddNewPatientPage(WebDriver driver) {
		this.driver = driver;
	}

	public void switchToFrame() throws InterruptedException {
		Thread.sleep(1000);
		driver.switchTo().frame(driver.findElement(frame));
	}

	public void chooseHonorific(String name) {
		Select assign = new Select(driver.findElement(honorific));
		assign.selectByVisibleText(name);
	}

	public void enterFirstName(String name) {
		driver.findElement(fisrtname).sendKeys(name);
	}

	public void lastName(String name) {
		driver.findElement(lastname).sendKeys(name);
	}

	public void chooseDOB(String date) {
		driver.findElement(dob).sendKeys(date);
	}

	public void chooseGender(String gen) {
		Select gender = new Select(driver.findElement(prefix));
		gender.selectByVisibleText(gen);
	}

	public void create() {
		driver.findElement(create).click();
	}

	public void switchBackFrame() {
		driver.switchTo().defaultContent();
	}

	public void swicthConfirmFrame() throws InterruptedException {
		Thread.sleep(1000);
		driver.switchTo().frame(driver.findElement(backf));
	}

	public void confirmNewPatient() {
		driver.findElement(confirm).click();
		driver.switchTo().defaultContent();
	}

//	public String printAlertText() throws InterruptedException {
//		Thread.sleep(1000);
//		String actualAlertText = driver.switchTo().alert().getText();
//		return actualAlertText;
//	}
//
//	public void handleAlert() throws InterruptedException {
//		Thread.sleep(1000);
//		driver.switchTo().alert().accept();
//		driver.findElement(alert).click();
//	}

}
