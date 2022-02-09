package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrokenLinksImages {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement validLink;
    WebElement brokenLink;

    public BrokenLinksImages(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getValidLink() {
        return driver.findElement(By.linkText("Click Here for Valid Link"));
    }

    public WebElement getBrokenLink() {
        return driver.findElement(By.linkText("Click Here for Broken Link"));
    }

    public String statusCodesTitle(){
        return driver.findElement(By.tagName("h3")).getText();
    }
    public String statuCodeMessage(){
        return driver.findElement(By.tagName("p")).getText().split("\n") [0];
    }
}
