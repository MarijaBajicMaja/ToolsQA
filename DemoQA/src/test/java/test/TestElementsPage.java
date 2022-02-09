package test;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestElementsPage extends BasePage {
    @BeforeMethod
    public void setUpPage() {

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        waiterURL(excelReader.getStringData("URL", 0, 1));
        homePage.clickOnCard("Elements");
        waiterURL(excelReader.getStringData("URL", 1, 1));
    }

    @Test
    public void clickingOnElementGroupHeaderClosesElementsAccordion() {
        Assert.assertTrue(elementsPage.getElementsAccordionShow().isDisplayed());
        String classShow = elementsPage.getElementsAccordionShow().getAttribute("class");

        cathegoryPage.clickOnAccordionGroupHeader("Elements");
        Assert.assertNotEquals(elementsPage.getElementsAccordion().getAttribute("class"), classShow);

        }

    @Test
    public void elementsListItemsAreFunctional() {
        for (int i = 0; i < 9; i++) {
            scrollIntoView(elementsPage.pickElement("Dynamic Properties"));
            elementsPage.clickElement(elementsPage.getElementsPageItems().get(i));
            waiterURL(excelReader.getStringData("Elements", 1, (i + 1)));

            Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("Elements", 1, (i + 1)));
        }
    }
//------------------------------------------------------------------------------------------------------------

    @Test
    public void textBoxCanBeSubmitted() {
        elementsPage.clickElementsPageItems("Text Box");
        Assert.assertFalse(elementIsDisplayed(textBox.getOutput()));

        for (int i = 0; i < textBox.getTextboxList().size(); i++) {
            textBox.inputText(textBox.getTextboxList().get(i), excelReader.getStringData("Elements", (i + 3), 1));
            textBox.clickSubmit();
        }
        Assert.assertEquals(textBox.outputText(), textBox.result(
                excelReader.getStringData("Elements", 3, 1),
                excelReader.getStringData("Elements", 4, 1),
                excelReader.getStringData("Elements", 5, 1),
                excelReader.getStringData("Elements", 6, 1)));
    }

    @Test
    public void userCanNotSubmitTheTextBoxFormWithoutAUsername() {
        elementsPage.clickElementsPageItems("Text Box");
        Assert.assertFalse(elementIsDisplayed(textBox.getOutput()));

        for (int i = 1; i < textBox.getTextboxList().size(); i++) {
            textBox.getTextboxList().get(i).sendKeys(excelReader.getStringData("Elements", (i + 3), 1));
            textBox.clickSubmit();
        }

        Assert.assertFalse(elementIsDisplayed(textBox.getOutput()));

    }
//-------------------------------------------------------------------------------------------------------------------

    public void goToCheckBoxPage() {
        elementsPage.clickElementsPageItems("Check Box");
        waiterURL(excelReader.getStringData("Elements", 1, 2));
    }

    @Test
    public void whenParentElementIsSelectedChildElementsAreDisplayed() {
        goToCheckBoxPage();

        checkBox.clickCBHomeArrow();
        for (WebElement e : checkBox.getChildElements()) {
            Assert.assertTrue(e.isDisplayed());
        }
    }

    @Test
    public void whenExpandAllButtonIsClickedAllChildChildElementsAreDisplayed() {
        goToCheckBoxPage();

        checkBox.clickExpanAll();
        for (int i = 0; i < 17; i++) {
            Assert.assertTrue(checkBox.getChildChildElements1_17().get(i).isDisplayed());
        }
    }

    @Test
    public void whenParentElementIsSelectedMessageInformsUsThatAllChildElementsAreSelected() {
        goToCheckBoxPage();

        checkBox.clickExpanAll();
        String[] text = new String[17];
        for (int i = 0; i < 17; i++) {
            text[i] = checkBox.elementText(checkBox.getChildChildElements1_17().get(i)).toLowerCase().replace(".doc", "").replace(" ", "");
        }
        checkBox.clickCollapseAll();

        checkBox.getChildChildElements1_17().get(0).click();
        Assert.assertTrue(checkBox.getMessage().isDisplayed());
        for (int i = 0; i < 17; i++) {
            Assert.assertTrue(checkBox.elementText(checkBox.getMessage()).toLowerCase().contains(text[i]));
        }
    }
//----------------------------------------------------------------------------------------------------------------

    public void goToRadioButtonsPage() {
        elementsPage.clickElementsPageItems("Radio Button");
        waiterURL(excelReader.getStringData("Elements", 1, 3));
    }

    @Test
    public void radioButtonsAreMutuallyExclusive() {
        goToRadioButtonsPage();


        for (WebElement w : radioButton.getrButtons()) {
            Assert.assertFalse(w.isSelected());
        }

        for (WebElement w : radioButton.getrButtons()) {
           click(w);
         Assert.assertTrue(w.isSelected());

            int brNeselektovanih = 0;
            for (WebElement e : radioButton.getrButtons()) {
                if (!e.isSelected()) {
                    brNeselektovanih += 1;
                }
            }
            Assert.assertEquals(brNeselektovanih, 2);
       }
    }

    @Test
    public void messageAppearsWhenRButtonIsSelected() throws InterruptedException {
        goToRadioButtonsPage();

        String[] poruka = {"Yes", "Impressive", "No"};
        for (int i = 0; i < radioButton.getrButtons().size(); i++) {
            click(radioButton.getrButtons().get(i));
            Assert.assertTrue(radioButton.messageText(radioButton.getMessage()).contains(poruka[i]));
        }
    }
//-------------------------------------------------------------------------------------------------------------------

    public void goToWebTablesPage() {
        elementsPage.clickElementsPageItems("Web Tables");
        waiterURL(excelReader.getStringData("Elements", 1, 4));
        do{
            wdwait.until(ExpectedConditions.elementToBeClickable(webTables.getDelete()));
            webTables.getDelete().click();
        }
        while(!webTables.getCell().getText().isBlank());

    }

    @Test
    public void userCanAddNewRowsToWebTable() throws InterruptedException {
        goToWebTablesPage();

        webTables.clickAdd();

        for(int i = 0; i<webTables.getrForm().size(); i++) {
            if (i < 3 || i == (webTables.getrForm().size()-1)) {
                webTables.insertData(webTables.getrForm().get(i), excelReader.getStringData("Elements", (i + 3), 4));
            } else {
                webTables.insertData(webTables.getrForm().get(i), String.valueOf(excelReader.getIntegerData("Elements", (i + 3), 4)));
            }
        }
        webTables.clickSubmit();

for(int i = 0; i<webTables.getrForm().size(); i++) {
    if (i < 3 || i == (webTables.getrForm().size() - 1)) {
        Assert.assertEquals(webTables.getCell().getText(), excelReader.getStringData("Elements", (i + 3), 4));
    } else {
        Assert.assertEquals(webTables.getCell().getText(), String.valueOf(excelReader.getIntegerData("Elements", (i + 3), 4)));
    }
}

    }

//-----------------------------------------------------------------------------------------------------

    @Test
public void messageAppearsWhenButtonsAreClickedInRequiredManner() throws InterruptedException {
        elementsPage.clickElementsPageItems("Buttons");
        waiterURL(excelReader.getStringData("Elements", 1, 5));

        buttons.doubleClick();
        buttons.rightClick();
        click(buttons.getButtonsList().get(2));

        Assert.assertTrue(buttons.getDobleClickMessage().isDisplayed());
        Assert.assertEquals(buttons.getDobleClickMessage().getText(),"You have done a double click");

        Assert.assertTrue(buttons.getRightClickMessage().isDisplayed());
        Assert.assertEquals(buttons.getRightClickMessage().getText(),"You have done a right click");

        Assert.assertTrue(buttons.getDynamicClickMessage().isDisplayed());
        Assert.assertEquals(buttons.getDynamicClickMessage().getText(),"You have done a dynamic click");

    }

//--------------------------------------------------------------------------------------------------------------
   public void goToLinksPage(){
       elementsPage.clickElementsPageItems("Links");
       waiterURL(excelReader.getStringData("Elements", 1, 6));
   }

    @Test
    public void linksOpenHomePageNewTab(){
        goToLinksPage();

        click(links.getHomeLink());
        click(links.getHomeLinkTwo());

        Assert.assertEquals(links.getTabList().size(), 3);

        for(int i = 1; i<links.getTabList().size(); i++){
            driver.switchTo().window(links.getTabList().get(i));
            Assert.assertEquals(driver.getCurrentUrl(),excelReader.getStringData("URL",0,1));
        }

    }

    @Test
    public void whenClickingAPICallLinksMatchingMessagesAppear() throws InterruptedException {
        goToLinksPage();

        for(int i = 0; i< links.getApiCallLinks().size(); i++){
            click(links.getApiCallLinks().get(i));
            Thread.sleep(1000);

            Assert.assertTrue(links.getMessageTexts().getText().contains(links.getApiCallLinks().get(i).getText()));
        }
    }

//-------------------------------------------------------------------------------------------------------

    public void goToBrokenLinksPage(){
        scrollIntoView(elementsPage.pickElement("Broken Links - Images"));
        elementsPage.clickElementsPageItems("Broken Links - Images");
        waiterURL(excelReader.getStringData("Elements", 1, 7));
    }

    @Test
    public void validLinkTakesUserToHomePage(){
        goToBrokenLinksPage();

        click(brokenLinksImages.getValidLink());
        waiterURL(excelReader.getStringData("URL",0,1));

        Assert.assertEquals(driver.getCurrentUrl(),excelReader.getStringData("URL",0,1));
    }

    @Test
    public void brokenLinkTakesUserToStatusCode500Page(){
        goToBrokenLinksPage();

        click(brokenLinksImages.getBrokenLink());
        waiterURL(excelReader.getStringData("Elements",3,7));

        Assert.assertEquals(driver.getCurrentUrl(),excelReader.getStringData("Elements",3,7));
        Assert.assertEquals(brokenLinksImages.statusCodesTitle(),"Status Codes");
      Assert.assertEquals(brokenLinksImages.statuCodeMessage(),"This page returned a 500 status code.");

    }


}



