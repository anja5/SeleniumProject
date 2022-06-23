package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SidebarPage {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement sidebarElements;
    public SidebarPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public List<WebElement> getSidebarElements(){
        return driver.findElements(By.className("text"));
    }


    //-----------------------------------------------------


    public void clickOnTextBox(){
        for (int i = 0; i<getSidebarElements().size(); i++){
            scrollIntoView(getSidebarElements().get(i));
            if (getSidebarElements().get(i).getText().equals("Text Box")){
                getSidebarElements().get(i).click();
                break;
            }
        }
    }

    public void clickOnRadioButton(){
        for (int i = 0; i<getSidebarElements().size(); i++){
            scrollIntoView(getSidebarElements().get(i));
            if (getSidebarElements().get(i).getText().equals("Radio Button")){
                getSidebarElements().get(i).click();
                break;
            }
        }
    }

    public void clickOnButtons(){
        for (int i = 0; i<getSidebarElements().size(); i++){
            scrollIntoView(getSidebarElements().get(i));
            if (getSidebarElements().get(i).getText().equals("Buttons")){
                getSidebarElements().get(i).click();
                break;
            }
        }
    }

    public void clickOnUploadAndDownload() {
        for (int i = 0; i<getSidebarElements().size(); i++){
            scrollIntoView(getSidebarElements().get(i));
            if (getSidebarElements().get(i).getText().equals("Upload and Download")){
                getSidebarElements().get(i).click();
                break;
            }
        }
    }

    public void clickOnLinks() {
        for (int i = 0; i<getSidebarElements().size(); i++){
            scrollIntoView(getSidebarElements().get(i));
            if (getSidebarElements().get(i).getText().equals("Links")){
                getSidebarElements().get(i).click();
                break;
            }
        }
    }

    public void clickOnBrokenLinks() {
        for (int i = 0; i<getSidebarElements().size(); i++){
            scrollIntoView(getSidebarElements().get(i));
            if (getSidebarElements().get(i).getText().equals("Broken Links - Images")){
                getSidebarElements().get(i).click();
                break;
            }
        }
    }
    public void clickOnDynamicProperties() {
        for (int i = 0; i<getSidebarElements().size(); i++){
            scrollIntoView(getSidebarElements().get(i));
            if (getSidebarElements().get(i).getText().equals("Dynamic Properties")){
                getSidebarElements().get(i).click();
                break;
            }
        }
    }
}
