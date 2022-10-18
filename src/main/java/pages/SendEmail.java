package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Set;

public class SendEmail {
    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Staff Emails')]")
    public static WebElement staffEmailsButton;

    @FindBy(xpath = "//div//button[contains(text(),'Close') and @ng-click='closeAmyMailAlert();']")
    public static WebElement closeAmyMailAlert;

    @FindBy(xpath = "//a[contains(text(),'Compose') and @ng-class]")
    public static WebElement composeButton;

    @FindBy(xpath = "//a[contains(text(),'Single Email')]")
    public static WebElement singleEmailButton;

    @FindBy(xpath = "//div[@id='toaddress']")
    public static WebElement toAddress;

    @FindBy(xpath = "//div//li//a[contains(text(),'Send') and @class='nav-link' and @ng-click='triggersendMail(composeMail.$valid);']")
    public static WebElement sendButton;

    @FindBy(xpath = "//button[contains(text(),'Send') and @ng-click='clickedSend = true;']")
    public static WebElement popupSendButton;



    public SendEmail(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void Login(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ClickOnStaffEmailsButton() throws InterruptedException {
        Thread.sleep(10000);
        staffEmailsButton.click();
    }

   /* public void CloseAmyMailAlert() throws InterruptedException {
        Thread.sleep(8000);
        closeAmyMailAlert.click();
    }*/

    public void ClickOnComposeButton() throws InterruptedException {
        Thread.sleep(8000);
        composeButton.click();
    }

    public void ClickOnSingleEmailButton() throws InterruptedException {
        Thread.sleep(8000);
        singleEmailButton.click();
    }

   public void EnterToAddress(String emailid) throws InterruptedException {
      /* String parent=driver.getWindowHandle();
       Set<String> allWindows=driver.getWindowHandles();

       int count=allWindows.size();
       System.out.println("Total window" +count);
       for(String child:allWindows)
       {
           if(!parent.equalsIgnoreCase(child))
               driver.switchTo().window(child);
           System.out.println("Clild window title is " +driver.getTitle());
               Thread.sleep(20000);
               toAddress.click();
               toAddress.sendKeys(emailid, Keys.ENTER);
       } */
       String parentHandle = driver.getWindowHandle();// get the current window handle
       System.out.println(parentHandle);
       for (String winHandle : driver.getWindowHandles()) {
           System.out.println(winHandle);
           driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
           driver.findElement(By.xpath("//div[@id='toaddress']")).sendKeys(emailid, Keys.ENTER); // click some link that opens a new window
       }
    }

    public void ClickOnSendButton() throws InterruptedException {
        Thread.sleep(8000);
        sendButton.click();
    }

    public void ClickOnPopupSendButton() throws InterruptedException {
        Thread.sleep(3000);
        popupSendButton.click();
    }

}
