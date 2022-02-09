package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
WebDriver driver;
WebDriverWait wdwait;
WebElement name;
List<WebElement> cards;
List<WebElement> cardNames;


    public HomePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getName() {
        return driver.findElement(By.cssSelector("[src='/images/Toolsqa.jpg']"));
    }

    public List<WebElement> getCards() {
        return driver.findElements(By.className("card-up"));
    }

    public List<WebElement> getCardNames() {
        return driver.findElements(By.tagName("h5"));
    }

    public WebElement getTitlesOfCathegoryPages() {
        return driver.findElement(By.className("main-header"));
    }

    public void clickOnCard(String s){
       for(int i= 0; i<getCardNames().size(); i++){
           if (getCardNames().get(i).getText().contains(s)){
               getCardNames().get(i).click();
               break;
           }
       }
    }
}
