package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebTables {
    WebDriver driver;
    WebDriverWait wdwait;
 WebElement delete;
    WebElement cell;
    WebElement addButton;
    WebElement submitRF;
    WebElement searchbox;
    List<WebElement> rForm;


    public WebTables(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getDelete() {
        return driver.findElement(By.cssSelector("[title='Delete']"));
    }

    public WebElement getCell() {
        return driver.findElement(By.className("rt-td"));
    }

    public WebElement getAddButton() {
        return driver.findElement(By.id("addNewRecordButton"));
    }

    public WebElement getSubmitRF() {
        return driver.findElement(By.id("submit"));
    }

    public WebElement getSearchbox() {
        return driver.findElement(By.id("searchBox"));
    }

    public List<WebElement> getrForm() {
        return driver.findElements(By.cssSelector(".mr-sm-2.form-control"));
    }

    public void clickSubmit(){
        getSubmitRF().click();
    }
    public void clickAdd(){
        getAddButton().click();
    }

    public void insertData(WebElement e, String s){
        e.clear();
        e.sendKeys(s);
    }
}
