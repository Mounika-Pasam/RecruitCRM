package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//h2[contains(text(),'Getting Started')]")
	WebElement homepageText;

	@FindBy(xpath = "//*[@id=\"sidebar\"]/nav/ul[1]/li[2]/a")
	WebElement contactsLink;

	/*
	 * @FindBy(xpath = "//div[contains(@class,'media')]") WebElement ImportContacts;
	 * 
	 * @FindBy(xpath = "//a[contains(text(),'button')]") WebElement ContactsUpload;
	 * 
	 * @FindBy(xpath = "//a[contains(text(),'Deals')]") WebElement dealsLink;
	 * 
	 * @FindBy(xpath = "//a[contains(text(),'Tasks')]") WebElement tasksLink;
	 */
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyHomePageText() {
		return homepageText.isDisplayed();
	}

	/*
	 * public void clickOnImportContacts(){ ImportContacts.click();
	 * 
	 * } public void clickOnUpload() { ContactsUpload.click(); }
	 */

	public CandidatesPage clickOnContactsLink() {
		contactsLink.click();
		return new CandidatesPage();
	}
}
/*
 * public DealsPage clickOnDealsLink(){ dealsLink.click(); return new
 * DealsPage(); }
 * 
 * public TasksPage clickOnTasksLink(){ tasksLink.click(); return new
 * TasksPage(); }
 * 
 * public void clickOnNewContactLink(){ Actions action = new Actions(driver);
 * action.moveToElement(contactsLink).build().perform(); newContactLink.click();
 * 
 * }
 */
