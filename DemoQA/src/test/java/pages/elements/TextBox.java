package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TextBox {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement fullname;
    WebElement email;
    WebElement currentAddress;
    WebElement permanentAddress;
    WebElement submit;
    List<WebElement> textboxList;
    WebElement output;

    public TextBox(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getSubmit() {
        return driver.findElement(By.id("submit"));
    }

    public List<WebElement> getTextboxList() {
        return driver.findElements(By.className("form-control"));
    }

    public WebElement getOutput() {
        return driver.findElement(By.id("output"));
    }

    public void inputText(WebElement e, String s){
        e.clear();
        e.sendKeys(s);
    }

    public void clickSubmit(){
        getSubmit().click();
    }

    public String outputText(){
        return getOutput().getText();
    }

    public String result(String name, String email, String caddress, String paddress){
        StringBuilder sb = new StringBuilder();

        //if(name != null){
        sb.append("Name:").append(name).append("\n");
   // } if(email != null){
        sb.append("Email:").append(email).append("\n");
   // } if(caddress != null){
        sb.append("Current Address :").append(caddress).append("\n");
   //}
        if(paddress != null){
        sb.append("Permananet Address :").append(paddress);
    }

        return sb.toString();
    }
}
