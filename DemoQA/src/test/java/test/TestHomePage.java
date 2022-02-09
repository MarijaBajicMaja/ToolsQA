package test;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestHomePage extends BasePage {

    @BeforeMethod
    public void setUpPage() {

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        waiterURL(excelReader.getStringData("URL", 0, 1));
    }

    @Test
    public void correctPage() {

        Assert.assertEquals(excelReader.getStringData("URL", 0, 1), "https://demoqa.com/");
        Assert.assertTrue(homePage.getName().isDisplayed());

        for (int i = 1; i < homePage.getCards().size(); i++) {
            Assert.assertTrue(homePage.getCards().get(i).isDisplayed());
        }
        for(int i = 0; i<homePage.getCardNames().size(); i++){
            Assert.assertEquals(homePage.getCardNames().get(i).getText(),excelReader.getStringData("URL",(i+1),0));
        }
    }


    @Test
    public void cardsAreFunctional() {
        for (int i = 0; i < homePage.getCards().size(); i++) {
            scrollIntoView(homePage.getCards().get(homePage.getCards().size() - 1));
            homePage.getCards().get(i).click();
            waiterURL(excelReader.getStringData("URL", (i + 1), 1));

            Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", (i + 1), 1));
            Assert.assertTrue(categoryPage.titleOfCategoryPagesText().contains(excelReader.getStringData("URL",(i+1),2)));

            driver.get(excelReader.getStringData("URL", 0, 1));
            waiterURL(excelReader.getStringData("URL", 0, 1));
        }

    }

}
