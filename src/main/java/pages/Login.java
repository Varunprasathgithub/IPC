package pages;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login {
	WebDriver driver;

	@FindBy(xpath = "//input[@id='email']")
	public static WebElement emailField;

	@FindBy(xpath = "//input[@id='password']")
	public static WebElement passwordField;

	@FindBy(xpath = "//*[@type='submit' and @class='btn btn-login col-4']")
	public static WebElement loginButton;

	@FindBy(css = "div#__next")
	public static WebElement dashboard;

	@FindBy(xpath = "//*[@class='button1 col-2 email-subnav width10']")
	public static WebElement closePopup;

	@FindBy(xpath = "//div[contains(text(),'Incorrect login details. Please check and try again.')]")
	public static WebElement warningMessage;

	@FindBy(xpath = "//div[contains(text(),'This field is required.')]")
	public static WebElement emailWarningMessage;

	public Login(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * This will verify the title of the given page
	 *
	 * @param expectedTitle accepts a expected title in string
	 */
	public void verifyTitleOfThePage(WebDriver driver, String expectedTitle) throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), expectedTitle);
	}
	/**
	 * This will enter the value in username field
	 *
	 * @param email accepts the any string value which needs to be pass into username field
	 */
	public void enterEmail(String email) throws InterruptedException {
		Thread.sleep(2000);
		System.out.println(emailField.isDisplayed());
		emailField.sendKeys(email);
	}
	/**
	 * This will enter the value in password field
	 *
	 * @param password accepts the any string value which needs to be pass into password field
	 */
	public void enterPassword(String password) throws InterruptedException {
		Thread.sleep(2000);
		System.out.println(passwordField.isDisplayed());
		passwordField.sendKeys(password);
	}
	/**
	 * This will click on the login button
	 */
	public void clickOnLoginButton() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println(loginButton.isDisplayed());
		loginButton.click();
	}
	/**
	 * This will verify the dashboard is displayed or not
	 */
	public void verifyIPCCaseOverviewIsDisplayed(WebDriver driver, String expectedTitle) throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), expectedTitle);
	}

	/*public void CloseTheRoadMapPopup() throws InterruptedException {
		Thread.sleep(8000);
		closePopup.click();
	}*/

	public void verifyWarningMeassage(WebDriver driver, String expectedTitle) throws InterruptedException {
		Thread.sleep(3000);
		System.out.println(warningMessage.getText());
		Assert.assertEquals(expectedTitle, warningMessage.getText());
	}

	public void verifyEmailWarningMessage(WebDriver driver, String expectedTitle) throws InterruptedException {
		Thread.sleep(3000);
		System.out.println(emailWarningMessage.getText());
		Assert.assertEquals(expectedTitle, emailWarningMessage.getText());
	}

}