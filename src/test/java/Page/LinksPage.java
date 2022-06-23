package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinksPage {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement homeLink1;
    WebElement homeLink2;
    WebElement created;
    WebElement noContent;
    WebElement moved;
    WebElement badRequest;
    WebElement unauthorized;
    WebElement forbidden;
    WebElement notFound;
    WebElement notification;
    public LinksPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getHomeLink1() {
        return driver.findElement(By.id("simpleLink"));
    }

    public WebElement getHomeLink2() {
        return driver.findElement(By.id("dynamicLink"));
    }

    public WebElement getCreated() {
        return driver.findElement(By.id("created"));
    }

    public WebElement getNoContent() {
        return driver.findElement(By.id("no-content"));
    }

    public WebElement getMoved() {
        return driver.findElement(By.id("moved"));
    }

    public WebElement getBadRequest() {
        return driver.findElement(By.id("bad-request"));
    }

    public WebElement getUnauthorized() {
        return driver.findElement(By.id("unauthorized"));
    }

    public WebElement getForbidden() {
        return driver.findElement(By.id("forbidden"));
    }

    public WebElement getNotFound() {
        return driver.findElement(By.id("invalid-url"));
    }

    public WebElement getNotification() {
        return driver.findElement(By.id("linkResponse"));
    }

    //------------------------------

    public void clickOnHomeLink1(){
        getHomeLink1().click();
    }

    public void clickOnHomeLink2(){
        getHomeLink2().click();
    }

    public void clickOnCreated(){
        getCreated().click();
    }
    public void clickOnMoved(){
        getMoved().click();
    }

    public void clickOnBadRequest(){
        getBadRequest().click();
    }

    public void clickOnUnauthorized(){
        getUnauthorized().click();
    }

    public void clickOnForbidden(){
        getForbidden().click();
    }

    public void clickOnNotFound(){
        getNotFound().click();
    }
    public void clickOnNoContent(){
        getNoContent().click();
    }

}
