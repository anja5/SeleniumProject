package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrokenLinksImagesPage {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement validImage;
    WebElement validLink;
    WebElement brokenLink;
    public BrokenLinksImagesPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getValidImage() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/img[1]"));
    }
    public WebElement getValidLink() {
        return driver.findElement(By.linkText("Click Here for Valid Link"));
    }
    public WebElement getBrokenLink() {
        return driver.findElement(By.linkText("Click Here for Broken Link"));
    }

    //-------------------------------------------------------

    public void clickOnValidLink() {
        getValidLink().click();
    }

    public void clickOnBrokenLink() {
        getBrokenLink().click();
    }
}
