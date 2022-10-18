package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import groovyjarjarantlr4.v4.parse.BlockSetTransformer.setAlt_return;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BasePage;
import pages.Login;

public class StepDef extends BasePage {

	Login loginPage = new Login(driver);


	@Given("^I launch the URL$")
	public void iLaunchTheUrl() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/ingramesq/admin/login");
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.id("email"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		//Thread.sleep(500);
	}

	@And("I am on the login page")
	public void iAmOnTheLoginPage() throws InterruptedException {
		Login loginPage = new Login(driver);
		loginPage.verifyTitleOfThePage(driver,"IPC Login");
	}

	@When("^I enter \"([^\"]*)\" in the email field$")
	public void iEnterValidUsername(String email) throws InterruptedException {
		loginPage.enterEmail(email);
	}

	@And("^I enter \"([^\"]*)\" in the password field$")
	public void iEnterValidPassword(String password) throws InterruptedException {
		loginPage.enterPassword(password);
	}

	@And("I click on submit button")
	public void iClickOnSubmitButton() throws InterruptedException {
		loginPage.clickOnLoginButton();
	}

	@Then("I should be logged in successfully")
	public void iShouldBeLoggedInSuccessfully() throws InterruptedException {
		loginPage.verifyIPCCaseOverviewIsDisplayed(driver, "IPC Case Overview");
	}

	/*@And("I close the road map popup")
	public void iCloseTheRoadMapPopup() throws InterruptedException {
		loginPage.CloseTheRoadMapPopup();

	}*/

	@And("I close the browser session")
	public void iCloseTheBrowserSession() {
		driver.quit();
	}

	@Then("I should \\(not) be logged in successfully")
	public void iShouldNotBeLoggedInSuccessfully() throws InterruptedException {
		Login loginPage = new Login(driver);
		loginPage.verifyTitleOfThePage(driver,"IPC Login");

		WebElement element = driver.findElement(By.id("email"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	@And("I verify the warning message")
	public void iVerifyTheWarningMessage() throws InterruptedException {
		loginPage.verifyWarningMeassage(driver,"Incorrect login details. Please check and try again.");
	}

	@Then("I should see warning message under email feild")
	public void iShouldSeeWarningMessageUnderEmailFeild() throws InterruptedException {
        loginPage.verifyEmailWarningMessage(driver, "This field is required.");
	}
}