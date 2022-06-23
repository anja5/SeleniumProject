package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBoxPage {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement fullName;
    WebElement email;
    WebElement currentAddress;
    WebElement permanentAddress;
    WebElement submitButton;
    WebElement text;
    Actions action;


    public TextBoxPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        this.action = new Actions(driver);
    }

    public WebElement getText() {
        return driver.findElement(By.cssSelector(".border.col-md-12.col-sm-12"));
    }

    public WebElement getFullName() {
        return driver.findElement(By.id("userName"));
    }

    public WebElement getEmail() {
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement getCurrentAddress() {
        return driver.findElement(By.id("currentAddress"));
    }

    public WebElement getPermanentAddress() {
        return driver.findElement(By.id("permanentAddress"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    //--------------------------------------------------------
    public void insertFullName(String fullnameInput) {
        this.getFullName().clear();
        this.getFullName().sendKeys(fullnameInput);
    }

    public void insertEmail(String emailInput) {
        this.getEmail().clear();
        this.getEmail().sendKeys(emailInput);
    }

    public void insertCurrentAddress(String currentAddressInput) {
        this.getCurrentAddress().clear();
        this.getCurrentAddress().sendKeys(currentAddressInput);
    }

    public void insertPermanentAddress(String permanentAddress) {
        this.getPermanentAddress().clear();
        this.getPermanentAddress().sendKeys(permanentAddress);
    }

    public void clickOnSubmitButton() {
        this.getSubmitButton().click();
    }

}
