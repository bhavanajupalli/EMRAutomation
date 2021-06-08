package org.cyient.test;

import org.cyient.basetest.WebdriverWrappertest;
import org.cyinet.pagetest.AddNewPatientPage;
import org.cyinet.pagetest.DashBoardPage;
import org.cyinet.pagetest.LoginPage;
import org.cyinet.pagetest.PatientDashboardPage;
import org.cyinet.pagetest.PatientFinderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatientTest extends WebdriverWrappertest {

	@Test(priority = 2)

	public void addPatientTest() throws InterruptedException {
		LoginPage page = new LoginPage(driver);
		page.sendUsername("admin");
		page.sendPassword("pass");
		page.selectLanguage("English (Indian)");
		page.selectLogin();

		DashBoardPage dashboard = new DashBoardPage(driver);
		dashboard.mousehoverPatientClient();
		dashboard.patientDetails();

		PatientFinderPage finder = new PatientFinderPage(driver);
		finder.switchTofinFrame();
		finder.addNewPatient();

		AddNewPatientPage add = new AddNewPatientPage(driver);
		add.switchToFrame();
		add.chooseHonorific("Ms.");
		add.enterFirstName("Lpppp");
		add.lastName("Aaaaa");
		add.chooseDOB("2021-06-04");
		add.chooseGender("Female");
		add.create();
		add.switchBackFrame();
		add.swicthConfirmFrame();
		add.confirmNewPatient();
		Thread.sleep(1000);
//		String alertTxt = add.printAlertText();
//		Thread.sleep(1000);
//		add.handleAlert();

		PatientDashboardPage dash = new PatientDashboardPage(driver);
		dash.swicthToFrame();
		String details = dash.patientDashboard();
		System.out.println(details);

		//Assert.assertTrue(alertTxt.contains("New Due Clinical Remainders"));
		Assert.assertEquals(details, "Medical Record Dashboard - Lpppp Aaaaa");

	}

}
