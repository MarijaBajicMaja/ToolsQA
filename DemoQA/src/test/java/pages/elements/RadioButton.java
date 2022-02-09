package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RadioButton {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement rButtonYes;
    WebElement rButtonImpressive;
    WebElement rButtonNo;
    List<WebElement> rButtons;
    WebElement message;

    public RadioButton(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getrButtonYes() {
        return driver.findElement(By.id("yesRadio"));
    }

    public WebElement getrButtonImpressive() {
        return driver.findElement(By.id("impressiveRadio"));
    }

    public WebElement getrButtonNo() {
        return driver.findElement(By.id("noRadio"));
    }

    public List<WebElement> getrButtons() {
        return driver.findElements(By.className("custom-control-input"));
    }

    public WebElement getMessage() {
        return driver.findElement(By.className("mt-3"));
    }

    public String messageText(WebElement e ){
return e.getText();
 }
}
