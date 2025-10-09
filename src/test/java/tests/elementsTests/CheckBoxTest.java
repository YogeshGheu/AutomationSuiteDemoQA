package tests.elementsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.base.BaseTest;
import pages.homepage.Homepage;
import pages.subPages.elements.ElementsPage;
import pages.subPages.elements.childPages.CheckBoxPage;
import pages.subPages.elements.childPages.TextBoxPage;

public class CheckBoxTest extends BaseTest {
    @Test(description = "test the checkbox functionality")
    public void testCheckBox(){
        CheckBoxPage checkBoxPage = new Homepage(BaseTest.getDriver()).clickElementsTile().clickCheckBoxLabelFromDropdown();
        checkBoxPage.clickOnHomeCheckBox();
        Assert.assertEquals(checkBoxPage.allResultsCount(), 17, "checked elements count mismatch!");
    }
}
