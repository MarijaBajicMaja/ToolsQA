package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import pages.CategoryPage;
import pages.ElementsPage;
import pages.HomePage;
import pages.elements.*;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

public class BasePage{
    public WebDriver driver;
    public WebDriverWait wdwait;
    public HomePage homePage;
    public ExcelReader excelReader;
    public ElementsPage elementsPage;
    public CategoryPage cathegoryPage;
    public TextBox textBox;
    public CheckBox checkBox;
    public RadioButton radioButton;
    public WebTables webTables;
    public Buttons buttons;
    public Links links;
    public BrokenLinksImages brokenLinksImages;


    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        homePage = new HomePage(driver, wdwait);
        excelReader = new ExcelReader("DemoQA.xlsx");
        elementsPage = new ElementsPage(driver,wdwait);
        cathegoryPage = new CategoryPage(driver,wdwait);
        textBox = new TextBox(driver, wdwait);
        checkBox = new CheckBox(driver,wdwait);
        radioButton = new RadioButton(driver,wdwait);
        webTables = new WebTables(driver,wdwait);
        buttons = new Buttons(driver,wdwait);
        links = new Links(driver, wdwait);
        brokenLinksImages = new BrokenLinksImages(driver,wdwait);

    }

    public void waiterURL(String url){
        wdwait.until(ExpectedConditions.urlToBe(url));
    }

    public void scrollIntoView(WebElement e){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",e);
    }
    public boolean elementIsDisplayed(WebElement e){
        boolean b=false;
        try{
            b=e.isDisplayed();
        }
        catch(NoSuchElementException ey) {
        }
        return b;
    }

    public void click (WebElement e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);
    }


  /*  @AfterClass
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    } */
}
