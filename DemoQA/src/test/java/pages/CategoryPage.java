package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CategoryPage {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement titlesOfCathegoryPages;
    List<WebElement> accordion;

    public CategoryPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getTitlesOfCathegoryPages() {
        return driver.findElement(By.className("main-header"));
    }

    public List<WebElement> getAccordion() {
        return driver.findElements(By.className("group-header"));
    }



    public String  titleOfCathegoryPagesText(){
        return getTitlesOfCathegoryPages().getText();
    }

    public void clickOnAccordionGroupHeader(String s){
        for( WebElement e : getAccordion()){
            if(e.getText().contains(s)){
                e.click();
            }
        }
    }
}
