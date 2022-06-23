package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RadioButtonPage {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement selectedText;
    WebElement button;
    WebElement selectedYesRadioBtn;
    WebElement selectedImpressiveRadioBtn;
    WebElement selectedNoRadioBtn;
    public RadioButtonPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public List<WebElement> getButton(){
        return driver.findElements(By.className("custom-control-label"));
    }


    public WebElement getSelectedText() {
        return driver.findElement(By.className("text-success"));
    }

    public WebElement getSelectedYesRadioBtn() {
        return driver.findElement(By.id("yesRadio"));
    }

    public WebElement getSelectedImpressiveRadioBtn() {
        return driver.findElement(By.id("impressiveRadio"));
    }

    public WebElement getSelectedNoRadioBtn() {
        return driver.findElement(By.id("noRadio"));
    }

    //---------------------------------------------------

    public void clickOnYesButton(){
        for (int i = 0; i<getButton().size(); i++){
            if (getButton().get(i).getAttribute("for").equals("yesRadio")){
                getButton().get(i).click();
                break;
            }
        }
    }
    public void clickOnImpressiveButton(){
        for (int i = 0; i<getButton().size(); i++){
            if (getButton().get(i).getAttribute("for").equals("impressiveRadio")){
                getButton().get(i).click();
                break;
            }
        }
    }

    public void clickOnNoButton(){
        for (int i = 0; i<getButton().size(); i++){
            if (getButton().get(i).getAttribute("for").equals("noRadio")){
                getButton().get(i).click();
                break;
            }
        }
    }

}
