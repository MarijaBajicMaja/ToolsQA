package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Links {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement homeLink;
    WebElement homeLinkTwo;
    ArrayList<String> tabList;
    List<WebElement> apiCallLinks;
    WebElement message;
    WebElement messageTexts;


    public Links(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getHomeLink() {
        return driver.findElement(By.id("simpleLink"));
    }
    public WebElement getHomeLinkTwo() {
        return driver.findElement(By.id("dynamicLink"));
    }

    public ArrayList<String> getTabList() {
        return tabList = new ArrayList<>(driver.getWindowHandles());
    }

    public List<WebElement> getApiCallLinks() {
        return driver.findElements(By.cssSelector("[href = 'javascript:void(0)']"));
    }

    public WebElement getMessage() {
        return driver.findElement(By.id("linkResponse"));
    }

    public WebElement getMessageTexts() {
        return driver.findElement(By.cssSelector("#linkResponse > b:nth-child(2)"));
    }

}
