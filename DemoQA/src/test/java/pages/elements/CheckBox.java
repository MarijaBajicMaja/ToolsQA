package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckBox {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement cbhomeArrow;
    WebElement expandAllButton;
    WebElement collapseAll;
    WebElement message;
    List<WebElement> childElements;
    List<WebElement> childChildElements1_17;

    public CheckBox(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getCbhomeArrow() {
        return driver.findElement(By.cssSelector(".rct-collapse.rct-collapse-btn"));
    }

    public WebElement getExpandAllButton() {
        return driver.findElement(By.cssSelector(".rct-option.rct-option-expand-all"));
    }

    public WebElement getCollapseAll() {
        return driver.findElement(By.cssSelector(".rct-option.rct-option-collapse-all"));
    }

    public WebElement getMessage() {
        return driver.findElement(By.id("result"));
    }

    public List<WebElement> getChildElements() {
        return driver.findElements(By.cssSelector(".rct-node.rct-node-parent.rct-node-collapsed"));
    }

    public List<WebElement> getChildChildElements1_17() {
        return driver.findElements(By.tagName("label"));
    }

    public void clickCBHomeArrow(){
        getCbhomeArrow().click();
    }

    public void clickExpanAll(){
        getExpandAllButton().click();
    }

    public void clickCollapseAll(){ getCollapseAll().click(); }

    public String elementText(WebElement e){
        return e.getText();
    }


}
