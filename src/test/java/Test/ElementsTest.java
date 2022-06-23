package Test;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;

public class ElementsTest extends BaseTest {
    String fullNameInput;
    String emailInput;
    String currentAddressInput;
    String permanentAddressInput;
    String invalidEmailFormat;
    String radioButtonYesMessage;
    String radioButtonImpressiveMessage;
    String doubleClickMeMessage;
    String rightClickMeMessage;
    String clickMeMessage;
    String uploadFilePathText;
    String createdLinkText;
    String noContentLinkText;
    String movedLinkText;
    String badRequestText;
    String forbiddenLinkText;
    String notFoundLinkText;
    String brokenLinkURL;

   @BeforeMethod
    public void pageSetUp(){
       driver.manage().window().maximize();
       driver.navigate().to(homepageURL);
       fullNameInput = excelReader.getStringData("Projekat", 1,1);
       emailInput = excelReader.getStringData("Projekat", 1,2);
       currentAddressInput = excelReader.getStringData("Projekat", 1,3);
       permanentAddressInput = excelReader.getStringData("Projekat", 1,4);
       invalidEmailFormat = excelReader.getStringData("Projekat", 1,5);
       radioButtonYesMessage = excelReader.getStringData("Projekat", 1,6);
       radioButtonImpressiveMessage = excelReader.getStringData("Projekat", 1,7);
       doubleClickMeMessage = excelReader.getStringData("Projekat", 1,8);
       rightClickMeMessage = excelReader.getStringData("Projekat",1,9);
       clickMeMessage = excelReader.getStringData("Projekat",1,10);
       uploadFilePathText = excelReader.getStringData("Projekat",1,11);
       createdLinkText = excelReader.getStringData("Projekat", 1,12);
       noContentLinkText = excelReader.getStringData("Projekat", 1,13);
       movedLinkText = excelReader.getStringData("Projekat", 1,14);
       badRequestText = excelReader.getStringData("Projekat", 1,15);
       forbiddenLinkText = excelReader.getStringData("Projekat", 1,16);
       notFoundLinkText = excelReader.getStringData("Projekat", 1,17);
       brokenLinkURL = excelReader.getStringData("Projekat", 2, 0);
   }

   @Test (priority = 0)
    public void validInputTextBoxTest() throws InterruptedException {
    homepagePage.clickOnElements();
    sidebarPage.clickOnTextBox();
    textBoxPage.insertFullName(fullNameInput);
    textBoxPage.insertEmail(emailInput);
    textBoxPage.insertCurrentAddress(currentAddressInput);
    textBoxPage.insertPermanentAddress(permanentAddressInput);
    scrollIntoView(textBoxPage.getSubmitButton());
    textBoxPage.clickOnSubmitButton();

    Assert.assertTrue(textBoxPage.getText().isDisplayed());
   }

   @Test (priority = 1)
    public void invalidEmailFormatTextBoxTest(){
       homepagePage.clickOnElements();
       sidebarPage.clickOnTextBox();
       textBoxPage.insertFullName(fullNameInput);
       textBoxPage.insertEmail(invalidEmailFormat);
       textBoxPage.insertCurrentAddress(currentAddressInput);
       textBoxPage.insertPermanentAddress(permanentAddressInput);
       scrollIntoView(textBoxPage.getSubmitButton());
       textBoxPage.clickOnSubmitButton();

       boolean check = false;
       try {
          check = textBoxPage.getText().isDisplayed();
       }
       catch (Exception e){

       }
       Assert.assertFalse(check);
   }

   @Test (priority = 2)
    public void radioButtonTest() throws InterruptedException {
       homepagePage.clickOnElements();
       sidebarPage.clickOnRadioButton();
       Thread.sleep(2000);
       radioButtonPage.clickOnYesButton();

       Assert.assertTrue(radioButtonPage.getSelectedYesRadioBtn().isSelected());
       Assert.assertEquals(radioButtonPage.getSelectedText().getText(), radioButtonYesMessage);

       radioButtonPage.clickOnImpressiveButton();

       Assert.assertTrue(radioButtonPage.getSelectedImpressiveRadioBtn().isSelected());
       Assert.assertEquals(radioButtonPage.getSelectedText().getText(), radioButtonImpressiveMessage);

       radioButtonPage.clickOnNoButton();

       boolean check = false;
       try {
           check = radioButtonPage.getSelectedNoRadioBtn().isSelected();
       }
       catch (Exception e){

       }
       Assert.assertFalse(check);

   }

    @Test (priority = 3)
    public void doubleClickMeButtonTest(){
       homepagePage.clickOnElements();
       sidebarPage.clickOnButtons();
       buttonsPage.clickOnDoubleClickMeButton();

       Assert.assertEquals(buttonsPage.getDoubleClickMeMessage().getText(), doubleClickMeMessage);
    }

    @Test (priority = 4)
    public void rightClickMeButtonTest(){
        homepagePage.clickOnElements();
        sidebarPage.clickOnButtons();
        buttonsPage.clickOnRightClickMeButton();

        Assert.assertEquals(buttonsPage.getRightClickMeMessage().getText(), rightClickMeMessage);
    }

    @Test (priority = 5)
    public void clickMeButtonTest(){
        homepagePage.clickOnElements();
        sidebarPage.clickOnButtons();
        buttonsPage.clickOnclickMeButton();

        Assert.assertEquals(buttonsPage.getClickMeMessage().getText(), clickMeMessage);
    }

    @Test (priority = 6)
    public void uploadFileTest(){
       homepagePage.clickOnElements();
       sidebarPage.clickOnUploadAndDownload();
       uploadAndDownloadPage.clickOnUploadButton();

       Assert.assertTrue(uploadAndDownloadPage.getUploadFilePathMessage().isDisplayed());
       Assert.assertEquals(uploadAndDownloadPage.getUploadFilePathMessage().getText(), uploadFilePathText);
    }

    @Test (priority = 7)
    public void downloadFileTest() throws InterruptedException {
        homepagePage.clickOnElements();
        sidebarPage.clickOnUploadAndDownload();
        uploadAndDownloadPage.clickOnDownloadButton();
        File filePath = new File("C:\\Users\\Anja\\Downloads\\sampleFile.jpeg");
        Thread.sleep(2000);

        Assert.assertTrue(filePath.exists());

        filePath.delete();
        Assert.assertFalse(filePath.exists());
    }

    @Test (priority = 8)
    public void homeLink1Test() throws InterruptedException {
        homepagePage.clickOnElements();
        sidebarPage.clickOnLinks();
        linksPage.clickOnHomeLink1();
        Thread.sleep(3000);
        ArrayList<String> tabList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));

        Assert.assertEquals(driver.getCurrentUrl(), homepageURL);
        Thread.sleep(2000);
        driver.close();
    }

    @Test (priority = 9)
    public void homeLink2Test() throws InterruptedException {
        homepagePage.clickOnElements();
        sidebarPage.clickOnLinks();
        linksPage.clickOnHomeLink2();
        Thread.sleep(3000);
        ArrayList<String> tabList = new ArrayList<String>(driver.getWindowHandles());
        //driver.switchTo().window(tabList.get(0));
        driver.switchTo().window(tabList.get(1));
        Thread.sleep(3000);

        Assert.assertEquals(driver.getCurrentUrl(), homepageURL);
        Thread.sleep(2000);
        driver.close();
    }

    @Test (priority = 10)
    public void createdLinkTest() throws InterruptedException {
        homepagePage.clickOnElements();
        sidebarPage.clickOnLinks();
        linksPage.clickOnCreated();
        Thread.sleep(2000);

        Assert.assertEquals(linksPage.getNotification().getText(), createdLinkText);
    }

    @Test (priority = 11)
    public void noContentLinkTest() throws InterruptedException {
        homepagePage.clickOnElements();
        sidebarPage.clickOnLinks();
        linksPage.clickOnNoContent();
        Thread.sleep(2000);

        Assert.assertEquals(linksPage.getNotification().getText(), noContentLinkText);
    }

    @Test (priority = 12)
    public void movedLinkTest() throws InterruptedException {
        homepagePage.clickOnElements();
        sidebarPage.clickOnLinks();
        linksPage.clickOnMoved();
        Thread.sleep(2000);

        Assert.assertEquals(linksPage.getNotification().getText(), movedLinkText);
    }

    @Test (priority = 13)
    public void badRequestLinkTest() throws InterruptedException {
        homepagePage.clickOnElements();
        sidebarPage.clickOnLinks();
        linksPage.clickOnBadRequest();
        Thread.sleep(2000);

        Assert.assertEquals(linksPage.getNotification().getText(), badRequestText);
    }

    @Test (priority = 14)
    public void unauthorizedLinkTest() throws InterruptedException {
        homepagePage.clickOnElements();
        sidebarPage.clickOnLinks();
        linksPage.clickOnUnauthorized();
        Thread.sleep(2000);

        Assert.assertEquals(linksPage.getNotification().getText(), badRequestText);
    }

    @Test (priority = 15)
    public void forbiddenLinkTest() throws InterruptedException {
        homepagePage.clickOnElements();
        sidebarPage.clickOnLinks();
        linksPage.clickOnForbidden();
        Thread.sleep(2000);

        Assert.assertEquals(linksPage.getNotification().getText(), forbiddenLinkText);
    }

    @Test (priority = 16)
    public void notFoundLinkTest() throws InterruptedException {
        homepagePage.clickOnElements();
        sidebarPage.clickOnLinks();
        linksPage.clickOnNotFound();
        Thread.sleep(2000);

        Assert.assertEquals(linksPage.getNotification().getText(), notFoundLinkText);
    }

    @Test (priority = 17)
    public void validImageTest(){
        homepagePage.clickOnElements();
        sidebarPage.clickOnBrokenLinks();

        Assert.assertTrue(brokenLinksImagesPage.getValidImage().isDisplayed());
    }

    @Test (priority = 18)
    public void validLinkTest() throws InterruptedException {
        homepagePage.clickOnElements();
        sidebarPage.clickOnBrokenLinks();
        brokenLinksImagesPage.clickOnValidLink();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), homepageURL);
    }

    @Test (priority = 19)
    public void brokenLinkTest() throws InterruptedException {
        homepagePage.clickOnElements();
        sidebarPage.clickOnBrokenLinks();
        scrollIntoView(brokenLinksImagesPage.getBrokenLink());
        brokenLinksImagesPage.clickOnBrokenLink();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), brokenLinkURL);

    }

    @Test (priority = 20)
    public void enableAfterButtonTest(){
        homepagePage.clickOnElements();
        sidebarPage.clickOnDynamicProperties();
        Assert.assertTrue(dynamicPropertiesPage.isClickable(dynamicPropertiesPage.getEnableAfterButton()));
    }

    @Test (priority = 21)
    public void visibleAfterButtonTest(){
        homepagePage.clickOnElements();
        sidebarPage.clickOnDynamicProperties();
        visibilityWait(dynamicPropertiesPage.getVisibleAfterButton());

        Assert.assertTrue(dynamicPropertiesPage.getVisibleAfterButton().isDisplayed());
    }

    @Test (priority = 22)
    public void colorChangeTest(){
        homepagePage.clickOnElements();
        sidebarPage.clickOnDynamicProperties();
        String cssValue = dynamicPropertiesPage.getColorChangeButton().getCssValue("color");
        String color  = Color.fromString(cssValue).asRgba();
        clickabilityWait(dynamicPropertiesPage.getEnableAfterButton());
        cssValue = dynamicPropertiesPage.getColorChangeButton().getCssValue("color");
        String color2 = Color.fromString(cssValue).asRgba();

        boolean check = false;
        try {
            if (color!=color2){
                check = true;
            }

        } catch (Exception e){

        }
        Assert.assertTrue(check);
    }
}
