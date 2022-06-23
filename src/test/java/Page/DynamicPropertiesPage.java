package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicPropertiesPage {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement text;
    WebElement enableAfterButton;
    WebElement colorChangeButton;
    WebElement visibleAfterButton;
    public DynamicPropertiesPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getEnableAfterButton() {
        return driver.findElement(By.id("enableAfter"));
    }

    public WebElement getColorChangeButton() {
        return driver.findElement(By.id("colorChange"));
    }

    public WebElement getVisibleAfterButton() {
        return driver.findElement(By.id("visibleAfter"));
    }

    //-------------------------------------------------

    public void clickOnEnableAfterButton(){
        getEnableAfterButton().click();
    }

    public boolean isClickable(WebElement we)
    {
        try
        {
            wdwait.until(ExpectedConditions.elementToBeClickable(we));
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

}
