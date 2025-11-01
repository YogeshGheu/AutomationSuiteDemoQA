package tests.elementsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.base.BaseTest;
import pages.homepage.Homepage;
import pages.subPages.elements.childPages.ButtonsPage;

public class ButtonsTest extends BaseTest {
    @Test(description = "test the buttons functionality", invocationCount = 10)
    public void testButtons(){
        Homepage homepage = new Homepage(getDriver());
        ButtonsPage buttonsPage = homepage.clickElementsTile().clickButtonsLabelFromDropdown();

        // test double click
        buttonsPage.clickDoubleClickButton();
        Assert.assertTrue(buttonsPage.isDoubleClickMessageVisible());

        // test right click
        buttonsPage.clickRightClickButton();
        Assert.assertTrue(buttonsPage.isRightClickMessageVisible());

        // test dynamic click
        buttonsPage.clickDynamicClickButton();
        Assert.assertTrue(buttonsPage.isDynamicClickMessageVisible());
    }
}
