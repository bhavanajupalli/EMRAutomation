package org.cyinet.pagetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

	private By usernameLocator = By.id("authUser");
	private By passwordLocator = By.id("clearPass");
	private By lanagugeLocator = By.name("languageChoice");
	private By loginLocator = By.xpath("//button[@type='submit']");
	private By errorMsg = By.xpath("//div[@class='alert alert-danger login-failure m-1']");

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void sendUsername(String username) {
		driver.findElement(usernameLocator).sendKeys(username);
	}

	public void sendPassword(String password) {
		driver.findElement(passwordLocator).sendKeys(password);
	}

	public void selectLanguage(String languageTest) {
		Select selectLanguage= new Select(driver.findElement(lanagugeLocator));
		selectLanguage.selectByVisibleText(languageTest);
	}

	public void selectLogin() {
		driver.findElement(loginLocator).click();
	}

	public String getErrorText() {
		String msg = driver.findElement(errorMsg).getText().trim();
		return msg;
	}
}
