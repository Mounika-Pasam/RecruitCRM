
package com.crm.qa.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CandidatesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CandidatesPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	CandidatesPage candidatesPage;

	String sheetName = "contacts";

	public CandidatesPageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		testUtil = new TestUtil();
		candidatesPage = new CandidatesPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		candidatesPage = homePage.clickOnContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(candidatesPage.verifyContactsLabel(), "Contacts");
	}

	@Test(priority = 2, testName = "Signle contact selection")
	public void selectSingleContactsTest() {
		candidatesPage.selectContactsByName("test2 test2");
	}

	@Test(priority = 3, testName = "Multiple contacts selected")
	public void selectMultipleContactsTest() {
		candidatesPage.selectContactsByName("test2 test2");
		candidatesPage.selectContactsByName("ui uiii");

	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 4, dataProvider = "getCRMTestData", testName = "Adding Contacts and dropdown functionality verification")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company) {
		// homePage.clickOnNewContactLink();
		candidatesPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		candidatesPage.createNewContact(title, firstName, lastName, company);

	}

	@Test(priority = 5, testName = "resume Upload")

	public void resumeupload() throws IOException, InterruptedException {
		driver.findElement(By.cssSelector("class*='btn__choose'")).click();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\user\\Downloads\\check\\fileupload.exe");
	}

	@Test(priority = 6, testName = "resume Download")
	public void resumedownload() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='medum']")));
		driver.findElement(By.cssSelector("button[class='medum']"));
		File f = new File("C:\\Usersf\\user\\Downloads\\convert.zip");
		Assert.assertTrue(f.exists());

	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}

}
