package Base;

import Page.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

//U ovom projektu koriscen je IntelliJIdea u kom je kreiran Maven projekat.
//Prilikom testiranja koristim POM jer je laksi za odrzavanje, lakse se prati rad
//Koristim i TestNG

public class BaseTest {

    //U ovom ispod delu deklarisem driver, webdriverwait ako bude potrebe i sve stranice koje cu testirati


    public WebDriver driver;
    public WebDriverWait wdwait;
    public ExcelReader excelReader;
    public String homepageURL;
    public SidebarPage sidebarPage;
    public HomepagePage homepagePage;
    public TextBoxPage textBoxPage;
    public RadioButtonPage radioButtonPage;
    public ButtonsPage buttonsPage;
    public UploadAndDownloadPage uploadAndDownloadPage;
    public LinksPage linksPage;
    public BrokenLinksImagesPage brokenLinksImagesPage;
    public DynamicPropertiesPage dynamicPropertiesPage;


    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        excelReader = new ExcelReader("C:\\Users\\Anja\\Desktop\\ProjekatSelenium.xlsx");
        sidebarPage = new SidebarPage(driver,wdwait);
        homepageURL = excelReader.getStringData("Projekat", 1,0);
        homepagePage = new HomepagePage(driver, wdwait);
        textBoxPage = new TextBoxPage(driver, wdwait);
        radioButtonPage = new RadioButtonPage(driver, wdwait);
        buttonsPage = new ButtonsPage(driver, wdwait);
        uploadAndDownloadPage = new UploadAndDownloadPage(driver, wdwait);
        linksPage = new LinksPage(driver, wdwait);
        brokenLinksImagesPage = new BrokenLinksImagesPage(driver, wdwait);
        dynamicPropertiesPage = new DynamicPropertiesPage(driver, wdwait);
    }

    public void visibilityWait(WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickabilityWait(WebElement element) {
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @AfterClass
    public void tearDown() {
       // driver.close();
      //  driver.quit();
    }

}
