package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Buttons {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement dobleClickMessage;
    WebElement rightClickMessage;
    WebElement dynamicClickMessage;
    List<WebElement> buttonsList;
    Actions actions;

    public Buttons(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        this.actions = new Actions(driver);
    }

    public List<WebElement> getButtonsList() {
        return driver.findElements(By.cssSelector(".btn.btn-primary"));
    }

    public WebElement getDobleClickMessage() {
        return driver.findElement(By.id("doubleClickMessage"));
    }

    public WebElement getRightClickMessage() {
        return driver.findElement(By.id("rightClickMessage"));
    }

    public WebElement getDynamicClickMessage() {
        return driver.findElement(By.id("dynamicClickMessage"));
    }

    public void doubleClick(){
        actions.doubleClick(getButtonsList().get(0)).perform();
    }
    public void rightClick(){
        actions.contextClick(getButtonsList().get(1)).perform();
    }



}
