package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class ElementsPage extends CategoryPage {
   WebElement elementsAccordionShow;
   WebElement elementsAccordion;
    List<WebElement> elementsPageItems;



    public ElementsPage(WebDriver driver, WebDriverWait wdwait) {
        super(driver, wdwait);
    }

    public WebElement getElementsAccordionShow() {
        return driver.findElement(By.cssSelector(".element-list.collapse.show"));
    }

    public WebElement getElementsAccordion() {
        return driver.findElement(By.cssSelector(".element-list.collapse"));
    }

    public List<WebElement> getElementsPageItems() {
        return driver.findElements(By.tagName("li"));
    }

    
    public void clickElementsPageItems(String s){
        for(WebElement e : getElementsPageItems()){
            if(e.getText().equals(s)){
                e.click();
                break;
            }
        }
    }
    public WebElement pickElement(String s) {
        WebElement w = null;
        for (WebElement e : getElementsPageItems()) {
            if (e.getText().equals(s)) {
                w = e;
                break;
            }
        } return w;
    }

    public void clickElement(WebElement e){
            e.click();
    }

}
