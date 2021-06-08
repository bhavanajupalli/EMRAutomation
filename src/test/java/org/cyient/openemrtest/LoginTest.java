package org.cyient.openemrtest;

import org.cyient.basetest.WebdriverWrappertest;
import org.cyient.utilities.DataProviderUtilies;
import org.cyinet.pagetest.DashBoardPage;
import org.cyinet.pagetest.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends WebdriverWrappertest {
	
	
	@Test(dataProvider="validCredentialData", dataProviderClass= DataProviderUtilies.class)
	public void validCredentialTest(String username,String password,String lang,String espectedValue) throws InterruptedException {
		LoginPage page = new LoginPage(driver);
		page.sendUsername(username);
		page.sendPassword(password);
		page.selectLanguage(lang);
		page.selectLogin();
		DashBoardPage dashboard = new DashBoardPage(driver);
		System.out.println(dashboard.getDashBoardPageTitle());

		Assert.assertEquals(dashboard.getDashBoardPageTitle(), espectedValue);

	}


	@Test(dataProvider = "invalidCredentialData",dataProviderClass=DataProviderUtilies.class)
	public void invalidCredintialTest(String username,String password,String lang,String espectedValue) {

		LoginPage page = new LoginPage(driver);
		page.sendUsername(username);
		page.sendPassword(password);
		page.selectLanguage(lang);
		page.selectLogin();

		Assert.assertEquals(page.getErrorText(), espectedValue);

	}

}
