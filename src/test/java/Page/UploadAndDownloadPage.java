package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class UploadAndDownloadPage {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement uploadButton;
    WebElement uploadFilePathMessage;
    WebElement downloadButton;
    public UploadAndDownloadPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getUploadButton() {
        return driver.findElement(By.id("uploadFile"));
    }

    public WebElement getUploadFilePathMessage() {
        return driver.findElement(By.id("uploadedFilePath"));
    }

    public WebElement getDownloadButton() {
        return driver.findElement(By.id("downloadButton"));
    }

    //------------------------------------------------

    public void clickOnUploadButton(){
        getUploadButton().sendKeys("C:\\Users\\Anja\\Desktop\\meme1.PNG");
    }
    public void clickOnDownloadButton(){
       getDownloadButton().click();
    }

}
