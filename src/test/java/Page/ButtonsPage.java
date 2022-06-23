package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ButtonsPage {

    WebDriver driver;
    WebDriverWait wdwait;
    WebElement doubleClickMeButton;
    WebElement doubleClickMeMessage;
    WebElement rightClickMeButton;
    WebElement rightClickMeMessage;
    WebElement clickMeButton;
    WebElement clickMeMessage;
    Actions act;
    public ButtonsPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        this.act = new Actions(driver);
    }

    public WebElement getDoubleClickMeButton() {
        return driver.findElement(By.id("doubleClickBtn"));
    }

    public WebElement getDoubleClickMeMessage() {
        return driver.findElement(By.id("doubleClickMessage"));
    }

    public WebElement getRightClickMeButton() {
        return driver.findElement(By.id("rightClickBtn"));
    }

    public WebElement getRightClickMeMessage() {
        return driver.findElement(By.id("rightClickMessage"));
    }

    public List<WebElement> getClickMeButton() {
        return driver.findElements(By.cssSelector(".btn.btn-primary"));
    }

    public WebElement getClickMeMessage() {
        return driver.findElement(By.id("dynamicClickMessage"));
    }

    //-----------------------------------------------------

    public void clickOnDoubleClickMeButton(){
        act.doubleClick(getDoubleClickMeButton()).perform();
    }

    public  void clickOnRightClickMeButton(){
        act.contextClick(getRightClickMeButton()).perform();
    }
    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void clickOnclickMeButton(){
        for (int i = 0; i<getClickMeButton().size(); i++){
            scrollIntoView(getClickMeButton().get(i));
            if (getClickMeButton().get(i).getText().equals("Click Me")){
                getClickMeButton().get(i).click();
                break;
            }
        }
    }
}
